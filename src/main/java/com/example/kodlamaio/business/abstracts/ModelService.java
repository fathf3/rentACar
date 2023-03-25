package com.example.kodlamaio.business.abstracts;

import java.util.List;

import com.example.kodlamaio.business.requests.CreateModelRequest;
import com.example.kodlamaio.business.responses.GetAllModelsResponse;

public interface ModelService {
	
	List<GetAllModelsResponse> getAll();
	void add(CreateModelRequest createModelRequest);
}
