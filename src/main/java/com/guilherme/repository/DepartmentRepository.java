package com.guilherme.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import com.guilherme.domain.Department;;

public interface DepartmentRepository extends JpaRepository<Department, Integer>{


}
