/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.alfa.rafaelgonzagag;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
/**
 *
 * @author Rafaelgonzagag
 */
public class InstanciaDriver {
    public static WebDriver getDriver() {

        WebDriver driver = null;

        final String OS = System.getProperty("os.name").toLowerCase();

        String urlDriver = OS.contains("win") ? "src/test/resources/chromedriver.exe" : "src/test/resources/chromedriver";

        System.setProperty("webdriver.chrome.driver", urlDriver);

        try{
            driver = new ChromeDriver();
        }catch (Exception e){
            System.out.println("Erro ao instanciar o driver");
        }

        return driver;

    }
}
