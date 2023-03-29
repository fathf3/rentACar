package com.example.kodlamaio.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.kodlamaio.entities.concretes.Brand;

public interface BrandRepository extends  JpaRepository<Brand, Integer> {
	boolean existsByName(String name); // JPA exists i gordugunde -> name e gore sorgu olusturur otomatik !
	
	// findByName vb. kullanimlar var Spring JPA keywords ! e bakabilirsiniz
	
}
