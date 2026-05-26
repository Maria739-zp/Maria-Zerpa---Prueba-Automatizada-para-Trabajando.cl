package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static pages.basePage.driver;

public class menuPage extends basePage{

    public menuPage(WebDriver driver) {
        super(driver);
    }

    basePage base;


    String botonOfertas = "//a[@class='text-center text-quinary-blue text-decoration-underline fs-4']";
    String botonBuscarEmpleo ="//button[@id='btnBuscarEmpleoCabecera']";
    String barraBuscadora = "//*[@id=\"__nuxt\"]/div/header/div[2]/div[1]/div/input";
    String textoObtenido = "//button[@class='btn primary-btn blue aim px-2']";
    String botonCookies = "//*[@id=\"__nuxt\"]/div/div[3]/div/div/div[2]";

    public void verOfertasDeEmpleo(){

        clickElemento(botonOfertas);
    }

    public void clickBuscar(){
        clickElemento(botonBuscarEmpleo);
    }

     public void ingresoEmpleo(String cargo) {
        encontrar(barraBuscadora).sendKeys(cargo);
    }

    public String obtenerMensaje() {
        return obtenerTexto(textoObtenido);
        }

   public void clickCookies(){
       encontrar(botonCookies);
        clickElemento(botonCookies);
    }

}
