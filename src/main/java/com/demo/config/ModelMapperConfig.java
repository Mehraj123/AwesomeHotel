package com.demo.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * 
 * Spring Bean configuration class for ModelMapper
 * 
 * @author Mehraj Malik
 * @version 1.0
 *
 */
@Component
public class ModelMapperConfig {

	/**
	 * Create a bean of Model Mapper and register into Spring Context
	 */
	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

}
