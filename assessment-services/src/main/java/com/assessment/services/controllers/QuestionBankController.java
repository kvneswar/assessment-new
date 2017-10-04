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

@RestController
@RequestMapping(params="school-code")
public class QuestionBankController {
	
	@Autowired
    private AssessmentService assessmentService;
	
	@GetMapping(value = "/question")
    public Page<QuestionBank> getAllQuestion(@RequestParam("school-code") String schoolCode, Pageable pageable){
        return assessmentService.getAllQuestions(schoolCode, pageable);
    }
    
    @GetMapping(value = "/question", params="ids")
    public Page<QuestionBank> getQuestionsByIds(@RequestParam("school-code") String schoolCode, 
    		@RequestParam(name="ids") List<Long> ids, Pageable pageable){
    	return assessmentService.getQuestionsByIds(schoolCode, ids, pageable);
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

    @DeleteMapping(value = "/question")
    public void deleteAllQuestions() {
        assessmentService.deleteAllQuestions();
    }
    
    @DeleteMapping(value = "/question/{id}")
    public void deleteAllQuestions(@PathVariable Long id) {
        assessmentService.deleteAQuestion(id);
    }

}
