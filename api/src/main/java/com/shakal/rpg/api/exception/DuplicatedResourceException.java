package com.shakal.rpg.api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class DuplicatedResourceException extends Exception {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DuplicatedResourceException(String message) {
        super(message);

    }
}
