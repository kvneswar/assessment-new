package com.assessment.services.exception;/**
 * Created by Anand Tadepalli on 9/16/2017.
 */

import com.assessment.services.businessservice.Response;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.web.AbstractErrorController;
import org.springframework.boot.autoconfigure.web.ErrorAttributes;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class AssessmentErrorController extends AbstractErrorController {

    @Value("${error.path:/error}")
    private String errorPath;

    public AssessmentErrorController(ErrorAttributes errorAttributes) {
        super(errorAttributes);
    }

    @Override
    public String getErrorPath() {
        return errorPath;
    }

    @RequestMapping(value ="${error.path:/error}", produces = "application/json;")
    public Response error(HttpServletRequest request) {
        Response response = new Response();
        response.setHttpStatus(getStatus(request));
        response.getErrorMessages().add("An error occurred that the application could not handle. Reason: "
                + getErrorAttributes(request, false));
        return response;
    }
}
