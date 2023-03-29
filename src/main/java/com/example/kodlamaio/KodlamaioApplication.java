package com.example.kodlamaio;

import java.util.HashMap;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.kodlamaio.core.utilities.exceptions.BusinessException;
import com.example.kodlamaio.core.utilities.exceptions.ProblemDetails;
import com.example.kodlamaio.core.utilities.exceptions.ValidationProblemDetails;

@SpringBootApplication
@RestControllerAdvice //
public class KodlamaioApplication {

	public static void main(String[] args) {
		SpringApplication.run(KodlamaioApplication.class, args);
	}

	@ExceptionHandler // Hata varsa buradan gecer
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public ProblemDetails handleBusinessException(BusinessException businessException) {
		ProblemDetails problemDetails = new ProblemDetails();
		problemDetails.setMessage(businessException.getMessage());
		return problemDetails;
	}

	@ExceptionHandler // @RestControllerAdvice ile birlikte kullanilir. (Trick Noktasi)
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public ProblemDetails handleValidationException(MethodArgumentNotValidException methodArgumentNotValidException) { // class
																														// adinin
																														// önemi
																														// yok
		ValidationProblemDetails validationProblemDetails = new ValidationProblemDetails();
		validationProblemDetails.setMessage("VALIDATION.EXCEPTION");
		validationProblemDetails.setValidationErrors(new HashMap<>());

		for (FieldError fieldError : methodArgumentNotValidException.getBindingResult().getFieldErrors()) {
			validationProblemDetails.getValidationErrors().put(fieldError.getField(), fieldError.getDefaultMessage());
		}
		return validationProblemDetails;
	}

	@Bean
	public ModelMapper getModelMapper() {
		return new ModelMapper();
	}

}
