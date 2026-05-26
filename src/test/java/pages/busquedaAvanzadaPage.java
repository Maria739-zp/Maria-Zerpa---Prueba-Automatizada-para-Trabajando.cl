package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class busquedaAvanzadaPage extends basePage {

    String espacioCargo = "//*[@id=\"advancedModal\"]/div/div/div[3]/div/div/div[1]/div/div/div/input";
    String buscarEmpleo = "//a[@class='advanced']";
    String espacioRegion = "//*[@id=\"advancedModal\"]/div/div/div[3]/div/div/div[2]/div/div/div/input";
    String espacioCarrera = "//*[@id=\"advancedModal\"]/div/div/div[3]/div/div/div[3]/div/div/div/input";
    String checkBox = "//*[@id=\"advancedModal\"]/div/div/div[3]/div/div/div[3]/div/div/div/ul/li[3]/a/label";
    String botonBuscarEmpleo = "//*[@id=\"advancedModal\"]/div/div/div[2]/button";
    String chkInformatica = "//label[contains(text(), 'Informática')]";
    String check ="//*[@id=\"advancedModal\"]/div/div/div[3]/div/div/div[3]/div/div[1]/div/ul/li[3]/a/label";

    String espacioJornada = "//*[@id=\"advancedModal\"]/div/div/div[3]/div/div/div[5]/div/div/button/span";

    String jornada = "//*[@id=\"advancedModal\"]/div/div/div[3]/div/div/div[5]/div/div/button/span";

    String chkJornada = "//*[@id=\"advancedModal\"]/div/div/div[3]/div/div/div[5]/div/div/ul/li[5]";
    String popUpBusquedaAdv = "//*[@id=\"advancedModal\"]";
    String btnFiltroBusquedaAdv = "//*[@id=\"__nuxt\"]/div/header/div[2]/a";
    String selecionaRegion = "//*[@id=\"advancedModal\"]/div/div/div[3]/div/div/div[2]/div/div/div/div/ul/li[1]";




    public busquedaAvanzadaPage(WebDriver driver) {
        super(driver);
    }


    public void clickBusquedaAdv() {
        encontrar(buscarEmpleo).click();
    }

    public void ingresoCargo(String cargo) {
        encontrar(espacioCargo).sendKeys(cargo);
    }

    public void ingresoRegion(String region) {
        encontrar(espacioRegion).sendKeys(region);
        encontrar(selecionaRegion).click();
    }

    public void ingresoCarrera(String carrera) {
        encontrar(espacioCarrera).sendKeys(carrera);
        encontrar(chkInformatica).click();

    }


    public void ingresoJornada(String jornada) {
        encontrar(espacioJornada).sendKeys(jornada);
       // scrollHaciaElemento(chkJornada);
       encontrar(chkJornada).click();
    }

    /*public void checkbox() {
        clickElemento(chkInformatica);
    }*/

    public void clickBuscarEmpleo() {
        clickElemento(botonBuscarEmpleo);
    }


    public void seleccionarCheckbox() {
        clickElementoSeguro(chkInformatica);
    }

    public String confirmarURL() {
        return obtenerUrlActual();
    }

    public void clickBusquedaAdvSeguro() {
        int intentosMaximos = 3;
        int intentoActual = 0;
        boolean popupAbierto = false;

        WebDriverWait waitCorto = new WebDriverWait(driver, Duration.ofSeconds(2));

        while (intentoActual < intentosMaximos && !popupAbierto) {
            try {
                encontrar(btnFiltroBusquedaAdv).click();
                waitCorto.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(popUpBusquedaAdv)));
                popupAbierto = true;

            } catch (TimeoutException e) {
                intentoActual++;
                System.out.println("Intento " + intentoActual + " fallido. Reintentando clic...");
            }
        }

    }
}