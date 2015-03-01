package in.rajesh.galla.actions;

import in.rajesh.galla.RetrieveEmail;
import in.rajesh.galla.objects.FBSignUpObjects;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Multipart;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Galla on 2/21/2015.
 */
public class FBSignUpActions extends FBSignUpObjects {

    public static Logger LOGGER = LoggerFactory.getLogger("");
    java.util.logging.Logger javaLogger = java.util.logging.Logger.getLogger("");


    public void goToSignUpPage() {

        goTo("https://www.facebook.com");
    }

    public void submitData(String username) throws InterruptedException {

        DateFormat dateFormat = new SimpleDateFormat("MMddHHmmss");
        Date date = new Date();
        String dateValue = dateFormat.format(date);
        System.setProperty("emailID",username + "+"+dateValue+"@gmail.com");

        firstName.getElement().sendKeys("Love");
        lastName.getElement().sendKeys("Coding");
        email.getElement().sendKeys(System.getProperty("emailID"));
        emailReEntry.getElement().sendKeys(System.getProperty("emailID"));
        password.getElement().sendKeys("automation123");

        month.click();
        day.click();
        year.click();
        male.click();

        submitButton.click();
        submitButton.click();

    }

    public boolean isResendEmailButtonShown() throws InterruptedException {

        Boolean isDisplayed = false;
        for (int i=0;i<10;i++){
            try {
                isDisplayed = resendEmail.isEnabled();
                if (isDisplayed)
                    break;

            }
            catch (Error e) {
                LOGGER.info("Error");
                Thread.sleep(500);
            }
            catch (Exception e) {
                LOGGER.info("Exception");
                Thread.sleep(500);
            }
        }
        return isDisplayed;
    }

    public String getConfirmationLink(Message message) throws Exception {

        String link=null;
        Object content = message.getContent();
        if (content instanceof Multipart) {
            Multipart mp = (Multipart) content;
            for (int i = 0; i < mp.getCount(); i++) {
                BodyPart bp = mp.getBodyPart(i);
                Pattern pattern = Pattern.compile(Pattern.quote("text/html"),Pattern.CASE_INSENSITIVE);
                if (pattern.matcher(bp.getContentType()).find()) {
                    String email = (String) bp.getContent();
                    System.out.println("HTML Email is " + email);
                    pattern = Pattern.compile("https:\\/\\/www.facebook.com\\/n\\/[\\S]*");
                    Matcher matcher = pattern.matcher(email);
                    if(matcher.find()) {
                        link = matcher.group(0);
                    }
                    link = java.net.URLDecoder.decode(link, "UTF-8");
                }
            }
        }

        if(content instanceof String) {
            RetrieveEmail retrieveEmail = new RetrieveEmail();
            String email = retrieveEmail.getEmail(message);
            System.out.println("Text Email is " + email);
            Pattern pattern = Pattern.compile("https:\\/\\/www.facebook.com\\/n\\/[\\S]*");
            Matcher matcher = pattern.matcher(email);
            if(matcher.find()) {
                link = matcher.group(0);
            }
        }

        return link;
    }

    public boolean isErrorDisplayed() {
        
        return registrationError.getText().equalsIgnoreCase("Registration Error");
    }
}