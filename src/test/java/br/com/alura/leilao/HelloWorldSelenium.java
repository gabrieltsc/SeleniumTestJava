package br.com.alura.leilao;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class HelloWorldSelenium {

    @Test
    public void hello(){
        System.setProperty("webdriver.edge.driver", "drivers/msedgedriver.exe"); // Uso do driver do navegador (Edge)
        WebDriver browser = new EdgeDriver(); // Abrir navegador
        browser.navigate().to("http://localhost:8080/leiloes"); // Entrar no site
        browser.quit(); // Fechar janela ao fim
    }
}
