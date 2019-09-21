package com.bhupeshpadiyar.sbmr.exceptions;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

/**
 * @author Bhupesh Singh Padiyar
 *
 */

@ControllerAdvice
public class GlobalExceptionHandler {

  /**
   * Resource not found exception response entity.
   *
   * @param ex the ex
   * @param request the request
   * @return the response entity
   */
  @ExceptionHandler(UserNotFoundException.class)
  public ResponseEntity<?> UserNotFoundException(
      UserNotFoundException ex, WebRequest request) {
    ErrorResponse errorDetails =
        new ErrorResponse(new Date(), HttpStatus.NOT_FOUND.toString(), ex.getMessage(), request.getDescription(false));
    return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
  }

  /**
   * Globle excpetion handler response entity.
   *
   * @param ex the ex
   * @param request the request
   * @return the response entity
   */
  @ExceptionHandler(Exception.class)
  public ResponseEntity<?> globleExcpetionHandler(Exception ex, WebRequest request) {
    ErrorResponse errorDetails =
        new ErrorResponse(new Date(), HttpStatus.INTERNAL_SERVER_ERROR.toString() ,ex.getMessage(), request.getDescription(false));
    return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
  }
}
