package br.com.jeanheberth.tests;

import br.com.jeanheberth.core.BaseTest;
import br.com.jeanheberth.pages.ContasPage;
import br.com.jeanheberth.pages.MenuPage;
import br.com.jeanheberth.pages.ResumoPage;
import org.junit.Assert;
import org.junit.Test;

public class ResumoTest extends BaseTest {

    MenuPage menuPage = new MenuPage();
    ResumoPage resumoPage = new ResumoPage();

    @Test
    public void excluirMovimentacao() {

        menuPage.acessarTelaResumoMensal();

        resumoPage.excluirMovimentacao();
        Assert.assertEquals("Movimentação removida com sucesso!", resumoPage.obterMensagemSucesso());

    }
}
