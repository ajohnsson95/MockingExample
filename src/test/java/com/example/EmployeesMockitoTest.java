package com.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class EmployeesMockitoTest {

    private EmployeeRepository employeeRepository;
    private BankService bankService;
    private Employees employees;

    @BeforeEach
    void setUp() {
        employeeRepository = mock(EmployeeRepository.class);
        bankService = mock(BankService.class);
        employees = new Employees(employeeRepository, bankService);
    }

    @Test
    @DisplayName("pay employees with exception mockito")
    void payEmployeesWithExceptionMockito() {
        List<Employee> employeeList = Arrays.asList(
                new Employee("123", 1000.0),
                new Employee("456", 2000.0)
        );
        when(employeeRepository.findAll()).thenReturn(employeeList);

        doThrow(RuntimeException.class).when(bankService).pay("123", 1000.0);

        int payments = employees.payEmployees();

        verify(bankService).pay("123", 1000.0);
        verify(bankService).pay("456", 2000.0);
        assertEquals(1, payments);
    }
}