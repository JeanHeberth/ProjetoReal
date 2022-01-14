package br.com.jeanheberth.tests;

import br.com.jeanheberth.core.BasePage;
import br.com.jeanheberth.core.BaseTest;
import br.com.jeanheberth.pages.ContasPage;
import br.com.jeanheberth.pages.MenuPage;
import br.com.jeanheberth.pages.MovimentacaoPage;
import br.com.jeanheberth.utils.DataUtils;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static br.com.jeanheberth.utils.DataUtils.obterDataFormatada;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MovimentacaoTest extends BaseTest {

    private MenuPage menuPage = new MenuPage();
    private MovimentacaoPage movimentacaoPage = new MovimentacaoPage();

    @Test
    public void test1_CriarMovimentacao() {
        menuPage.acessarTelaInserirMovimentacao();

        Date dataAtual = DataUtils.obterDataAtual();


        movimentacaoPage.setTipoMovimentacao("Receita");
        movimentacaoPage.setDataMovimentacao(obterDataFormatada(dataAtual));
        movimentacaoPage.setDataDoPagamento(obterDataFormatada(dataAtual));
        movimentacaoPage.setDescricao("Pagamento realizado");
        movimentacaoPage.setInteressado("Jean Heberth");
        movimentacaoPage.setValor("15000.00");
        movimentacaoPage.setConta("Jean Heberths");
        movimentacaoPage.setStatusPagamento();
        movimentacaoPage.salvar();

        Assert.assertEquals("Movimentação adicionada com sucesso!", movimentacaoPage.obterMensagemSucesso());

    }

    @Test
    public void test2_CamposObrigatorios() {
        menuPage.acessarTelaInserirMovimentacao();

        movimentacaoPage.salvar();
        List<String> erros = movimentacaoPage.obterErros();
//		Assert.assertEquals("Data da Movimentação é obrigatório", erros.get(0));
//		Assert.assertTrue(erros.contains("Data da Movimentação é obrigatório"));
        Assert.assertTrue(erros.containsAll(Arrays.asList(
                "Data da Movimentação é obrigatório", "Data do pagamento é obrigatório",
                "Descrição é obrigatório", "Interessado é obrigatório",
                "Valor é obrigatório", "Valor deve ser um número")));
        Assert.assertEquals(6, erros.size());
    }

    @Test
    public void test3_InserirMovimentacaoFutura() {
        menuPage.acessarTelaInserirMovimentacao();

        Date dataFutura = DataUtils.obterDataComDiferencaDias(2);


        movimentacaoPage.setTipoMovimentacao("Despesa");
        movimentacaoPage.setDataMovimentacao(obterDataFormatada(dataFutura));
        movimentacaoPage.setDataDoPagamento(obterDataFormatada(dataFutura));
        movimentacaoPage.setDescricao("Pagamento realizado");
        movimentacaoPage.setInteressado("Jean Heberth");
        movimentacaoPage.setValor("8454800.00");
        movimentacaoPage.setConta("Jean Heberths");
        movimentacaoPage.setStatusPagamento();
        movimentacaoPage.salvar();

        List<String> erros = movimentacaoPage.obterErros();
        Assert.assertTrue(
                erros.contains("Data da Movimentação deve ser menor ou igual à data atual"));
        Assert.assertEquals(1, erros.size());
    }
}
