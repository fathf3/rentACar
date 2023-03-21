package com.example.kodlamaio.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.kodlamaio.entities.concretes.Brand;

public interface BrandRepository extends  JpaRepository<Brand, Integer> {

}
