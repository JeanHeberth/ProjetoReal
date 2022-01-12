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

        /*  Clicar em Criar Movimentação */
        clicarElementosUtilizandoLinkText("Criar Movimentação");

    }
    public void acessarTelaResumoMensal() {

        /*  Clicar em Resumo Mensal */
        clicarElementosUtilizandoLinkText("Resumo Mensal");

    }

}
