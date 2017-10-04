package com.assessment.services.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.assessment.services.businessservice.AssessmentService;
import com.assessment.services.domain.QuestionBank;
import com.assessment.services.domain.Test;

@RestController
@RequestMapping(params="school-code")
public class TestDetailsController {
	
	@Autowired
	private AssessmentService assessmentService;
	
	@GetMapping(value = "/test")
    public Page<Test> getAlltests(@RequestParam("school-code") String schoolCode, Pageable pageable){
        return assessmentService.getAllTests(schoolCode, pageable);
    }
    
    @GetMapping(value = "/test", params="ids")
    public Page<Test> getTestsByIds(@RequestParam("school-code") String schoolCode, 
    		@RequestParam(name="ids") List<Long> ids, Pageable pageable){
        return assessmentService.getAllTests(schoolCode, ids, pageable);
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

    @DeleteMapping(value = "/test")
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
