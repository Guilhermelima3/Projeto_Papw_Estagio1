package com.guilherme.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.guilherme.domain.Project;

public interface ProjectRepository extends JpaRepository<Project, Integer>{

}
