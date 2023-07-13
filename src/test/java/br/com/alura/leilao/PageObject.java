package br.com.alura.leilao;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.util.concurrent.TimeUnit;

public class PageObject {

    protected WebDriver browser;

    public PageObject(WebDriver browser) {
        System.setProperty("webdriver.edge.driver", "drivers/msedgedriver.exe"); // Uso do driver do navegador (Edge)
        if (browser == null){
            this.browser = new EdgeDriver();
        } else {
            this.browser = browser; // Abrir navegador
        }

        this.browser.manage().timeouts()
                .implicitlyWait(5, TimeUnit.SECONDS)
                .pageLoadTimeout(10, TimeUnit.SECONDS); // Timeouts úteis para evitar erros de testagem em Javascript
    }

    public void fechar() {
        this.browser.quit();
    }
}
