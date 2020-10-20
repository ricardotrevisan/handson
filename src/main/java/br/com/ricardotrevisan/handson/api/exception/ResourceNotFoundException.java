package br.com.ricardotrevisan.handson.api.exception;

import br.com.ricardotrevisan.handson.domain.exception.BusinessException;

public class ResourceNotFoundException extends BusinessException {

	private static final long serialVersionUID = 1L;

	public ResourceNotFoundException(String message) {
		super(message);
	}
	
}


