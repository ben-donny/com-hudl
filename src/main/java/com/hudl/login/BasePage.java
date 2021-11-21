package com.hudl.login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;


public class BasePage {

    public static WebDriver driver;

    public static void createDriver(String browserName, String url) throws Exception{

        if (browserName.equalsIgnoreCase("chrome")){
            log("Test starts Running in Google chrome browser.");
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.home") + "/git/hudl-project/chromedriver");
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.get(url);
        }else if (browserName.equalsIgnoreCase("firefox")){
            log("Test starts Running In Firefox browser.");
            System.setProperty("webdriver.gecko.driver",System.getProperty("user.home") + "/git/hudl-project/geckodriver");
            driver = new FirefoxDriver();
            driver.manage().window().maximize();
            driver.get(url);
        }

    }

    /*
    Wait i is in seconds using Thread.sleep
	 *
     */
    public static void wait(int i) {
        try {
            int a = i * 1000;
            Thread.sleep(a);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String getPageTitle(){

        String title = driver.getTitle();
        return title;
    }

    public static void log(String msg) {
        System.out.println(msg);
        Reporter.log(msg);
    }

    public static void dologout(){
        driver.get("https://www.hudl.com/logout");
        log("Logged out of application");


    }

    public static void closeDriver(){
        driver.close();
        log("Driver closed");

    }
}


