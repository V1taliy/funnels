package tests.stepDefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import tests.Fixture;

import java.util.UUID;


public class MaximizerAlgorithm extends Fixture {

    static String randomEmail;

    @Given("^I navigate to maximizeralgorithm \"([^\"]*)\"$")
    public void iNavigateToMaximizeralgorithm(String page) throws Throwable {
        compositionFunnels.funnels.openHomePage(page);

    }

    @Then("^funnel maximizeralgorithm should be opened and logo present$")
    public void funnelMaximizeralgorithmShouldBeOpenedAndLogoPresent() throws Throwable {
        Assert.assertEquals(compositionFunnels.funnels.getLogoLink("maximizeralgorithmLogo"), "http://www.maximizeralgorithm.com/img/profitmax/payment.png");
        randomEmail = randomEmail();
        compositionFunnels.funnels.web.clearAndInputAndClickEnter("maximizeralgorithmEmailField", randomEmail);
    }

    private static String randomEmail() {
        return "random-" + UUID.randomUUID().toString() + "@rootfest.net";
    }

    @When("^customer fill all required maximizeralgorithm fields in registration form$")
    public void customerFillAllRequiredMaximizeralgorithmFieldsInRegistrationForm() throws Throwable {
        //final String randomEmail = randomEmail();
        compositionFunnels.funnels.web.clearAndInput("maximizeralgorithmFirstName", "test");
        compositionFunnels.funnels.web.clearAndInput("maximizeralgorithmLastName", "test");
        compositionFunnels.funnels.web.clearAndInput("maximizeralgorithmPassword", "qwerty");
        compositionFunnels.funnels.web.clearAndInput("maximizeralgorithmPhone", "123456789");
        compositionFunnels.funnels.web.clickButton("maximizeralgorithmSubmit");
        Assert.assertEquals(randomEmail, compositionFunnels.web.getElement("algoprotraderEmail").getText());
    }

    @And("^user should see the Deposit page from maximizeralgorithm$")
    public void userShouldSeeTheDepositPageFromMaximizeralgorithm() throws Throwable {
        Assert.assertEquals(true, compositionFunnels.web.getElement("algoprotraderDeposiForm").isDisplayed());
    }
}