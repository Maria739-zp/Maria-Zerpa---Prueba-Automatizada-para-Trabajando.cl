package steps;

import io.cucumber.java.en.*;
import org.junit.Assert;
import pages.basePage;
import pages.loginPage;
import pages.menuPage;

public class menuSteps {


    menuPage menu = new menuPage(basePage.driver);
    loginPage login = new loginPage(loginPage.driver);
    basePage base = new basePage(basePage.driver);

    @When("hace click en ver ofertas de trabajo")
    public void clickOfertas(){
        login.botonOculto();
        menu.verOfertasDeEmpleo();
    }

    @And("ingresa el cargo {string} en la barra buscadora")
    public void ingresoEmpleo(String cargo){
        menu.ingresoEmpleo(cargo);
    }

    @And("hace click en el boton buscar")
    public void clickBuscar(){
        menu.clickBuscar();
    }



    @Then("la pagina deberia mostrar una lista de resultados relacionados")
    public void botonEsperado() {
        String botonEsperado = "Postular";
        String mensajeObtenido = menu.obtenerMensaje();

        Assert.assertEquals(botonEsperado, mensajeObtenido);
        base.cierre();
    }
}

