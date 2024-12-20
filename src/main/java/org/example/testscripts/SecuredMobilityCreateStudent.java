package org.example.testscripts;

import io.qameta.allure.*;
import org.example.Listener.ReportListener;
import org.example.pages.CreateStudentPage;
import org.example.selenium.core.BasePage;
import org.example.selenium.core.BaseTest;
import org.junit.jupiter.api.condition.EnabledIfEnvironmentVariable;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Epic("#42439")
@Feature("Create student form")
@Story("User is created successfully")
@Owner("Amit Kashyap")
@Severity(SeverityLevel.BLOCKER)
@EnabledIfEnvironmentVariable(named = "Chetu Machine", matches = "Chetu", disabledReason = "Disabled")

@Listeners(value= ReportListener.class)
public class SecuredMobilityCreateStudent extends BaseTest {

    public SecuredMobilityCreateStudent() {
        super();
    }

    @Test(groups ={"regression"}, priority = 0)
    public static void CreateStudentTestCase() {

        CreateStudentPage createStudentPage = new CreateStudentPage(driver);
        createStudentPage.clickStudents();
        createStudentPage.clickStudentSearch();
        createStudentPage.clickCreateStudentButton();
        createStudentPage.StudentIDWebElement("12345");
        createStudentPage.StudentFirstNameWebElement("Test");
        createStudentPage.StudentLastNameWebElement("User");
        createStudentPage.StudentGradeWebElement("1230");
        createStudentPage.StudentGenderWebElement("Male");
        createStudentPage.StudentDOBCalenderWebElement();
        createStudentPage.StudentDateOfBirth();
        createStudentPage.StudentAddressWebElement("Address");
        createStudentPage.StudentCityWebElement("City");
        createStudentPage.StudentStateWebElement("State");
        createStudentPage.StudentZIPWebElement("12345");
    }
}