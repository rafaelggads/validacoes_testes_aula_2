package com.example.tests;

import com.example.util.InstanciaDriver;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;


import java.util.concurrent.TimeUnit;

import static org.junit.Assert.fail;

public class ValidaCPFInvalido {
  private WebDriver driver;
  private String baseUrl;
  private final StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
    driver = InstanciaDriver.getDriver();
    baseUrl = "http://www.geradorcpf.com/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testValidaCPF() {
    try {
        driver.get(baseUrl + "/validar-cpf.htm");
        Thread.sleep(2000);
        driver.findElement(By.id("cpf")).clear();
        Thread.sleep(2000);
        driver.findElement(By.id("cpf")).sendKeys("33462461167");
        Thread.sleep(2000);
        driver.findElement(By.id("botaoValidarCPF")).click();
        Thread.sleep(2000);
        String cpfInvalido = driver.findElement(By.id("saida")).getText();
        Assert.assertEquals(cpfInvalido,"CPF Inválido!");
    }catch (Exception e){
        e.printStackTrace();
    }

  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

}
