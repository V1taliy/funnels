package tests.stepDefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

import cucumber.api.java.en.When;
import org.junit.Assert;
import tests.Fixture;

import java.util.UUID;


public class ZulanderMethod extends Fixture {

    @Given("^I navigate to \"([^\"]*)\"$")
    public void iNavigateTo(String page) throws InterruptedException {
        compositionFunnels.funnels.openHomePage(page);
    }

    @Then("^funnel zulander should be opened and logo present$")
    public void funnelShouldBeOpened() {
        Assert.assertEquals(compositionFunnels.funnels.getLogoLink("zulanderLogo"), "http://www.zulandermethod.com/img/logo.png");

    }

    @And("^video should autorun$")
    public void videoShouldAutorun() throws Throwable {
        Assert.assertEquals("true", compositionFunnels.funnels.getElement("zulanderAutoplay").getAttribute("autoplay"));
    }

    @When("^customer fill all required fields in registration form$")
    public void customerFillAllRequiredFieldsInRegistrationForm() throws Throwable {
        final String randomEmail = randomEmail();
        compositionFunnels.web.windowScrollDown(500);
        compositionFunnels.funnels.web.clearAndInputAndClickEnter("zulanderFirstPageEmail", randomEmail);
        compositionFunnels.funnels.web.clearAndInput("zulanderSecondPageFirstName", "test");
        compositionFunnels.funnels.web.clearAndInput("zulanderSecondPageLastName", "test");
        compositionFunnels.funnels.web.clearAndInput("zulanderSecondPagePassword", "qwerty");
        compositionFunnels.funnels.web.clearAndInputAndClickEnter("zulanderSecondPagePhone", "123456789");
        Assert.assertEquals(true, compositionFunnels.web.getElement("algoprotraderEmail").getText().contains(randomEmail));
    }

    private static String randomEmail() {
        return "random-" + UUID.randomUUID().toString() + "@rootfest.net";
    }

    @And("^user should see the Deposit page$")
    public void userShouldSeeTheDepositPage() throws Throwable {
        Assert.assertEquals(true, compositionFunnels.web.getElement("algoprotraderDeposiForm").isDisplayed());

    }
}





