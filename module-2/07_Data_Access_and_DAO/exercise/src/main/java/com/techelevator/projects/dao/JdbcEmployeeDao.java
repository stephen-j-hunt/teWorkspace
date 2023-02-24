package com.techelevator.projects.dao;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.techelevator.projects.model.Employee;
import org.springframework.jdbc.support.rowset.SqlRowSet;

public class JdbcEmployeeDao implements EmployeeDao {

	private final JdbcTemplate jdbcTemplate;

	public JdbcEmployeeDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public List<Employee> getAllEmployees() {
		List<Employee> employees = new ArrayList<>();
		SqlRowSet results = jdbcTemplate.queryForRowSet("SELECT employee_id, department_id, first_name, last_name, birth_date, hire_date\n" +
				"\tFROM employee;");
		while (results.next()) {
			employees.add(mapRowToEmployee(results));
		}
		return employees;
	}

	@Override
	public List<Employee> searchEmployeesByName(String firstNameSearch, String lastNameSearch) {
		List<Employee> names = new ArrayList<>();
		String sql = "SELECT employee_id, department_id, first_name, last_name, birth_date, hire_date\n" +
				"\tFROM employee\n" +
				"\tWHERE employee_id =?;";
		SqlRowSet rowSet= jdbcTemplate.queryForRowSet(sql,firstNameSearch, lastNameSearch );
		while (rowSet.next()) {
			names.add(mapRowToNames(rowSet));
		}
		return names;
	}

	@Override
	public List<Employee> getEmployeesByProjectId(int projectId) {
		List<Employee> names = new ArrayList<>();
		String sql = "SELECT employee_id\n" +
				"\tFROM project_employee\n" +
				"\tWHERE project_id =?;";
		SqlRowSet rowSet= jdbcTemplate.queryForRowSet(sql, projectId );
		while (rowSet.next()) {
			names.add(mapRowToNames(rowSet));
		}
		return names;
	}

	@Override
	public void addEmployeeToProject(int projectId, int employeeId) {
	}

	@Override
	public void removeEmployeeFromProject(int projectId, int employeeId) {
	}

	@Override
	public List<Employee> getEmployeesWithoutProjects() {
		return new ArrayList<>();
	}

	private Employee mapRowToEmployee(SqlRowSet rowSet) {
		Employee employees = new Employee();
		employees.setId(rowSet.getInt("employee_id"));
		employees.setDepartmentId(rowSet.getInt("department_id"));
		employees.setFirstName(rowSet.getString("first_name"));
		employees.setLastName(rowSet.getString("last_name"));
		employees.setBirthDate(rowSet.getDate("birth_date").toLocalDate());
		employees.setHireDate(rowSet.getDate("hire_date").toLocalDate());
		return employees;
	}


	private Employee mapRowToNames(SqlRowSet rowSet) {
		Employee employees = new Employee();
		employees.setId(rowSet.getInt("employee_id"));
		return employees;
	}
	}


