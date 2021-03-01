package com.egen.orders.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.egen.orders.enums.Errors;

/**
 * @author sanjaykhan
 *
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends Exception { // Custom Exception Handling Class
	private static final long serialVersionUID = 1L;

	/**
	 * @param orderNotFound
	 */
	public ResourceNotFoundException(Errors orderNotFound) {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
