package it.ictpiemonte.immobiliare.exception;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@ControllerAdvice
public class ExceptionManagement {

	@ExceptionHandler({MethodArgumentNotValidException.class})
	public ResponseEntity<String> handleArgumentNotValidValue(MethodArgumentNotValidException ex) {

		BindingResult bindingResults = ex.getBindingResult();
		List<String> errors = bindingResults
				.getFieldErrors()
				.stream().map(e -> {
					return e.getField()+": "+e.getDefaultMessage();
				})
				.collect(Collectors.toList());

		return new ResponseEntity<String>(errors.toString(), HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler({ConstraintViolationException.class})
	public ResponseEntity<String> handleConstraintViolation(ConstraintViolationException ex) {

		Set<ConstraintViolation<?>> violations = ex.getConstraintViolations();
		List<String> errors = violations
				.stream().map(e -> {
					return e.getMessage();
				})
				.collect(Collectors.toList());

		return new ResponseEntity<String>(errors.toString(), HttpStatus.BAD_REQUEST);
	}


}
