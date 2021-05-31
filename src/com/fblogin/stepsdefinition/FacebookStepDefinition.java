package com.fblogin.stepsdefinition;

import com.fblogin.tests.init.Init;
import com.fblogin.tests.testcases.TestCases;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class FacebookStepDefinition {

    @Given("^I am on the Facebook home page page on URL$")
    public void i_am_on_the_facebook_home_page_page_on_url() throws Throwable {
        Init.initProperties();
    }

    @When("^I fill in Email or Phone$")
    public void i_fill_in_email_or_phone() throws Throwable {
        TestCases.emailOrPhone();
    }

    @And("^I fill in Password$")
    public void i_fill_in_password() throws Throwable {
        TestCases.password();
    }

    @And("^I click on the Log In button$")
    public void i_click_on_the_log_in_button() throws Throwable {
        TestCases.loginButton();
    }

    @And("^It shall redirect to the homepage$")
    public void it_shall_redirect_to_the_homepage() throws Throwable {
        TestCases.homepageRedirect();
    }

    @And("^I click on the post box$")
    public void i_click_on_the_post_box() throws Throwable {
        TestCases.postBoxClick();
    }

    @And("^type hello world$")
    public void type_hello_world() throws Throwable {
        TestCases.postBoxPaste();
    }

    @Then("^click on the post button$")
    public void click_on_the_post_button() throws Throwable {
        TestCases.clickPostbutton();
    }

    @Then("^Log In$")
    public void logIn() throws Throwable {
        TestCases.validateFbPage();
    }
}
