package br;

import java.util.List;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import br.webdriver.WebDriverConfig;

public class TesteCampoTreinamento {

	private static WebDriver driver;

	@BeforeClass
	public static void configuracaoDriver() {
		driver = WebDriverConfig.getDriver();
	}

	@Test
	public void testeTextField() {
		driver.findElement(By.id("elementosForm:nome")).sendKeys("Teste de escrita");
		Assert.assertEquals("Teste de escrita",driver.findElement(By.id("elementosForm:nome")).getAttribute("value"));
		
	}
	
	@Test
	public void deveInteragirComTextArea() {
		driver.findElement(By.id("elementosForm:sugestoes")).sendKeys("Teste\nNova linha\nUltima linha");
		Assert.assertEquals("Teste\nNova linha\nUltima linha", driver.findElement(By.id("elementosForm:sugestoes")).getAttribute("value"));
		
	}
	
	@Test
	public void deveInteragirComRadioButton() {
		driver.findElement(By.id("elementosForm:sexo:0")).click();
		Assert.assertTrue(driver.findElement(By.id("elementosForm:sexo:0")).isSelected());
		
	}
	
	@Test
	public void deveInteragirComCheckbox() {	
		driver.findElement(By.id("elementosForm:comidaFavorita:2")).click();
		Assert.assertTrue(driver.findElement(By.id("elementosForm:comidaFavorita:2")).isSelected());
	
	}
	
	@Test
	public void deveInteragirComCombo() {
		WebElement element = driver.findElement(By.id("elementosForm:escolaridade"));
		Select combo = new Select(element);
		// combo.selectByIndex(5);
		combo.selectByVisibleText("Especializacao");
		Assert.assertEquals("Especializacao", combo.getFirstSelectedOption().getText());
	}
	
	@Test
	public void deveVerificarValoresCombo() {
		WebElement element = driver.findElement(By.id("elementosForm:escolaridade"));
		Select combo = new Select(element);
		List<WebElement> options = combo.getOptions();
		Assert.assertEquals(8, options.size());
		
		boolean encontrou = false;
		for(WebElement option: options) {
			if(option.getText().equals("Mestrado")) {
				encontrou = true;
				break;
			}
		}
		Assert.assertTrue(encontrou);
	}
	
	@Test
	public void deveVerificarValoresComboMultiplo() {
		WebElement element = driver.findElement(By.id("elementosForm:esportes"));
		Select combo = new Select(element);
		combo.selectByVisibleText("Natacao");
		combo.selectByVisibleText("Corrida");
		combo.selectByVisibleText("O que eh esporte?");
		
		List<WebElement> selecao = combo.getAllSelectedOptions();
		Assert.assertEquals(3, selecao.size());
		
		combo.deselectByVisibleText("Corrida");
		selecao = combo.getAllSelectedOptions();
		Assert.assertEquals(2, selecao.size());
	}
	
	@Test
	public void deveInteragirComBotoes() {
		WebElement botao = driver.findElement(By.id("buttonSimple"));
		botao.click();
		Assert.assertEquals("Obrigado!", botao.getAttribute("value"));
	}
	
	@Test
	public void deveInteragirComLinks() {
		WebElement botao = driver.findElement(By.linkText("Voltar"));
		botao.click();
		String resultado = driver.findElement(By.id("resultado")).getText();
		Assert.assertEquals("Voltou!", resultado);
	}
	
	@Test
	public void deveBuscarTextoNaPagina() {
		Assert.assertEquals("Campo de Treinamento",
				driver.findElement(By.tagName("h3")).getText());
		
		Assert.assertEquals("Cuidado onde clica, muitas armadilhas...", 
				driver.findElement(By.className("facilAchar")).getText());
	}
	
	@AfterClass
	public static void fechar() {
		WebDriverConfig.quitDriver();
	}

}