package com.assessment.services.businessservice;/**
 * Created by Anand Tadepalli on 9/16/2017.
 */

import org.springframework.http.HttpStatus;

import java.util.ArrayList;
import java.util.List;

public class Response {
    private HttpStatus httpStatus;
    private List<String> errorMessages = new ArrayList<>();

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }

    public List<String> getErrorMessages() {
        return errorMessages;
    }

    public void setErrorMessages(List<String> errorMessages) {
        this.errorMessages = errorMessages;
    }
}
