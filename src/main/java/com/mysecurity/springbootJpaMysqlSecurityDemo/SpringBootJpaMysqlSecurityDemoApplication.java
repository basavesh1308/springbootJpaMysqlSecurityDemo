package com.mysecurity.springbootJpaMysqlSecurityDemo;

import com.mysecurity.springbootJpaMysqlSecurityDemo.entity.UserCred;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@SpringBootApplication

//If JPA is not working , then add cmpt scan very important and enableJpaRepo...
@EnableJpaRepositories()
@ComponentScan(basePackages = {"com.mysecurity.springbootJpaMysqlSecurityDemo"})
public class SpringBootJpaMysqlSecurityDemoApplication {

	static RestTemplate restTemplate = new RestTemplate();
	private static final String HOME_URL = "http://localhost:8080/";
	private static final String GET_USER_URL = "http://localhost:8080/getUserCred/divya";

	public static void main(String[] args) {
		SpringApplication.run(SpringBootJpaMysqlSecurityDemoApplication.class, args);
		//callHelloApi();
		callGetUserCredApi();
	}

	public static void callHelloApi(){

		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<String> httpEntity = new HttpEntity<>(null,httpHeaders);
		ResponseEntity<String> responseEntity = restTemplate.exchange(HOME_URL, HttpMethod.GET, httpEntity, String.class);
		System.out.println("body: "+responseEntity.getBody() + " \nstatusCode : " +responseEntity.getStatusCode());


	}

	public static void callGetUserCredApi(){

		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<UserCred> httpEntity = new HttpEntity<>(null,httpHeaders);
		ResponseEntity<UserCred> responseEntity = restTemplate.exchange(GET_USER_URL, HttpMethod.GET, httpEntity, UserCred.class);
		System.out.println("body: "+responseEntity.getBody().toString() + " \nstatusCode : " +responseEntity.getStatusCode());


	}

}
