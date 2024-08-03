package com.eshopping.bmw.core.domain.specification.shared;

/**
 * @Author Paul Kevin ESSELEBO<esselebomebara@gmail.com>
 */
public interface Specification<T> {
	/**
	 * Return true if the provided item satisfies the specification
	 * @param item
	 * @return
	 */
	boolean isSatisfiedBy(T item);
}
