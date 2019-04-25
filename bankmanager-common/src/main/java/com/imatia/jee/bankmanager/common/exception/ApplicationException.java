package com.imatia.jee.bankmanager.common.exception;

import com.ontimize.jee.common.exceptions.OntimizeJEERuntimeException;

public class ApplicationException extends OntimizeJEERuntimeException {

	public ApplicationException() {

		super();
	}

	public ApplicationException(String message) {

		super(message);
	}

	public ApplicationException(Throwable cause) {

		super(cause);
	}

	public ApplicationException(String message, Throwable cause) {

		super(message, cause);
	}

//	public ApplicationException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
//
//		super(message, cause, enableSuppression, writableStackTrace);
//	}

}