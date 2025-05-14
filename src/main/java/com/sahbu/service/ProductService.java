package com.sahbu.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sahbu.dto.ProductRequest;
import com.sahbu.dto.ProductResponse;
import com.sahbu.model.Product;
import com.sahbu.repo.ProductRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {

	private final ProductRepository productRepository;
	public ProductResponse createProduct(ProductRequest req) {
		Product product = Product.builder()
		.name(req.name())
		.description(req.description())
		.price(req.price())
		.build();
		Product product2 = productRepository.save(product);
		log.info("Prodcut Successfully Created");
		return new ProductResponse(product2.getId(), product2.getName(), product2.getDescription(), product2.getPrice());
	}
	public List<ProductResponse> getAllProducts() {
		
		return productRepository.findAll()
				.stream()
				.map(product -> new ProductResponse(product.getId(), product.getName(), product.getDescription(), product.getPrice()))
				.toList();
				
	}

}
