package tests.stepDefinitions;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import tests.Fixture;

import java.util.UUID;

public class AutoClickSoftware extends Fixture {
    final String randomEmail = randomEmail();

    @Given("^I navigate to AutoClickSoftWare \"([^\"]*)\"$")
    public void i_navigate_to_AutoClickSoftWare(String page) {
        compositionFunnels.funnels.openHomePage(page);
    }

    @Then("^funnel autoclicksoftware should be opened and logo present$")
    public void funnel_autoclicksoftware_should_be_opened_and_logo_present() {
        Assert.assertEquals(compositionFunnels.funnels.getLogoLink("autoclicksoftwareLogo"), "http://www.autoclicksoftware.com/images/logo-clr.png");
        compositionFunnels.web.windowScrollDown(500);
        compositionFunnels.web.clearAndInput("autoclicksoftwareNameFirstPage", "test");
        compositionFunnels.web.clearAndInputAndClickEnter("autoclicksoftwareEmailFirstPage", randomEmail);
    }

    private static String randomEmail() {
        return "random-" + UUID.randomUUID().toString() + "@rootfest.net";
    }

    @Then("^video autoclicksoftware should autorun$")
    public void video_autoclicksoftware_should_autorun() {
        Assert.assertEquals("true", compositionFunnels.funnels.getElement("autoclicksoftwareAutoPlay").getAttribute("autoplay"));

    }

    @When("^customer fill all required autoclicksoftware fields in registration form$")
    public void customer_fill_all_required_autoclicksoftware_fields_in_registration_form() {
        compositionFunnels.web.windowScrollDown(500);
        compositionFunnels.web.clearAndInput("autoclicksoftwareLastName", "test");
        compositionFunnels.web.clearAndInput("autoclicksoftwarePassword", "qwerty");
        compositionFunnels.web.clearAndInput("autoclicksoftwarePhone", "1234456789");
        compositionFunnels.web.clickButton("autoclicksofSignUp");

    }

    @And("^user should see the Deposit page from autoclicksotfare$")
    public void userShouldSeeTheDepositPageFromAutoclicksotfare() {
        Assert.assertTrue(compositionFunnels.web.isElementPresent("24algotraderLogo"));
    }
}
