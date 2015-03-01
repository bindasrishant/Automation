package in.rajesh.galla.actions;

import in.rajesh.galla.objects.FBSignUpObjects;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Galla on 2/21/2015.
 */
public class FBSignUpActions extends FBSignUpObjects {

    public void goToSignUpPage() {

        goTo("https://www.facebook.com");
    }

    public void submitData(String username) throws InterruptedException {

        DateFormat dateFormat = new SimpleDateFormat("MMddHHmmss");
        Date date = new Date();
        String dateValue = dateFormat.format(date);
        System.setProperty("emailID",username + "+"+dateValue+"@gmail.com");

        firstName.getElement().sendKeys("Love");
        Thread.sleep(500);
        lastName.getElement().sendKeys("Coding");
        Thread.sleep(500);
        email.getElement().sendKeys(System.getProperty("emailID"));
        Thread.sleep(500);
        emailReEntry.getElement().sendKeys(System.getProperty("emailID"));
        Thread.sleep(500);
        password.getElement().sendKeys("automation123");
        Thread.sleep(500);

        month.click();
        Thread.sleep(500);
        day.click();
        Thread.sleep(500);
        year.click();
        Thread.sleep(500);
        male.click();
        Thread.sleep(500);

        signUp.click();
        Thread.sleep(500);
        signUp.click();

        Thread.sleep(5000);
    }

    public boolean isResendEmailButtonShown() {

        return resendEmail.isDisplayed();
    }

    public String getConfirmationLink(String email) {

        String link=null;
        Pattern pattern = Pattern.compile("https:\\/\\/www.facebook.com\\/n([^\\s]+)gmail.com");
        Matcher matcher = pattern.matcher(email);
        if(matcher.find()) {
            link = matcher.group(1);
        }

        return "https://www.facebook.com/n/"+link+"gmail.com";
    }
}