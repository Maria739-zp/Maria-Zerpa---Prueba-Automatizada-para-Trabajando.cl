package steps;

import io.cucumber.java.en.*;
import pages.basePage;

import static pages.basePage.driver;

public class baseSteps {

    basePage base = new basePage(driver);

    @Given("el usuario navega a la pagina de inicio {string}")
    public void navegar(String url){
        base.iniciar();
        base.navegarA(url);

    }

    @Then("la pagina carga exitosamente")
    public void cierre(){
       base.cierre();
    }
}
