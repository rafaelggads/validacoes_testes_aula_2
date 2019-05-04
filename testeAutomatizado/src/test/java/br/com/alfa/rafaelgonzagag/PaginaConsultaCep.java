/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.alfa.rafaelgonzagag;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

/**
 *
 * @author Aluno
 */
public class PaginaConsultaCep {
    
    @FindBy(name ="relaxation")
    private WebElement caixaTextoCep;
    
    @FindBy(xpath="(.//*[normalize-space(text()) and normalize-space(.)='Sim'])[1]/following::input[1]")
    private WebElement botaoConsulta;
    
    private WebDriver driver;
    
    public PaginaConsultaCep (WebDriver driver)
    {
        this.driver = driver;
        AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 30);
        PageFactory.initElements(factory, this);  
    }
    
    public void informarCep (String cep)
    {
        caixaTextoCep.clear();
        caixaTextoCep.sendKeys(cep);
    }
    
    public void consultar()
    {
        botaoConsulta.click();
    }
}
