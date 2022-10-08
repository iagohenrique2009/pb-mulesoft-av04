package br.com.mulesoft.paymentservicepb.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {
	
	 @Bean
	    public ModelMapper obterModelMapper() {
	        return new ModelMapper();
	    }
	 
}
