package org.example;

import io.restassured.response.Response;
import org.bson.Document;
import org.example.dto.request.*;
import org.example.dto.response.*;
import org.example.support.Specifications;
import org.example.support.TestDataGenerator;
import org.example.service.DbService;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.request;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class MainTest {

    private static String token;

    public static Stream<Arguments> userProvider() {
        return TestDataGenerator.generateTestUsers().stream().map(Arguments::of);
    }

    @Test
    @Order(1)
    public void loginTest() {
        File jsonSchema = new File("src/test/resources/auth-response-schema.json");
        Specifications.installSpecification(Specifications.getRequestSpecJson(), Specifications.responseSpecOk200(jsonSchema));
        Response response = given().body(TestDataGenerator.getLogin()).log().all()
                .when().post("/api/auth/login")
                .then().extract().response();
        token = response.jsonPath().getString("token");
        String username = response.jsonPath().getString("user.username");
        assertNotNull(token);
        assertEquals("chendarev_mikhail", username);
    }

    @Disabled
    @ParameterizedTest
    @MethodSource("userProvider")
    public void userAddTest(UserRequest user) {
        File jsonSchema = new File("src/test/resources/user-response-schema.json");
        Specifications.installSpecification(Specifications.getRequestSpecJson(), Specifications.responseSpecOk200(jsonSchema));
        Response response = given().header("Authorization", token).body(user)
                .when().post("/api/user-auth1")
                .then().extract().response();
        UserResponse userResponse = response.as(UserResponse.class);
        System.out.println(response.asPrettyString());
        Document foundUser = DbService.getUserFromDatabase(userResponse);
        assertNotNull(foundUser, "Пользователь не найден в базе данных");
        assertEquals(userResponse.getData().getUsername(), foundUser.getString("username"));
    }

    @Test
    public void addQuestionTest() {
        File jsonSchema = new File("src/test/resources/add-question-response-schema.json");
        Specifications.installSpecification(Specifications.getRequestSpecJson(), Specifications.responseSpecOk200(jsonSchema));
        QuestionRequest questionRequest = new QuestionRequest("question");
        Response response = given().header("Authorization", token).body(questionRequest).log().all()
                .when().post("/api/theme-question")
                .then().extract().response();
        QuestionResponse questionResponse = response.as(QuestionResponse.class);
        System.out.println(response.asPrettyString());
        Document foundQuestion = DbService.getQuestionFromDatabase(questionResponse);
        assertNotNull(foundQuestion, "Вопрос не найден в базе данных");
        assertEquals(foundQuestion.getString("name"), questionResponse.getData().getName());
    }

    @Test
    public void addQuizTest() {
        File jsonSchema = new File("src/test/resources/add-quiz-response-schema.json");
        Specifications.installSpecification(Specifications.getRequestSpecJson(), Specifications.responseSpecOk200(jsonSchema));
        List<QuizRequest.File> files = new ArrayList<>();
        QuizRequest quizRequest = new QuizRequest("quiz", true, "test", files, TestDataGenerator.getVariationList());
        Specifications.installSpecification(Specifications.getRequestSpecJson(), Specifications.responseSpecOk200(jsonSchema));
        Response response = given().header("Authorization", token).body(quizRequest).log().all()
                .when().post("/api/quiz")
                .then().extract().response();
        QuizResponse quizResponse = response.as(QuizResponse.class);
        System.out.println(response.asPrettyString());
        Document foundQuiz = DbService.getQuizFromDatabase(quizResponse);
        assertNotNull(foundQuiz, "Квиз не найден в базе данных");
        assertEquals(foundQuiz.getString("name"), quizResponse.getData().getName());
    }

    @Test
    public void addModuleTest() {
        File jsonSchema = new File("src/test/resources/add-module-response-schema.json");
        Specifications.installSpecification(Specifications.getRequestSpecJson(), Specifications.responseSpecOk200(jsonSchema));
        Response response = given().header("Authorization", token).body(TestDataGenerator.getModule()).log().all()
                .when().post("/api/course-module")
                .then().extract().response();
        ModuleResponse moduleResponse = response.as(ModuleResponse.class);
        System.out.println(response.asPrettyString());
        Document foundModule = DbService.getModuleFromDatabase(moduleResponse);
        assertNotNull(foundModule, "Модуль курса не найден в базе данных");
        assertEquals(moduleResponse.getData().getName(), foundModule.getString("name"));
        assertEquals(moduleResponse.getData().getQuestions(), foundModule.getList("questions", Integer.class));
    }

    @Test
    public void addCourseTest() {
        File jsonSchema = new File("src/test/resources/add-course-response-schema.json");
        Specifications.installSpecification(Specifications.getRequestSpecJson(), Specifications.responseSpecOk200(jsonSchema));
        Response response = given().header("Authorization", token).body(TestDataGenerator.getCourse()).log().all()
                .when().post("/api/course")
                .then().extract().response();
        CourseResponse courseResponse = response.as(CourseResponse.class);
        System.out.println(response.asPrettyString());
        Document foundCourse = DbService.getCourseFromDatabase(courseResponse);
        assertNotNull(foundCourse, "Курс не найден в базе данных");
        assertEquals(courseResponse.getData().getName(), foundCourse.getString("name"));
    }

    @Test
    public void addExamTest() {
        File jsonSchema = new File("src/test/resources/add-exam-response-schema.json");
        Specifications.installSpecification(Specifications.getRequestSpecJson(), Specifications.responseSpecOk200(jsonSchema));
        Response response = given().header("Authorization", token).body(TestDataGenerator.getExam()).log().all()
                .when().post("/api/exam")
                .then().extract().response();
        ExamResponse examResponse = response.as(ExamResponse.class);
        System.out.println(response.asPrettyString());
        Document foundExam = DbService.getExamFromDatabase(examResponse);
        assertNotNull(foundExam, "Экзамен не найден в базе данных");
        assertEquals(examResponse.getData().getName(), foundExam.getString("name"));
        assertEquals(examResponse.getData().get_id(), foundExam.getInteger("_id"));
    }

    @Test
    public void addTemplateTest() {
        File jsonSchema = new File("src/test/resources/add-template-response-schema.json");
        Specifications.installSpecification(Specifications.getRequestSpecJson(), Specifications.responseSpecOk200(jsonSchema));
        Response response = given().body(TestDataGenerator.getTemplate()).log().all()
                .when().post("/api/user-hr-template")
                .then().extract().response();
        TemplateResponse templateResponse = response.as(TemplateResponse.class);
        System.out.println(response.asPrettyString());
        Document foundTemplate = DbService.getTemplateFromDatabase(templateResponse);
        assertNotNull(foundTemplate, "Шаблон не найден в базе данных");
        assertEquals(templateResponse.getData().get_id(), foundTemplate.getInteger("_id"));
    }

}
