package br.com.jeanheberth.tests;

import br.com.jeanheberth.core.BaseTest;
import br.com.jeanheberth.pages.ContasPage;
import br.com.jeanheberth.pages.MenuPage;
import org.junit.Assert;
import org.junit.Test;

public class ContaTest extends BaseTest {

    MenuPage menuPage = new MenuPage();
    ContasPage contasPage = new ContasPage();

    @Test
    public void testInserirConta() {
        menuPage.acessarTelaInserirConta();
        contasPage.setNomeConta("Conta do teste");
        contasPage.salvar();

        Assert.assertEquals("Conta adicionada com sucesso!", contasPage.obterMensagemSucesso());

    }

    @Test
    public void testInserirContaComMesmoNome() {
        menuPage.acessarTelaInserirConta();
        contasPage.setNomeConta("Conta do teste");
        contasPage.salvar();

        Assert.assertEquals("Já existe uma conta com esse nome!", contasPage.obterMensagemErro());


    }

    @Test
    public void testAlterarConta() {
        menuPage.acessarTelaListarConta();
        contasPage.clicarAlterarConta("Conta do teste");
        contasPage.setNomeConta("Conta Alterada");
        contasPage.salvar();

        Assert.assertEquals("Conta alterada com sucesso!", contasPage.obterMensagemSucesso());
    }


}
