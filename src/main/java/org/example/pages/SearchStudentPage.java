package org.example.pages;

import org.example.selenium.core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestListener;

public class SearchStudentPage extends BasePage  {
    public SearchStudentPage(WebDriver driver) {
//        super(driver);
        PageFactory.initElements(driver, this);
    }
}
