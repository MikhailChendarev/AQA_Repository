package org.example.user;

import org.example.admin.pages.UserStatsPage;
import org.example.user.pages.MainPage;
import org.example.user.pages.UserCoursePage;
import org.example.user.pages.UserLoginPage;
import org.testng.annotations.Test;

public class UserTest extends BaseUserTest {

    @Test
    public void createVoiceRecordTest() {
        UserLoginPage userLoginPage = new UserLoginPage();
        userLoginPage.login();
        MainPage.goToCourses();
        UserCoursePage userCoursePage = new UserCoursePage();
        userCoursePage.clickOnCourse();
        userCoursePage.knowledgeTest();
    }

}
