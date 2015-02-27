package in.rajesh.galla.actions;

import in.rajesh.galla.ResourceLoader;
import in.rajesh.galla.objects.FBSignUpObjects;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

/**
 * Created by Galla on 2/21/2015.
 */
public class FBSignUpActions extends FBSignUpObjects {

    public void goToSignUpPage() {

        goTo("https://www.facebook.com");
    }

    public void submitData() throws InterruptedException {

        DateFormat dateFormat = new SimpleDateFormat("MMddHHmmss");
        Date date = new Date();

        firstName.getElement().sendKeys("Rajesh");
        lastName.getElement().sendKeys(dateFormat.format(date));
        email.getElement().sendKeys("rajesh.g.c6+"+dateFormat.format(date)+"@gmail.com");
        emailReEntry.getElement().sendKeys("rajesh.g.c6+"+dateFormat.format(date)+"@gmail.com");
        password.getElement().sendKeys("automation123");

        month.click();
        day.click();
        year.click();
        male.click();

        signUp.click();
        signUp.click();

        Thread.sleep(5000);
    }

    public boolean isResendEmailButtonShown() {

        return resendEmail.isDisplayed();
    }

    public boolean isEmailSent() throws Exception {

        Properties properties = ResourceLoader.loadGradleResource("property/fb.properties");

        return false;
    }
}