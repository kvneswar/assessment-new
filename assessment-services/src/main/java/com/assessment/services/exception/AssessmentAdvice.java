package com.assessment.services.exception;/**
 * Created by Anand Tadepalli on 9/16/2017.
 */

import com.assessment.services.businessservice.Response;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class AssessmentAdvice {
    @ExceptionHandler(AssessmentException.class)
    public Response handleException(HttpServletRequest request, AssessmentException ex) throws Throwable {
        throw ex.getCause();
    }

    @ExceptionHandler(Exception.class)
    public Response handleOtherException(HttpServletRequest request, Exception ex) throws Exception{
        throw ex;
    }
}

