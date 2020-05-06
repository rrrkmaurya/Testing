package com.WEINVEST;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.util.Properties;


public class Common {

    public WebDriver driver;
    WebDriverWait wait;
    private static final Logger logger = LogManager.getLogger(Common.class);

    public Common(WebDriver driver) throws Exception {
        this.driver=driver;
        int time = 30;
        wait = new WebDriverWait(driver, time);
    }
    
    //check visibility of any element
    public boolean verifyvisibility(String path) throws InterruptedException {
        WebElement element =wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(path)));
        logger.info(path);
        if(element.isDisplayed()) {
            logger.info("Element is loaded and visible in the page");
        	return true;
        }
        logger.error("Element is failed to load or visible in the page");
        Thread.sleep(5000);
        return false;
    }
    
    //click on button or on given elements
    public boolean clickonelement(String path) throws InterruptedException {
        boolean status = false;
        if(verifyvisibility(path)) {
	        WebElement element =driver.findElement(By.xpath(path));
	        if(element!=null) {
	        	//Actions action = new Actions(driver);
	        	//action.moveToElement(element).click().build().perform();
	        	element.click();
	        	status=true;
	        	logger.info("Element is clicked successfully ");
	        }
	        else
	        	logger.error("failed to click on the element ");	  
        }
	    return status;
    }
    
    //get the text of the elements
    public String getTextofElement(String path) throws InterruptedException {
        String text = "";
        if(verifyvisibility(path)) {
	        text =driver.findElement(By.xpath(path)).getText().trim();
	        if(text.length()>0)
	        	logger.info("Element founded with text : "+text);
	        else
	        	logger.error("failed to get the text or size of text is 0");	  
        }
	    return text;
    }
    
}