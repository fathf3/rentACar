package com.example.kodlamaio.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.kodlamaio.business.abstracts.ModelService;
import com.example.kodlamaio.business.requests.CreateModelRequest;
import com.example.kodlamaio.business.responses.GetAllModelsResponse;
import com.example.kodlamaio.core.utilities.mappers.ModelMapperService;
import com.example.kodlamaio.dataAccess.abstracts.ModelRepository;
import com.example.kodlamaio.entities.concretes.Model;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ModelManager implements ModelService{
	
	private ModelRepository modelRepository;
	private ModelMapperService modelMapperService;
	
	@Override
	public List<GetAllModelsResponse> getAll() {
		
		List<Model> models = modelRepository.findAll();
		
		List<GetAllModelsResponse> modelsResponse = models.stream()
				.map(model->this.modelMapperService.forResponse()
						.map(model, GetAllModelsResponse.class)).collect(Collectors.toList());
		return modelsResponse;
	}

	@Override
	public void add(CreateModelRequest createModelRequest) {
		
		Model model = this.modelMapperService.forRequest().map(createModelRequest, Model.class);
		this.modelRepository.save(model);
		
	}

	
	
	
	
	
	
}
