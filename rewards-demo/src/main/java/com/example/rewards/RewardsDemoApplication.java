package com.example.rewards;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class RewardsDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(RewardsDemoApplication.class, args);
	}
	
	@Bean
	RestTemplate restTemplate() {
		RestTemplate restTemplate = new RestTemplate();
        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
        converter.setObjectMapper(new ObjectMapper());
        
        // Add Jackson converter to RestTemplate
        List converters = restTemplate.getMessageConverters();
        converters.add(converter);
        restTemplate.setMessageConverters(converters);
        
		return restTemplate;
	}

}
