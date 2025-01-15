package pages;

import core.BasePage;

public class ResumoPage extends BasePage {
	
	public void clicarExcluirPrimeiraMovimentacao() {
		clicarPorXpath("//span[@class='glyphicon glyphicon-remove-circle']");
	}
	
	public void selecionarAno(String ano) {
		selecionarCombo("ano", new String [] {ano});
	}
	
	public void clicarBuscar() {
		clicarPorXpath("//input[@value='Buscar']");
	}
}