package com.fblogin.tests.testcases;

import com.fblogin.tests.init.Init;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.openqa.selenium.By;
import com.fblogin.testrunner.TestRunners;

import java.nio.charset.Charset;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class TestCases extends Init {

    public TestCases(){}
    public TestCases( WebDriver driver ) { super(driver); }

    public static void assertProject(String myprops, String props ) throws Throwable {
        String facebook = driver.findElement(By.cssSelector(myValues(myprops))).getText();
        Assert.assertEquals(facebook, getProperties().getProperty(props));
    }

    public static void assertProjectXpath(String myprops, String props ) throws Throwable {
        String facebook = driver.findElement(By.xpath(myValues(myprops))).getText();
        Assert.assertEquals(facebook, getProperties().getProperty(props));
    }

    public static void validateFbPage() throws Throwable {
        assertProjectXpath("facebook.loginbutton.field", "facebook.greetings");
    }

    private static void insertValues(String field, String value ) throws Throwable {
        driver.findElement(By.cssSelector(myValues(field))).clear();
        driver.findElement(By.cssSelector(myValues(field))).sendKeys(myValues(value));
    }

    public static void emailOrPhone () throws Throwable {
        insertValues("facebook.username.field", "facebook.username");
    }

    public static void password () throws Throwable {
        insertValues("facebook.password.field", "facebook.password");
    }

    public static void loginButton () throws Throwable {
        driver.findElement(By.xpath(myValues("facebook.loginbutton.field"))).click();
    }

    private static String myValues(String values) throws Throwable {
       return TestRunners.getProperties().getProperty(values );
    }

    public static void homepageRedirect () throws Throwable {
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        WebElement myElement = driver.findElement(By.cssSelector(myValues("facebook.createstory.field")));
        if ( !myElement.equals(null) && !myElement.getText().equals(null) && myElement.getText().equals(myValues("facebook.createstory.text"))) {
            System.out.println(myElement.getText().toString());
        } else {
            System.out.println("not there");
        }
    }

    public static void postBoxClick() throws Throwable {
        WebElement myElement = driver.findElement(By.xpath(myValues("facebook.story.field")));
        if ( !myElement.equals(null) && myElement.isDisplayed() ) {
            myElement.click();
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        } else {
            System.out.println("not there");
        }
    }

    public static void postBoxPaste() throws Throwable {
        driver.switchTo().activeElement();
        WebElement element = (new WebDriverWait(driver, 20))
                .until(ExpectedConditions.elementToBeClickable(By.xpath(myValues("facebook.story.paste"))));
        //WebElement myElement = driver.findElement(By.cssSelector(myValues("facebook.story.paste")));
        if ( !element.equals(null) && element.isDisplayed()) {
            element.sendKeys(myValues("facebook.story.realText"));
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        } else {
            System.out.println("not there");
        }
    }

    public static void clickPostbutton() throws Throwable {
        driver.switchTo().activeElement();
        WebElement myElement = driver.findElement(By.xpath(myValues("facebook.post.button")));
        if ( !myElement.equals(null) && myElement.isDisplayed()) {
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            myElement.click();
        } else {
            System.out.println("not there");
        }
    }

    private static void shared(String inputValue) throws Throwable {

    }
}
