package in.rajesh.galla;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by Galla on 2/23/2015.
 */
public class DriverHandler extends PageInjector{

    @Before
    public void before() {
        this.initFluent(new FirefoxDriver());
        this.initTest();
        this.getDriver().manage().window().maximize();
    }

    @After
    public void after(){
        this.quit();
    }
}
