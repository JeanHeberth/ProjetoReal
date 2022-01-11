package br.com.jeanheberth.core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class DriveFactory {
    private static WebDriver driver;

    private DriveFactory() {

    }

    public static WebDriver getDriver() {
        if (driver == null) {
            switch (Propriedades.browser) {
                case CHROME:
                    driver = new ChromeDriver();
                    break;
                case FIREFOX:
                    driver = new FirefoxDriver();
                    break;

            }
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        }
        return driver;
    }

    public static void killDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
