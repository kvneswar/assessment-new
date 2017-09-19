package com.assessment.services.domain;/**
 * Created by Anand Tadepalli on 9/16/2017.
 */

import javax.persistence.*;
import java.util.List;

@Entity
public class QuestionPaper {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private String schoolCode;
    
    private String questionPaperName;
    
    private String questionPaperDescription;
    
    @ManyToOne
    private Test test;

    @ManyToMany
    @JoinTable(
            name = "QUESTION_PAPER_QUESTIONS",
            joinColumns = @JoinColumn(
                    name = "QUESTION_PAPER_ID"),
            inverseJoinColumns = @JoinColumn(name = "QUESTION_BANK_ID"
            )
    )
    private List<QuestionBank> questions;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Test getTest() {
        return test;
    }

    public void setTest(Test test) {
        this.test = test;
    }

    public List<QuestionBank> getQuestions() {
        return questions;
    }

    public void setQuestions(List<QuestionBank> questions) {
        this.questions = questions;
    }

	public String getSchoolCode() {
		return schoolCode;
	}

	public void setSchoolCode(String schoolCode) {
		this.schoolCode = schoolCode;
	}

	public String getQuestionPaperName() {
		return questionPaperName;
	}

	public void setQuestionPaperName(String questionPaperName) {
		this.questionPaperName = questionPaperName;
	}

	public String getQuestionPaperDescription() {
		return questionPaperDescription;
	}

	public void setQuestionPaperDescription(String questionPaperDescription) {
		this.questionPaperDescription = questionPaperDescription;
	}
}
