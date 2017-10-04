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
import com.assessment.services.domain.QuestionPaper;

@RestController
@RequestMapping(params="school-code")
public class QuestionPaperController {

	@Autowired
    private AssessmentService assessmentService;

    @GetMapping(value = "/question-paper")
    public Page<QuestionPaper> getAllQuestionPapers(@RequestParam("school-code") String schoolCode, Pageable pageable) {
        return assessmentService.getAllQuestionPapers(schoolCode, pageable);
    }
    
    @GetMapping(value = "/question-paper", params="ids")
    public Page<QuestionPaper> getAllQuestionPapers(@RequestParam("school-code") String schoolCode, 
    		@RequestParam(name="ids") List<Long> ids, Pageable pageable) {
        return assessmentService.getAllQuestionPapersBasedOnIds(schoolCode, ids, pageable);
    }
    
    @GetMapping(value = "/question-paper/{id}")
    public QuestionPaper getQuestionPapers(@PathVariable("id") String id){
        return assessmentService.getQuestionPaper(new Long(id));
    }

    @PostMapping(value = "/question-paper")
    public QuestionPaper saveQuestionPaper(@RequestBody QuestionPaper questionPaper) {
        return assessmentService.addQuestionPaper(questionPaper);
    }
    
    @DeleteMapping(value = "/question-paper/{id}")
    public void deleteQuestionPaper(@PathVariable("id") Long id) {
        assessmentService.deleteAQuestionPaper(id);
    }
    
    @DeleteMapping(value = "/question-paper")
    public void deleteAll() {
        assessmentService.deleteAllQuestionPapers();
    }
	
}
