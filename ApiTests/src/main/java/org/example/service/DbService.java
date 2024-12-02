package org.example.service;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.example.dto.response.*;
import org.junit.jupiter.api.AfterAll;

public class DbService {

    private static final MongoClient mongoClient = MongoClients.create("mongodb://javacode:bestEducationEver@80.66.64.141:27017/estim?authSource=admin");
    private static final MongoDatabase database = mongoClient.getDatabase("estim");
    private static MongoCollection<Document> collection;

    public static Document getUserFromDatabase(UserResponse userResponse) {
        collection = database.getCollection("users");
        return collection.find(new Document("_id", userResponse.getData().get_id())).first();

    }

    public static Document getQuestionFromDatabase(QuestionResponse questionResponse) {
        return database.getCollection("themequestions").find(new Document("_id", questionResponse.getData().get_id())).first();
    }

    public static Document getQuizFromDatabase(QuizResponse quizResponse) {
        return database.getCollection("quizzes").find(new Document("_id", quizResponse.getData().get_id())).first();
    }

    public static Document getModuleFromDatabase(ModuleResponse moduleResponse) {
        return database.getCollection("coursemodules").find(new Document("_id", moduleResponse.getData().get_id())).first();
    }

    public static Document getCourseFromDatabase(CourseResponse courseResponse) {
        return database.getCollection("courses").find(new Document("_id", courseResponse.getData().get_id())).first();
    }

    public static Document getExamFromDatabase(ExamResponse examResponse) {
        return database.getCollection("exams").find(new Document("_id", examResponse.getData().get_id())).first();
    }

    public static Document getTemplateFromDatabase(TemplateResponse templateResponse) {
        return database.getCollection("userhrtemplates").find(new Document("_id", templateResponse.getData().get_id())).first();
    }

    @AfterAll
    public static void closeConnection() {
        mongoClient.close();
    }

    public static void listCollections() {
        for (String name : database.listCollectionNames()) {
            System.out.println(name);
        }
    }

}
