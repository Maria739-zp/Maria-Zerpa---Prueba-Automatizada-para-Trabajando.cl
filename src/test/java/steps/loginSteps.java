package steps;


import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import pages.basePage;
import pages.loginPage;


import static pages.basePage.driver;

public class loginSteps {

    loginPage login = new loginPage(driver);
    basePage base = new basePage(driver);

    @When("ingresa usuario")
    public void ingresoUsuario(){
    login.botonIngresa();
    login.ingresoMail();

    }

    @And("contraseña validos")
    public void ingresoPass(){
    login.ingresoPassword();
    login.boton();
    }

    @And("hace click en ingresar")
    public void ingreso(){
        base.boton();
    }
}
