package org.example.selenium.core;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class BasePage extends BaseTest{
    protected static final Duration DEFAULT_WAIT_4_ELEMENT = Duration.ofMillis(1000);

    /**
     * Input text into the element
     */
    public void inputText(WebElement element, String text) {
        waitForElementClickable(element);
        element.sendKeys(text);
    }

    /**
     * Click action performed and then wait
     */
    public void waitAndClick(WebElement element) {
        waitForElementClickable(element);
        element.click();
    }

    /**
     * Wait for element to be clickable
     */
    public WebElement waitForElementClickable(WebElement webElement) {
        WebElement element;
        try {
            WebDriverWait wait = new WebDriverWait(driver, DEFAULT_WAIT_4_ELEMENT);
            element = wait.until(ExpectedConditions.elementToBeClickable(webElement));

            return element;

        } catch (Exception e) {
        }
        return null;
    }

    /** This method handles the login for Stale Element exception
     * @param webElement
     * @return
     */
    public WebElement handlingStaleElement(WebElement webElement) {
        WebElement afterReLocating = null;
        // verifying if the webElement is stale
        boolean isWebElementStale = ExpectedConditions.stalenessOf(webElement).apply(driver);
        // if the element is stale
        if (isWebElementStale) {
            // re-retrieving the desired input HTML element
            afterReLocating = driver.findElement(By.xpath("//a[text()=\"Student search\"]"));
        }
        return afterReLocating;
    }
}