package com.example.kodlamaio.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.kodlamaio.entities.concretes.Model;

public interface ModelRepository extends JpaRepository<Model, Integer>{

}
