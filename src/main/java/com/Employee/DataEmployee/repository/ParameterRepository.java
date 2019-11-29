package com.Employee.DataEmployee.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Employee.DataEmployee.model.Parameter;

@Repository
public interface ParameterRepository extends JpaRepository<Parameter, Long> {

}