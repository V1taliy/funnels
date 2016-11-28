package tests.stepDefinitions;


import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import tests.Fixture;

import java.util.UUID;

public class WonderClickAlgotrader extends Fixture {
    static String randomEmail;
    @Given("^I navigate to wonderclickalgotrader\"([^\"]*)\"$")
    public void i_navigate_to_wonderclickalgotrader(String page) {
        compositionFunnels.funnels.openHomePage(page);
    }

    @Then("^funnel wonderclickalgotrader should be opened and logo present$")
    public void funnel_wonderclickalgotrader_should_be_opened_and_logo_present() {
        randomEmail = randomEmail();
        Assert.assertEquals(compositionFunnels.funnels.getLogoLink("wonderclickalgotraderLogo"), "http://www.wonderclickalgotrader.com/assets/images/logo.png");
        compositionFunnels.web.windowScrollDown(500);
        compositionFunnels.web.clearAndInput("wonderclickalgotraderFirstName", "test");
        compositionFunnels.web.clearAndInputAndClickEnter("wonderclickalgotraderEmail",randomEmail);
    }
    private static String randomEmail() {
        return "random-" + UUID.randomUUID().toString() + "@rootfest.net";
    }

    @Then("^video wonderclickalgotrader should autorun$")
    public void video_wonderclickalgotrader_should_autorun() {
        Assert.assertEquals("true", compositionFunnels.funnels.getElement("wonderclickalgotraderVideo").getAttribute("autoplay"));
        compositionFunnels.web.windowScrollDown(500);
        compositionFunnels.web.clearAndInput("wonderclickalgotraderlastName", "test");
        compositionFunnels.web.clearAndInput("wonderclickalgotraderPhone", "123456789123");
        compositionFunnels.web.clearAndInputAndClickEnter("wonderclickalgotraderPassword", "qwerty");
    }

    @When("^customer fill all required fields in wonderclickalgotrader registration form$")
    public void customer_fill_all_required_fields_in_wonderclickalgotrader_registration_form() {
        Assert.assertTrue(compositionFunnels.web.isElementPresent("24algotraderLogo"));

    }
}
