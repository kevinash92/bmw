package com.eshopping.bmw.framework.config;

import java.text.Normalizer;

public class H2Functions {
	public static String unaccent(final String input) {
		if (input == null) {
			return null;
		}
		return Normalizer.normalize(input, Normalizer.Form.NFD).replaceAll("\\p{M}", "");
	}
}
