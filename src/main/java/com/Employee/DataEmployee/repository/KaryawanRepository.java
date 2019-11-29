package com.Employee.DataEmployee.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Employee.DataEmployee.model.Karyawan;

@Repository
public interface KaryawanRepository extends JpaRepository<Karyawan, Long> {

}