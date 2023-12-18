package org.AXA.utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ScreenshotUtils {

    private String pathScreenshot;
    private File ruta;
    private WebDriver driver;
    public ScreenshotUtils(WebDriver driver, String pathScreenshot){
        this.driver = driver;
        this.pathScreenshot =  pathScreenshot;
        ruta = new File(pathScreenshot);
    }
    public String captureScreenshot(String screenshotName){
        try {
            TakesScreenshot ts = (TakesScreenshot) driver;
            byte[] bytes = ts.getScreenshotAs(OutputType.BYTES);
            String screenshotPath = pathScreenshot+ "/"+ screenshotName+".png";
            Files.write(Paths.get(screenshotPath), bytes);
            return screenshotName+".png";
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}