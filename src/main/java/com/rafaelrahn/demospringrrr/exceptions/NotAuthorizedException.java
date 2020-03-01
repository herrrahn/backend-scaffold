package com.rafaelrahn.demospringrrr.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.UNAUTHORIZED)
public class NotAuthorizedException extends RuntimeException {
}
