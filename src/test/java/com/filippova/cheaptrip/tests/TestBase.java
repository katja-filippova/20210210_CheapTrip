package com.filippova.cheaptrip.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestBase {

    WebDriver driver;

    @BeforeMethod
    public void setUp (){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--window-size=1920, 1200");
        driver = new ChromeDriver();
        driver.get("http://test70.lowcoststrip.com./");
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void teatDown(){
        driver.quit();
    }
}
