package com.Employee.DataEmployee.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Employee.DataEmployee.model.Penempatan;

@Repository
public interface PenempatanRepository extends JpaRepository<Penempatan, Long> {

}