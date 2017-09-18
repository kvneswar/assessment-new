package com.assessment.services.businessservice;/**
 * Created by Anand Tadepalli on 9/16/2017.
 */

import com.assessment.services.domain.QuestionBank;
import com.assessment.services.domain.QuestionPaper;
import com.assessment.services.domain.Test;
import com.assessment.services.repositories.QuestionBankRepository;
import com.assessment.services.repositories.QuestionPaperRepository;
import com.assessment.services.repositories.TestRepository;
import org.apache.commons.collections.IteratorUtils;
import org.springframework.beans.factory.annotation.Autowired;
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


    public void addQuestions(List<QuestionBank> questions) {
        questionBankRepository.save(questions);
    }

    public QuestionBank addQuestion(QuestionBank question) {
        return questionBankRepository.save(question);
    }

    public QuestionPaper addQuestionPaper(QuestionPaper questionPaper) {
        return questionPaperRepository.save(questionPaper);
    }

    public void addQuestionPapers(List<QuestionPaper> questionPapers) {
        questionPaperRepository.save(questionPapers);
    }

    public void deleteAllQuestionPapers() {
        questionPaperRepository.deleteAll();
    }

    public QuestionPaper getQuestionPaper(Long id) {
        return questionPaperRepository.findOne(id);
    }

    public List<QuestionPaper> getAllQuestionPapers() {
        return IteratorUtils.toList(questionPaperRepository.findAll().iterator());
    }

    public QuestionBank getQuestion(Long id) {
        return questionBankRepository.findOne(id);
    }

    public List<QuestionBank> getAllQuestions() {
        return IteratorUtils.toList(questionBankRepository.findAll().iterator());
    }

    public void deleteAllQuestions() {
        questionBankRepository.deleteAll();
    }


    public List<Test> getAllTests(){
    	return testRepository.findAll();
    }
    
    public List<Test> getAllTests(List<Long> ids){
    	return testRepository.findAll(ids);
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
    
    
    
}