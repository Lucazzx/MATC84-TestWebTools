package pages;

import core.BasePage;

public class HomePage extends BasePage {
	
	public String obterSaldoConta(String conta) {
		return obterCelula("Conta", conta, "Saldo", "tabelaSaldo").getText();
		
	}

}