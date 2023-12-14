package org.AXA.utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ScreenshotUtils {
    private WebDriver driver;
    public ScreenshotUtils(WebDriver driver){
        this.driver = driver;
    }
    public String captureScreenshot(String screenshotName){
        try {
            TakesScreenshot ts = (TakesScreenshot) driver;
            byte[] bytes = ts.getScreenshotAs(OutputType.BYTES);
            String screenshotPath = "target/extentReport/"+screenshotName+".png";
            Files.write(Paths.get(screenshotPath), bytes);
            return screenshotPath+".png";
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}