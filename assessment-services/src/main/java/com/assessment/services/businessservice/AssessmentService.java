package com.assessment.services.businessservice;/**
 * Created by Anand Tadepalli on 9/16/2017.
 */

import com.assessment.services.domain.QuestionBank;
import com.assessment.services.domain.QuestionPaper;
import com.assessment.services.domain.Test;
import com.assessment.services.domain.TestResults;
import com.assessment.services.repositories.QuestionBankRepository;
import com.assessment.services.repositories.QuestionPaperRepository;
import com.assessment.services.repositories.TestRepository;
import com.assessment.services.repositories.TestResultsRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AssessmentService {

    @Autowired
    private QuestionBankRepository questionBankRepository;
    
    @Autowired
    private QuestionPaperRepository questionPaperRepository;
    
    @Autowired
    private TestRepository testRepository;
    
    @Autowired
    private TestResultsRepository testResultsRepository; 


    public List<QuestionBank> addQuestions(List<QuestionBank> questions) {
        return questionBankRepository.save(questions);
    }

    public QuestionBank addQuestion(QuestionBank question) {
        return questionBankRepository.save(question);
    }
    

    public QuestionPaper addQuestionPaper(QuestionPaper questionPaper) {
        return questionPaperRepository.save(questionPaper);
    }
    
    public List<QuestionPaper> addQuestionPaper(List<QuestionPaper> questionPapers) {
        return questionPaperRepository.save(questionPapers);
    }

    public void addQuestionPapers(List<QuestionPaper> questionPapers) {
        questionPaperRepository.save(questionPapers);
    }

    public void deleteAQuestionPaper(Long id) {
        questionPaperRepository.delete(id);
    }
    
    public void deleteAllQuestionPapers() {
        questionPaperRepository.deleteAll();
    }

    public QuestionPaper getQuestionPaper(Long id) {
        return questionPaperRepository.findOne(id);
    }

    public Page<QuestionPaper> getAllQuestionPapers(String schoolCode, Pageable pageable) {
        return questionPaperRepository.findAllBySchoolCode(schoolCode, pageable);
    }
    
    public Page<QuestionPaper> getAllQuestionPapersBasedOnIds(String schoolCode, List<Long> ids, Pageable pageable) {
        return questionPaperRepository.findAllBySchoolCodeAndIdIn(schoolCode, ids, pageable);
    }

    public QuestionBank getQuestion(Long id) {
        return questionBankRepository.findOne(id);
    }

    public Page<QuestionBank> getAllQuestions(String schoolCode, Pageable pageable) {
        return questionBankRepository.findAllBySchoolCode(schoolCode, pageable);
    }

    public Page<QuestionBank> getQuestionsByIds(String schoolCode, List<Long> ids, Pageable pageable) {
		return questionBankRepository.findAllBySchoolCodeAndIdIn(schoolCode, ids, pageable);
	}
    
    public void deleteAllQuestions() {
        questionBankRepository.deleteAll();
    }
    
    public void deleteAQuestion(Long id) {
        questionBankRepository.delete(id);
    }


    public Page<Test> getAllTests(String schoolCode, Pageable pageable){
    	return testRepository.findAllBySchoolCode(schoolCode, pageable);
    }
    
    public Page<Test> getAllTests(String schoolCode, List<Long> ids, Pageable pageable){
    	return testRepository.findAllBySchoolCodeAndIdIn(schoolCode, ids, pageable);
    }
    
    public Test getTest(Long id) {
        return testRepository.findOne(id);
    }
    
    public Test addTest(Test test) {
        return testRepository.save(test);
    }
    
    public List<Test> saveTests(List<Test> tests) {
        return testRepository.save(tests);
    }
    
    public void deleteAllTests() {
        testRepository.deleteAll();
    }
    
    public void deleteATest(long id) {
        testRepository.delete(id);
    }

    
    
    public List<TestResults> getTestResults(){
    	return testResultsRepository.findAll();
    }
    
    public List<TestResults> getTestResultsBasedOnIds(List<Long> ids){
    	return testResultsRepository.findAll(ids);
    }
    
    public TestResults getTestResultBasedOnId(long id){
    	return testResultsRepository.findOne(id);
    }
    
    public TestResults saveTestResult(TestResults testResults){
    	return testResultsRepository.save(testResults);
    }
    
    public List<TestResults> saveTestResults(List<TestResults> testResults){
    	return testResultsRepository.save(testResults);
    }
    
    public void deleteTestResult(long id){
    	testResultsRepository.delete(id);
    }
    
}
