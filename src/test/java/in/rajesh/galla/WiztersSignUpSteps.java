package in.rajesh.galla;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import sun.security.util.PendingException;

/**
 * Created by Galla on 2/24/2015.
 */
public class WiztersSignUpSteps extends PageInjector{


    public WiztersSignUpSteps(DriverInitializer driverInitializer) {

        this.wiztersSignUpActions = driverInitializer.wiztersSignUpActions;
    }

    @Given("^I am on wizters sign up page$")
    public void I_am_on_wizters_sign_up_page() throws Throwable {

        wiztersSignUpActions.goToSignUpPage();
    }

    @When("^I enter details for wizters$")
    public void I_enter_details_for_wizters() throws Throwable {

        wiztersSignUpActions.submitData();
    }

    @And("^I get the confirmation email from wizters$")
    public void I_get_the_confirmation_email_from_wizters() throws Throwable {
        // Express the Regexp above with the code you wish you had
        throw new PendingException();
    }

    @Then("^I confirm email from wizters$")
    public void I_confirm_email_from_wizters() throws Throwable {
        // Express the Regexp above with the code you wish you had
        throw new PendingException();
    }
}
