package org.example.utils;

import net.datafaker.Faker;
import org.example.admin.entity.Interview;
import org.example.admin.entity.User;
import org.testng.annotations.DataProvider;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
public class TestDataProvider {

    private static final Faker faker = new Faker();

    @DataProvider(name = "userData")
    public static Object[][] generateRegisterUserData() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        LocalDate today = LocalDate.now();
        LocalDate futureDate = today.plusDays(faker.number().numberBetween(1, 365));
        LocalDate pastDate = today.minusDays(faker.number().numberBetween(1, 365));
        return new Object[][]{
                //1
                {new User(faker.regexify("[a-zA-Z!@#$%^&*()_+{}:<>?]{5}"), "", faker.letterify("?????"), "", "тест", "-", false, today.format(formatter), "active_search")},
                //2
                {new User(faker.regexify("[a-zA-Z!@#$%^&*()_+{}:<>?]{5}"), faker.letterify("?????"), "", "тест", "", "admin", true, futureDate.format(formatter), "on_project")},
                //3
                {new User(faker.regexify("[a-zA-Z!@#$%^&*()_+{}:<>?]{5}"), faker.regexify("[a-zA-Z!@#$%^&*()_+{}:<>?]{5}"), faker.internet().emailAddress(), faker.regexify("[!@#$%^&*()_+{}:<>?]+"), faker.bothify("?????##"), "-", false, today.format(formatter), "")},
                //4
                {new User(faker.regexify("[a-zA-Z!@#$%^&*()_+{}:<>?]{5}"), "", faker.letterify("?????"), "", "тест", "user", true, pastDate.format(formatter), "active_search")},
                //5
                {new User(faker.regexify("[a-zA-Z!@#$%^&*()_+{}:<>?]{5}"), "тест", "тест", faker.letterify("?????"), faker.regexify("[!@#$%^&*()_+{}:<>?]+"), "-", false, "01.01.1970", "pause_search")},
                //6
                {new User(faker.regexify("[a-zA-Z!@#$%^&*()_+{}:<>?]{5}"), faker.letterify("?????"), "", "тест", "", "user", false, "25.08.2024", "on_project")},
                //7
                {new User("", "", "тест", "тест", faker.bothify("?????##"), "user", false, "25.08.2024", "-")},
                //8
                {new User("", faker.letterify("?????"), faker.internet().emailAddress(), "", faker.regexify("[!@#$%^&*()_+{}:<>?]+"), "user", true, today.format(formatter), "pause_search")},
                //9
                {new User("", faker.regexify("[a-zA-Z!@#$%^&*()_+{}:<>?]{5}"), faker.letterify("?????"), faker.letterify("?????"), "", "admin", false, "25.08.2024", "on_project")},
                //10
                {new User("", "", "тест", "тест", faker.bothify("?????##"), "-", false, futureDate.format(formatter), "-")},
                //11
                {new User("", "тест", "", faker.regexify("[!@#$%^&*()_+{}:<>?]+"), "тест", "user", true, today.format(formatter), "active_search")},
                //12
                {new User("", faker.letterify("?????"), faker.internet().emailAddress(), "", faker.regexify("[!@#$%^&*()_+{}:<>?]+"), "admin", false, pastDate.format(formatter), "pause_search")},
                //13
                {new User("", faker.regexify("[a-zA-Z!@#$%^&*()_+{}:<>?]{5}"), faker.letterify("?????"), faker.letterify("?????"), "", "-", true, "", "on_project")},
                //14
                {new User("тест", "тест", faker.internet().emailAddress(), faker.letterify("?????"), faker.bothify("?????##"), "user", false, "", "-")},
                //15
                {new User("тест", faker.letterify("?????"), faker.letterify("?????"), "тест", "тест", "admin", true, "25.08.2024", "active_search")},
                //16
                {new User("тест", faker.letterify("?????"), "тест", faker.regexify("[!@#$%^&*()_+{}:<>?]+"), faker.regexify("[!@#$%^&*()_+{}:<>?]+"), "-", false, futureDate.format(formatter), "pause_search")},
                //17
                {new User("тест", "", "", "", "", "user", false, today.format(formatter), "on_project")},
                //18
                {new User("тест", "тест", faker.internet().emailAddress(), faker.letterify("?????"), faker.bothify("?????##"), "-", true, "25.08.2024", "-")},
                //19
                {new User("тест", faker.letterify("?????"), faker.letterify("?????"), "тест", "тест", "user", false, futureDate.format(formatter), "active_search")},
                //20
                {new User("тест", faker.regexify("[a-zA-Z!@#$%^&*()_+{}:<>?]{5}"), "тест", faker.regexify("[!@#$%^&*()_+{}:<>?]+"), faker.regexify("[!@#$%^&*()_+{}:<>?]+"), "admin", false, today.format(formatter), "pause_search")},
                //21
                {new User("тест", "", "", "", "", "-", true, pastDate.format(formatter), "on_project")},
                //22
                {new User(faker.letterify("?????"), faker.letterify("?????"), "тест", "", faker.bothify("?????##"), "user", false, pastDate.format(formatter), "-")},
                //23
                {new User(faker.letterify("?????"), faker.regexify("[a-zA-Z!@#$%^&*()_+{}:<>?]{5}"), "", faker.letterify("?????"), "тест", "admin", true, "", "active_search")},
                //24
                {new User(faker.letterify("?????"), "", faker.internet().emailAddress(), "тест", faker.regexify("[!@#$%^&*()_+{}:<>?]+"), "-", false, "25.08.2024", "pause_search")},
                //25
                {new User(faker.letterify("?????"), "тест", faker.letterify("?????"), faker.regexify("[!@#$%^&*()_+{}:<>?]+"), "", "user", true, futureDate.format(formatter), "on_project")},
                //26
                {new User(faker.letterify("?????"), faker.letterify("?????"), "тест", "", faker.bothify("?????##"), "admin", false, today.format(formatter), "-")},
                //27
                {new User(faker.letterify("?????"), faker.regexify("[a-zA-Z!@#$%^&*()_+{}:<>?]{5}"), "", faker.letterify("?????"), "тест", "-", false, "25.08.2024", "active_search")},
                //28
                {new User("", faker.letterify("?????"), faker.internet().emailAddress(), "тест", faker.regexify("[!@#$%^&*()_+{}:<>?]+"), "user", true, futureDate.format(formatter), "pause_search")},
                //29
                {new User("тест", faker.letterify("?????"), faker.letterify("?????"), faker.regexify("[!@#$%^&*()_+{}:<>?]+"), "", "-", false, today.format(formatter), "on_project")},
                //30
                {new User(faker.regexify("[a-zA-Z!@#$%^&*()_+{}:<>?]{5}"), faker.regexify("[a-zA-Z!@#$%^&*()_+{}:<>?]{5}"), faker.internet().emailAddress(), faker.regexify("[!@#$%^&*()_+{}:<>?]+"), faker.bothify("?????##"), "-", true, today.format(formatter), "-")},
                //31
                {new User(faker.regexify("[a-zA-Z!@#$%^&*()_+{}:<>?]{5}"), "", faker.letterify("?????"), "", "тест", "user", false, pastDate.format(formatter), "active_search")},
                //32
                {new User(faker.regexify("[a-zA-Z!@#$%^&*()_+{}:<>?]{5}"), "тест", "тест", "vanyaIvanov", faker.regexify("[!@#$%^&*()_+{}:<>?]+"), "-", false, "", "pause_search")},
                //33
                {new User(faker.regexify("[a-zA-Z!@#$%^&*()_+{}:<>?]{5}"), faker.letterify("?????"), "", "тест", "", "user", true, "25.08.2024", "on_project")},
                //34
                {new User(faker.regexify("[a-zA-Z!@#$%^&*()_+{}:<>?]{5}"), faker.regexify("[a-zA-Z!@#$%^&*()_+{}:<>?]{5}"), faker.internet().emailAddress(), faker.regexify("[!@#$%^&*()_+{}:<>?]+"), faker.bothify("?????##"), "admin", false, futureDate.format(formatter), "-")},
                //35
                {new User(faker.regexify("[a-zA-Z!@#$%^&*()_+{}:<>?]{5}"), "", faker.letterify("?????"), "", "тест", "-", true, today.format(formatter), "active_search")},
                //36
                {new User(faker.regexify("[a-zA-Z!@#$%^&*()_+{}:<>?]{5}"), "тест", "тест", faker.letterify("?????"), faker.regexify("[!@#$%^&*()_+{}:<>?]+"), "user", false, "25.08.2024", "pause_search")},
                //37
                {new User(faker.regexify("[a-zA-Z!@#$%^&*()_+{}:<>?]{5}"), faker.letterify("?????"), "", "тест", "", "admin", false, futureDate.format(formatter), "on_project")},
                //38
                {new User("", "", "тест", "тест", faker.bothify("?????##"), "-", false, futureDate.format(formatter), "-")},
                //39
                {new User("", "тест", "", faker.regexify("[!@#$%^&*()_+{}:<>?]+"), "тест", "user", false, today.format(formatter), "active_search")},
                //40
                {new User("", faker.letterify("?????"), faker.internet().emailAddress(), "", faker.regexify("[!@#$%^&*()_+{}:<>?]+"), "admin", true, pastDate.format(formatter), "pause_search")},
                //41
                {new User("", faker.regexify("[a-zA-Z!@#$%^&*()_+{}:<>?]{5}"), faker.letterify("?????"), faker.letterify("?????"), "", "-", false, "", "on_project")},
                //42
                {new User("", "", "тест", "тест", faker.bothify("?????##"), "user", false, "25.08.2024", "-")},
                //43
                {new User("", "тест", "", faker.regexify("[!@#$%^&*()_+{}:<>?]+"), "тест", "-", true, futureDate.format(formatter), "active_search")},
                //44
                {new User("", faker.letterify("?????"), faker.internet().emailAddress(), "", faker.regexify("[!@#$%^&*()_+{}:<>?]+"), "user", false, today.format(formatter), "pause_search")},
                //45
                {new User("", faker.regexify("[a-zA-Z!@#$%^&*()_+{}:<>?]{5}"), faker.letterify("?????"), faker.letterify("?????"), "", "admin", true, "25.08.2024", "on_project")}

        };
    }

    @DataProvider(name = "generateInterviewData")
    public static Object[][] generateInterviewData() {
        LocalDate today = LocalDate.now();
        LocalDate futureDate = today.plusDays(faker.number().numberBetween(1, 365));
        LocalDate pastDate = today.minusDays(faker.number().numberBetween(1, 365));
        return new Object[][]{
                {new Interview(faker.regexify("[a-zA-Z!@#$%^&*()_+{}:<>?]{5}"), today, "", "", "")},
                {new Interview(faker.regexify("[a-zA-Z!@#$%^&*()_+{}:<>?]{5}"), null, "hr", faker.regexify("[a-zA-Z]{5}"), faker.regexify("[a-zA-Z]{5}"))},
                {new Interview(faker.regexify("[a-zA-Z!@#$%^&*()_+{}:<>?]{5}"), futureDate, "tech", faker.regexify("[а-яА-Я]{5}"), faker.regexify("[а-яА-Я]{5}"))},
                {new Interview(faker.regexify("[a-zA-Z!@#$%^&*()_+{}:<>?]{5}"), pastDate, "", faker.lorem().characters(255), faker.lorem().characters(255))},
                {new Interview(faker.regexify("[a-zA-Z!@#$%^&*()_+{}:<>?]{5}"), today, "hr", faker.lorem().characters(256), faker.lorem().characters(256))},
                {new Interview(faker.regexify("[a-zA-Z!@#$%^&*()_+{}:<>?]{5}"), null, "tech", faker.regexify("[!@#$%^&*()_+{}:<>?]+"), faker.regexify("[!@#$%^&*()_+{}:<>?]+"))},
                {new Interview(faker.regexify("[а-яА-Я]{5}"), null, "tech", faker.lorem().characters(255), "")},
                {new Interview(faker.regexify("[а-яА-Я]{5}"), futureDate, "", faker.lorem().characters(256), faker.regexify("[a-zA-Z]{5}"))},
                {new Interview(faker.regexify("[а-яА-Я]{5}"), pastDate, "hr", faker.regexify("[!@#$%^&*()_+{}:<>?]+"), faker.regexify("[а-яА-Я]{5}"))},
                {new Interview(faker.regexify("[а-яА-Я]{5}"), today, "tech", "", faker.lorem().characters(255))},
                {new Interview(faker.regexify("[а-яА-Я]{5}"), null, "", faker.regexify("[a-zA-Z]{5}"), faker.lorem().characters(256))},
                {new Interview(faker.regexify("[а-яА-Я]{5}"), today, "hr", faker.regexify("[а-яА-Я]{5}"), faker.regexify("[!@#$%^&*()_+{}:<>?]+"))},
                {new Interview(faker.regexify("[a-zA-Z!@#$%^&*()_+{}:<>?]{5}"), futureDate, "hr", "", "")},
                {new Interview(faker.regexify("[a-zA-Z!@#$%^&*()_+{}:<>?]{5}"), pastDate, "tech", faker.regexify("[a-zA-Z]{5}"), faker.regexify("[a-zA-Z]{5}"))},
                {new Interview(faker.regexify("[a-zA-Z!@#$%^&*()_+{}:<>?]{5}"), today, "", faker.regexify("[а-яА-Я]{5}"), faker.regexify("[а-яА-Я]{5}"))},
                {new Interview(faker.regexify("[a-zA-Z!@#$%^&*()_+{}:<>?]{5}"), null, "hr", faker.lorem().characters(255), faker.lorem().characters(255))},
                {new Interview(faker.regexify("[a-zA-Z!@#$%^&*()_+{}:<>?]{5}"), today, "tech", faker.lorem().characters(256), faker.lorem().characters(256))},
                {new Interview(faker.regexify("[a-zA-Z!@#$%^&*()_+{}:<>?]{5}"), null, "", faker.regexify("[!@#$%^&*()_+{}:<>?]+"), faker.regexify("[!@#$%^&*()_+{}:<>?]+"))},
                {new Interview("", pastDate, "", faker.lorem().characters(255), "")},
                {new Interview("", today, "hr", faker.lorem().characters(256), faker.regexify("[a-zA-Z]{5}"))},
                {new Interview("", null, "tech", faker.regexify("[!@#$%^&*()_+{}:<>?]+"), faker.regexify("[а-яА-Я]{5}"))},
                {new Interview("", today, "", "", faker.lorem().characters(255))},
                {new Interview("", null, "hr", faker.regexify("[a-zA-Z]{5}"), faker.lorem().characters(256))},
                {new Interview("", futureDate, "tech", faker.regexify("[а-яА-Я]{5}"), faker.regexify("[!@#$%^&*()_+{}:<>?]+"))},
                {new Interview(null, today, "tech", "", "")},
                {new Interview(null, null, "", faker.regexify("[a-zA-Z]{5}"), faker.regexify("[a-zA-Z]{5}"))},
                {new Interview(null, today, "hr", faker.regexify("[а-яА-Я]{5}"), faker.regexify("[а-яА-Я]{5}"))},
                {new Interview(null, null, "tech", faker.lorem().characters(255), faker.lorem().characters(255))},
                {new Interview(null, futureDate, "", faker.lorem().characters(256), faker.lorem().characters(256))},
                {new Interview(null, pastDate, "hr", faker.regexify("[!@#$%^&*()_+{}:<>?]+"), faker.regexify("[!@#$%^&*()_+{}:<>?]+"))},
                {new Interview(faker.regexify("[a-zA-Z]{5}"), null, "hr", faker.lorem().characters(255), "")},
                {new Interview(faker.regexify("[a-zA-Z]{5}"), today, "tech", faker.lorem().characters(256), faker.regexify("[a-zA-Z]{5}"))},
                {new Interview(faker.regexify("[a-zA-Z]{5}"), null, "", faker.regexify("[!@#$%^&*()_+{}:<>?]+"), faker.regexify("[а-яА-Я]{5}"))},
                {new Interview(faker.regexify("[a-zA-Z]{5}"), futureDate, "hr", "", faker.lorem().characters(255))},
                {new Interview(faker.regexify("[a-zA-Z]{5}"), pastDate, "tech", faker.regexify("[a-zA-Z]{5}"), faker.lorem().characters(256))},
                {new Interview(faker.regexify("[a-zA-Z]{5}"), today, "", faker.regexify("[а-яА-Я]{5}"), faker.regexify("[!@#$%^&*()_+{}:<>?]+"))}
        };
    }
}

