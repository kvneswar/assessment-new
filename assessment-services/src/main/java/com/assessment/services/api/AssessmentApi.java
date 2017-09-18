package com.assessment.services.api;/**
 * Created by Anand Tadepalli on 9/16/2017.
 */

import com.assessment.services.businessservice.AssessmentService;
import com.assessment.services.domain.QuestionBank;
import com.assessment.services.domain.QuestionPaper;
import com.assessment.services.domain.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/assessment")
public class AssessmentApi {

    @Autowired
    private AssessmentService assessmentService;

    @GetMapping(value = "/questionPapers/{id}")
    public QuestionPaper getQuestionPapers(@PathVariable("id") String id){
        return assessmentService.getQuestionPaper(new Long(id));
    }

    @GetMapping(value = "/questionPapers")
    public List<QuestionPaper> getAllQuestionPapers() {
        return assessmentService.getAllQuestionPapers();
    }

    @PostMapping(value = "/questionPapers")
    public QuestionPaper saveQuestionPaper(@RequestBody QuestionPaper questionPaper) {
        return assessmentService.addQuestionPaper(questionPaper);
    }

    @DeleteMapping(value = "/questionPapers")
    public void deleteAll() {
        assessmentService.deleteAllQuestionPapers();
    }

    @GetMapping(value = "/questions/{id}")
    public QuestionBank getQuestion(@PathVariable("id") String id){
        return assessmentService.getQuestion(new Long(id));
    }

    @GetMapping(value = "/questions")
    public List<QuestionBank> getAllQuestion(){
        return assessmentService.getAllQuestions();
    }

    @PostMapping(value = "/questions")
    public QuestionBank saveQuestionBank(@RequestBody QuestionBank question) {
        return assessmentService.addQuestion(question);
    }

    @DeleteMapping(value = "/questions")
    public void deleteAllQuestions() {
        assessmentService.deleteAllQuestions();
    }

    
    
    
    @GetMapping(value = "/tests")
    public List<Test> getAlltests(){
        return assessmentService.getAllTests();
    }
    
    @GetMapping(value = "/test")
    public List<Test> getTestsByIds(@RequestParam(name="ids", required=true) List<Long> ids){
        return assessmentService.getAllTests(ids);
    }

    @GetMapping(value = "/test/{id}")
    public Test test(@PathVariable("id") String id){
        return assessmentService.getTest(new Long(id));
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
