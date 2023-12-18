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
import org.AXA.pages.CheckBoxPage;
import org.AXA.utils.ExtentManage;
import org.AXA.utils.ScreenshotUtils;
import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Steps {

    private static WebDriver driver;
    private static String name;
    private static String email;
    private static String currentAdd;
    private static String permanentAdd;
    private  static TextBoxPage textBoxPage;
    private static CheckBoxPage checkBoxPage;
    public static ExtentTest test;
    public static ExtentReports extent;
    public static ScreenshotUtils screenshotUtils;

    public static String ruta;

    @Before
    public static void setup(Scenario scenario){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd_HHmmssSS");
        String timestamp = dateFormat.format(new Date());
        ruta = "output/" + scenario.getName() + " " +timestamp;
        extent = ExtentManage.getInstance(ruta);

        test = extent.createTest(scenario.getName());

        System.setProperty("webdriver.chrome.driver","src/test/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

        screenshotUtils = new ScreenshotUtils(driver, ruta);
        textBoxPage = new TextBoxPage(driver);
        checkBoxPage = new CheckBoxPage(driver);

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
    public void ingreso_al_apartado_de_elements_y_text_box(){
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
    public void presiono_el_boton_enviar(){
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
        try{
            test.info("Validación de retorno de datos");
            textBoxPage.validacion(name, email, currentAdd, permanentAdd);
            test.pass("Los datos ingresados fueron almacenados correctamente");
        }catch (Exception e){
            test.fail("Error al almacenar los datos" + e.getMessage());
        }


    }

    @When("ingreso al apartado de elements y check box")
    public void ingreso_al_apartado_de_elements_y_check_box() {
        try{
            test.info("ingreso a elements/checkBox");
            checkBoxPage.ingresarCheckBoxPage();
            test.pass("Ingreso exitoso");
        }catch(Exception e){
            test.fail("Error al ingresar, excepcion " + e.getMessage());
        }
    }
    @When("marco los campos deseados {string}, {string}, {string}")
    public void marco_los_campos_deseados(String string, String string2, String string3) throws InterruptedException {
        try{
            test.info("Seleccionar campos");
            checkBoxPage.seleccionarCampos(string, string2, string3);

            test.pass("Campos seleccionados");
        }catch (Exception e){
            test.fail("Error al seleccionar los campos"+ e.getMessage());
        }
    }
    @Then("los campos son seleccionados")
    public void los_campos_son_seleccionados() {

    }
}
