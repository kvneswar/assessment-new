package com.assessment.services.exception;/**
 * Created by Anand Tadepalli on 9/16/2017.
 */

public class AssessmentException extends RuntimeException {

    public AssessmentException(String message, Throwable t) {
        super(message, t);
    }
}
