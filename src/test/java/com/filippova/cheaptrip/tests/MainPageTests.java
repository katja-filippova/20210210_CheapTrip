package com.filippova.cheaptrip.tests;

import com.filippova.cheaptrip.pages.MainPageHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
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
        Assert.assertTrue(mainPageHelper.isSloganContainsText(text));
    }

    @Test(priority = 1, groups = {"functional"})
    public void changeLanguageValidationTest() throws InterruptedException {
        mainPageHelper.selectRussianLanguage();
        Thread.sleep(100);
        Assert.assertTrue(mainPageHelper.isLanguageOnPageRussian("Найдите самый дешевый способ добраться из города в город, сочетая самолет, поезд, автобус и совместные поездки на автомобиле"));
    }

    @Test
    public void fillInTripForm() throws InterruptedException {
        mainPageHelper.fillInFromTypeForm("Berlin");
        Thread.sleep(100);
        mainPageHelper.fillInToTypeForm("Moscow");
        Thread.sleep(100);
        mainPageHelper.clickOnLetsGoButton();
        WebElement tripContainer = driver.findElement(By.cssSelector("ion-row.md.hydrated"));
        Assert.assertTrue(mainPageHelper.isElementPresent(tripContainer));
    }

    @Test
    public void changeCurrencyTest() {
        mainPageHelper.selectUSD();
        WebElement usdCurrency = driver.findElement(By.xpath("//*[contains(@class,\"sc-ion-popover-md-h sc-ion-popover-md-s select-popover md hydrated\")]/div[2]/div[2]/ion-select-popover/ion-list/ion-radio-group/ion-item[2]"));
        Assert.assertTrue(mainPageHelper.isElementPresent(usdCurrency));
    }

    @Test (dataProvider = "fillInTripFromTripsCSVFile", dataProviderClass = DataProviders.class)
    public void fillInTripFormFromCityCSVFile(String from, String to) {
        mainPageHelper.fillInFromTypeForm(from);;
        mainPageHelper.fillInToTypeForm(to);
        mainPageHelper.clickOnLetsGoButton();
        WebElement tripContainer = driver.findElement(By.cssSelector("ion-row.md.hydrated"));
        Assert.assertTrue(mainPageHelper.isElementPresent(tripContainer));
    }
}
