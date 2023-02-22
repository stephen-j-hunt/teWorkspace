package com.techelevator.dao;

import com.techelevator.model.Park;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

public class JdbcParkDao implements ParkDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcParkDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public Park getPark(int parkId) {
        Park park = null;
        final String sql = "SELECT p.park_id, park_name, date_established, area, has_camping\n" +
                "FROM park p \n" +
                "WHERE park_id = ?;\n";
        final SqlRowSet rs = jdbcTemplate.queryForRowSet(sql, parkId);
        if (rs.next()) {
            park = mapRowToPark(rs);
        }
        return park;
    }

    @Override
    public List<Park> getParksByState(String stateAbbreviation) {
        final List<Park> parks = new ArrayList<Park>();
        final String sql = "SELECT p.park_id, park_name, date_established, area, has_camping\n" +
                "FROM park p INNER JOIN park_state ps ON p.park_id = ps.park_id\n" +
                "WHERE ps.state_abbreviation = ?;\n";

        final SqlRowSet rs = jdbcTemplate.queryForRowSet(sql, stateAbbreviation);
        while (rs.next()) {
            parks.add(mapRowToPark(rs));
        }

        return parks;
    }

    private Park mapRowToPark(SqlRowSet rowSet) {
        final Park park = new Park();
        park.setParkId(rowSet.getInt("park_id"));
        park.setParkName(rowSet.getString("park_name"));

        if (rowSet.getDate("date_established") != null) {
            park.setDateEstablished(rowSet.getDate("date_established").toLocalDate()); // return to this
        }

        park.setArea(rowSet.getDouble("area"));
        park.setHasCamping(rowSet.getBoolean("has_camping"));

        return park;
    }

    @Override
    public Park createPark(Park park) {
        final String sql = "INSERT INTO park (park_name, date_established, area, has_camping)\n" +
                "VALUES (?, ?, ?, ?) RETURNING park_id;"; // 1
        final Integer parkid = jdbcTemplate.queryForObject(sql, Integer.class,
                park.getParkName(),
                park.getDateEstablished(),
                park.getArea(),
                park.getHasCamping()); // 2

        return this.getPark(parkid); // 3

    }

    @Override
    public void addParkToState(int parkId, String stateAbbreviation) {

        final String sql = "INSERT INTO park_state (park_id, state_abbreviation)\n" +
                "VALUES (?, ?);"; // 1
        jdbcTemplate.update(sql, parkId, stateAbbreviation); // 2
    }

    @Override
    public void updatePark(Park park) {
        final String sql = "UPDATE park\n" +
                "\tSET park_name=?, date_established=?, area=?, has_camping=?\n" +
                "WHERE park_id = ?;";
        jdbcTemplate.update(sql,
                park.getParkName(),
                park.getDateEstablished(),
                park.getArea(),
                park.getHasCamping(),
                park.getParkId());
    }

    @Override
    public void deletePark(int parkId) {
        final String sql = "DELETE FROM park_state WHERE park_id = ?;\n" +
                "DELETE FROM park WHERE park_id = ?;\n";
        jdbcTemplate.update(sql, parkId, parkId);
    }

    @Override
    public void removeParkFromState(int parkId, String stateAbbreviation) {
        final String sql = "DELETE FROM park_state WHERE park_id = ? AND state_abbreviation = ?;\n";
        jdbcTemplate.update(sql, parkId, stateAbbreviation);
    }
}
