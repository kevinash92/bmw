package com.eshopping.bmw.core.domain.specification.shared;

/**
 * @Author Paul Kevin ESSELEBO<esselebomebara@gmail.com>
 */
public class AndSpecification<T> implements Specification<T> {

	private Specification<T> leftSpec;

	private Specification<T> rightSpec;

	public AndSpecification(final Specification<T> leftSpec, final Specification<T> rightSpec) {
		super();
		this.leftSpec = leftSpec;
		this.rightSpec = rightSpec;
	}

	@Override
	public boolean isSatisfiedBy(final T item) {
		return leftSpec.isSatisfiedBy(item) && rightSpec.isSatisfiedBy(item);
	}

}
