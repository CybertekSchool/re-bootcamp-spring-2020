package com.cybertek.library.step_definitions;


import com.cybertek.library.utilities.common.Encoder;
import com.cybertek.library.utilities.common.Environment;
import com.cybertek.library.utilities.db.DBUtils;
import com.cybertek.library.utilities.ui.Driver;
import io.cucumber.java.*;
import io.restassured.RestAssured;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.util.concurrent.TimeUnit;

public class Hooks extends BaseStep {

    @Before(order = 0)
    public void setUpScenario() {
        Driver.getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//        Driver.getDriver().manage().window().fullscreen();
        RestAssured.baseURI = Environment.getProperty("base_url");

    }

    @Before(value = "@db", order = 1)
    public void connect() {
        String url = "jdbc:mysql://" + Environment.getProperty("qa2_db_host") +
                Environment.getProperty("db_name");
        String username = Environment.getProperty("db_username");
        String password = Environment.getProperty("db_password");
        password = Encoder.decrypt(password);
        DBUtils.createConnection(url, username, password);
    }

    @After
    public void tearDownScenario(Scenario scenario) {
        if (scenario.isFailed()) {
            // take screenshot using selenium
            byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            // attach to report
            scenario.embed(screenshot, "image/png", scenario.getName());
        }
        Driver.closeDriver();
    }

    @After("@db")
    public void closeConnection() {
        DBUtils.destroy();
    }


}