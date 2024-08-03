package com.eshopping.bmw.core.domain.bo.common;

import java.math.BigDecimal;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = {"id"})
public class Product {

	private Long id;

	private String name;

	private String description;

	private BigDecimal price;

}
