package in.rajesh.galla.objects;

import org.fluentlenium.core.FluentPage;
import org.fluentlenium.core.domain.FluentWebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Galla on 2/21/2015.
 */
public class FBSignUpObjects extends FluentPage {

    @FindBy(css = "#u_0_1")
    protected FluentWebElement firstName;

    @FindBy(css = "#u_0_3")
    protected FluentWebElement lastName;

    @FindBy(css = "#u_0_5")
    protected FluentWebElement email;

    @FindBy(css = "#u_0_8")
    protected FluentWebElement emailReEntry;

    @FindBy(css = "#u_0_a")
    protected FluentWebElement password;

    @FindBy(css = "#month option[value='3']")
    protected FluentWebElement month;

    @FindBy(css = "#day option[value='10']")
    protected FluentWebElement day;

    @FindBy(css = "#year>option[value='2010']")
    protected FluentWebElement year;

    @FindBy(css = "#u_0_d")
    protected FluentWebElement female;

    @FindBy(css = "#u_0_e")
    protected FluentWebElement male;

    @FindBy(css = "#u_0_i")
    protected FluentWebElement signUp;

    @FindBy(css = "#req")
    protected FluentWebElement form;
}
