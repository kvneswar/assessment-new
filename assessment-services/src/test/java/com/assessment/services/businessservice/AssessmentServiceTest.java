package com.assessment.services.businessservice;/**
 * Created by Anand Tadepalli on 9/16/2017.
 */

import com.assessment.services.domain.QuestionBank;
import com.assessment.services.domain.QuestionPaper;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.assertThat;

public class AssessmentServiceTest {

    static RequestSpecification specification;

    String baseUrl = "http://localhost:8080/assessment";


    @BeforeClass
    public static void initialize() {
        specification = given()
                .accept(ContentType.JSON).contentType(ContentType.JSON);
    }

    @Test
    public void test() {

        // Delete all data before inserting
        specification.baseUri(baseUrl+ "/questionPapers").delete();
        specification.baseUri(baseUrl+ "/questions").delete();
        specification.baseUri(baseUrl+ "/tests").delete();


        // ADD a new TEST
        com.assessment.services.domain.Test test = new com.assessment.services.domain.Test();
        test.setName("TEST");
    //    com.assessment.services.domain.Test test1 = new com.assessment.services.domain.Test();
    //    test1.setName("TEST1");
    //    com.assessment.services.domain.Test test2 = new com.assessment.services.domain.Test();
    //    test2.setName("TEST2");

        com.assessment.services.domain.Test savedTest = executePOST(baseUrl + "/tests", test).as(com.assessment.services.domain.Test.class);
    //    com.assessment.services.domain.Test savedTest1 = executePOST(baseUrl + "/tests", test1).as(com.assessment.services.domain.Test.class);
   //     com.assessment.services.domain.Test savedTest2 = executePOST(baseUrl + "/tests", test2).as(com.assessment.services.domain.Test.class);

        assertThat(savedTest, is(notNullValue()));
        assertThat(savedTest.getName(), is(test.getName()));
   //     assertThat(savedTest1, is(notNullValue()));
   //     assertThat(savedTest1.getName(), is(test1.getName()));
  //      assertThat(savedTest2, is(notNullValue()));
  //      assertThat(savedTest2.getName(), is(test2.getName()));

        // Add Questions
        executePOST(baseUrl + "/questions", new QuestionBank("What is your name for the  time"));
        executePOST(baseUrl + "/questions", new QuestionBank("Why do you want to take this test for the  time"));
        executePOST(baseUrl + "/questions", new QuestionBank("Are you and idiot? You took the test for times"));

        executePOST(baseUrl + "/questions", new QuestionBank("DUMMY_1"));
        executePOST(baseUrl + "/questions", new QuestionBank("DUMMY_2"));
        executePOST(baseUrl + "/questions", new QuestionBank("DUMMY_3"));

        List<QuestionBank> allQuestions = Arrays.asList(executeGET(baseUrl + "/questions").body().as(QuestionBank[].class));

        List<QuestionBank> questionsForQuestionPaper = new ArrayList<>();
        questionsForQuestionPaper.add(allQuestions.get(0));
        questionsForQuestionPaper.add(allQuestions.get(1));

        //Add A Question paper with 2 questions
        List<QuestionPaper> allQuestionPapers = Arrays.asList(executeGET(baseUrl + "/questionPapers").body().as(QuestionPaper[].class));
        QuestionPaper questionPaper = new QuestionPaper();
        questionPaper.setQuestions(questionsForQuestionPaper);
        questionPaper.setTest(savedTest);

        QuestionPaper responseQuestionPaper = executePOST(baseUrl + "/questionPapers", questionPaper).as(QuestionPaper.class);

        assertThat(responseQuestionPaper, is(notNullValue()));
        assertThat(responseQuestionPaper.getQuestions().size(), is(2));
        assertThat(responseQuestionPaper.getTest().getName(), is("TEST"));
        assertThat(responseQuestionPaper.getTest().getId(), is(savedTest.getId()));
        assertThat(responseQuestionPaper.getQuestions().get(0).getQuestion(), is(allQuestions.get(0).getQuestion()));
        assertThat(responseQuestionPaper.getQuestions().get(0).getId(), is(allQuestions.get(0).getId()));

        allQuestions = Arrays.asList(executeGET(baseUrl + "/questions").body().as(QuestionBank[].class));

        //Add A Question paper with 2 questions
        questionsForQuestionPaper = new ArrayList<>();
        questionsForQuestionPaper.add(allQuestions.get(0));
        questionsForQuestionPaper.add(allQuestions.get(1));
        questionsForQuestionPaper.add(allQuestions.get(2));
        questionsForQuestionPaper.add(allQuestions.get(3));

        QuestionPaper questionPaper2 = new QuestionPaper();

        questionPaper2.setQuestions(questionsForQuestionPaper);
        questionPaper2.setTest(savedTest);

        QuestionPaper responseQuestionPaper1 = executePOST(baseUrl + "/questionPapers", questionPaper2).as(QuestionPaper.class);

        assertThat(responseQuestionPaper1, is(notNullValue()));
        assertThat(responseQuestionPaper1.getQuestions().size(), is(4));

        allQuestions = Arrays.asList(executeGET(baseUrl + "/questions").body().as(QuestionBank[].class));

        //Add A Question paper with different set of 2 questions
        questionsForQuestionPaper = new ArrayList<>();
        questionsForQuestionPaper.add(allQuestions.get(3));
        questionsForQuestionPaper.add(allQuestions.get(4));
        questionsForQuestionPaper.add(allQuestions.get(5));

        QuestionPaper questionPaper3 = new QuestionPaper();
        questionPaper3.setQuestions(questionsForQuestionPaper);
        questionPaper3.setTest(savedTest);

        QuestionPaper responseQuestionPaper2 = executePOST(baseUrl + "/questionPapers", questionPaper3).as(QuestionPaper.class);
    }

    @Test
    public void testAddQuestionsToExistingQuestionPaper() {

        List<QuestionBank> allQuestions = Arrays.asList(executeGET(baseUrl + "/questions").body().as(QuestionBank[].class));

        QuestionPaper questionPaper = executeGET(baseUrl + "/questionPapers/9").as(QuestionPaper.class);

        assertThat(questionPaper.getQuestions().size(), is(2));

        questionPaper.getQuestions().add(allQuestions.get(2));
        questionPaper.getQuestions().add(allQuestions.get(3));
        questionPaper.getQuestions().add(allQuestions.get(4));


        QuestionPaper questionPaperAfterAddingQuestions = executePOST(baseUrl + "/questionPapers", questionPaper).as(QuestionPaper.class);

        assertThat(questionPaperAfterAddingQuestions.getQuestions().size(), is(5));
    }

    private <T> io.restassured.response.Response executeGET(String endpoint) {
        specification.baseUri(endpoint);
        return specification.get();
    }

    private <T> io.restassured.response.Response executePOST(String endpoint, T body) {
        specification.baseUri(endpoint);
        return specification.body(body).post();
    }
}

