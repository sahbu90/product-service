package com.sahbu;


import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.context.annotation.Import;
import org.testcontainers.containers.MongoDBContainer;

import io.restassured.RestAssured;

@Import(TestcontainersConfiguration.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class ProductServiceApplicationTests {
	@ServiceConnection
	static MongoDBContainer mongoDBContainer = new MongoDBContainer("mongo:latest");
	
	@LocalServerPort
	private Integer port;
	
	@BeforeEach
	void setUp() {
		RestAssured.baseURI = "http://localhost";
		RestAssured.port = port;
	}
	
	static {
		mongoDBContainer.start();
	}
	
	@Test
	void shouldCreateProduct() {
		System.out.println("Going to validate");
		String requestBody = """
				{
    "name" : "Iphone 15",
    "description" : "Iphone 15 is a smartphone from Apple Inc",
    "price" : "78199"
     }
				""";
		RestAssured.given()
		.contentType("application/json")
		.body(requestBody)
		.when()
		.post("/api/products")
		.then()
		.statusCode(201)
		.body("id", Matchers.notNullValue())
		.body("name", Matchers.equalTo("Iphone 15"))
		.body("description", Matchers.equalTo("Iphone 15 is a smartphone from Apple Inc"))
		.body("price", Matchers.equalTo(78199));
		System.out.println("validated");

	}

}
