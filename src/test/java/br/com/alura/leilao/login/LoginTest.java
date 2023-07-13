package br.com.alura.leilao.login;

import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LoginTest {

    private LoginPage paginaDeLogin;

    @BeforeEach
    public void beforeEach(){
        this.paginaDeLogin = new LoginPage();
    }

    @AfterEach
    public void afterEach(){
        this.paginaDeLogin.fechar();
    }

    @Test
    public void deveriaEfetuarLoginComDadosValidos(){
        paginaDeLogin.preencheFormularioDeLogin("fulano", "pass");
        paginaDeLogin.efetuaLogin();

        Assert.assertFalse(paginaDeLogin.isPaginaDeLogin()); // Verifica se não está mais na página de login
        Assert.assertEquals("fulano", paginaDeLogin.getNomeUsuarioLogado());
    }

    @Test
    public void nãoDeveriaLogarComDadosInvalidos(){
        paginaDeLogin.preencheFormularioDeLogin("invalido", "123123");
        paginaDeLogin.efetuaLogin();

        Assert.assertTrue(paginaDeLogin.isPaginaDeLoginComDadosInvalidos()); // Verifica se está na página de login
        Assert.assertNull(paginaDeLogin.getNomeUsuarioLogado());
        Assert.assertTrue(paginaDeLogin.contemEscritaNaPagina("Usuário e senha inválidos."));// Verifica se no código fonte da página há esse texto presente
    }

    @Test
    public void naoDeveriaAcessarPaginaRestritaSemEstarLogado(){
        paginaDeLogin.navegaParaPaginaDeLances();

        Assert.assertTrue(paginaDeLogin.isPaginaDeLogin()); // Verifica se ele entrou na página de login caso o usuário não esteja logado
        Assert.assertFalse(paginaDeLogin.contemEscritaNaPagina("Dados do Leilão")); // Verifica se de fato não entrou na página de leilões
    }
}
