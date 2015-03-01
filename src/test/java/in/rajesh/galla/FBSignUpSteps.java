package in.rajesh.galla;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class FBSignUpSteps extends PageInjector {

    static String confirmationLink;

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
        Assert.assertTrue(fbSignUpActions.isResendEmailButtonShown());
    }

    @And("^I get the confirmation email$")
    public void I_get_the_confirmation_email() throws Throwable {

        RetrieveEmail retrieveEmail = new RetrieveEmail();
        String email =  retrieveEmail.getEmail("imap.gmail.com",
                "ilovecodingattokyo@gmail.com","codingattokyo",
                System.getProperty("emailID"));
        System.out.println("Email retrieved is " + email);
        confirmationLink = fbSignUpActions.getConfirmationLink(email);
        System.out.println("Confirmation link is " + confirmationLink);
        Assert.assertTrue(confirmationLink != null);
    }

    @Then("^I confirm the details$")
    public void I_confirm_the_details() throws Throwable {

        fbSignUpActions.goTo(confirmationLink);
    }
}
