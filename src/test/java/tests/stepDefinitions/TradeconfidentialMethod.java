package tests.stepDefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import tests.Fixture;

import java.util.UUID;


public class TradeconfidentialMethod extends Fixture {
    static String randomEmail;

    @Given("^I navigate to tradeconfidentialmethod \"([^\"]*)\"$")
    public void i_navigate_to_tradeconfidentialmethod(String page) {
        compositionFunnels.funnels.openHomePage(page);
    }

    @Then("^funnel tradeconfidentialmethod should be opened and logo present$")
    public void funnel_tradeconfidentialmethod_should_be_opened_and_logo_present() {
        randomEmail = randomEmail();
        Assert.assertEquals(compositionFunnels.funnels.getLogoLink("tradeconfidentialmethodLogo"), "http://www.tradeconfidentialmethod.com/images/logo.png");
        compositionFunnels.web.clearAndInput("tradeconfidentialFirstName", "test");
        compositionFunnels.web.clearAndInputAndClickEnter("tradeconfidentialEmail", randomEmail);
    }

    private static String randomEmail() {
        return "random-" + UUID.randomUUID().toString() + "@rootfest.net";
    }

    @Then("^video tradeconfidentialmethod should autorun$")
    public void video_tradeconfidentialmethod_should_autorun() throws Throwable {
        Assert.assertEquals("true", compositionFunnels.funnels.getElement("tradeconfidentialAutoPlay").getAttribute("autoplay"));
    }

    @When("^customer fill all required fields in tradeconfidentialmethod registration form$")
    public void customer_fill_all_required_fields_in_tradeconfidentialmethod_registration_form() {

        compositionFunnels.web.clearAndInput("tradeconfidentialLastName", "test");
        compositionFunnels.web.clearAndInput("tradeconfidentialPassword", "qwerty");
        compositionFunnels.web.clearAndInput("tradeconfidentialPhone", "123456789");
        compositionFunnels.web.clickButton("tradeconfidentialSubmitButton");
        Assert.assertEquals(true, compositionFunnels.web.getElement("algoprotraderEmail").getText().contains(randomEmail));
    }

    @When("^user should see the tradeconfidentialmethod Deposit page$")
    public void user_should_see_the_tradeconfidentialmethod_Deposit_page() {
        Assert.assertEquals(true, compositionFunnels.web.getElement("algoprotraderDeposiForm").isDisplayed());
    }
}
