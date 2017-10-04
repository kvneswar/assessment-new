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
import com.assessment.services.domain.TestResults;

@RestController
public class TestResultsController {

	@Autowired
	private AssessmentService assessmentService;
	
	@GetMapping("/test-result")
	public List<TestResults> getTestResults(){
    	return assessmentService.getTestResults();
    }
    
	@GetMapping(value="/test-result", params="ids")
    public List<TestResults> getTestResultsBasedOnIds(@RequestParam List<Long> ids){
    	return assessmentService.getTestResultsBasedOnIds(ids);
    }
    
	@GetMapping("/test-result/{id}")
    public TestResults getTestResultBasedOnId(@PathVariable long id){
    	return assessmentService.getTestResultBasedOnId(id);
    }
    
	@PostMapping("/test-result")
    public TestResults saveTestResult(@RequestBody TestResults testResults){
    	return assessmentService.saveTestResult(testResults);
    }
    
	@PostMapping("/test-results")
	public List<TestResults> saveTestResults(@RequestBody List<TestResults> testResults){
    	return assessmentService.saveTestResults(testResults);
    }
    
	@DeleteMapping("/test-result/{id}")
    public void deleteTestResult(@PathVariable long id){
    	assessmentService.deleteTestResult(id);
    }
	
}
