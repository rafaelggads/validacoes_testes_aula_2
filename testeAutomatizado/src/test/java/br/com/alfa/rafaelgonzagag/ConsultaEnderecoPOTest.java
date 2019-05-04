/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.alfa.rafaelgonzagag;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 *
 * @author Rafaelgonzagag
 */
public class ConsultaEnderecoPOTest 
{
    
    private WebDriver driver;
    private br.com.gilmarioarantes.crudspringbottest.paginas.PaginaConsultaCep consultaCep;
    private br.com.gilmarioarantes.crudspringbottest.paginas.PaginaResultadoConsulta resultado;

    @BeforeTest
    public void setup()
    {
        this.driver = br.com.gilmarioarantes.crudspringbottest.InstanciaDriver.getDriver();
        driver.get("http://www.buscacep.correios.com.br/sistemas/buscacep/");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        consultaCep = new br.com.gilmarioarantes.crudspringbottest.paginas.PaginaConsultaCep(this.driver);
        resultado = new br.com.gilmarioarantes.crudspringbottest.paginas.PaginaResultadoConsulta(this.driver);
    }

    @Test
    public void consultaPorCep()
    {
        consultaCep.informarCep("74393580");
        consultaCep.consultar();
        Assert.assertTrue(resultado.getGridResultadoConsulta().getText().contains("Rua SR 17"));
        driver.close();
    }
}
