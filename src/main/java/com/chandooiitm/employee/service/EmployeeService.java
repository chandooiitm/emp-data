package com.chandooiitm.employee.service;

import com.chandooiitm.employee.entity.Employee;
import com.chandooiitm.employee.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public Employee createEmployee(Employee data) {
        return employeeRepository.save(data);
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employee getEmployeeById(Long id) {
        return employeeRepository.findById(id).orElse(null);
    }

    public Employee updateEmployee(Employee employee) {
        Employee existingEmployee = employeeRepository.findById(employee.getId()).get();
        //Add object mapping here using mapstruc dependency
        Employee updatedEmployee = employeeRepository.save(existingEmployee);
        return updatedEmployee;
    }

    public String deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
        return "data removed !! " + id;
    }

}