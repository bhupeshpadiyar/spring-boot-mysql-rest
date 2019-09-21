package com.bhupeshpadiyar.sbmr.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author Bhupesh Singh Padiyar
 *
 */

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class UserNotFoundException extends Exception {

	  /**
	   * Instantiates a new User not found exception.
	   *
	   * @param message the message
	   */
	  public UserNotFoundException(String message) {
	    super(message);
	  }
}
