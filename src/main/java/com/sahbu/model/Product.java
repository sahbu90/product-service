package com.sahbu.model;

import java.math.BigDecimal;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Document(value = "product")
@AllArgsConstructor
@Builder
@Data
public class Product {

	private String id;
	private String name;
	private String description;
	private BigDecimal price;
}
