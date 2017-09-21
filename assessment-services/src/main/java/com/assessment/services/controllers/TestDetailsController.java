package com.assessment.services.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.assessment.services.businessservice.AssessmentService;
import com.assessment.services.domain.Test;

@RestController
public class TestDetailsController {
	
	@Autowired
	private AssessmentService assessmentService;
	
	@GetMapping(value = "/tests")
    public List<Test> getAlltests(){
        return assessmentService.getAllTests();
    }
    
    @GetMapping(value = "/test")
    public List<Test> getTestsByIds(@RequestParam(name="ids") List<Long> ids){
        return assessmentService.getAllTests(ids);
    }

    @GetMapping(value = "/test/{id}")
    public Test test(@PathVariable("id") Long id){
        return assessmentService.getTest(id);
    }

    @PostMapping(value = "/test")
    public Test saveTest(@RequestBody Test test) {
        return assessmentService.addTest(test);
    }
    
    @PostMapping(value = "/tests")
    public List<Test> saveTests(@RequestBody List<Test> tests) {
        return assessmentService.saveTests(tests);
    }

    @DeleteMapping(value = "/tests")
    public void deleteAllTests() {
        assessmentService.deleteAllTests();
    }
    
    @DeleteMapping(value = "/test/{id}")
    public void deleteATest(@PathVariable("id") long id) {
        assessmentService.deleteATest(id);
    }
    
    /*@DeleteMapping(value = "/test")
    public void deleteTestsByIds(@RequestParam List<Long> ids) {
        assessmentService.deleteTestsByIds(ids);
    }*/

}
