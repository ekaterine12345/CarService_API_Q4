package com.exam.javacarservice_api.controllers;

import com.exam.javacarservice_api.apiUtils.NoSuchElementFoundException;
import com.exam.javacarservice_api.dtos.ApiResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class ExceptionController {
    @ResponseBody
    @ExceptionHandler(NoSuchElementFoundException.class)
    public ApiResponse handelUnexpectedException(NoSuchElementFoundException e){
        ApiResponse apiResponse = new ApiResponse();
        //  apiResponse.addData("error", e.getMessage());
        apiResponse.addError("error", e.getMessage());
        return apiResponse;
    }

    @ResponseBody
    @ExceptionHandler(Exception.class)
    public ApiResponse handelUnexpectedException(Exception e){
        ApiResponse apiResponse = new ApiResponse();
        //    apiResponse.addData("unknown", e.getMessage());
        apiResponse.addError("unknown", e.getMessage());
        return apiResponse;
    }


}
