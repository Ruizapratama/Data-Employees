package com.Employee.DataEmployee.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Employee.DataEmployee.model.Kemampuan;

@Repository
public interface KemampuanRepository extends JpaRepository<Kemampuan, Long> {

}