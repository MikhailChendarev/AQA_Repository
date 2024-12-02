package org.example.support;

import net.datafaker.Faker;
import org.example.dto.request.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class TestDataGenerator {

    private static final Faker faker = new Faker();

    public static List<UserRequest> generateTestUsers() {
        List<UserRequest> users = new ArrayList<>();
        users.add(createUser(faker.letterify("?????@"), "", faker.letterify("?????"), "", faker.regexify("[а-яА-Я]{8}"), "-", false, LocalDate.now().format(DateTimeFormatter.ISO_DATE), "active_search"));
        users.add(createUser(faker.letterify("?????@"), faker.letterify("?????"), "", faker.regexify("[а-яА-Я]{8}"), "", "admin", true, LocalDate.now().plusDays(1).format(DateTimeFormatter.ISO_DATE), "on_project"));
        users.add(createUser(faker.letterify("?????@"), faker.letterify("?????@"), faker.internet().emailAddress(), faker.regexify("[!@#$%^&*()_+]{8}"), faker.bothify("?????###"), "-", false, LocalDate.now().format(DateTimeFormatter.ISO_DATE), "-"));
        users.add(createUser(faker.letterify("?????@"), "", faker.letterify("?????"), "", faker.regexify("[а-яА-Я]{8}"), "user", true, LocalDate.now().minusDays(1).format(DateTimeFormatter.ISO_DATE), "active_search"));
        users.add(createUser(faker.letterify("?????@"), faker.regexify("[а-яА-Я]{8}"), faker.regexify("[а-яА-Я]{8}"), faker.letterify("?????"), faker.regexify("[!@#$%^&*()_+]{8}"), "-", false, "", "pause_search"));
        users.add(createUser(faker.letterify("?????@"), faker.letterify("?????"), "", faker.regexify("[а-яА-Я]{8}"), "", "user", false, "2024-08-25", "on_project"));
        users.add(createUser("", "", faker.regexify("[а-яА-Я]{8}"), faker.regexify("[а-яА-Я]{8}"), faker.bothify("?????###"), "user", false, "2024-08-25", "-"));
        users.add(createUser("", faker.letterify("?????"), faker.internet().emailAddress(), "", faker.regexify("[!@#$%^&*()_+]{8}"), "user", true, LocalDate.now().format(DateTimeFormatter.ISO_DATE), "pause_search"));
        users.add(createUser("", faker.letterify("?????@"), faker.letterify("?????"), faker.letterify("?????"), "", "admin", false, "2024-08-25", "on_project"));
        users.add(createUser("", "", faker.regexify("[а-яА-Я]{8}"), faker.regexify("[а-яА-Я]{8}"), faker.bothify("?????###"), "-", false, LocalDate.now().plusDays(1).format(DateTimeFormatter.ISO_DATE), "-"));
        users.add(createUser("", faker.regexify("[а-яА-Я]{8}"), "", faker.regexify("[!@#$%^&*()_+]{8}"), faker.regexify("[а-яА-Я]{8}"), "user", true, LocalDate.now().format(DateTimeFormatter.ISO_DATE), "active_search"));
        users.add(createUser("", faker.letterify("?????"), faker.internet().emailAddress(), "", faker.regexify("[!@#$%^&*()_+]{8}"), "admin", false, LocalDate.now().minusDays(1).format(DateTimeFormatter.ISO_DATE), "pause_search"));
        users.add(createUser("", faker.letterify("?????@"), faker.letterify("?????"), faker.letterify("?????"), "", "-", true, "", "on_project"));
        users.add(createUser(faker.regexify("[а-яА-Я]{8}"), faker.regexify("[а-яА-Я]{8}"), faker.internet().emailAddress(), faker.letterify("?????"), faker.bothify("?????###"), "user", false, "", "-"));
        users.add(createUser(faker.regexify("[а-яА-Я]{8}"), faker.letterify("?????"), faker.letterify("?????"), faker.regexify("[а-яА-Я]{8}"), faker.regexify("[а-яА-Я]{8}"), "admin", true, "2024-08-25", "active_search"));
        users.add(createUser(faker.regexify("[а-яА-Я]{8}"), "", "", "", "", "user", false, LocalDate.now().format(DateTimeFormatter.ISO_DATE), "on_project"));
        users.add(createUser(faker.regexify("[а-яА-Я]{8}"), faker.regexify("[а-яА-Я]{8}"), faker.internet().emailAddress(), faker.letterify("?????"), faker.bothify("?????###"), "-", true, "2024-08-25", "-"));
        users.add(createUser(faker.regexify("[а-яА-Я]{8}"), faker.letterify("?????"), faker.letterify("?????"), faker.regexify("[а-яА-Я]{8}"), faker.regexify("[а-яА-Я]{8}"), "user", false, LocalDate.now().plusDays(1).format(DateTimeFormatter.ISO_DATE), "active_search"));
        users.add(createUser(faker.regexify("[а-яА-Я]{8}"), faker.letterify("?????@"), faker.regexify("[а-яА-Я]{8}"), faker.regexify("[!@#$%^&*()_+]{8}"), faker.regexify("[!@#$%^&*()_+]{8}"), "admin", false, LocalDate.now().format(DateTimeFormatter.ISO_DATE), "pause_search"));
        users.add(createUser(faker.regexify("[а-яА-Я]{8}"), "", "", "", "", "-", true, LocalDate.now().minusDays(1).format(DateTimeFormatter.ISO_DATE), "on_project"));
        users.add(createUser(faker.letterify("?????"), faker.letterify("?????"), faker.regexify("[а-яА-Я]{8}"), "", faker.bothify("?????###"), "user", false, LocalDate.now().minusDays(1).format(DateTimeFormatter.ISO_DATE), "-"));
        users.add(createUser(faker.letterify("?????"), faker.letterify("?????@"), "", faker.letterify("?????"), faker.regexify("[а-яА-Я]{8}"), "admin", true, "", "active_search"));
        users.add(createUser(faker.letterify("?????"), "", faker.internet().emailAddress(), faker.regexify("[а-яА-Я]{8}"), faker.regexify("[!@#$%^&*()_+]{8}"), "-", false, "2024-08-25", "pause_search"));
        users.add(createUser(faker.letterify("?????"), faker.regexify("[а-яА-Я]{8}"), faker.letterify("?????"), faker.regexify("[!@#$%^&*()_+]{8}"), "", "user", true, LocalDate.now().plusDays(1).format(DateTimeFormatter.ISO_DATE), "on_project"));
        users.add(createUser(faker.letterify("?????"), faker.letterify("?????"), faker.regexify("[а-яА-Я]{8}"), "", faker.bothify("?????###"), "admin", false, LocalDate.now().format(DateTimeFormatter.ISO_DATE), "-"));
        users.add(createUser(faker.letterify("?????"), faker.letterify("?????@"), "", faker.letterify("?????"), faker.regexify("[а-яА-Я]{8}"), "-", false, "2024-08-25", "active_search"));
        users.add(createUser(faker.letterify("?????"), "", faker.internet().emailAddress(), faker.regexify("[а-яА-Я]{8}"), faker.regexify("[!@#$%^&*()_+]{8}"), "user", true, LocalDate.now().plusDays(1).format(DateTimeFormatter.ISO_DATE), "pause_search"));
        users.add(createUser(faker.letterify("?????"), faker.regexify("[а-яА-Я]{8}"), faker.letterify("?????"), faker.regexify("[!@#$%^&*()_+]{8}"), "", "-", false, LocalDate.now().format(DateTimeFormatter.ISO_DATE), "on_project"));
        users.add(createUser(faker.letterify("?????@"), faker.letterify("?????@"), faker.internet().emailAddress(), faker.regexify("[!@#$%^&*()_+]{8}"), faker.bothify("?????###"), "-", true, LocalDate.now().format(DateTimeFormatter.ISO_DATE), "-"));
        users.add(createUser(faker.bothify("?????@###"), faker.bothify("?????@###"), faker.internet().emailAddress(), faker.regexify("[!@#$%^&*()_+]{8}"), faker.bothify("?????###"), "-", true, LocalDate.now().format(DateTimeFormatter.ISO_DATE), "-"));
        users.add(createUser(faker.bothify("?????@###"), "", faker.bothify("?????@###"), "", faker.regexify("[а-яА-Я]{8}"), "user", false, LocalDate.now().minusDays(1).format(DateTimeFormatter.ISO_DATE), "active_search"));
        users.add(createUser(faker.bothify("?????@###"), faker.regexify("[а-яА-Я]{8}"), faker.regexify("[а-яА-Я]{8}"), "vanyaIvanov", faker.regexify("[!@#$%^&*()_+]{8}"), "-", false, "", "pause_search"));
        users.add(createUser(faker.bothify("?????@###"), faker.bothify("?????@###"), "", faker.regexify("[а-яА-Я]{8}"), "", "user", true, "2024-08-25", "on_project"));
        users.add(createUser(faker.bothify("?????@###"), faker.bothify("?????@###"), faker.internet().emailAddress(), faker.regexify("[!@#$%^&*()_+]{8}"), faker.bothify("?????###"), "admin", false, LocalDate.now().plusDays(1).format(DateTimeFormatter.ISO_DATE), "-"));
        users.add(createUser(faker.bothify("?????@###"), "", faker.bothify("?????@###"), "", faker.regexify("[а-яА-Я]{8}"), "-", true, LocalDate.now().format(DateTimeFormatter.ISO_DATE), "active_search"));
        users.add(createUser(faker.bothify("?????@###"), faker.regexify("[а-яА-Я]{8}"), faker.regexify("[а-яА-Я]{8}"), faker.bothify("?????@###"), faker.regexify("[!@#$%^&*()_+]{8}"), "user", false, "2024-08-25", "pause_search"));
        users.add(createUser(faker.bothify("?????@###"), faker.bothify("?????@###"), "", faker.regexify("[а-яА-Я]{8}"), "", "admin", false, LocalDate.now().plusDays(1).format(DateTimeFormatter.ISO_DATE), "on_project"));
        users.add(createUser("", "", faker.regexify("[а-яА-Я]{8}"), faker.regexify("[а-яА-Я]{8}"), faker.bothify("?????###"), "-", false, LocalDate.now().plusDays(1).format(DateTimeFormatter.ISO_DATE), "-"));
        users.add(createUser("", faker.regexify("[а-яА-Я]{8}"), "", faker.regexify("[!@#$%^&*()_+]{8}"), faker.regexify("[а-яА-Я]{8}"), "user", false, LocalDate.now().format(DateTimeFormatter.ISO_DATE), "active_search"));
        users.add(createUser("", faker.bothify("?????@###"), faker.internet().emailAddress(), "", faker.regexify("[!@#$%^&*()_+]{8}"), "admin", true, LocalDate.now().minusDays(1).format(DateTimeFormatter.ISO_DATE), "pause_search"));
        users.add(createUser("", faker.bothify("?????@###"), faker.bothify("?????@###"), faker.bothify("?????@###"), "", "-", false, "", "on_project"));
        users.add(createUser("", "", faker.regexify("[а-яА-Я]{8}"), faker.regexify("[а-яА-Я]{8}"), faker.bothify("?????###"), "user", false, "2024-08-25", "-"));
        users.add(createUser("", faker.regexify("[а-яА-Я]{8}"), "", faker.regexify("[!@#$%^&*()_+]{8}"), faker.regexify("[а-яА-Я]{8}"), "-", true, LocalDate.now().plusDays(1).format(DateTimeFormatter.ISO_DATE), "active_search"));
        users.add(createUser("", faker.bothify("?????@###"), faker.internet().emailAddress(), "", faker.regexify("[!@#$%^&*()_+]{8}"), "user", false, LocalDate.now().format(DateTimeFormatter.ISO_DATE), "pause_search"));
        users.add(createUser("", faker.bothify("?????@###"), faker.bothify("?????@###"), faker.bothify("?????@###"), "", "admin", true, "2024-08-25", "on_project"));
        return users;
    }

    public static List<QuizRequest.Variation> getVariationList() {
        List<QuizRequest.Variation> variations = new ArrayList<>();
        variations.add(new QuizRequest.Variation("", true));
        variations.add(new QuizRequest.Variation("", null));
        variations.add(new QuizRequest.Variation("", null));
        return variations;
    }

    public static TemplateRequest getTemplate() {
        TemplateRequest.Exam exam = new TemplateRequest.Exam(1005);
        List<TemplateRequest.Exam> exams = new ArrayList<>();
        exams.add(exam);
        TemplateRequest.Course course = new TemplateRequest.Course(1003);
        List<TemplateRequest.Course> courses = new ArrayList<>();
        courses.add(course);
        return new TemplateRequest("Test", "test", exams, courses);
    }

    public static CourseRequest getCourse() {
        return new CourseRequest("Test", List.of(new CourseRequest.Module(1000, "test")));
    }

    public static ExamRequest getExam() {
        return new ExamRequest("Test", 60, new ArrayList<>());
    }

    public static ModuleRequest getModule() {
        return new ModuleRequest("тест", Arrays.asList(1000, 1001, 1002, 1005));
    }

    public static QuestionRequest getQuestion() {
        return new QuestionRequest("question");
    }

    public static AuthRequest getLogin() {
        return new AuthRequest("chendarev_mikhail", "U9uDBD–<A8)>SkA");
    }

    private static UserRequest createUser(String firstName, String surname, String email, String username, String plainPassword, String roles, boolean isCV, String salesOpenTime, String salesStatus) {
        UserRequest userRequest = new UserRequest();
        UserRequest.CustomData customData = new UserRequest.CustomData();
        userRequest.setFirstname(firstName);
        userRequest.setSurname(surname);
        userRequest.setEmail(email);
        userRequest.setUsername(username);
        userRequest.setPlainPassword(plainPassword);
        userRequest.setRoles(roles);
        customData.setIsCV(isCV);
        customData.setSalesOpenTime(salesOpenTime);
        customData.setSalesStatus(salesStatus);
        userRequest.setCustomData(customData);
        return userRequest;
    }

}
