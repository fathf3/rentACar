package com.example.kodlamaio.business.rules;

import org.springframework.stereotype.Service;

import com.example.kodlamaio.core.utilities.exceptions.BusinessException;
import com.example.kodlamaio.dataAccess.abstracts.BrandRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service // IoC ye yerlestirip her seferinde ordan kullanmamizi saglar

public class BrandBussniessRules {
	
	
	private BrandRepository brandRepository;
	
	public void checkIfBrandNameExists(String name) {
		
		if(this.brandRepository.existsByName(name)) {
			
			// Java exception types 
			throw new BusinessException("Brand already exists");
			
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
