package com.Employee.DataEmployee.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Employee.DataEmployee.model.Agama;

@Repository
public interface AgamaRepository extends JpaRepository<Agama, Long> {
}