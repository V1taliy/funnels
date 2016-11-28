package tests.stepDefinitions;


import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import tests.Fixture;

import java.util.UUID;

public class Virtnexmethod extends Fixture {
    static String randomEmail;

    @Given("^I navigate to virtnextmethod \"([^\"]*)\"$")
    public void i_navigate_to_virtnextmethod(String page) {
        compositionFunnels.funnels.openHomePage(page);
    }


    @Then("^funnel virtnextmethod should be opened and logo present$")
    public void funnel_virtnextmethod_should_be_opened_and_logo_present() {
        compositionFunnels.web.windowScrollDown(500);
        randomEmail = randomEmail();
        Assert.assertEquals(compositionFunnels.funnels.getLogoLink("virtnextmethodLogo"), "http://virtnextmethod.com/img/virtnext/logo.png");
        compositionFunnels.web.clearAndInputAndClickEnter("virtnextmethodEmail", randomEmail);
    }

    private static String randomEmail() {
        return "random-" + UUID.randomUUID().toString() + "@rootfest.net";
    }


    @When("^customer fill all required fields in virtnextmethod registration form$")
    public void customer_fill_all_required_fields_in_virtnextmethod_registration_form() {
        compositionFunnels.web.clearAndInput("virtnextmethodFirstName", "test");
        compositionFunnels.web.clearAndInput("virtnextmethodLastName", "test");
        compositionFunnels.web.clearAndInput("virtnextmethodPassword", "qwerty");
        compositionFunnels.web.clearAndInput("virtnextmethodPhone", "123456789");
        compositionFunnels.web.clickButton("virtnextmethodSubmitButton");
        Assert.assertEquals(true, compositionFunnels.web.getElement("algoprotraderEmail").getText().contains(randomEmail));
    }

    @When("^user should see the virtnextmethod Deposit page$")
    public void user_should_see_the_virtnextmethod_Deposit_page() {
        Assert.assertEquals(true, compositionFunnels.web.getElement("algoprotraderDeposiForm").isDisplayed());
    }


}
