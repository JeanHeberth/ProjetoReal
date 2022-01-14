package br.com.jeanheberth.pages;

import br.com.jeanheberth.core.BasePage;

public class HomePage extends BasePage {
    public String obterSaldoConta(String nome) {
        return obterCelula("Conta", nome, "Saldo", "tabelaSaldo").getText();
    }
}
