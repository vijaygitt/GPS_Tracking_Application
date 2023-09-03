package com.GPS_Tracking.Application.exceptions;

import com.GPS_Tracking.Application.payloads.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

/**
 * Global exception handler for the GPS Tracking application.
 * This class handles custom exceptions and validation errors, returning appropriate API responses.
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * Handles OwnerNotFoundException and returns an API response with a 404 NOT FOUND status.
     *
     * @param ex The OwnerNotFoundException that was thrown.
     * @return A ResponseEntity containing an API response with the error message and status.
     */
    @ExceptionHandler(OwnerNotFoundException.class)
    public ResponseEntity<ApiResponse> OwnerNotFoundExceptionHandler(OwnerNotFoundException ex){
        String message= ex.getMessage();
        ApiResponse apiResponse=new ApiResponse(message,false);
        return new ResponseEntity<>(apiResponse, HttpStatus.NOT_FOUND);
    }

    /**
     * Handles VehicleNotFoundException and returns an API response with a 404 NOT FOUND status.
     *
     * @param ex The VehicleNotFoundException that was thrown.
     * @return A ResponseEntity containing an API response with the error message and status.
     */
    @ExceptionHandler(VehicleNotFoundException.class)
    public ResponseEntity<ApiResponse> VehicleNotFoundExceptionHandler(VehicleNotFoundException ex){
        String message= ex.getMessage();
        ApiResponse apiResponse=new ApiResponse(message,false);
        return new ResponseEntity<>(apiResponse, HttpStatus.NOT_FOUND);
    }

    /**
     * Handles VehicleOwnerMappingNotFoundException and returns an API response with a 404 NOT FOUND status.
     *
     * @param ex The VehicleOwnerMappingNotFoundException that was thrown.
     * @return A ResponseEntity containing an API response with the error message and status.
     */
    @ExceptionHandler(VehicleOwnerMappingNotFoundException.class)
    public  ResponseEntity<ApiResponse> VehicleOwnerMappingNotFoundExceptionHandler(VehicleOwnerMappingNotFoundException ex){
        String message= ex.getMessage();
        ApiResponse apiResponse=new ApiResponse(message,false);
        return new ResponseEntity<>(apiResponse,HttpStatus.NOT_FOUND);
    }

    /**
     * Handles VehicleOwnerMappingAlreadyExistsException and returns an API response with a 302 FOUND status.
     *
     * @param ex The VehicleOwnerMappingAlreadyExistsException that was thrown.
     * @return A ResponseEntity containing an API response with the error message and status.
     */
    @ExceptionHandler(VehicleOwnerMappingAlreadyExistsException.class)
    public  ResponseEntity<ApiResponse> VehicleOwnerMappingAlreadyExistsExceptionHandler(VehicleOwnerMappingAlreadyExistsException ex){
        String message= ex.getMessage();
        ApiResponse apiResponse=new ApiResponse(message,false);
        return new ResponseEntity<>(apiResponse,HttpStatus.FOUND);
    }

    /**
     * Handles MethodArgumentNotValidException (validation errors) and returns a map of field errors with a 400 BAD REQUEST status.
     *
     * @param ex The MethodArgumentNotValidException that was thrown.
     * @return A ResponseEntity containing a map of field errors and the status.
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String,String>> MethodArgumentNotValidExceptionHandler(MethodArgumentNotValidException ex){
        Map<String,String> resp=new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error)->{
            String fieldName=((FieldError)error).getField();
            String message=error.getDefaultMessage();
            resp.put(fieldName,message);
        });
        return new ResponseEntity<>(resp,HttpStatus.BAD_REQUEST);
    }
}
