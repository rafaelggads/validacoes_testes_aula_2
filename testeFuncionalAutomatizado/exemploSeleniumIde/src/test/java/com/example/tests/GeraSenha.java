package com.example.tests;

import java.util.concurrent.TimeUnit;

import com.example.util.InstanciaDriver;
import org.junit.*;
import static org.junit.Assert.*;
import org.openqa.selenium.*;

public class GeraSenha {
  private WebDriver driver;
  private String baseUrl;
  private final StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
    driver = InstanciaDriver.getDriver();
    baseUrl = "http://www.geradordesenha.com.br/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testGeraSenha() throws Exception {
    driver.get(baseUrl + "/");
    Thread.sleep(2000);
    driver.findElement(By.xpath("//label[2]")).click();
    Thread.sleep(2000);
    driver.findElement(By.xpath("//div[2]/div/label[2]")).click();
    Thread.sleep(2000);
    driver.findElement(By.xpath("//div[2]/div/label[3]")).click();
    Thread.sleep(2000);
    driver.findElement(By.xpath("//input[@value='Gerar Senha']")).click();
    Thread.sleep(2000);
    Assert.assertTrue(driver.findElement(By.name("password")).getText() != null);
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
