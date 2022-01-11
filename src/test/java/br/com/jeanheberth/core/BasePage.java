package br.com.jeanheberth.core;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

import static br.com.jeanheberth.core.DriveFactory.getDriver;

public class BasePage {

    /* Método para escrever *//*
    public void escrever(By by, String texto) {
        getDriver().findElement(by).clear();
        getDriver().findElement(by).sendKeys(texto);
    }*/

    /* Método para escrever */
    public void escrever(String id_campo, String texto) {
        getDriver().findElement(By.id(id_campo)).sendKeys(texto);

    }

    /* Método para clicar nos elementos com xpath*/
    public void clicarElementosUtilizandoXpath(String xpath) {
        getDriver().findElement(By.xpath(xpath)).click();

    }

    /* Método para clicar nos elementos com linkText*/
    public void clicarElementosUtilizandoLinkText(String linkText) {
        getDriver().findElement(By.linkText(linkText)).click();

    }
    /* Método para clicar nos elementos por texto */
    public void clicarBotaoPorTexto(String texto) {
        getDriver().findElement(By.xpath("//button[.='"+texto+"']")).click();

    }

    /* Método para selecionar dropDown */
    public void campoSelecionarDropDown(String id_campoSelecionar, String valor) {
        WebElement dropdown = getDriver().findElement(By.id(id_campoSelecionar));
        Select combo = new Select(dropdown);
        combo.selectByVisibleText(valor);
    }

    public void campoSelecionar(String id_campoSelecionar) {
        getDriver().findElement(By.id(id_campoSelecionar)).click();
    }

    /********* Textos ************/

    public String obterTexto(By by) {
        return getDriver().findElement(by).getText();
    }

    public String obterTexto(String id) {
        return obterTexto(By.id(id));
    }

    /************** Tabela *********************/

    public WebElement obterCelula(String colunaBusca, String valor, String colunaBotao, String idTabela) {
        //procurar coluna do registro
        WebElement tabela = getDriver().findElement(By.xpath("//*[@id='" +idTabela+ "']"));
        int idColuna = obterIndiceColuna(colunaBusca, tabela);

        //encontrar a linha do registro
        int idLinha = obterIndiceLinha(valor, tabela, idColuna);

        //procurar coluna do botao
        int idColunaBotao = obterIndiceColuna(colunaBotao, tabela);

        //clicar no botao da celula encontrada
        WebElement celula = tabela.findElement(By.xpath(".//tr[" + idLinha + "]/td[" + idColunaBotao + "]"));
        return celula;

    }


    public void clicarBotaoTabela(String colunaBusca, String valor, String colunaBotao, String idTabela) {
        WebElement celula = obterCelula(colunaBusca, valor, colunaBotao, idTabela);
        celula.findElement(By.xpath(".//input")).click();

    }

    protected int obterIndiceLinha(String valor, WebElement tabela, int idColuna) {
        List<WebElement> linhas = tabela.findElements(By.xpath("./tbody/tr/td[" + idColuna + "]"));
        int idLinha = -1;
        for (int i = 0; i < linhas.size(); i++) {
            if (linhas.get(i).getText().equals(valor)) {
                idLinha = i + 1;
                break;
            }
        }
        return idLinha;
    }

    protected int obterIndiceColuna(String coluna, WebElement tabela) {
        List<WebElement> colunas = tabela.findElements(By.xpath(".//th"));
        int idColuna = -1;
        for (int i = 0; i < colunas.size(); i++) {
            if (colunas.get(i).getText().equals(coluna)) {
                idColuna = i + 1;
                break;
            }
        }
        return idColuna;
    }

}


