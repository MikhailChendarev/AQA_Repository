package org.example.utils;

import net.datafaker.Faker;
import org.testng.annotations.DataProvider;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class UserDataProvider {

    private static final Faker faker = new Faker();

    @DataProvider(name = "userData")
    public static Object[][] generateUserData() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        LocalDate today = LocalDate.now();
        LocalDate futureDate = today.plusDays(faker.number().numberBetween(1, 365));
        LocalDate pastDate = today.minusDays(faker.number().numberBetween(1, 365));
        return new Object[][]{
                //1
                {faker.regexify("[a-zA-Z!@#$%^&*()_+{}:<>?]{5}"), "", faker.letterify("?????"), "", "тест", "-", false, today.format(formatter), "active_search"},
                //2
                {faker.regexify("[a-zA-Z!@#$%^&*()_+{}:<>?]{5}"), faker.letterify("?????"), "", "тест", "", "admin", true, futureDate.format(formatter), "on_project"},
                //3
                {faker.regexify("[a-zA-Z!@#$%^&*()_+{}:<>?]{5}"), faker.regexify("[a-zA-Z!@#$%^&*()_+{}:<>?]{5}"), faker.internet().emailAddress(), faker.regexify("[!@#$%^&*()_+{}:<>?]+"), faker.bothify("?????##"), "-", false, today.format(formatter), ""},
                //4
                {faker.regexify("[a-zA-Z!@#$%^&*()_+{}:<>?]{5}"), "", faker.letterify("?????"), "", "тест", "user", true, pastDate.format(formatter), "active_search"},
                //5
                {faker.regexify("[a-zA-Z!@#$%^&*()_+{}:<>?]{5}"), "тест", "тест", faker.letterify("?????"), faker.regexify("[!@#$%^&*()_+{}:<>?]+"), "-", false, "01.01.1970", "pause_search"},
                //6
                {faker.regexify("[a-zA-Z!@#$%^&*()_+{}:<>?]{5}"), faker.letterify("?????"), "", "тест", "", "user", false, "25.08.2024", "on_project"},
                //7
                {"", "", "тест", "тест", faker.bothify("?????##"), "user", false, "25.08.2024", "-"},
                //8
                {"", faker.letterify("?????"), faker.internet().emailAddress(), "", faker.regexify("[!@#$%^&*()_+{}:<>?]+"), "user", true, today.format(formatter), "pause_search"},
                //9
                {"", faker.regexify("[a-zA-Z!@#$%^&*()_+{}:<>?]{5}"), faker.letterify("?????"), faker.letterify("?????"), "", "admin", false, "25.08.2024", "on_project"},
                //10
                {"", "", "тест", "тест", faker.bothify("?????##"), "-", false, futureDate.format(formatter), "-"},
                //11
                {"", "тест", "", faker.regexify("[!@#$%^&*()_+{}:<>?]+"), "тест", "user", true, today.format(formatter), "active_search"},
                //12
                {"", faker.letterify("?????"), faker.internet().emailAddress(), "", faker.regexify("[!@#$%^&*()_+{}:<>?]+"), "admin", false, pastDate.format(formatter), "pause_search"},
                //13
                {"", faker.regexify("[a-zA-Z!@#$%^&*()_+{}:<>?]{5}"), faker.letterify("?????"), faker.letterify("?????"), "", "-", true, "", "on_project"},
                //14
                {"тест", "тест", faker.internet().emailAddress(), faker.letterify("?????"), faker.bothify("?????##"), "user", false, "", "-"},
                //15
                {"тест", faker.letterify("?????"), faker.letterify("?????"), "тест", "тест", "admin", true, "25.08.2024", "active_search"},
                //16
                {"тест", faker.letterify("?????"), "тест", faker.regexify("[!@#$%^&*()_+{}:<>?]+"), faker.regexify("[!@#$%^&*()_+{}:<>?]+"), "-", false, futureDate.format(formatter), "pause_search"},
                //17
                {"тест", "", "", "", "", "user", false, today.format(formatter), "on_project"},
                //18
                {"тест", "тест", faker.internet().emailAddress(), faker.letterify("?????"), faker.bothify("?????##"), "-", true, "25.08.2024", "-"},
                //19
                {"тест", faker.letterify("?????"), faker.letterify("?????"), "тест", "тест", "user", false, futureDate.format(formatter), "active_search"},
                //20
                {"тест", faker.regexify("[a-zA-Z!@#$%^&*()_+{}:<>?]{5}"), "тест", faker.regexify("[!@#$%^&*()_+{}:<>?]+"), faker.regexify("[!@#$%^&*()_+{}:<>?]+"), "admin", false, today.format(formatter), "pause_search"},
                //21
                {"тест", "", "", "", "", "-", true, pastDate.format(formatter), "on_project"},
                //22
                {faker.letterify("?????"), faker.letterify("?????"), "тест", "", faker.bothify("?????##"), "user", false, pastDate.format(formatter), "-"},
                //23
                {faker.letterify("?????"), faker.regexify("[a-zA-Z!@#$%^&*()_+{}:<>?]{5}"), "", faker.letterify("?????"), "тест", "admin", true, "", "active_search"},
                //24
                {faker.letterify("?????"), "", faker.internet().emailAddress(), "тест", faker.regexify("[!@#$%^&*()_+{}:<>?]+"), "-", false, "25.08.2024", "pause_search"},
                //25
                {faker.letterify("?????"), "тест", faker.letterify("?????"), faker.regexify("[!@#$%^&*()_+{}:<>?]+"), "", "user", true, futureDate.format(formatter), "on_project"},
                //26
                {faker.letterify("?????"), faker.letterify("?????"), "тест", "", faker.bothify("?????##"), "admin", false, today.format(formatter), "-"},
                //27
                {faker.letterify("?????"), faker.regexify("[a-zA-Z!@#$%^&*()_+{}:<>?]{5}"), "", faker.letterify("?????"), "тест", "-", false, "25.08.2024", "active_search"},
                //28
                {"", faker.letterify("?????"), faker.internet().emailAddress(), "тест", faker.regexify("[!@#$%^&*()_+{}:<>?]+"), "user", true, futureDate.format(formatter), "pause_search"},
                //29
                {"тест", faker.letterify("?????"), faker.letterify("?????"), faker.regexify("[!@#$%^&*()_+{}:<>?]+"), "", "-", false, today.format(formatter), "on_project"},
                //30
                {faker.regexify("[a-zA-Z!@#$%^&*()_+{}:<>?]{5}"), faker.regexify("[a-zA-Z!@#$%^&*()_+{}:<>?]{5}"), faker.internet().emailAddress(), faker.regexify("[!@#$%^&*()_+{}:<>?]+"), faker.bothify("?????##"), "-", true, today.format(formatter), "-"},
                //31
                {faker.regexify("[a-zA-Z!@#$%^&*()_+{}:<>?]{5}"), "", faker.letterify("?????"), "", "тест", "user", false, pastDate.format(formatter), "active_search"},
                //32
                {faker.regexify("[a-zA-Z!@#$%^&*()_+{}:<>?]{5}"), "тест", "тест", "vanyaIvanov", faker.regexify("[!@#$%^&*()_+{}:<>?]+"), "-", false, "", "pause_search"},
                //33
                {faker.regexify("[a-zA-Z!@#$%^&*()_+{}:<>?]{5}"), faker.letterify("?????"), "", "тест", "", "user", true, "25.08.2024", "on_project"},
                //34
                {faker.regexify("[a-zA-Z!@#$%^&*()_+{}:<>?]{5}"), faker.regexify("[a-zA-Z!@#$%^&*()_+{}:<>?]{5}"), faker.internet().emailAddress(), faker.regexify("[!@#$%^&*()_+{}:<>?]+"), faker.bothify("?????##"), "admin", false, futureDate.format(formatter), "-"},
                //35
                {faker.regexify("[a-zA-Z!@#$%^&*()_+{}:<>?]{5}"), "", faker.letterify("?????"), "", "тест", "-", true, today.format(formatter), "active_search"},
                //36
                {faker.regexify("[a-zA-Z!@#$%^&*()_+{}:<>?]{5}"), "тест", "тест", faker.letterify("?????"), faker.regexify("[!@#$%^&*()_+{}:<>?]+"), "user", false, "25.08.2024", "pause_search"},
                //37
                {faker.regexify("[a-zA-Z!@#$%^&*()_+{}:<>?]{5}"), faker.letterify("?????"), "", "тест", "", "admin", false, futureDate.format(formatter), "on_project"},
                //38
                {"", "", "тест", "тест", faker.bothify("?????##"), "-", false, futureDate.format(formatter), "-"},
                //39
                {"", "тест", "", faker.regexify("[!@#$%^&*()_+{}:<>?]+"), "тест", "user", false, today.format(formatter), "active_search"},
                //40
                {"", faker.letterify("?????"), faker.internet().emailAddress(), "", faker.regexify("[!@#$%^&*()_+{}:<>?]+"), "admin", true, pastDate.format(formatter), "pause_search"},
                //41
                {"", faker.regexify("[a-zA-Z!@#$%^&*()_+{}:<>?]{5}"), faker.letterify("?????"), faker.letterify("?????"), "", "-", false, "", "on_project"},
                //42
                {"", "", "тест", "тест", faker.bothify("?????##"), "user", false, "25.08.2024", "-"},
                //43
                {"", "тест", "", faker.regexify("[!@#$%^&*()_+{}:<>?]+"), "тест", "-", true, futureDate.format(formatter), "active_search"},
                //44
                {"", faker.letterify("?????"), faker.internet().emailAddress(), "", faker.regexify("[!@#$%^&*()_+{}:<>?]+"), "user", false, today.format(formatter), "pause_search"},
                //45
                {"", faker.regexify("[a-zA-Z!@#$%^&*()_+{}:<>?]{5}"), faker.letterify("?????"), faker.letterify("?????"), "", "admin", true, "25.08.2024", "on_project"}

        };
    }
}
