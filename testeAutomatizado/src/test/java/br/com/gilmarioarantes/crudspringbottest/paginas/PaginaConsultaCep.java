package br.com.gilmarioarantes.crudspringbottest.paginas;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class PaginaConsultaCep {

    @FindBy(name = "relaxation")
    private WebElement caixaTextoCep;

    @FindBy(xpath = "(.//*[normalize-space(text()) and normalize-space(.)='Sim'])[1]/following::input[1]")
    private WebElement botaoConsulta;

    private WebDriver driver;

    public PaginaConsultaCep(WebDriver driver){
        this.driver = driver;
        AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 30);
        PageFactory.initElements(factory, this);
    }

    public void informarCep(String cep){
        caixaTextoCep.clear();
        caixaTextoCep.sendKeys(cep);
    }

    public void consultar(){
        botaoConsulta.click();
    }


}
