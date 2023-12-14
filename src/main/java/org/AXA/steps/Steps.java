package org.AXA.steps;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.AXA.pages.TextBoxPage;
import org.AXA.utils.ExtentManage;
import org.AXA.utils.ScreenshotUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

public class Steps {

    private static WebDriver driver;
    private static String name;
    private static String email;
    private static String currentAdd;
    private static String permanentAdd;
    private  static TextBoxPage textBoxPage;
    public static ExtentTest test;
    public static ExtentReports extent;
    public static ScreenshotUtils screenshotUtils;

    @Before
    public static void setup(Scenario scenario){
        extent = ExtentManage.getInstance();
        test = extent.createTest(scenario.getName());

        System.setProperty("webdriver.chrome.driver","src/test/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

        screenshotUtils = new ScreenshotUtils(driver);
        textBoxPage = new TextBoxPage(driver);

    }

    @After
    public static void tearDown(){
        driver.close();
        driver.quit();
        extent.flush();
    }

    @Given("estoy en la pagina demoqa.com")

    public void estoy_en_la_pagina_demoqa_com() {
        try{

            test.info("ingreso a demoqa.com");
            driver.get("https://demoqa.com");
            test.pass("Ingreso a la URL exitoso");
        }catch(Exception e){
            test.fail("Error al ingresar, excepcion " + e.getMessage());
        }

    }


    @When("ingreso al apartado de elements y text box")
    public void ingreso_al_apartado_de_elements_y_text_box() throws InterruptedException {
        try{
            test.info("ingreso a elements/textBox");
            textBoxPage.ingresarTextBoxPage();
            test.pass("Ingreso exitoso");
        }catch(Exception e){
            test.fail("Error al ingresar, excepcion " + e.getMessage());
        }
    }

    @When("completo los text box con {string} {string} {string} {string}")
    public void completo_los_text_box_con(String string, String string2, String string3, String string4){
        try{
            test.info("Llenar formulario");
            textBoxPage.ingresarDatosFormularioTextBox(string, string2, string3, string4);
            name = string;
            email = string2;
            currentAdd = string3;
            permanentAdd = string4;
            test.pass("Formulario lleno");
        }catch(Exception e){
            test.fail("Error al llenar el formulario " + e.getMessage());
        }
    }
    @When("presiono el boton enviar")
    public void presiono_el_boton_enviar() throws InterruptedException {
        try{
            test.info("Enviar formulario");
            textBoxPage.enviarFormulario();
            test.pass("Formulario enviado correctamente");
        }catch(Exception e){
            test.fail("No se pudo enviar el formulario" + e.getMessage());
        }
    }
    @Then("Los datos son recibidos")
    public void los_datos_son_recibidos() {
        textBoxPage.validacion(name, email, currentAdd, permanentAdd);
    }
}