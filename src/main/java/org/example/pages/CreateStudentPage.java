package org.example.pages;

import org.example.selenium.core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateStudentPage extends BasePage {
    public CreateStudentPage(WebDriver driver) {
//        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//li[text()='Students']")
    private WebElement studentWebElement;

    @FindBy(xpath = "//a[text()=\"Student search\"]")
    private WebElement studentSearchWebElement;

    @FindBy(xpath = "//a[text()=\"Create a student\"]")
    private WebElement createStudentWebElement;

    @FindBy(id = "StudentExternalId")
    private WebElement StudentIDWebElement;

    @FindBy(id = "FirstName")
    private WebElement StudentFirstNameWebElement;

    @FindBy(id = "LastName")
    private WebElement StudentLastNameWebElement;

    @FindBy(id = "Grade")
    private WebElement StudentGradeWebElement;

    @FindBy(xpath = "//select[@id='Gender']")
    private WebElement StudentGenderWebElement;

    @FindBy(id = "DateOfBirth")
    private WebElement StudentDOBWebElement;

    @FindBy(xpath = "//a[text()='13']")
    private WebElement StudentDate;
    @FindBy(id = "Address")
    private WebElement StudentAddressWebElement;

    @FindBy(id = "City")
    private WebElement StudentCityWebElement;

    @FindBy(xpath = "//select[@id='State']")
    private WebElement StudentStateWebElement;

    @FindBy(id = "Zip")
    private WebElement StudentZIPWebElement;

    @FindBy(id = "btnSaveChanges")
    private WebElement createStudentSaveButton;

    public void clickStudents() {
        handlingStaleElement(studentWebElement);
        waitAndClick(studentWebElement);
    }

    public void clickStudentSearch() {
        waitAndClick(studentSearchWebElement);
    }

    public void clickCreateStudentButton() {
        waitAndClick(createStudentWebElement);
    }

    public void StudentIDWebElement(String ID) {
        inputText(StudentIDWebElement, ID);
    }

    public void StudentFirstNameWebElement(String firstName) {
        inputText(StudentFirstNameWebElement, firstName);
    }

    public void StudentLastNameWebElement(String lastName) {
        inputText(StudentLastNameWebElement, lastName);
    }


    public void StudentGradeWebElement(String grade) {
        inputText(StudentGradeWebElement, grade);
    }

    public void StudentGenderWebElement(String gender) {
        inputText(StudentGenderWebElement, gender);
    }

    public void StudentDOBCalenderWebElement() {
        waitAndClick(StudentDOBWebElement);
    }

    public void StudentDateOfBirth() {
        waitAndClick(StudentDate);
    }

    public void StudentAddressWebElement(String address) {
        inputText(StudentAddressWebElement, address);
    }

    public void StudentCityWebElement(String city) {
        inputText(StudentCityWebElement, city);
    }

    public void StudentStateWebElement(String state) {
        inputText(StudentStateWebElement, state);
    }

    public void StudentZIPWebElement(String zip) {
        inputText(StudentZIPWebElement, zip);
    }

    public void StudentSaveButtonWebElement() {
        waitAndClick(createStudentSaveButton);
    }
}