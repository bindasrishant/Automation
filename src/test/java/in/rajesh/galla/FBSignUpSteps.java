package in.rajesh.galla;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class FBSignUpSteps extends PageInjector {

    public FBSignUpSteps(DriverInitializer driverInitializer) {

        this.signUpActions = driverInitializer.signUpActions;
    }

    @Given("^I am on sign up page$")
    public void I_am_on_sign_up_page() throws Throwable {

        signUpActions.goToSignUpPage();
    }

    @When("^I sign up$")
    public void I_sign_up() throws Throwable {

        signUpActions.submitData();
    }

    @And("^I get the confirmation email$")
    public void I_get_the_confirmation_email() throws Throwable {

//      TODO
    }

    @Then("^I get confirm$")
    public void I_get_confirm() throws Throwable {

//      TODO
    }

}
