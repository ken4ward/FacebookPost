package com.fblogin.testrunner;

import com.fblogin.utility.PropertiesFileReader;
import cucumber.api.CucumberOptions;
import cucumber.api.testng.CucumberFeatureWrapper;
import cucumber.api.testng.TestNGCucumberRunner;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import java.util.Properties;

@CucumberOptions(
        features = "./features",
        glue = {"com.fblogin.stepsdefinition"},
        tags = {"@UATTesting"},
        plugin = {"pretty", "html:target/site/cucumber-pretty", "json:target/cucumber.json"},
        monochrome = true )
public class TestRunners {
    public static WebDriver driver;
    private static TestNGCucumberRunner testNGCucumberRunner;
    static PropertiesFileReader propertiesFileReader = new PropertiesFileReader();

    public TestRunners(){}
    public TestRunners( WebDriver _driver ){ this.driver = _driver; }

    @BeforeClass( alwaysRun=true )
    public void setUpClass( ) throws Exception {
        testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
    }

    public static Properties getProperties() throws Throwable {
        Properties properties = propertiesFileReader.getProperties();
        return properties;
    }

    @Test( dataProvider = "features")
    public static void feature(CucumberFeatureWrapper cucumberFeatureWrapper) throws Throwable {
        testNGCucumberRunner.runCucumber(cucumberFeatureWrapper.getCucumberFeature());
    }

    @DataProvider
    public Object[][] features() {
        return testNGCucumberRunner.provideFeatures();
    }

    @AfterClass(alwaysRun = true )
    public void tearDownClass() throws Exception {
        testNGCucumberRunner.finish();
    }
}
