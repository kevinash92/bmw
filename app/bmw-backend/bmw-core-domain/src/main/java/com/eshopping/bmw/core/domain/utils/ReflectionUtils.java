package com.eshopping.bmw.core.domain.utils;

import java.lang.reflect.Field;

import lombok.experimental.UtilityClass;

@UtilityClass
public final class ReflectionUtils {

	/**
	 * Sets a private property of a given object
	 *
	 * @param obj       the object whose property is to be set
	 * @param fieldName the name of the property to set
	 * @param value     the value to set to the property
	 * @throws Exception if any reflection error occurs
	 */
	public static void setPrivateProperty(final Object obj, final String fieldName, final Object value) throws Exception {
		// Get the class of the object
		Class<?> clazz = obj.getClass();

		// Get the private field
		Field field = clazz.getDeclaredField(fieldName);

		// Make the field accessible
		field.setAccessible(true);

		// Set the value of the field
		field.set(obj, value);
	}
}
