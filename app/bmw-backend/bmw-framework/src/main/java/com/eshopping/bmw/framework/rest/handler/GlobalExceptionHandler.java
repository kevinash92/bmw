package com.eshopping.bmw.framework.rest.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.eshopping.bmw.core.application.exception.AbstractNotFoundException;
import com.eshopping.bmw.framework.rest.dto.ApiResponseDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

	private static final String START_OF_ERROR_MESSAGE_SEPARATOR = " : ";

	@AllArgsConstructor
	@Getter
	private class Response {

		private HttpStatusCode status;

		private String message;
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<ApiResponseDto> handleException(final Exception exception) {

		Response response = generateResponse(exception);

		log.error(response.getMessage(), exception);

		return ResponseEntity.status(response.getStatus())
				.body(ApiResponseDto.builder().success(false).message(response.getMessage()).build());
	}

	private Response generateResponse(final Exception exception) {

		HttpStatusCode status = HttpStatus.INTERNAL_SERVER_ERROR;

		String message = getLastCauseMessage(exception);

		if (exception instanceof AbstractNotFoundException) {
			status = HttpStatus.NOT_FOUND;
		}

		return new Response(status, message);
	}

	private String getLastCauseMessage(final Throwable exception) {
		Throwable cause = exception;
		while (cause.getCause() != null) {
			cause = cause.getCause();
		}

		String message = cause.getLocalizedMessage();
		int index = message.indexOf(START_OF_ERROR_MESSAGE_SEPARATOR);
		return index != -1 ? message.substring(index + START_OF_ERROR_MESSAGE_SEPARATOR.length()) : message;
	}
}
