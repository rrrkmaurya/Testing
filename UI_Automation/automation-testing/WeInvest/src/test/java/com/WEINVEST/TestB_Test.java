package com.WEINVEST;

import java.util.Properties;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import com.data.WEINVEST.PropertiesFile;
import com.utilities.BrowserSetUp;



public class TestB_Test extends BrowserSetUp {

    public WebDriver driver;
    public static Properties props;
    public WeInvest TestB;



    private static final Logger logger = LogManager.getLogger(TestB_Test.class);


    //This will initialise the driver and create weinvest class object
    @BeforeClass
    public void setUp() throws Exception{
        driver = getDriver();
        TestB = new WeInvest(driver);
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
        Assert.assertEquals(TestB.verifyPageTittle(), "WeInvest | Simple, Smart, Transparent Investing");
        logger.info("Page title is verified") ;
    }

    //check visibility of All Weather Strategy Section in the loaded page
    @Test(priority = 5)
    public void visibilityOfAllWeatherStrategySection() throws InterruptedException {
    	if(TestB.visibilityOfAllWeatherStrategySection()) {
    		Assert.assertTrue(true);
    		logger.info("visibilityOfAllWeatherStrategySection :passed");
    	}
    	else {
    		logger.error("visibilityOfAllWeatherStrategySection : failed");
    		Assert.assertTrue(true);
    	}
    }

    //click on Explore Investment Ideas to costomize the portfolio
    @Test(priority = 7)
    public void clickonExploreInvestmentIdeasLink() throws InterruptedException {
    	if(TestB.clickonExploreInvestmentIdeasLink()) {
    		Assert.assertTrue(true);
    		logger.info("clickonExploreInvestmentIdeasLink : passed");
    	}
    	else {
    		logger.error("clickonExploreInvestmentIdeasLink : failed");
    		Assert.assertTrue(false);
    	}
    }
    
    //check portfolio page for All weather Strategy loaded 
    @Test(priority = 9)
    public void visibilityOfAllWeatherStrategyPage() throws InterruptedException {
    	if(TestB.visibilityOfAllWeatherStrategyPage()) {
    		Assert.assertTrue(true);
    		logger.info("visibilityOfAllWeatherStrategyPage : Passed");
    	}
    	else {
    		logger.error("visibilityOfAllWeatherStrategyPage : failed");
    		Assert.assertTrue(false);
    	}
    }
 
    //click on customize button to edit the portfolio stocks
    @Test(priority = 11)
    public void clickonCustomizePortfolio() throws InterruptedException {
    	if(TestB.clickonCustomizePortfolio()) {
    		Assert.assertTrue(true);
    		logger.info("clickonCustomizePortfolio : passed");
    	}
    	else {
    		logger.error("clickonCustomizePortfolio : failed");
    		Assert.assertTrue(false);
    	}
    }
    
    //verify Portfolio constituent page loaded successfully
    @Test(priority = 13)
    public void visibilityOfPortfolioConstituentsSection() throws InterruptedException {
    	if(TestB.visibilityOfPortfolioConstituentsSection()) {
    		Assert.assertTrue(true);
    		logger.info("visibilityOfPortfolioConstituentsSection : passed");
    	}
    	else {
    		logger.error("visibilityOfPortfolioConstituentsSection : failed");
    		Assert.assertTrue(false);
    	}
    }
    
    //click on customize button to edit the stock section
    @Test(priority = 15)
    public void clickonCustomizeButton() throws InterruptedException {
    	if(TestB.clickonCustomizeButton()) {
    		Assert.assertTrue(true);
    		logger.info("clickonCustomizeButton : passed");
    	}
    	else {
    		logger.error("clickonCustomizeButton : failed");
    		Assert.assertTrue(false);
    	}
    }
    
    //verify after click on customize, label changed to Reset
    @Test(priority = 17)
    public void verifyCustomizeChangedToReset() throws InterruptedException {
    	if(TestB.verifyCustomizeChangedToReset()) {
    		Assert.assertTrue(true);
    		logger.info("verifyCustomizeChangedToReset : passed");
    	}
    	else {
    		logger.error("verifyCustomizeChangedToReset : failed");
    		Assert.assertTrue(false);
    	}
    }
    
    //click on Add stock for US Equities
    @Test(priority = 19)
    public void clickonAddStockUnderUSEquities()  throws InterruptedException {
    	if(TestB.clickonAddStockUnderUSEquities()) {
    		Assert.assertTrue(true);
    		logger.info("clickonAddStockUnderUSEquities : passed");
    	}
    	else {
    		logger.error("clickonAddStockUnderUSEquities : failed");
    		Assert.assertTrue(false);
    	}
    }
    
    //verify ETFs table loaded successfully
    @Test(priority = 21)
    public void visibilityOfETFsTable() throws InterruptedException {
    	if(TestB.visibilityOfETFsTable()) {
    		Assert.assertTrue(true);
    		logger.info("visibilityOfETFsTable : passed");
    	}
    	else {
    		logger.error("visibilityOfETFsTable : failed");
    		Assert.assertTrue(false);
    	}
    }
    
    //check visibility of BT Group Plc stock in the table
    @Test(priority = 23)
    public void visibilityOfBTGroupPlc() throws InterruptedException{
    	if(TestB.visibilityOfBTGroupPlc()) {
    		Assert.assertTrue(true);
    		logger.info("visibilityOfBTGroupPlc : passed");
    	}
    	else {
    		logger.error("visibilityOfBTGroupPlc : failed");
    		Assert.assertTrue(false);
    	}
    }
    
    //click on Add stock for BT Group Plc stock
    @Test(priority = 25)
    public void clickonAddStockOfBTGroupPlc() throws InterruptedException{
    	if(TestB.clickonAddStockOfBTGroupPlc()) {
    		Assert.assertTrue(true);
    		logger.info("clickonAddStockOfBTGroupPlc : passed");
    	}
    	else {
    		logger.error("clickonAddStockOfBTGroupPlc : failed");
    		Assert.assertTrue(false);
    	}
    }
    
    //click on done button from bottom of ETFs table
    @Test(priority = 27)
    public void clickonDoneButton() throws InterruptedException{
    	if(TestB.clickonDoneButton()) {
    		Assert.assertTrue(true);
    		logger.info("clickonDoneButton : passed");
    	}
    	else {
    		logger.error("clickonDoneButton : failed");
    		Assert.assertTrue(false);
    	}
    }
    
    //verify BT Group Plc added in the list of stock
    @Test(priority = 29) 
    public void verifyBTGroupPlcAddedInPortfolio() throws InterruptedException {
    	if(TestB.verifyBTGroupPlcAddedInPortfolio()) {
    		Assert.assertTrue(true);
    		logger.info("verifyBTGroupPlcAddedInPortfolio : passed");
    	}
    	else {
    		logger.error("verifyBTGroupPlcAddedInPortfolio : failed");
    		Assert.assertTrue(false);
    	}
    }
   
    
    
//*/

}
