package org.AXA.pages;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.AXA.steps.Steps.screenshotUtils;
import static org.AXA.steps.Steps.test;


import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

public class TextBoxPage{

    private WebDriver driver;
    private WebDriverWait wait;



    @FindBy(xpath="(//div[@class='card mt-4 top-card'])[1]")
    private WebElement btnElements;

    @FindBy(xpath="(//li[@class='btn btn-light '])[1]")
    private WebElement btnTextBox;

    @FindBy(id="userName")
    private WebElement userNameTextBox;

    @FindBy(id="userEmail")
    private WebElement userEmailTextBox;

    @FindBy(xpath="//textArea[@id = 'currentAddress']")
    private WebElement currentAddressTextBox;

    @FindBy(xpath="//textArea[@id = 'permanentAddress']")
    private WebElement permanentAddressTextBox;

    @FindBy(xpath="//button[@id = 'submit']")
    private WebElement btnSubmit;

    @FindBy(id="name")
    private WebElement nameTextBox;
    @FindBy(id="email")
    private WebElement emailTextBox;
    @FindBy(id="currentAddress")
    private WebElement currentAddTextBox;
    @FindBy(id="permanentAddress")
    private WebElement permanentAddTextBox;

    public TextBoxPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(this.driver, Duration.ofSeconds(30));

    }

    public void ingresarTextBoxPage(){
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        takecreenshot();
        executor.executeScript("arguments[0].setAttribute('style', 'border: 2px solid red;');", btnElements);
        takecreenshot();
        executor.executeScript("arguments[0].click();", btnElements);
        takecreenshot();
        executor.executeScript("arguments[0].setAttribute('style', 'border: 2px solid red;');", btnTextBox);
        takecreenshot();
        executor.executeScript("arguments[0].click();", btnTextBox);
    }

    public void ingresarDatosFormularioTextBox(String name, String mail, String currentAddress, String permanentAddress) throws InterruptedException {
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        takecreenshot();
        executor.executeScript("arguments[0].setAttribute('style', 'border: 2px solid red;');", userNameTextBox);
        takecreenshot();
        executor.executeScript("arguments[0].value = arguments[1]", userNameTextBox, name);
        takecreenshot();
        //userNameTextBox.sendKeys(name);
        executor.executeScript("arguments[0].setAttribute('style', 'border: 2px solid red;');", userEmailTextBox);
        takecreenshot();
        executor.executeScript("arguments[0].value = arguments[1]", userEmailTextBox, mail);
        takecreenshot();
        executor.executeScript("arguments[0].setAttribute('style', 'border: 2px solid red;');", currentAddressTextBox);
        takecreenshot();
        executor.executeScript("arguments[0].value = arguments[1]", currentAddressTextBox, currentAddress);
        takecreenshot();
        executor.executeScript("arguments[0].setAttribute('style', 'border: 2px solid red;');", permanentAddressTextBox);
        takecreenshot();
        executor.executeScript("arguments[0].value = arguments[1]", permanentAddressTextBox, permanentAddress);
    }

    public void enviarFormulario(){
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        takecreenshot();
        executor.executeScript("arguments[0].setAttribute('style', 'border: 2px solid red;');", btnSubmit);
        takecreenshot();
        executor.executeScript("arguments[0].click();", btnSubmit);
        takecreenshot();
    }

    public void validacion(String name, String mail, String currentAdd, String permanentAdd){

        Assert.assertTrue(nameTextBox.isDisplayed());
        String nameActual = nameTextBox.getText();
        Assert.assertEquals("El nombre capturado no es igual al esperado","Name:"+ name, nameActual);

        Assert.assertTrue(emailTextBox.isDisplayed());
        String emailActual = emailTextBox.getText();
        Assert.assertEquals("El email capturado no es igual al esperado","Name:"+ mail, emailActual);

        Assert.assertTrue(currentAddTextBox.isDisplayed());
        String currentAddActual = currentAddTextBox.getText();
        Assert.assertEquals("El email capturado no es igual al esperado","Name:"+ currentAdd, currentAddActual);

        Assert.assertTrue(permanentAddTextBox.isDisplayed());
        String permanentAddActual = permanentAddTextBox.getText();
        Assert.assertEquals("El email capturado no es igual al esperado","Name:"+ permanentAdd, permanentAddActual);
    }

    private void takecreenshot(){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd_HHmmss");
        String timestamp = dateFormat.format(new Date());

        test.addScreenCaptureFromPath(screenshotUtils.captureScreenshot(timestamp));
    }
}