package com.utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BrowserSetUp {

    public static WebDriver driver;
    // Create global variable which will be used in all method
    public static ExtentHtmlReporter htmlReporter;
    public static ExtentReports extent;
    public static ExtentTest test;
    static String chromepath = new File("chromedriver.exe").getAbsolutePath();
    private final Logger logger = LogManager.getLogger(BrowserSetUp.class);

    public WebDriver getDriver() {
        return driver;
    }

    private void setDriver(String browserType, String url) {
    	//driver = initChromeDriver(url);
    	
        switch (browserType) {
            case "chrome":
                driver = initChromeDriver(url);
                System.out.println("4");
                break;
            case "firefox":
                driver = initFirefoxDriver(url);
                System.out.println("5");
                break;
            default:
                System.out.println("browser : " + browserType
                        + " is invalid, Launching Firefox as browser of choice..");
                driver = initChromeDriver(url);
        }
    }

    private static WebDriver initChromeDriver(String url) {
        System.out.println("Launching google chrome with new profile..");
        System.setProperty("webdriver.chrome.driver", chromepath);
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to(url);;
        return driver;
    }

    private static WebDriver initFirefoxDriver(String url) {
        System.out.println("Launching Firefox browser..");
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().fullscreen();
        System.out.println(url);
        driver.navigate().to(url);;
        return driver;
    }

    @Parameters({ "browserType", "url","problem"})
    @BeforeSuite
    public void initializeTestBaseSetup(String browserType, String url,String problem) throws Exception {
        setDriver(browserType, url);
        DOMConfigurator.configure("log4j.xml");

        String curDir = System.getProperty("user.dir");
        
        String newloc=curDir+"/automation_report";
        File file = new File(newloc);
        
        try {
        	file.mkdir();
            newloc=newloc+"/"+problem;
            file = new File(newloc);
            if(file.mkdir())
            	System.out.println("Dir and subDir is created ");
        }catch(Exception e) {
            newloc=newloc+"/"+problem;
            file = new File(newloc);
            try {
            	if(file.mkdir())
            		System.out.println("subDir is created");
            }catch(Exception ee) {
            	System.out.println("failed to created Dir or SubDir");
            }
        }
        
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-HHmm");
        String curDate = dateFormat.format(date);

        // initialize the HtmlReporter
        String filelocation=newloc+"/"+problem+"-"+curDate+".html";
        System.out.println(filelocation);
        htmlReporter = new ExtentHtmlReporter(filelocation);

        // initialize ExtentReports and attach the HtmlReporter
        extent = new ExtentReports();

        // attach only HtmlReporter
        extent.attachReporter(htmlReporter);

        extent.setSystemInfo("OS",System.getProperty("os.name"));
        extent.setSystemInfo("URL", url);
        extent.setSystemInfo("User Name", "Ravi");

        htmlReporter.config().setChartVisibilityOnOpen(true);
        htmlReporter.config().setDocumentTitle("Automation Report");
        htmlReporter.config().setReportName("Problem : "+problem.toUpperCase()+", Browser : "+browserType.toUpperCase()+ ", URL : "+url);
        htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
        htmlReporter.config().setTheme(Theme.DARK);

    }

    @AfterMethod
    public void getResult(ITestResult result)
    {
       String methodname="";
       String[] listofname=result.getName().split("(?=[A-Z])");
       for(String temp:listofname)
    	   methodname=methodname+" "+temp;
       if(methodname.length()<1)
    	   methodname=result.getName();
    	
       if(result.getStatus() == ITestResult.FAILURE)
       {        
           test.log(Status.FAIL, MarkupHelper.createLabel(methodname+" -> FAILED due to below issues:", ExtentColor.RED));
           test.fail(result.getThrowable());
           logger.error(result.getName()+" -> FAILED due to below issues :\n"+result.getThrowable()+"\n"); 
           
       	// take screenshot after test falied
           String filePath = new File("src/test/java/com/Screenshot/").getAbsolutePath()+"/"+result.getName()+".png";
           Object currentClass = result.getInstance();
           WebDriver driver = ((BrowserSetUp)currentClass).getDriver();
           
           try {
           	File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
           	FileUtils.copyFile(scrFile, new File(filePath));
           	logger.info("Screenshot for this failed method : Screenshot/"+result.getName()+".png");
           }
           catch(Exception e) {
           	e.printStackTrace();
           }
       }
       else if(result.getStatus() == ITestResult.SUCCESS)
       {
           test.log(Status.PASS, MarkupHelper.createLabel(methodname+" -> PASSED", ExtentColor.GREEN));
       }
       else
       {
           test.log(Status.SKIP, MarkupHelper.createLabel(methodname+" -> SKIPPED", ExtentColor.ORANGE));
           test.skip(result.getThrowable());
       }
    }

    @Parameters({"problem"})
    @AfterSuite
    public void tearDown(String problem) { 
    	
    	
        String curDir = System.getProperty("user.dir");
        
        String newloc=curDir+"/automation_report/"+problem;
        File file = new File(newloc);
        
        try {
        	file.mkdir();
            newloc=newloc+"/Logs";
            file = new File(newloc);
            if(file.mkdir())
            	System.out.println("Log subDir is created ");
        }catch(Exception e) {}
        
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-HHmm");
        String curDate = dateFormat.format(date);

        String filelocation=newloc+"/"+problem+"-"+curDate+".log";
        try {
        	FileUtils.copyFile(new File(curDir+"/appLogs.log"), new File(filelocation));
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
        
        extent.flush();
        driver.quit();
    }
}