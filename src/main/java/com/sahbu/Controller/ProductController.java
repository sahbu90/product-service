package com.sahbu.Controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.sahbu.dto.ProductRequest;
import com.sahbu.dto.ProductResponse;
import com.sahbu.service.ProductService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {
	
	private final ProductService productService;
  @PostMapping
  @ResponseStatus(code = HttpStatus.CREATED)
  public ProductResponse createProduct(@RequestBody ProductRequest product) {
	 return  productService.createProduct(product);
  }
  @GetMapping
  @ResponseStatus(code = HttpStatus.OK)
  public List<ProductResponse> getAllProducts(){
	  return productService.getAllProducts();
  }
}
