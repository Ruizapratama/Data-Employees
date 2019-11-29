package com.Employee.DataEmployee.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Employee.DataEmployee.model.Posisi;

@Repository
public interface PosisiRepository extends JpaRepository<Posisi, Long> {

}