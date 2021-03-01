package com.egen.orders.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author sanjaykhan
 *
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends Exception {
	private static final long serialVersionUID = 1L;

	/**
	 * @param message
	 */
	public ResourceNotFoundException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}
	
	
	
}
