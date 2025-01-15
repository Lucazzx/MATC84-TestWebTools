package tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import core.BaseTest;
import core.DriverFactory;
import pages.MenuPage;
import pages.ResumoPage;

public class ResumoTest extends BaseTest{
    
    MenuPage menuPage = new MenuPage();
    ResumoPage resumoPage = new ResumoPage();
    
    @Test
    public void testeExcluirMovimentacao() {
        menuPage.acessarTelaResumo();
        resumoPage.clicarExcluirPrimeiraMovimentacao();
        assertEquals("Movimentação removida com sucesso!", resumoPage.obterMensagemSucesso());
    }
    
    @Test
    public void testeResumoMensal() {
        menuPage.acessarTelaResumo();
        resumoPage.selecionarAno("2020");
        resumoPage.clicarBuscar();
        
        // Atualizando para usar o método correto de obtenção de elementos
        List<WebElement> elementosEncontrados = 
                DriverFactory.getDriver().findElements(By.xpath("//*[@id='tabelaExtrato']/tbody/tr"));
        assertEquals(0, elementosEncontrados.size());
    }
}
