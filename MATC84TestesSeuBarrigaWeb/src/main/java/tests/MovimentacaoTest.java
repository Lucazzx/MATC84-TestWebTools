package tests;

import java.util.Arrays;
import java.util.Collection;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import core.BaseTest;
import pages.MenuPage;
import pages.MovimentacaoPage;

public class MovimentacaoTest extends BaseTest {

    MenuPage menuPage = new MenuPage();

    @ParameterizedTest
    @MethodSource("getTestData")
    public void testeInserirMovimentacao(String[] tipo, String dataMovimentacao, String dataPagamento,
                                         String descricao, String interessado, String valor, 
                                         String[] conta, String[] situacao, String mensagem) {
        MovimentacaoPage movimentacaoPage = new MovimentacaoPage();
        menuPage.acessarTelaCriarMovimentacao();

        if (tipo[0].equals("Receita")) movimentacaoPage.setTipoMovimentacaoReceita();
        if (tipo[0].equals("Despesa")) movimentacaoPage.setTipoMovimentacaoDespesa();
        movimentacaoPage.setDataMovimentacao(dataMovimentacao);
        movimentacaoPage.setDataPagamento(dataPagamento);
        movimentacaoPage.setDescricao(descricao);
        movimentacaoPage.setInteressado(interessado);
        movimentacaoPage.setValor(valor);
        if (conta[0].equals("ContaTesteLucas2")) movimentacaoPage.setConta("Conta para movimentacoes");
        if (conta[0].equals("ContaTesteLucas2-Alterada")) movimentacaoPage.setConta("Conta para movimentacoes");
        if (situacao[0].equals("Pago")) movimentacaoPage.setSituacaoPago();
        if (situacao[0].equals("Pendente")) movimentacaoPage.setSituacaoPendente();
        movimentacaoPage.clicarSalvar();

        Assertions.assertEquals(mensagem, movimentacaoPage.obterTextoXPathComFallback());
    }

    private static Collection<Object[]> getTestData() {
        MovimentacaoPage movimentacaoPage = new MovimentacaoPage();
        String dataAtual = movimentacaoPage.getDataAtualFormatada();
        return Arrays.asList(new Object[][]{
            {new String[]{""}, "", "", "", "", "", new String[]{""}, new String[]{""}, "Data da Movimentação é obrigatório"},
            {new String[]{""}, "DataInvalida", "", "", "", "", new String[]{""}, new String[]{""}, "Data da Movimentação inválida (DD/MM/YYYY)"},
            {new String[]{""}, "20/09/2099", "", "", "", "", new String[]{""}, new String[]{""}, "Data da Movimentação deve ser menor ou igual à data atual"},
            {new String[]{""}, dataAtual, "", "", "", "", new String[]{""}, new String[]{""}, "Data do pagamento é obrigatório"},
            {new String[]{""}, dataAtual, "DataInvalida", "", "", "", new String[]{""}, new String[]{""}, "Data do pagamento inválida (DD/MM/YYYY)"},
            {new String[]{""}, dataAtual, dataAtual, "", "", "", new String[]{""}, new String[]{""}, "Descrição é obrigatório"},
            {new String[]{""}, dataAtual, dataAtual, "DescriçãoExemplo", "", "", new String[]{""}, new String[]{""}, "Interessado é obrigatório"},
            {new String[]{""}, dataAtual, dataAtual, "DescriçãoExemplo", "InteressadoExemplo", "", new String[]{""}, new String[]{""}, "Valor é obrigatório"},
            {new String[]{""}, dataAtual, dataAtual, "DescriçãoExemplo", "InteressadoExemplo", "TesteValor", new String[]{""}, new String[]{""}, "Valor deve ser um número"},
            {new String[]{""}, dataAtual, dataAtual, "DescriçãoExemplo", "InteressadoExemplo", "500.25", new String[]{""}, new String[]{""}, "Movimentação adicionada com sucesso!"},
            {new String[]{"Despesa"}, dataAtual, dataAtual, "DescriçãoExemplo", "InteressadoExemplo", "500.25", new String[]{""}, new String[]{""}, "Movimentação adicionada com sucesso!"},
            {new String[]{"Despesa"}, dataAtual, dataAtual, "DescriçãoExemplo", "InteressadoExemplo", "500.25", new String[]{"ContaTesteLucas2-Alterada"}, new String[]{""}, "Movimentação adicionada com sucesso!"},
            {new String[]{"Despesa"}, dataAtual, dataAtual, "DescriçãoExemplo", "InteressadoExemplo", "500.25", new String[]{"ContaTesteLucas2-Alterada"}, new String[]{"Pago"}, "Movimentação adicionada com sucesso!"}
        });
    }
}
