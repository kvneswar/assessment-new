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
import com.assessment.services.domain.QuestionPaper;

@RestController
public class QuestionPaperController {

	@Autowired
    private AssessmentService assessmentService;

    @GetMapping(value = "/questionPapers")
    public List<QuestionPaper> getAllQuestionPapers() {
        return assessmentService.getAllQuestionPapers();
    }
    
    @GetMapping(value = "/questionPaper")
    public List<QuestionPaper> getAllQuestionPapers(@RequestParam List<Long> ids) {
        return assessmentService.getAllQuestionPapers();
    }
    
    @GetMapping(value = "/questionPaper/{id}")
    public QuestionPaper getQuestionPapers(@PathVariable("id") String id){
        return assessmentService.getQuestionPaper(new Long(id));
    }

    @PostMapping(value = "/questionPaper")
    public QuestionPaper saveQuestionPaper(@RequestBody QuestionPaper questionPaper) {
        return assessmentService.addQuestionPaper(questionPaper);
    }
    
    @DeleteMapping(value = "/questionPaper/{id}")
    public void deleteQuestionPaper(@PathVariable("id") Long id) {
        assessmentService.deleteAQuestionPaper(id);
    }
    
    @DeleteMapping(value = "/questionPapers")
    public void deleteAll() {
        assessmentService.deleteAllQuestionPapers();
    }
	
}
