package com.Employee.DataEmployee.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Employee.DataEmployee.model.Pendapatan;

@Repository
public interface PendapatanRepository extends JpaRepository<Pendapatan, Long> {

}