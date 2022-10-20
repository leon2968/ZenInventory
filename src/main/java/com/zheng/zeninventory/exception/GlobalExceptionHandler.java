
package com.zheng.zeninventory.exception;

import java.util.NoSuchElementException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
/*
 * class to handle exception globally
 */
public class GlobalExceptionHandler {

	@ExceptionHandler(value = NoSuchElementException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	/*
	 * Method to handle NoSuchElementException
	 */
	public @ResponseBody ExceptionResponse handleException(NoSuchElementException ex) {
		return new ExceptionResponse(HttpStatus.NOT_FOUND.value(), ex.getMessage());
	}
}