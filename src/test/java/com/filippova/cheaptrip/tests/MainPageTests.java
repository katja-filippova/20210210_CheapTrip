package com.filippova.cheaptrip.tests;

import com.filippova.cheaptrip.pages.MainPageHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MainPageTests extends TestBase {

    MainPageHelper mainPageHelper;

    @BeforeMethod
    public void initTest() {
        mainPageHelper = PageFactory.initElements(driver, MainPageHelper.class);
    }

    @Test(priority = 2, groups = {"UI"})
    public void sloganValidationTest() {
        System.out.println("site opened");
        String text = "CheapTrip. Pay less, travel more";
        assert mainPageHelper.isSloganContainsText(text);
    }

    @Test(priority = 1, groups = {"functional"})
    public void changeLanguageValidationTest() throws InterruptedException {
        mainPageHelper.selectRussianLanguage();
        Thread.sleep(100);
        assert mainPageHelper.isLanguageOnPageRussian("Найдите самый дешевый способ добраться из города в город, сочетая самолет, поезд, автобус и совместные поездки на автомобиле");
    }

    @FindBy(xpath = "//*[@id=\"main-content\"]/app-places/ion-tabs/div/ion-router-outlet/app-offer/ion-content//main")
    WebElement tripContainer;


    @Test
    public void fillInTripForm() throws InterruptedException {
        mainPageHelper.fillInFromTypeForm("Berlin");
        Thread.sleep(100);
        mainPageHelper.fillInToTypeForm("London");
        Thread.sleep(100);

        WebElement letsGoButton = driver.findElement(By.xpath("//*[@id=\"main-content\"]/app-places/ion-tabs/div/ion-router-outlet/app-discover/ion-content/ion-card/ion-card-content/ion-grid/ion-row[2]/ion-col/ion-button[2]"));
        mainPageHelper.tap(letsGoButton);
        WebElement tripContainer = driver.findElement((By.xpath("//*[@id=\"main-content\"]/app-places/ion-tabs/div/ion-router-outlet/app-offer/ion-content//main")));
        Assert.assertTrue(mainPageHelper.isElementPresent(tripContainer));

    }

    @Test
    public void changeCurrencyTest() {
        mainPageHelper.selectUSD();
        WebElement usdCurrency = driver.findElement(By.xpath("//*[contains(@class,\"sc-ion-popover-md-h sc-ion-popover-md-s select-popover md hydrated\")]/div[2]/div[2]/ion-select-popover/ion-list/ion-radio-group/ion-item[2]"));
        Assert.assertTrue(mainPageHelper.isElementPresent(usdCurrency));
    }
}
