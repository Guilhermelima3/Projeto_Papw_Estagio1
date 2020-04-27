package com.guilherme.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.guilherme.domain.Task;


public interface TaskRepository extends JpaRepository<Task, Integer> {
	
	public List<Task> findByStartDateBetweenAndStatus(Date initialDate, Date finalDate, Long status);
    public List<Task> findByStartDateBetween(Date initialDate, Date finalDate);
    public List<Task> findByTaskPointsBetween(Long initialPoints, Long finalPoints);
	

}
