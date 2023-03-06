package com.techelevator;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.web.client.ResourceAccessException;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import java.util.ArrayList;
import java.util.List;


public class CelticsDao {
    public static void main(String[] args) {
        
    }

    private jdbcTemplate jdbcTemplate;

    public JdbcCelticsDao() {
        final BasicDataSource dataSource = new BasicDataSource();
        dataSource.setUrl("jdbc:postgresql://localhost:5432/Quiz");
        dataSource.setUsername("Celtics");
        dataSource.setPassword("Celtics1");
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }
public List<CelticsStats> getStatsofPlayer() {
        String getStatsSQL = "SELECT *\n" +
                "\tFROM player stats\n" +
                "\tWHERE player_id=?;";

    List<CelticsStats> stats = new ArrayList<>();
    SqlRowSet rowSet = this.jdbcTemplate.queryForRowSet(getStatsSQL);
    while (rowSet.next()) {
        int playerId = rowSet.getInt("player_id");
        
        
}



}
