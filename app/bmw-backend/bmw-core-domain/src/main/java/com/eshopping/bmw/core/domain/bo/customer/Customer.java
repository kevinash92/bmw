package com.eshopping.bmw.core.domain.bo.customer;

import java.time.LocalDate;

import com.eshopping.bmw.core.domain.bo.common.Address;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = {"id"})
public class Customer {

	private Long id;

	private String firstName;

	private String lastName;

	private String email;

	private LocalDate dateOfBirth;

	private CustomerGender gender;

	private Address address;

	private String phoneNumber;

}
