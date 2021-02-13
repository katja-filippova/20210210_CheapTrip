package com.filippova.cheaptrip.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Arrays;

public class TestBase {

    WebDriver driver;

    public Logger logger = LoggerFactory.getLogger(TestBase.class.getName());

    @BeforeMethod
    public void startTest(Method m, Object[] objects){
        logger.info("Start test " + m.getName() + " with data " + Arrays.asList(objects));
    }

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

    @AfterMethod (alwaysRun = true)
    public void stopTest(ITestResult result) {
        if (result.isSuccess()){
            logger.info("PASSED: test method " + result.getMethod().getMethodName());
        }else {
            logger.error("FAILED: test method " + result.getMethod().getMethodName());

        }
    }
}
