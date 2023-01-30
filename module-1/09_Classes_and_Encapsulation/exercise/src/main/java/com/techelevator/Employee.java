package com.techelevator;

public class Employee {


    int employeeId;
    String firstName;
    String lastName;
    String department;
    double annualSalary;

    public Employee(int employeeId, String firstName, String lastName, double annualSalary) {
        this.annualSalary = annualSalary;
        this. employeeId = employeeId;
        this.firstName = firstName;
        this.lastName = lastName;
    }
    public int getEmployeeId() {
        return employeeId;
    }
    public String getDepartment() {
        return department;
    }
    public void setDepartment(String department) {
        this.department = department;
    }
    public double getAnnualSalary() {
        return annualSalary;
    }
    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName (String lastName) {
        this.lastName = lastName;
    }
    public String getFullName() {
        return lastName + ", " + firstName;
    }

    public void raiseSalary(double percent) {
        double percentIncrease =annualSalary*(percent/100);
        annualSalary = annualSalary +percentIncrease;


    }

}
