package br.com.jeanheberth.tests;

import br.com.jeanheberth.core.BaseTest;
import br.com.jeanheberth.pages.ContasPage;
import br.com.jeanheberth.pages.MenuPage;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class RemoverMovimentacaoContaTest extends BaseTest {

    MenuPage menuPage = new MenuPage();
    ContasPage contasPage = new ContasPage();

    @Test
    public void testExcluirContaComMovimentacao() {
        menuPage.acessarTelaListarConta();

        contasPage.clicarExcluirConta("Jean Heberths");

        Assert.assertEquals("Conta em uso na movimentações", contasPage.obterMensagemErro());
    }

}
