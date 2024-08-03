package com.eshopping.bmw.core.application.bo;

import java.io.Serializable;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * This class must be extended by all service search method
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PagedResponse<T> implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<T> content;

	private int page;

	private int size;

	private long totalElements;

	private int totalPages;

	private boolean last;
}
