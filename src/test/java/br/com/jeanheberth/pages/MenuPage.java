package br.com.jeanheberth.pages;

import br.com.jeanheberth.core.BasePage;

public class MenuPage extends BasePage {

    public void acessarTelaInserirConta() {

        /*  Clicar em contas */
        clicarElementosUtilizandoLinkText("Contas");

        /*  Clicar em Adicionar contas */
        clicarElementosUtilizandoLinkText("Adicionar");


    }

    public void acessarTelaListarConta() {

        /*  Clicar em contas */
        clicarElementosUtilizandoLinkText("Contas");

        /*  Clicar em Adicionar contas */
        clicarElementosUtilizandoLinkText("Listar");


    }
    public void acessarTelaInserirMovimentacao() {

        /*  Clicar em contas */
        clicarElementosUtilizandoLinkText("Criar Movimentação");




    }

}
