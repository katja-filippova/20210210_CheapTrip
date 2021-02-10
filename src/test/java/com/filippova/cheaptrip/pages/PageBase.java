package com.filippova.cheaptrip.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public abstract class PageBase {
    protected WebDriver driver;

    // Logger logger = Logger.getLogger(TestBase.class.getName());
    public PageBase(WebDriver driver) {
        this.driver = driver;
    }

    public String getPageTitle() {
        return driver.getTitle();
    }

    public void waitUntilElementClickable(WebElement element, int time) {
        try {
            new WebDriverWait(driver, time).until(ExpectedConditions.elementToBeClickable(element));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void waitUntilElementVisible(WebElement element, int time) {
        try {
            new WebDriverWait(driver, time).until(ExpectedConditions.visibilityOf(element));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void waitUntilAllElementsVisible(List<WebElement> elements, int time) {
        try {
            new WebDriverWait(driver, time).until(ExpectedConditions.visibilityOfAllElements(elements));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void inputTextToField(WebElement element, String text) {
        try {
            element.click();
            element.clear();
            element.sendKeys(text);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void checkIn(WebElement element) {
        try {
            if (!element.isSelected()) {
                element.click();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean isElementPresent(WebElement element) {
        return element.isDisplayed();
    }

    public boolean isElementClickable(WebElement element) {
        try {
            element.click();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public void tap(WebElement element) {
        element.click();
    }
}
