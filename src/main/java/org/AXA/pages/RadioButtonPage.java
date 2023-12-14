package org.AXA.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RadioButtonPage {
    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(xpath="(//div[@class='card mt-4 top-card'])[1]")
    private WebElement btnElements;

    @FindBy(xpath="(//li[@class='btn btn-light '])[3]")
    private WebElement btnCheckBox;

    public RadioButtonPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(this.driver, Duration.ofSeconds(30));
    }

    public void ingresarRadioButtonPage(){
        btnElements.click();
        wait.until(ExpectedConditions.elementToBeClickable(btnCheckBox));
        btnCheckBox.click();
    }
}