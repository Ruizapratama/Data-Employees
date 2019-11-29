package com.Employee.DataEmployee.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Employee.DataEmployee.model.ParameterPajak;

@Repository
public interface ParameterPajakRepository extends JpaRepository<ParameterPajak, Long> {

}