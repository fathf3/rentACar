package com.example.kodlamaio.business.abstracts;

import java.util.List;

import com.example.kodlamaio.business.requests.CreateBrandRequest;
import com.example.kodlamaio.business.requests.UpdateBrandRequest;
import com.example.kodlamaio.business.responses.GetAllBrandsResponse;
import com.example.kodlamaio.business.responses.GetByIdBrandResponse;

public interface BrandService {
	List<GetAllBrandsResponse> getAll();
	GetByIdBrandResponse getById(int id);
	void add(CreateBrandRequest createBrandRequest);
	void update(UpdateBrandRequest updateBrandRequest);
	void delete(int id);

}