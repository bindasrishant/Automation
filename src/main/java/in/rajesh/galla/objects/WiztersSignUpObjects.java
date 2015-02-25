package in.rajesh.galla.objects;

import org.fluentlenium.core.FluentPage;
import org.fluentlenium.core.domain.FluentWebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Galla on 2/24/2015.
 */
public class WiztersSignUpObjects extends FluentPage{

    @FindBy(css = "#xlInput")
    protected FluentWebElement realName;

    @FindBy(css = "#email")
    protected FluentWebElement email;

    @FindBy(css = "#Password")
    protected FluentWebElement password;

    @FindBy(css = "#ConfirmPassword")
    protected FluentWebElement confirmPassword;

    @FindBy(css = "#AgreeTerms")
    protected FluentWebElement agreeTerms;

    @FindBy(css = ".btn")
    protected FluentWebElement signUp;
}
