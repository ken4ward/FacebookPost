package com.fblogin.tests.init;

import com.fblogin.utility.PropertiesFileReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.Properties;

public class Init {

    public static WebDriver driver;

    public Init(){}
    public Init(WebDriver _driver) {
        this.driver = _driver;
    }
    static PropertiesFileReader propertiesFileReader = new PropertiesFileReader();

    public static Properties getProperties() throws Throwable {
        Properties properties = propertiesFileReader.getProperties();
        return properties;
    }

    public static void initProperties() throws Throwable {
        System.setProperty("webdriver.chrome.driver", "chromedriver");
        ChromeOptions options  = new ChromeOptions();
        options.addArguments("--disable-popup-blocking");
        options.addArguments("--disable-notifications");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get(getProperties().getProperty("browser.baseURL"));
        Thread.sleep(3000);
    }

    public static void quit() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }
}
