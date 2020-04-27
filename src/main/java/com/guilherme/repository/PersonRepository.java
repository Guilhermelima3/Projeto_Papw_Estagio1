package com.guilherme.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.guilherme.domain.Person;;

public interface PersonRepository extends JpaRepository < Person, Integer>{

}
