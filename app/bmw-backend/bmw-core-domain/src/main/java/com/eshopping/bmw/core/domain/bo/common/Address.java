package com.eshopping.bmw.core.domain.bo.common;

import java.io.Serializable;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class Address implements Serializable {

	private static final long serialVersionUID = 1L;

	private String city;

	private String postalCode;

	private String stateProvince;

	private String zone;

	private String country;
}
