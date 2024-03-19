package br;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TestAlert {

	private static WebDriver driver;

	@BeforeClass
	public static void configuracaoDriver() {
		driver = WebDriverConfig.getDriver();
	}

	@Test
	public void deveInteragirComAlertSimples() {
		driver.findElement(By.id("alert")).click();
		Alert alert = driver.switchTo().alert();
		String texto = alert.getText();
		Assert.assertEquals("Alert Simples", alert.getText());
		alert.accept();
		
		driver.findElement(By.id("elementosForm:nome")).sendKeys(texto);

		
	}
	
//	@AfterClass
//	public static void fechar() {
//		WebDriverConfig.quitDriver();
//	}

}