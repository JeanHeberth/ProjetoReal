package br.com.jeanheberth.tests;

import br.com.jeanheberth.core.BaseTest;
import br.com.jeanheberth.pages.HomePage;
import org.junit.Assert;
import org.junit.Test;

public class SaldoTest extends BaseTest {

    HomePage page = new HomePage();

    @Test
    public void testSaldoConta(){
        Assert.assertEquals("15000.00", page.obterSaldoConta("Jean Heberths"));
    }
}
