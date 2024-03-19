package br;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class WebDriverConfig {

    private static WebDriver driver;

    public static WebDriver getDriver() {
        if (driver == null) {
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\edinunes\\dev\\drivers\\chromedriver.exe");
            driver = new ChromeDriver();
            driver.manage().window().setSize(new Dimension(900, 982));
    		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
        }
        return driver;
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}