package com.eshopping.bmw.core.domain.specification.shared;

/**
 * @Author Paul Kevin ESSELEBO<esselebomebara@gmail.com>
 */
public abstract class AbstractSpecification<T> implements Specification<T> {

	public Specification<T> and(final Specification<T> specification) {
		return new AndSpecification<>(this, specification);
	}
}
