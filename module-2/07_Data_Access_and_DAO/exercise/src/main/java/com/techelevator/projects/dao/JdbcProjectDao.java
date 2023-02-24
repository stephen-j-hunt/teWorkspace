package com.techelevator.projects.dao;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.techelevator.projects.model.Project;

public class JdbcProjectDao implements ProjectDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcProjectDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public Project getProject(int projectId) {
        Project projects = null;
        final String sql = "SELECT project_id, name, from_date, to_date\n" +
                "\tFROM project\n" +
                "\tWHERE project_id =?;";
        final SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql, projectId);
        if (rowSet.next()) {
            projects = mapRowToProject(rowSet);
        }
        return projects;
    }

    @Override
    public List<Project> getAllProjects() {
        List<Project> projects = new ArrayList<>();
        SqlRowSet rowSet = jdbcTemplate.queryForRowSet("SELECT project_id, name, from_date, to_date\n" +
                "\tFROM project;");
        while (rowSet.next()) {
            projects.add(mapRowToProjects(rowSet));
        }
        return projects;
    }

    @Override
    public Project createProject(Project newProject) {
        String sql= "INSERT INTO project(\n" +
                "\tproject_id, name, from_date, to_date)\n" +
                "\tVALUES (?, ?, ?, ?) RETURNING project_id;";
        Integer projectId =jdbcTemplate.queryForObject(sql, Integer.class,
        newProject.getId(),
        newProject.getName(),
        newProject.getFromDate(),
        newProject.getToDate());
        return getProject(projectId);
    }

    @Override
    public void deleteProject(int projectId) {
        final String sql = "\n" +
                "\tDELETE FROM timesheet\n" +
                "\tWHERE project_id =?;\n" +
                "\tDELETE FROM project_employee\n" +
                "\tWHERE project_id =?;\n" +
                "\tDELETE FROM project\n" +
                "\tWHERE project_id=?;";
        jdbcTemplate.update(sql, projectId, projectId, projectId);
    }

    private Project mapRowToProject(SqlRowSet rowSet) {
        final Project project = new Project();
        project.setId(rowSet.getInt("project_id"));
        project.setName(rowSet.getString("name"));
        if (rowSet.getDate("from_date") != null) {
            project.setFromDate(rowSet.getDate("from_date").toLocalDate());
        }
        if (rowSet.getDate("to_date") != null) {
            project.setToDate(rowSet.getDate("to_date").toLocalDate());
        }
        return project;
    }

    private Project mapRowToProjects(SqlRowSet rowSet) {
        Project projects = new Project();
        projects.setId(rowSet.getInt("project_id"));
        projects.setName(rowSet.getString("name"));
        if (rowSet.getDate("from_date") != null) {
            projects.setFromDate(rowSet.getDate("from_date").toLocalDate());
        }
        if (rowSet.getDate("to_date") != null) {
            projects.setToDate(rowSet.getDate("to_date").toLocalDate());
        }
        return projects;
    }
}







