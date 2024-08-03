package com.eshopping.bmw.core.domain.utils;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;

import lombok.experimental.UtilityClass;

@UtilityClass
public class IdUtils {

	public static Long randomId() {
		return randomId(String.valueOf(UUID.randomUUID()));
	}

	public static Long randomId(final String input) {
		try {
			MessageDigest digest = MessageDigest.getInstance("SHA-256");
			byte[] hash = digest.digest(input.getBytes(StandardCharsets.UTF_8));
			BigInteger number = new BigInteger(1, hash);
			return number.longValue();
		} catch (NoSuchAlgorithmException e) {
			return null;
		}
	}
}
