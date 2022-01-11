package br.com.jeanheberth.pages;

import br.com.jeanheberth.core.BasePage;
import br.com.jeanheberth.core.DriveFactory;
import org.junit.Test;

public class LoginPage extends BasePage {


    public void acessarTelaInicial() {
        DriveFactory.getDriver().get("https://seubarriga.wcaquino.me");
    }

    public void setEmail(String email) {
        escrever("email", email);
    }

    public void setSenha(String senha) {
        escrever("senha", senha);
    }

    public void entrar(){
        clicarBotaoPorTexto("Entrar");
    }

    public void logar(String email, String senha) {
        setEmail(email);
        setSenha(senha);
        entrar();
    }

}
