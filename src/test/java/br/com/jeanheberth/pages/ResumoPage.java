package br.com.jeanheberth.pages;

import br.com.jeanheberth.core.BasePage;
import org.openqa.selenium.By;

public class ResumoPage extends BasePage {

    public void excluirMovimentacao() {
        clicarElementosUtilizandoXpath("//span[@class='glyphicon glyphicon-remove-circle']");
    }

    public String obterMensagemSucesso() {
        return obterTexto(By.xpath("//div[@class='alert alert-success']"));
    }

}
