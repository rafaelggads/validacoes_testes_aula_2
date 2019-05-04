package com.example.tests;

import java.util.concurrent.TimeUnit;

import com.example.util.InstanciaDriver;
import org.junit.*;
import static org.junit.Assert.*;
import org.openqa.selenium.*;


public class ValidaCPFValido {
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
  public void testValidaCPF() throws Exception {
    driver.get(baseUrl + "/validar-cpf.htm");
    Thread.sleep(2000);
    driver.findElement(By.id("cpf")).clear();
    Thread.sleep(2000);
    driver.findElement(By.id("cpf")).sendKeys("33462461168");
    Thread.sleep(2000);
    driver.findElement(By.id("botaoValidarCPF")).click();
    Thread.sleep(2000);
    String cpfValido = driver.findElement(By.id("saida")).getText();
    Assert.assertEquals(cpfValido,"CPF Válido!");
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
