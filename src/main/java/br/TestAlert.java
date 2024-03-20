package br;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

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
	
	@Test
	public void deveInterAlertConfirm() {
		driver.findElement(By.id("confirm")).click();
		Alert alerta = driver.switchTo().alert();
		Assert.assertEquals("Confirm Simples", alerta.getText());
		alerta.accept();
		Assert.assertEquals("Confirmado", alerta.getText());
		alerta.accept();
		
		driver.findElement(By.id("confirm")).click();
		alerta = driver.switchTo().alert();
		Assert.assertEquals("Confirm Simples", alerta.getText());
		alerta.dismiss();
		Assert.assertEquals("Negado", alerta.getText());
		alerta.dismiss();	
	}
	

	
//	@AfterClass
//	public static void fechar() {
//		WebDriverConfig.quitDriver();
//	}

}