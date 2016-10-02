package com.bj58.api.exceptions;

import java.io.IOException;

public class AccountCaptchaException extends Exception {

	public AccountCaptchaException(String msg) {
		super(msg);
	}

	public AccountCaptchaException(String msg, Throwable e) {
		super(msg, e);
	}

}
