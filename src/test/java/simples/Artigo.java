package simples;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
public class Artigo {
    String url;         // endereço so site alvo
    WebDriver driver;   // objeto do selenium WebDriver

    @Before             // Antes do Teste
    public void iniciar(){
        url = "https://pt.wikipedia.org/";
        // Onde está o Chrome Driver
        System.setProperty("webdriver.chrome.driver", "drivers/chrome/90/chromedriver.exe");
        driver = new ChromeDriver();    // Instanciar o Selenium com o Chrome Driver

        driver.manage().window().maximize();    // Maximar a janela do navegador
        // define uma espera implicita  de 1 min, verificando o carregamento a cada milissegundo
        driver.manage().timeouts().implicitlyWait(60000, TimeUnit.MILLISECONDS);
    }

    @Test               // Durante o Teste
    public void consultarArtigo(){
        // Abrir o site
        driver.get(url);

        // Pesquisar por "Ovo de Pascoa"
        driver.findElement(By.name("search")).sendKeys("Ovos de Páscoa" + Keys.ENTER);
        //driver.findElement(By.name("search")).click();

        // Validar o título da página de retorno
        //assertEquals("Ovo de Páscoa - Wikipédia, a enciclopédia livre", driver.getTitle());
        assertTrue(driver.getTitle().contains("Ovo_de_Páscoa"));
    }

    @After              // Depois do Teste
    public void finalizar(){
        driver.quit();
    }
}

