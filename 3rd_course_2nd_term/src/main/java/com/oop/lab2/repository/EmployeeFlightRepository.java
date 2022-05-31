package com.oop.lab2.repository;

import com.oop.lab2.domain.EmployeeFlight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeFlightRepository extends JpaRepository<EmployeeFlight, Long> {

}
