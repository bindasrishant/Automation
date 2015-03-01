package in.rajesh.galla;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

import javax.mail.Message;

public class FBSignUpSteps extends PageInjector {

    static String confirmationLink;
    static Message message;

    public FBSignUpSteps(DriverHandler driverHandler) {

        this.fbSignUpActions = driverHandler.fbSignUpActions;
    }

    @Given("^I am on sign up page$")
    public void I_am_on_sign_up_page() throws Throwable {

        fbSignUpActions.goToSignUpPage();
    }

    @When("^I sign up$")
    public void I_sign_up() throws Throwable {

        fbSignUpActions.submitData("ilovecodingattokyo");
        Assert.assertTrue("Next page not loaded", fbSignUpActions.isResendEmailButtonShown());
    }

    @And("^I get the confirmation email$")
    public void I_get_the_confirmation_email() throws Throwable {

        RetrieveEmail retrieveEmail = new RetrieveEmail();
        message =  retrieveEmail.getMessage("imap.gmail.com",
                "ilovecodingattokyo@gmail.com","codingattokyo",
                System.getProperty("emailID"));
        System.out.println("Message retrieved is " + message);
        confirmationLink = fbSignUpActions.getConfirmationLink(message);
        System.out.println("Confirmation link is " + confirmationLink);
        Assert.assertTrue("Confirmation link is null",confirmationLink != null);
    }

    @Then("^I complete the registration$")
    public void I_complete_the_registration() throws Throwable {

        fbSignUpActions.goTo(confirmationLink);
    }

    @And("^I see an error$")
    public void I_see_an_error() throws Throwable {

        Assert.assertTrue("Error is not displayed",fbSignUpActions.isErrorDisplayed());
    }
}
