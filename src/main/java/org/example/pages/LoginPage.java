package org.example.pages;

import org.example.selenium.core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.example.selenium.core.BaseTest.loadProperties;

public class LoginPage extends BasePage {


    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@id='DistrictName']")
    private WebElement districtNameDDWebElement;

    @FindBy(xpath = "//li[text()=\"Development\"]")
    private WebElement districtNameListWebElement;

    @FindBy(xpath = "//input[@id='UserName']")
    private WebElement userNameWebElement;

    @FindBy(xpath = "//input[@id='Password']")
    private WebElement passwordWebElement;

    @FindBy(xpath = "//input[@value=\"Log in\"]")
    private WebElement loginButtonWebElement;

    public void selectDistrict(String districtName) {
        waitAndClick(districtNameDDWebElement);
        inputText(districtNameDDWebElement, districtName);
        waitAndClick(districtNameListWebElement);
    }

    public void enterUsername(String username) {
        inputText(userNameWebElement, username);
    }

    public void enterPassword(String password) {
        inputText(passwordWebElement, password);
    }

    public void clickLoginButton() {
        waitAndClick(loginButtonWebElement);
    }
}