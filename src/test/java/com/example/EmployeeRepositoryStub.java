package com.example;

import com.example.testdoubles.BankServiceSpy;
import com.example.testdoubles.EmployeeRepositoryStub;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

class EmployeesCustomDoubleTest {

    @Test
    @DisplayName("pay employees successfully")
    void payEmployeesSuccessfully() {
        EmployeeRepositoryStub employeeRepositoryStub = new EmployeeRepositoryStub(
                Collections.singletonList(new Employee("123", 1000.0)));
        BankServiceSpy bankServiceSpy = new BankServiceSpy();
        Employees employees = new Employees(employeeRepositoryStub, bankServiceSpy);

      int payments = employees.payEmployees();

        assertEquals(1, payments);
        assertEquals(1, bankServiceSpy.getNumberOfCalls());
    }

    @Test
    @DisplayName("pay employees with exception")
    void payEmployeesWithException() {
        EmployeeRepositoryStub employeeRepositoryStub = new EmployeeRepositoryStub(
                Collections.singletonList(new Employee("123", 1000.0)));
        BankServiceSpy bankServiceSpy = new BankServiceSpy();
        bankServiceSpy.setShouldThrowException(true);

        Employees employees = new Employees(employeeRepositoryStub, bankServiceSpy);
        int payments = employees.payEmployees();

        assertEquals(0, payments);
        Employee employee = employeeRepositoryStub.findAll().get(0);
        assertFalse(employee.isPaid());
        assertEquals(1, bankServiceSpy.getNumberOfCalls());
    }
}