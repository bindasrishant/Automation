package in.rajesh.galla;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class FBSignUpSteps extends PageInjector {

    public FBSignUpSteps(DriverInitializer driverInitializer) {

        this.fbSignUpActions = driverInitializer.fbSignUpActions;
    }

    @Given("^I am on sign up page$")
    public void I_am_on_sign_up_page() throws Throwable {

        fbSignUpActions.goToSignUpPage();
    }

    @When("^I sign up$")
    public void I_sign_up() throws Throwable {

        fbSignUpActions.submitData();
        Assert.assertTrue(fbSignUpActions.isResendEmailButtonShown());
    }

    @And("^I get the confirmation email$")
    public void I_get_the_confirmation_email() throws Throwable {

        Assert.assertTrue(fbSignUpActions.isEmailSent());
    }

    @Then("^I confirm the details$")
    public void I_confirm_the_details() throws Throwable {

    }
}
