package org.AXA.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import static org.AXA.steps.Steps.screenshotUtils;
import static org.AXA.steps.Steps.test;

public class CheckBoxPage {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(xpath="(//div[@class='card mt-4 top-card'])[1]")
    private WebElement btnElements;
    @FindBy(xpath="(//li[@class='btn btn-light '])[2]")
    private WebElement btnCheckBox;
    @FindBy(xpath="(//button[@class = 'rct-collapse rct-collapse-btn'])[1]")
    private WebElement collapse1;
    @FindBy(xpath="(//button[@class = 'rct-collapse rct-collapse-btn'])[2]")
    private WebElement collapse2;
    @FindBy(xpath="(//button[@class = 'rct-collapse rct-collapse-btn'])[3]")
    private WebElement collapse3;
    @FindBy(xpath="(//button[@class = 'rct-collapse rct-collapse-btn'])[4]")
    private WebElement collapse4;
    @FindBy(xpath="(//button[@class = 'rct-collapse rct-collapse-btn'])[5]")
    private WebElement collapse5;
    @FindBy(xpath="(//button[@class = 'rct-collapse rct-collapse-btn'])[6]")
    private WebElement collapse6;

    public CheckBoxPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(this.driver, Duration.ofSeconds(10));
    }

    public void ingresarCheckBoxPage(){
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        takecreenshot();
        executor.executeScript("arguments[0].setAttribute('style', 'border: 2px solid red;');", btnElements);
        takecreenshot();
        executor.executeScript("arguments[0].click();", btnElements);
        takecreenshot();
        executor.executeScript("arguments[0].setAttribute('style', 'border: 2px solid red;');", btnCheckBox);
        takecreenshot();
        executor.executeScript("arguments[0].click();", btnCheckBox);
    }

    public void seleccionarCampos(String select1, String select2, String select3) throws InterruptedException {
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        takecreenshot();
        executor.executeScript("arguments[0].click();", collapse1);
        executor.executeScript("arguments[0].click();", collapse2);
        executor.executeScript("arguments[0].click();", collapse3);
        executor.executeScript("arguments[0].click();", collapse4);
        executor.executeScript("arguments[0].click();", collapse5);
        executor.executeScript("arguments[0].click();", collapse6);
        takecreenshot();
        WebElement checkBox1 = driver.findElement(By.xpath("(//span[.='"+select1+"'])[2]"));
        System.out.println("(//span[.='"+select1+"'])[2]");
        checkBox1.click();
        WebElement checkBox2 = driver.findElement(By.xpath("(//span[.='"+select2+"'])[2]"));
        System.out.println("(//span[.='"+select2+"'])[2]");
        checkBox2.click();
        WebElement checkBox3 = driver.findElement(By.xpath("(//span[.='"+select3+"'])[2]"));
        System.out.println("(//span[.='"+select3+"'])[2]");
        checkBox3.click();
        takecreenshot();
        Thread.sleep(5000);
    }

    private void takecreenshot(){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd_HHmmssSS");
        String timestamp = dateFormat.format(new Date());

        test.addScreenCaptureFromPath(screenshotUtils.captureScreenshot(timestamp));
    }

}
