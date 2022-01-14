package br.com.jeanheberth.tests;

import br.com.jeanheberth.core.BaseTest;
import br.com.jeanheberth.pages.ContasPage;
import br.com.jeanheberth.pages.MenuPage;
import br.com.jeanheberth.pages.ResumoPage;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import static br.com.jeanheberth.core.DriveFactory.getDriver;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ResumoTest extends BaseTest {

    MenuPage menuPage = new MenuPage();
    ResumoPage resumoPage = new ResumoPage();


    @Test
    public void test1_ResumoMensal(){
        menuPage.acessarTelaResumo();

        Assert.assertEquals("Seu Barriga - Extrato", getDriver().getTitle());
    }
    @Test
    public void test2_excluirMovimentacao() {

        menuPage.acessarTelaResumoMensal();

        resumoPage.excluirMovimentacao();
        Assert.assertEquals("Movimentação removida com sucesso!", resumoPage.obterMensagemSucesso());

    }

}
