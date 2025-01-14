package pages;

import core.BasePage;

public class MenuPage extends BasePage {
	
	public void acessarHome(){
		clicarLink("Home");
	}
	
	public void acessarTelaInserirConta(){
		clicarLink("Contas");
		clicarLink("Adicionar");
	}
	
	public void acessarTelaAlterarConta(){
		clicarLink("Contas");
		clicarLink("Listar");
	}
	
	public void acessarTelaCriarMovimentacao(){
		clicarLink("Criar Movimentação");
	}
	
	public void acessarTelaResumo(){
		clicarLink("Resumo Mensal");
	}

}