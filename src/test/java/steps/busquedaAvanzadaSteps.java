package steps;

import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import pages.basePage;
import pages.busquedaAvanzadaPage;
import org.junit.Assert;
import pages.menuPage;

public class busquedaAvanzadaSteps {


    basePage base = new basePage(basePage.driver);
    busquedaAvanzadaPage busqueda = new busquedaAvanzadaPage(busquedaAvanzadaPage.driver);
    menuPage menu = new menuPage(menuPage.driver);

    @And("el usuario hace click en aplicar filtros")
    public void clickBusquedaAvanzada() {
        busqueda.clickBusquedaAdvSeguro();
        menu.clickCookies();
    }

    @And("ingresa en el campo cargo {string}")
    public void llenadoEspacioCargo(String cargo) {
        busqueda.ingresoCargo(cargo);
    }

    @And("ingresa en el campo ubicacion {string}")
    public void llenadoEspacioRegion(String region) {
        busqueda.ingresoRegion(region);
    }


    /*@And("ingresa en el campo jornada {string}")
    public void llenadoEspacioJornada(String jornada) {
        busqueda.ingresoJornada(jornada);
    }*/

    @And("ingresa en el campo carrera {string}")
    public void llenadoEspacioCarrera(String carrera) {
        busqueda.ingresoCarrera(carrera);

    }

    /*@And("hace click en el checkbox de informatica")
    public void checkboxCarrera() {
        busqueda.checkbox();
    }*/


    @And("hace click en buscar empleo")
    public void buscarEmpleo() {
        busqueda.clickBuscarEmpleo();
    }


    @Then("la pagina carga las opciones de empleo disponibles")
    public void validarUrlConFiltros() {
        String urlActual = busqueda.confirmarURL().toLowerCase();

        Assert.assertTrue("La URL no contiene el cargo QA", urlActual.contains("qa"));
        base.cierre();
    }


}