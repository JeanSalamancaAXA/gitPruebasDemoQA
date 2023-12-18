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

    @FindBy(xpath="//textArea[@id = 'curraentAddress']")
    private WebElement currentAddressTextBox;

    @FindBy(xpath="//textArea[@id = 'permanentAddress']")
    private WebElement permanentAddressTextBox;

    @FindBy(xpath="//button[@id = 'submit']")
    private WebElement btnSubmit;

    @FindBy(id="name")
    private WebElement nameTextBox;
    @FindBy(id="email")
    private WebElement emailTextBox;
    @FindBy(xpath="//p[@id = 'currentAddress']")
    private WebElement currentAddTextBox;
    @FindBy(xpath="//p[@id = 'permanentAddress']")
    private WebElement permanentAddTextBox;

    public TextBoxPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(this.driver, Duration.ofSeconds(10));
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

    public void ingresarDatosFormularioTextBox(String name, String mail, String currentAddress, String permanentAddress){
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        takecreenshot();
        executor.executeScript("arguments[0].setAttribute('style', 'border: 2px solid red;');", userNameTextBox);
        executor.executeScript("arguments[0].value = arguments[1]", userNameTextBox, name);
        takecreenshot();
        executor.executeScript("arguments[0].setAttribute('style', 'border: 0px;');", userNameTextBox);
        executor.executeScript("arguments[0].setAttribute('style', 'border: 2px solid red;');", userEmailTextBox);
        executor.executeScript("arguments[0].value = arguments[1]", userEmailTextBox, mail);
        takecreenshot();
        executor.executeScript("arguments[0].setAttribute('style', 'border: 0px;');", userEmailTextBox);
        executor.executeScript("arguments[0].setAttribute('style', 'border: 2px solid red;');", currentAddressTextBox);
        executor.executeScript("arguments[0].value = arguments[1]", currentAddressTextBox, currentAddress);
        takecreenshot();
        executor.executeScript("arguments[0].setAttribute('style', 'border: 0px;');", currentAddressTextBox);
        executor.executeScript("arguments[0].setAttribute('style', 'border: 2px solid red;');", permanentAddressTextBox);
        executor.executeScript("arguments[0].value = arguments[1]", permanentAddressTextBox, permanentAddress);
        takecreenshot();
        executor.executeScript("arguments[0].setAttribute('style', 'border: 0px;');", permanentAddressTextBox);
    }

    public void enviarFormulario() throws InterruptedException {
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].setAttribute('style', 'border: 2px solid red;');", btnSubmit);
        takecreenshot();
        executor.executeScript("arguments[0].click();", btnSubmit);
        takecreenshot();

    }

    public void validacion(String name, String email, String currentAdd, String permanentAdd){

        Assert.assertTrue(nameTextBox.isDisplayed());
        String nameActual = nameTextBox.getText();
        Assert.assertEquals("El nombre capturado no es igual al esperado","Name:"+ name, nameActual);
        System.out.println(name+"---"+ nameActual);

        Assert.assertTrue(emailTextBox.isDisplayed());
        String emailActual = emailTextBox.getText();
        Assert.assertEquals("El email capturado no es igual al esperado","Email:"+ email, emailActual);
        System.out.println(email+"---"+ emailActual);

        Assert.assertTrue(currentAddTextBox.isDisplayed());
        String currentAddActual = currentAddTextBox.getText();
        Assert.assertEquals("La direccion capturada no es igual a la esperada","Current Address :"+ currentAdd, currentAddActual);
        System.out.println(currentAdd+"---"+ currentAddActual);

        Assert.assertTrue(permanentAddTextBox.isDisplayed());
        String permanentAddActual = permanentAddTextBox.getText();
        Assert.assertEquals("La direccion capturada no es igual a la esperada","Permananet Address :"+ permanentAdd, permanentAddActual);
        System.out.println(permanentAdd+"---"+permanentAddActual);
    }

    private void takecreenshot(){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd_HHmmssSS");
        String timestamp = dateFormat.format(new Date());

        test.addScreenCaptureFromPath(screenshotUtils.captureScreenshot(timestamp));
    }
}
