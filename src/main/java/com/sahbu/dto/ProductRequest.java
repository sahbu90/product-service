package com.sahbu.dto;

import java.math.BigDecimal;

import lombok.Builder;
@Builder
public record ProductRequest(String id, String name, String description, BigDecimal price) {

}
