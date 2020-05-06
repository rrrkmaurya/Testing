package com.WEINVEST;


import com.data.WEINVEST.PropertiesFile;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.util.Properties;


public class WeInvest extends Common {


    public Properties props;
    public WebDriver driver;
    WebDriverWait wait;
    private static final Logger logger = LogManager.getLogger(WeInvest.class);

    public WeInvest(WebDriver driver) throws Exception {
    	super(driver);
        this.driver=driver;
        props = PropertiesFile.prop;
        int time = 30;
        wait = new WebDriverWait(driver, time);
        PropertiesFile.readPropertiesFIle();
    }
    
//------------------------------------ Test B -------------------------------------------------  
    
    //fetches title of the first Page
    public String verifyPageTittle() {
        return driver.getTitle();
    }

    //check visibility of All Weather Strategy Section in the loaded page
    public boolean visibilityOfAllWeatherStrategySection() throws InterruptedException {
        props = PropertiesFile.prop;
        String path=props.getProperty("allWeatherStrategy");
        return verifyvisibility(path);
    }

    //click on Explore Investment Ideas to costomize the portfolio
    public boolean clickonExploreInvestmentIdeasLink() throws InterruptedException {
        props = PropertiesFile.prop;
        String path=props.getProperty("allWeatherStrategy")+props.getProperty("+ExploreInvestmentIdeas");
        return clickonelement(path);
    }
    
    //check portfolio page for All weather Strategy loaded 
    public boolean visibilityOfAllWeatherStrategyPage() throws InterruptedException {
        props = PropertiesFile.prop;
        String path=props.getProperty("portfolioHeader");
        return verifyvisibility(path);
    }
    
    //click on customize button to edit the portfolio stocks
    public boolean clickonCustomizePortfolio() throws InterruptedException {
        props = PropertiesFile.prop;
        String path=props.getProperty("portfolioHeader")+props.getProperty("+customizePortfolio");
        return clickonelement(path);
    }
    
    //verify Portfolio constituent page loaded successfully
    public boolean visibilityOfPortfolioConstituentsSection() throws InterruptedException {
        props = PropertiesFile.prop;
        String path=props.getProperty("portfolioConstituentsHeader");
        return verifyvisibility(path);
    }
    
    //click on customize button to edit the stock section
    public boolean clickonCustomizeButton()  throws InterruptedException{
        props = PropertiesFile.prop;
        String path=props.getProperty("portfolioConstituentsHeader")+props.getProperty("+cusotomize");
        return clickonelement(path);
    }
    
    //verify after click on customize, label changed to Reset
    public boolean verifyCustomizeChangedToReset() throws InterruptedException {
        props = PropertiesFile.prop;
        String path=props.getProperty("portfolioConstituentsHeader")+props.getProperty("+reset");
        return verifyvisibility(path);
    }
    
    //click on Add stock for US Equities
    public boolean clickonAddStockUnderUSEquities() throws InterruptedException {
        props = PropertiesFile.prop;
        String path=props.getProperty("portfolioConstituentsHeader")+props.getProperty("+firstStock")+props.getProperty("++addStock");
        return clickonelement(path);
    }
    
    //verify ETFs table loaded successfully
    public boolean visibilityOfETFsTable() throws InterruptedException {
        props = PropertiesFile.prop;
        String path=props.getProperty("portfolioConstituentsHeader")+props.getProperty("+firstStock")+props.getProperty("++addStock")+
        		props.getProperty("+++AddETFstable");
        return verifyvisibility(path);
    }
    
    //check visibility of BT Group Plc stock in the table
    public boolean visibilityOfBTGroupPlc() throws InterruptedException {
        props = PropertiesFile.prop;
        String path=props.getProperty("portfolioConstituentsHeader")+props.getProperty("+firstStock")+props.getProperty("++addStock")+
        		props.getProperty("+++BTGroup");
        return verifyvisibility(path);
    }
    
    //click on Add stock for BT Group Plc stock
    public boolean clickonAddStockOfBTGroupPlc() throws InterruptedException {
        props = PropertiesFile.prop;
        String path=props.getProperty("portfolioConstituentsHeader")+props.getProperty("+firstStock")+props.getProperty("++addStock")+
        		props.getProperty("+++BTGroup")+props.getProperty("++++addStock");
        return clickonelement(path);
    }
    
    //click on done button from bottom of ETFs table
    public boolean clickonDoneButton() throws InterruptedException {
        props = PropertiesFile.prop;
        String path=props.getProperty("portfolioConstituentsHeader")+props.getProperty("+firstStock")+props.getProperty("++addStock")+
        		props.getProperty("+++AddETFstable")+props.getProperty("++++Donebutton");
        return clickonelement(path);
    }
    
    //verify BT Group Plc added in the list of stock
    public boolean verifyBTGroupPlcAddedInPortfolio() throws InterruptedException {
        props = PropertiesFile.prop;
        String path=props.getProperty("portfolioConstituentsHeader")+props.getProperty("+firstStock")+props.getProperty("++BTGroup");
        return verifyvisibility(path);
    }

//------------------------------------ Test C ------------------------------------------------- 
    
  //verify visibility of full text for Recommended portfolio
    public boolean visibilityOfFullRecommendation() throws InterruptedException {
        props = PropertiesFile.prop;
        String path=props.getProperty("fullRecommendation");
        return verifyvisibility(path);
    }
    
  //verify visibility of full text for some other portfolio
    public boolean visibilityOfFullOtherPortfolio() throws InterruptedException {
        props = PropertiesFile.prop;
        String path=props.getProperty("fullOtherportfolio");
        return verifyvisibility(path);
    }
    
    //change browse windoe size to 375 x 667
    public boolean changeWindowSize() throws InterruptedException {
    	 Dimension d = new Dimension(375,667);
    	 driver.manage().window().setSize(d);
    	 return true;
    }
    
    //verify visibility of sort text for Recommended portfolio
    public boolean visibilityOfSortRecommendation() throws InterruptedException {
        props = PropertiesFile.prop;
        String path=props.getProperty("sortRecommendation");
        return verifyvisibility(path);
    }
    
    //verify visibility of sort text for some other portfolio
    public boolean visibilityOfSortOtherPortfolio() throws InterruptedException {
        props = PropertiesFile.prop;
        String path=props.getProperty("sortOtherportfolio");
        return verifyvisibility(path);
    }
    
    
}

