package tests.stepDefinitions;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

import cucumber.api.java.en.When;
import org.junit.Assert;

import tests.Fixture;

import java.util.UUID;


public class GoogleTraderMethod extends Fixture {

    @Given("^I navigate to googletradermethod \"([^\"]*)\"$")
    public void iNavigateTo(String page) {
        compositionFunnels.web.openPage(page);
    }

    @Then("^funnel googletradermethod should be opened and logo present$")
    public void funnelGoogletradermethodShouldBeOpenedAndLogoPresent() throws Throwable {
        Assert.assertEquals(compositionFunnels.funnels.getLogoLink("googletradermethodLogo"), "http://www.googletradermethod.com/img/display1.png");

    }

    @When("^customer fill all required googletradermethod fields in registration form$")
    public void customerFillAllRequiredGoogletradermethodFieldsInRegistrationForm() throws Throwable {
        final String randomEmail = randomEmail();
        compositionFunnels.funnels.web.clickButton("googletradermethodGetAccess");
        compositionFunnels.funnels.web.clearAndInput("googletradermethodFirstName", "test");
        compositionFunnels.funnels.web.clearAndInput("googletradermethodLastName", "test");
        compositionFunnels.funnels.web.clearAndInput("googletradermethodEmail", randomEmail);
        compositionFunnels.funnels.web.clearAndInput("googletradermethodPassword", "qwerty");
        compositionFunnels.funnels.web.clearAndInputAndClickEnter("googletradermethodPhone", "123456789");
        Assert.assertEquals(true, compositionFunnels.web.getElement("algoprotraderEmail").getText().contains(randomEmail));
    }

    private static String randomEmail() {
        return "random-" + UUID.randomUUID().toString() + "@rootfest.net";
    }

    @And("^user should see the Deposit page from googletradermethod$")
    public void userShouldSeeTheDepositPageFromGoogletradermethod() throws Throwable {
        Assert.assertEquals(true, compositionFunnels.web.getElement("algoprotraderDeposiForm").isDisplayed());
    }

}
