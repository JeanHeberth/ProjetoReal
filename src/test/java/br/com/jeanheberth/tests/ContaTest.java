package br.com.jeanheberth.tests;

import br.com.jeanheberth.core.BaseTest;
import br.com.jeanheberth.pages.ContasPage;
import br.com.jeanheberth.pages.MenuPage;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ContaTest extends BaseTest {

    MenuPage menuPage = new MenuPage();
    ContasPage contasPage = new ContasPage();

    @Test
    public void test1_InserirConta(){
        menuPage.acessarTelaInserirConta();

        contasPage.setNomeConta("Conta do Teste");
        contasPage.salvar();

        Assert.assertEquals("Conta adicionada com sucesso!", contasPage.obterMensagemSucesso());
    }

    @Test
    public void test2_AlterarConta(){
        menuPage.acessarTelaListarConta();

        contasPage.clicarAlterarConta("Conta do Teste");

        contasPage.setNomeConta("Jean Heberths");
        contasPage.salvar();

        Assert.assertEquals("Conta alterada com sucesso!", contasPage.obterMensagemSucesso());
    }

    @Test
    public void test3_InserirContaMesmoNome(){
        menuPage.acessarTelaInserirConta();

        contasPage.setNomeConta("Jean Heberths");
        contasPage.salvar();

        Assert.assertEquals("Já existe uma conta com esse nome!", contasPage.obterMensagemErro());
    }

}
