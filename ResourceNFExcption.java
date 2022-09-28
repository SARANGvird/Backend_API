package com.shivila.boot.exceptn;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
@ResponseStatus(value=HttpStatus.NOT_FOUND)
public class ResourceNFExcption extends RuntimeException {

	
	public ResourceNFExcption(String message) {
		super(message);
	}
}
