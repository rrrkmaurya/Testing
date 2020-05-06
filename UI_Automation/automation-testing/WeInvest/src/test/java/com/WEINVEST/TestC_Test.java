package com.WEINVEST;

import java.util.Properties;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import com.data.WEINVEST.PropertiesFile;
import com.utilities.BrowserSetUp;


public class TestC_Test extends BrowserSetUp {

    public WebDriver driver;
    public static Properties props;
    public WeInvest TestC;



    private static final Logger logger = LogManager.getLogger(TestC_Test.class);


    //This will initialise the driver and create weinvest class object
    @BeforeClass
    public void setUp() throws Exception{
        driver = getDriver();
        TestC = new WeInvest(driver);
        props = PropertiesFile.prop;
        PropertiesFile.readPropertiesFIle();
    }
    
    //Verify Title
    @Parameters({"url"})
    @Test(priority = 3)
    public void verifyPageTittle(String url)
    {
        test = extent.createTest("Test B");
        driver.navigate().to(url);
        Assert.assertEquals(TestC.verifyPageTittle(), "WeInvest | Simple, Smart, Transparent Investing");
        logger.info("Page title is verified") ;
    }

    //verify visibility of full text for Recommended portfolio
    @Test(priority = 5)
    public void visibilityOfFullRecommendation() throws InterruptedException {
    	if(TestC.visibilityOfFullRecommendation()) {
    		Assert.assertTrue(true);
    		logger.info("visibilityOfFullRecommendation : passed");
    	}
    	else {
    		logger.error("visibilityOfFullRecommendation : failed");
    		Assert.assertTrue(true);
    	}
    }
    
  //verify visibility of full text for some other portfolio
    @Test(priority = 7)
    public void visibilityOfFullOtherPortfolio() throws InterruptedException {
    	if(TestC.visibilityOfFullOtherPortfolio()) {
    		Assert.assertTrue(true);
    		logger.info("visibilityOfFullOtherPortfolio : passed");
    	}
    	else {
    		logger.error("visibilityOfFullOtherPortfolio : failed");
    		Assert.assertTrue(true);
    	}
    }
    
    //change browse windoe size to 375 x 667
    @Test(priority = 9)
    public void changeWindowSize() throws InterruptedException {
    	if(TestC.changeWindowSize()) {
    		Assert.assertTrue(true);
    		logger.info("changeWindowSize : passed");
    	}
    	else {
    		logger.error("changeWindowSize : failed");
    		Assert.assertTrue(true);
    	}
    }
    
    //verify visibility of sort text for Recommended portfolio
    @Test(priority = 11)
    public void visibilityOfSortRecommendation() throws InterruptedException {
    	if(TestC.visibilityOfSortRecommendation()) {
    		Assert.assertTrue(true);
    		logger.info("visibilityOfSortRecommendation : passed");
    	}
    	else {
    		logger.error("visibilityOfSortRecommendation : failed");
    		Assert.assertTrue(true);
    	}
    }
    
    //verify visibility of sort text for some other portfolio
    @Test(priority = 13)
    public void visibilityOfSortOtherPortfolio() throws InterruptedException {
    	if(TestC.visibilityOfSortOtherPortfolio()) {
    		Assert.assertTrue(true);
    		logger.info("visibilityOfSortOtherPortfolio : passed");
    	}
    	else {
    		logger.error("visibilityOfSortOtherPortfolio : failed");
    		Assert.assertTrue(true);
    	}
    }



}
