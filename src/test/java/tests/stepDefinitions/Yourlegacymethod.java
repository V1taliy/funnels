package tests.stepDefinitions;


import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import tests.Fixture;

import java.util.UUID;

public class Yourlegacymethod extends Fixture {
    static String randomEmail;
    @Given("^I navigate to yourlegacymethod \"([^\"]*)\"$")
    public void i_navigate_to_yourlegacymethod(String page) {
        compositionFunnels.funnels.openHomePage(page);

    }

    @Then("^funnel yourlegacymethod should be opened and logo present$")
    public void funnel_yourlegacymethod_should_be_opened_and_logo_present() {
        randomEmail = randomEmail();
        Assert.assertEquals(compositionFunnels.funnels.getLogoLink("yourlegacymethodLogo"), "http://www.yourlegacymethod.com/images/logo.png");
        compositionFunnels.web.clearAndInput("yourlegacymethodEmail", randomEmail);

    }
    private static String randomEmail() {
        return "random-" + UUID.randomUUID().toString() + "@rootfest.net";
    }

    @When("^customer fill all required fields in yourlegacymethod registration form$")
    public void customer_fill_all_required_fields_in_yourlegacymethod_registration_form() {

    }

    @And("^(\\d+) algo robot should open$")
    public void algo_robot_should_open(int arg1) {

    }

}
