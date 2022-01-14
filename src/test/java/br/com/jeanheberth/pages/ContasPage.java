package br.com.jeanheberth.pages;

import br.com.jeanheberth.core.BasePage;
import org.openqa.selenium.By;

public class ContasPage extends BasePage {

    public void setNomeConta(String nomeConta) {
        escrever("nome", nomeConta);
    }

    public void salvar() {
        clicarBotaoPorTexto("Salvar");

    }

    public String obterMensagemSucesso() {
        return obterTexto(By.xpath("//div[@class='alert alert-success']"));
    }

    public String obterMensagemErro() {
        return obterTexto(By.xpath("//div[@class='alert alert-danger']"));
    }

    public void clicarAlterarConta(String string) {
        obterCelula("Conta", string, "Ações", "tabelaContas")
                .findElement(By.xpath(".//span[@class='glyphicon glyphicon-edit']")).click();
    }

    public void clicarExcluirConta(String string) {
        obterCelula("Conta", string, "Ações", "tabelaContas")
                .findElement(By.xpath(".//span[@class='glyphicon glyphicon-remove-circle']")).click();
    }
}
