package com.oop.lab2.service;


import com.oop.lab2.repository.EmployeeFlightRepository;
import com.oop.lab2.domain.EmployeeFlight;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeFlightService {

    @Autowired
    private EmployeeFlightRepository repository;

    public void addFlightEmployee(EmployeeFlight employeeFlight) {
        repository.save(employeeFlight);
    }

    public void deleteFlight(EmployeeFlight employeeFlight) {
        repository.delete(employeeFlight);
    }
}
