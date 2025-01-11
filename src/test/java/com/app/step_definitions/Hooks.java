package com.app.step_definitions;


import com.app.utilities.TestDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.time.Duration;

public class Hooks {

    @Before
    public void setUp(){
        TestDriver.get().manage().window().maximize();
        TestDriver.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @After
    public void tearDown(Scenario scenario){
//        if(scenario.isFailed()){
//            final byte[] screenshot = ((TakesScreenshot) TestDriver.get()).getScreenshotAs(OutputType.BYTES);
//            scenario.attach(screenshot, "image/png", "screenshot");
//        }
        TestDriver.closeDriver();
    }

}
