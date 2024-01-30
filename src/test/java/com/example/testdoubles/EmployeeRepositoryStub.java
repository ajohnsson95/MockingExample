package com.example.testdoubles;

import com.example.Employee;
import com.example.EmployeeRepository;

import java.util.List;

public class EmployeeRepositoryStub implements EmployeeRepository {
    private final List<Employee> employees;

    public EmployeeRepositoryStub(List<Employee> employees) {
        this.employees = employees;
    }

    @Override
    public List<Employee> findAll() {
        return employees;
    }

    @Override
    public Employee save(Employee e) {
        return e;
    }
}