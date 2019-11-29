package com.Employee.DataEmployee.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Employee.DataEmployee.model.TunjanganPegawai;

@Repository
public interface TunjanganPegawaiRepository extends JpaRepository<TunjanganPegawai, Long> {

}