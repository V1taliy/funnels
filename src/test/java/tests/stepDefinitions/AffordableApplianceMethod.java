package tests.stepDefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import tests.Fixture;

import java.util.UUID;

public class AffordableApplianceMethod extends Fixture {

    @Given("^I navigate to affordable-appliancemethod \"([^\"]*)\"$")
    public void iNavigateToAffordableAppliancemethod(String page) {
        compositionFunnels.funnels.openHomePage(page);
    }

    @Then("^funnel affordable-appliancemethod should be opened and logo present$")
    public void funnelAffordableAppliancemethodShouldBeOpenedAndLogoPresent() {
        Assert.assertEquals(compositionFunnels.funnels.getLogoLink("affordable-appliancemethodLogo"), "http://www.affordable-appliancemethod.com/img/logo.png");
        final String randomEmail = randomEmail();
        compositionFunnels.funnels.web.clearAndInput("affordable-appliancemethodeNameFirstPage", "test");
        compositionFunnels.funnels.web.clearAndInputAndClickEnter("affordable-appliancemethodEmailFirstPage", randomEmail);
    }

    private static String randomEmail() {
        return "random-" + UUID.randomUUID().toString() + "@rootfest.net";
    }

    @And("^video affordable-appliancemethod should autorun$")
    public void videoAffordableAppliancemethodShouldAutorun() {
        Assert.assertEquals("true", compositionFunnels.funnels.getElement("affordable-appliancemethodAutoPlay").getAttribute("autoplay"));
    }

    @When("^customer fill all required affordable-appliancemethod fields in registration form$")
    public void customerFillAllRequiredAffordableAppliancemethodFieldsInRegistrationForm() {
        final String randomEmail = randomEmail();
        compositionFunnels.web.windowScrollDown(500);
        compositionFunnels.web.clearAndInput("affordable-appliancemethodLastName", "test");
        compositionFunnels.web.clearAndInput("affordable-appliancemethodPassword", "qwerty");
        compositionFunnels.web.clearAndInput("affordable-appliancemethodAreaCode", "44");
        compositionFunnels.web.clearAndInputAndClickEnter("affordable-appliancemethodPhone", "123456789");
        Assert.assertEquals(true, compositionFunnels.web.getElement("algoprotraderEmail").getText().contains(randomEmail));
    }

    @And("^user should see the Deposit page from affordable-appliancemethod$")
    public void userShouldSeeTheDepositPageFromAffordableAppliancemethod() {
        Assert.assertEquals(true, compositionFunnels.web.getElement("algoprotraderDeposiForm").isDisplayed());
    }


}
