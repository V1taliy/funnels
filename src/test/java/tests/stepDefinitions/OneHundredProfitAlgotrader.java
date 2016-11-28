package tests.stepDefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import tests.Fixture;

import java.util.UUID;

public class OneHundredProfitAlgotrader extends Fixture {
    @Given("^I navigate to oneHundredProfitalgotrader \"([^\"]*)\"$")
    public void iNavigateToProfitalgotrader(String page) throws Throwable {
        compositionFunnels.funnels.openHomePage(page);

    }

    @Then("^funnel oneHundredProfitalgotrader should be opened and logo present$")
    public void funnelProfitalgotraderShouldBeOpenedAndLogoPresent() throws Throwable {
        Assert.assertEquals(compositionFunnels.funnels.getLogoLink("100profitalgotraderLogo"), "http://www.100profitalgotrader.com/images/affiliates/logo.png");
    }

    @And("^video oneHundredProfitalgotrader should autorun$")
    public void videoProfitalgotraderShouldAutorun() throws Throwable {
        Assert.assertEquals("true", compositionFunnels.funnels.getElement("100profitalgotraderAutoplay").getAttribute("autoplay"));

    }

    @When("^customer fill all required oneHundredProfitalgotrader fields in registration form$")
    public void customerFillAllRequiredProfitalgotraderFieldsInRegistrationForm() throws Throwable {
        driverWrapper.navigate().refresh();
        final String randomEmail = randomEmail();
        compositionFunnels.funnels.web.scrollToElementBy("100profitalgotraderEmailField");
        compositionFunnels.funnels.web.clearAndInput("100profitalgotraderEmailField", randomEmail);
        compositionFunnels.funnels.web.clearAndInput("100profitalgotraderPassword", "qwerty");
        compositionFunnels.funnels.web.clearAndInput("100profitalgotraderFirstName", "test");
        compositionFunnels.funnels.web.clearAndInput("100profitalgotraderLastName", "test");
        compositionFunnels.funnels.web.clearAndInput("100profitalgotraderPhone", "123456789");
        compositionFunnels.funnels.web.clickElement("100profitalgotraderSubmitButton");
        Assert.assertEquals(true, compositionFunnels.web.getElement("algoprotraderEmail").getText().contains(randomEmail));
    }

    private static String randomEmail() {
        return "random-" + UUID.randomUUID().toString() + "@rootfest.net";
    }

    @And("^user should see the Deposit page from oneHundredProfitalgotrader$")
    public void userShouldSeeTheDepositPageFromProfitalgotraderFromMitlukashermann() throws Throwable {
        Assert.assertEquals(true, compositionFunnels.web.getElement("algoprotraderDeposiForm").isDisplayed());
    }


}
