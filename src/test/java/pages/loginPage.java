package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.io.FileInputStream;
import java.util.Properties;

public class loginPage extends basePage {

    basePage base = new basePage(driver);


    String botonIngreso = "(//*[@id='ingresarATuCuenta'])[2]";
    String cajaMail = "//input[@placeholder='Escribe tu email']";
    String cajaPass = "//input[@placeholder='Escribe tu contraseña']";
    String bEntrar = "//button[@type='submit']";
    String esperaVisibilidad = "//div[@class='loading-backdrop']";
    String espacioCargo = "//*[@id=\"advancedModal\"]/div/div/div[3]/div/div/div[1]/div/div/div/input";


    public loginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }


   public void botonIngresa (){
       clickElemento(botonIngreso);
   }


    public void ingresoMail(){

        String correoProtegido = obtenerCredencial("usuario");
        encontrar(cajaMail).sendKeys(correoProtegido);
    }

    public void ingresoPassword(){
        String claveProtegida = obtenerCredencial("password");
        encontrar(cajaPass).sendKeys(claveProtegida);
    }


    public String obtenerCredencial(String llave) {
        Properties propiedades = new Properties();
        try {
            FileInputStream archivo = new FileInputStream("config.properties");
            propiedades.load(archivo);
        } catch (Exception e) {
            System.out.println("Error leyendo el archivo de propiedades");
        }
        return propiedades.getProperty(llave);
    }

    public void botonOculto(){
        base.esperarInvisibilidad(esperaVisibilidad);
    }
}
