package com.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeTest {

    @Test
    @DisplayName("Employee Constructor and Getters")
    void employeeConstructorAndGetters() {
        Employee employee = new Employee("12345", 50000.0);

        assertEquals("12345", employee.getId(), "Constructor should set the employee id");
        assertEquals(50000.0, employee.getSalary(), 0.001, "Constructor should set the employee salary");
        assertFalse(employee.isPaid(), "New employee should not be marked as paid by default");
    }

    @Test
    @DisplayName("Employee Setters")
    void employeeSetters() {
        Employee employee = new Employee("12345", 50000.0);

        employee.setId("54321");
        employee.setSalary(60000.0);
        employee.setPaid(true);

        assertEquals("54321", employee.getId(), "setId should set the employee id");
        assertEquals(60000.0, employee.getSalary(), 0.001, "setSalary should set the employee salary");
        assertTrue(employee.isPaid(), "setPaid should set the paid status to true");
    }

    @Test
    @DisplayName("Employee to String")
    void employeeToString() {
        Employee employee = new Employee("54321", 35000.0);
        String result = employee.toString();
        assertEquals("Employee [id=54321, salary=35000.0]", result, "toString should return the expected string");
    }
}
