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
import com.assessment.services.domain.QuestionBank;

@RestController
public class QuestionBankController {
	
	@Autowired
    private AssessmentService assessmentService;
	
	@GetMapping(value = "/questions")
    public List<QuestionBank> getAllQuestion(){
        return assessmentService.getAllQuestions();
    }
    
    @GetMapping(value = "/question")
    public List<QuestionBank> getQuestionsByIds(@RequestParam(name="ids") List<Long> ids){
    	return assessmentService.getQuestionsByIds(ids);
    }

    @GetMapping(value = "/question/{id}")
    public QuestionBank getQuestion(@PathVariable("id") Long id){
        return assessmentService.getQuestion(id);
    }

    @PostMapping(value = "/question")
    public QuestionBank saveQuestionk(@RequestBody QuestionBank question) {
        return assessmentService.addQuestion(question);
    }
    
    @PostMapping(value = "/questions")
    public List<QuestionBank> saveQuestionk(@RequestBody List<QuestionBank> questions) {
        return assessmentService.addQuestions(questions);
    }

    @DeleteMapping(value = "/questions")
    public void deleteAllQuestions() {
        assessmentService.deleteAllQuestions();
    }
    
    @DeleteMapping(value = "/question/{id}")
    public void deleteAllQuestions(@PathVariable Long id) {
        assessmentService.deleteAQuestion(id);
    }

}
