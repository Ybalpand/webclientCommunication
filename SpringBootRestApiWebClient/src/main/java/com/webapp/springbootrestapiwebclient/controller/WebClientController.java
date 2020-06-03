package com.webapp.springbootrestapiwebclient.controller;

import org.springframework.http.HttpHeaders;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import com.webapp.springbootrestapiwebclient.entity.Customer;


@RestController
public class WebClientController {

	public static Customer getCustomerByInfo(Integer customerId) {

		WebClient webClient = WebClient.builder().baseUrl("http://localhost:8080/springbootrestapi")
				.defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE).build();
		 Customer cust =  webClient.get().uri("/customers/" + customerId).retrieve().bodyToMono(Customer.class).block();
		
		 
		return cust;
	}

}
