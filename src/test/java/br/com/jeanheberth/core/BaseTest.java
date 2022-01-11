package br.com.jeanheberth.core;


import static br.com.jeanheberth.core.DriveFactory.killDriver;

import br.com.jeanheberth.pages.LoginPage;
import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;


public class BaseTest {
    private LoginPage page = new LoginPage();

    @Rule
    public TestName prints = new TestName();


    @Before
    public void inicializa() {
        page.acessarTelaInicial();
        page.setEmail("jeanheberth19@gmail.com");
        page.setSenha("JeanHeberth");
        page.entrar();

        /* Podemos simplificar o login
        page.logar("jeanheberth19@gmail.com", "JeanHeberth");
        */


    }

    @After
    public void finaliza() throws IOException {
        TakesScreenshot screenshot = (TakesScreenshot) DriveFactory.getDriver();
        File arquivo = screenshot.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(arquivo, new File("target" + File.separator + "screenshot" +
                File.separator + prints.getMethodName() + "screenshot.jpg"));


        if (Propriedades.FECHAR_BROWSER) {
            killDriver();


        }
    }

    @Before
    public void link() {

        //Drive do google
        System.setProperty("webdriver.chrome.driver", "D:\\Documentos\\Desenvolvimentos TestesAutomatizados\\DriversTestes\\chromedriver.exe");
        // driver = new ChromeDriver();

        //Drive do firefox
        System.setProperty("webdriver.gecko.driver", "D:\\Documentos\\Desenvolvimentos TestesAutomatizados\\DriversTestes\\geckodriver.exe");
        // driver = new FirefoxDriver();

    }


}
