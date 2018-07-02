package com.raudra.exception.handler;

import com.raudra.exception.CourseNotCreateException;
import com.raudra.exception.CourseNotFoundException;
import com.raudra.exception.error.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@RestControllerAdvice
public class CustomizedRestExceptionHandler extends ResponseEntityExceptionHandler{

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> hanldeAllExceptions(Exception exc ,
                                                 WebRequest request ){
        ErrorResponse errorResponse = new ErrorResponse();

        errorResponse.setTimeStamp(new Date().getTime());
        errorResponse.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        errorResponse.setTitle("Course Not Found");
        errorResponse.setDeveloperMessage(exc.getClass().getName());
        request.getDescription(false);

        return new ResponseEntity<Object>(errorResponse ,
                                                  HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(CourseNotFoundException.class)
    public ResponseEntity<?> hanldeCourseNotFoundExceptions(ClassNotFoundException exc ,
                                                 WebRequest request ){
        ErrorResponse errorResponse = new ErrorResponse();

        errorResponse.setTimeStamp(new Date().getTime());
        errorResponse.setStatus(HttpStatus.NOT_FOUND.value());
        errorResponse.setTitle("Course Not Found");
        errorResponse.setDeveloperMessage(exc.getClass().getName());

        return new ResponseEntity<Object>(errorResponse, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(CourseNotCreateException.class)
    public ResponseEntity<?> handleCourseNotCreateException(CourseNotCreateException exc , WebRequest request){
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setTimeStamp(new Date().getTime());
        errorResponse.setStatus(HttpStatus.BAD_REQUEST.value());
        errorResponse.setTitle("Course not Create");
        errorResponse.setDeveloperMessage(exc.getClass().getName());

        return new ResponseEntity<Object>(errorResponse , HttpStatus.BAD_REQUEST);
    }
}
