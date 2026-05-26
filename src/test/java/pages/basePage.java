package pages;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;
import java.time.Duration;

public class basePage {
    public static WebDriver driver;
    public static WebDriverWait wait;

    public basePage(WebDriver driver){
        basePage.driver = driver;
    }

    public void iniciar() {
        if (driver == null) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--remote-allow-origins=*");

            driver = new ChromeDriver(options);
            driver.manage().window().maximize();
            wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        }
    }


    public void navegarA(String url){
        driver.get(url);
    }


    public void cierre() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

    public WebElement encontrar(String Locator) {
        return wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Locator)));
    }

    public void clickElemento(String Locator){
        encontrar(Locator).click();
    }

    public String obtenerTexto(String Locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Locator))).getText();
    }


    public void clickForzadoJS(String locator){
        WebElement elemento = encontrar(locator);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", elemento);
    }




    public void clickElementoSeguro(String locator) {
        WebElement elemento = encontrar(locator);

        try {
            elemento.click();

        } catch (Exception e) {

            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].click();", elemento);
        }
    }


    String bEntrar = "//button[@type='submit']";

    public void boton() {
        clickForzadoJS(bEntrar);
    }

    public void esperarInvisibilidad(String locator) {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(locator)));
    }




    public void scrollHaciaElemento(String locator) {
        WebElement element = encontrar(locator);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }


    public String obtenerUrlActual() {
        return driver.getCurrentUrl();
    }


}

