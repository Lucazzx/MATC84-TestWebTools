package pages;

import core.BasePage;
import core.DriverFactory;

public class LoginPage extends BasePage {
	
	public void acessarTelaInicial () {
		DriverFactory.getDriver().get("https://seubarriga.wcaquino.me");
	}
	
	public void setEmail(String email) {
		escrever("email", email);
	}
	
	public void setSenha(String senha) {
		escrever("senha", senha);
	}
	
	public void clickEntrar() {
		clicarPorXpath("//button[.='Entrar']");
	}
	
	public void logar(String email, String senha) {
		acessarTelaInicial();
		setEmail(email);
		setSenha(senha);
		clickEntrar();
	}

	public void clickReset() {
		clicarLink("reset");
	}
}