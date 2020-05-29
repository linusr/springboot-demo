package me_4vr.menuapp.controller;

import me_4vr.menuapp.common.ErrorMessage;
import me_4vr.menuapp.common.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@RestController
@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

  private static final DateTimeFormatter ERR_TIME_FORMAT =
      DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");

  @ExceptionHandler({NotFoundException.class})
  public ResponseEntity<ErrorMessage> handleNotFoundException(
      NotFoundException ex, WebRequest request) {
    var msg = new ErrorMessage();
    msg.setMessage(
        String.format(
            "Request for %s failed",
                ((ServletWebRequest) request).getRequest().getRequestURI()));
    msg.setTimestamp(LocalDateTime.now().format(ERR_TIME_FORMAT));
    return new ResponseEntity<>(msg, HttpStatus.BAD_REQUEST);
  }
}
