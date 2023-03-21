package com.example.kodlamaio.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.kodlamaio.business.abstracts.BrandService;
import com.example.kodlamaio.business.requests.CreateBrandRequest;
import com.example.kodlamaio.business.requests.UpdateBrandRequest;
import com.example.kodlamaio.business.responses.GetAllBrandResponse;
import com.example.kodlamaio.business.responses.GetByIdBrandResponse;
import com.example.kodlamaio.core.utilities.mappers.ModelMapperService;
import com.example.kodlamaio.dataAccess.abstracts.BrandRepository;
import com.example.kodlamaio.entities.concretes.Brand;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class BrandManager implements BrandService {
	private BrandRepository brandRepository;
	private ModelMapperService modelMapperService;

	@Override
	public List<GetAllBrandResponse> getAll() {
	
		// mapping
		List<Brand> brands = brandRepository.findAll();
		

		List<GetAllBrandResponse> brandsResponse = brands.stream()
				.map(brand -> this.modelMapperService.forResponse().map(brand, GetAllBrandResponse.class))
				.collect(Collectors.toList());

		return brandsResponse;
	}

	@Override
	public void add(CreateBrandRequest createBrandRequest) {

//		Brand brand=new Brand();
//		brand.setName(createBrandRequest.getName());

		Brand brand = this.modelMapperService.forRequest().map(createBrandRequest, Brand.class);

		this.brandRepository.save(brand);

	}

	@Override
	public GetByIdBrandResponse getById(int id) {
		Brand brand  =this.brandRepository.findById(id).orElseThrow();
		
		GetByIdBrandResponse response  = this.modelMapperService.forResponse().map(brand, GetByIdBrandResponse.class);
		
		return response;
	}

	@Override
	public void update(UpdateBrandRequest updateBrandRequest) {
		Brand brand = this.modelMapperService.forRequest().map(updateBrandRequest, Brand.class);
		this.brandRepository.save(brand);
		
	}

	@Override
	public void delete(int id) {
		brandRepository.deleteById(id);
		
	}

}
