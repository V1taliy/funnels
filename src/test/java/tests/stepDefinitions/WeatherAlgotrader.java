package tests.stepDefinitions;


import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import tests.Fixture;

import java.util.UUID;

public class WeatherAlgotrader extends Fixture {
    static String randomEmail;

    @Given("^I navigate to weatheralgotrader\"([^\"]*)\"$")
    public void i_navigate_to_weatheralgotrader(String page) {
        compositionFunnels.funnels.openHomePage(page);
    }

    @Then("^funnel weatheralgotrader should be opened and logo present$")
    public void funnel_weatheralgotrader_should_be_opened_and_logo_present() {
        randomEmail = randomEmail();
        Assert.assertEquals(compositionFunnels.funnels.getLogoLink("weatheralgotradeLogo"), "http://www.weatheralgotrader.com/images/white-logo.png");
        compositionFunnels.web.clearAndInput("weatheralgotradeFirstName", "test");
        compositionFunnels.web.clearAndInputAndClickEnter("weatheralgotradeEmail", randomEmail);
    }

    private static String randomEmail() {
        return "random-" + UUID.randomUUID().toString() + "@rootfest.net";
    }

    @And("^video weatheralgotrader should autorun$")
    public void videoWeatheralgotraderShouldAutorun() {
        Assert.assertEquals("true", compositionFunnels.funnels.getElement("weatheralgotradeVideo").getAttribute("autoplay"));
    }

    @When("^customer fill all required fields in weatheralgotrader registration form$")
    public void customer_fill_all_required_fields_in_weatheralgotrader_registration_form() {
        compositionFunnels.web.clearAndInput("weatheralgotradeLastName", "test");
        compositionFunnels.web.clearAndInput("weatheralgotradePhone", "1234567891234");
        compositionFunnels.web.clearAndInputAndClickEnter("weatheralgotradePassword", "qwerty");
        Assert.assertEquals(true, compositionFunnels.web.getElement("algoprotraderEmail").getText().contains(randomEmail));
    }

    @When("^user should see the weatheralgotrader Deposit page$")
    public void user_should_see_the_weatheralgotrader_Deposit_page() {
        Assert.assertEquals(true, compositionFunnels.web.getElement("algoprotraderDeposiForm").isDisplayed());
    }

}
