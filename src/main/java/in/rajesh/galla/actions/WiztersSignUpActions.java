package in.rajesh.galla.actions;

import in.rajesh.galla.objects.WiztersSignUpObjects;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Galla on 2/24/2015.
 */
public class WiztersSignUpActions extends WiztersSignUpObjects {

    public void goToSignUpPage() {

        goTo("http://www.wizters.com/signup.php");
    }

    public void submitData() throws InterruptedException {

        DateFormat dateFormat = new SimpleDateFormat("MMddHHmmss");
        Date date = new Date();

        realName.getElement().sendKeys("Yokohoma");

        email.getElement().sendKeys("geekzeus+" + dateFormat.format(date) + "@gmail.com");
        password.getElement().sendKeys("automation123");
        confirmPassword.getElement().sendKeys("automation123");
        agreeTerms.click();

        signUp.click();
        signUp.click();

        Thread.sleep(5000);
    }
}
