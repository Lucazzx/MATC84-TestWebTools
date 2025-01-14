package pages;

import java.util.List;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.WebElement;

import core.BasePage;

public class MovimentacaoPage extends BasePage {
	
	public void setTipoMovimentacaoReceita() {
		selecionarCombo("tipo", new String [] {"Receita"});
	}
	
	public void setTipoMovimentacaoDespesa() {
		selecionarCombo("tipo", new String [] {"Despesa"});
	}
	
	public void setDataMovimentacao(String data) {
		escrever("data_transacao", data);
	}
	
	public void setDataPagamento(String data) {
		escrever("data_pagamento", data);
	}
	
	public void setDescricao(String descricao) {
		escrever("descricao", descricao);
	}
	
	public void setInteressado(String nome) {
		escrever("interessado", nome);
	}
	
	public void setValor(String valor) {
		escrever("valor", valor);
	}
	
	public void setConta(String conta) {
		selecionarCombo("conta", new String [] {conta});
	}
	
	public void setSituacaoPago() {
		clicar("status_pago");
	}
	
	public void setSituacaoPendente() {
		clicar("status_pendente");
	}
	
	public String obterTextoXPathComFallback() {
	    String texto = "";
	    String xPathSucesso = "//div[@class='alert alert-success']";
	    String xPathErro = "//div[@class='alert alert-danger']//ul/li[1]";

	    List<WebElement> elementoErro = (List<WebElement>) buscaElementoXPath(xPathErro);
	    
	    if (!elementoErro.isEmpty()) {
	        texto = elementoErro.get(0).getText();
	    } else {
	        List<WebElement> elementoSucesso = buscaElementoXPath(xPathSucesso);
	        
	        if (!elementoSucesso.isEmpty()) {
	            texto = elementoSucesso.get(0).getText();
	        } else {
	            texto = "Nenhum alerta encontrado.";
	        }
	    }

	    return texto;
	}
	
    public String getDataAtualFormatada() {
        LocalDate dataAtual = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return dataAtual.format(formatter);
    }
	
}