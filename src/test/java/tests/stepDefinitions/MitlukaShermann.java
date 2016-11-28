package tests.stepDefinitions;


import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import tests.Fixture;

import java.util.UUID;

public class MitlukaShermann extends Fixture {

    @Given("^I navigate to mitlukashermann \"([^\"]*)\"$")
    public void iNavigateToMitlukashermann(String page) {
        compositionFunnels.web.openPage(page);
    }

    @Then("^funnel mitlukashermann should be opened and logo present$")
    public void funnelMitlukashermannShouldBeOpenedAndLogoPresent() throws Throwable {
        Assert.assertEquals(compositionFunnels.funnels.getLogoLink("mitlukashermannLogo"),
                "http://www.mitlukashermann.com/img/aussie-new/de/bavarian-logo.jpg");

    }

    @When("^customer fill all required mitlukashermann fields in registration form$")
    public void customerFillAllRequiredMitlukashermannFieldsInRegistrationForm() throws Throwable {
        final String randomEmail = randomEmail();
        compositionFunnels.funnels.web.clearAndInputAndClickEnter("mitlukashermannEmailField",
                randomEmail);
    }

    @And("^video mitlukashermann should autorun$")
    public void videoMitlukashermannShouldAutorun() throws Throwable {
        Assert.assertEquals("true", compositionFunnels.funnels.getElement
                ("mitlukashermannAutoplay").getAttribute("autoplay"));

    }

    @And("^finish with registration$")
    public void finishWithRegistration() throws Throwable {
        final String randomEmail = randomEmail();
        compositionFunnels.funnels.web.clearAndInput("mitlukashermannFirstName", "test");
        compositionFunnels.funnels.web.clearAndInput("mitlukashermannLastName", "test");
        compositionFunnels.funnels.web.clearAndInput("mitlukashermannPassword", "qwerty");
        compositionFunnels.funnels.web.clearAndInput("mitlukashermannPhone", "123456789");
        compositionFunnels.funnels.web.clickButton("mitlukashermannSubmitButton");
    }

    private static String randomEmail() {
        return "random-" + UUID.randomUUID().toString() + "@rootfest.net";
    }

    @And("^user should see the Deposit page from mitlukashermann$")
    public void userShouldSeeTheDepositPageFromMitlukashermann() throws Throwable {
        Assert.assertTrue(compositionFunnels.web.isElementPresent("24algotraderLogo"));
    }
}


