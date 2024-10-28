// main/Main.java (ajuste para múltiplos financiamentos)
package main;

import java.util.ArrayList;
import java.util.List;
import modelo.Financiamento;
import util.InterfaceUsuario;

public class Main {
    public static void main(String[] args) {
        InterfaceUsuario ui = new InterfaceUsuario();
        List<Financiamento> financiamentos = new ArrayList<>();

        int numeroFinanciamentos = 3; // Exemplo: solicitar 3 financiamentos para teste

        for (int i = 0; i < numeroFinanciamentos; i++) {
            System.out.println("\n--- Financiamento " + (i + 1) + " ---");
            double valorImovel = ui.obterValorImovel();
            int prazo = ui.obterPrazo();
            double taxaJuros = ui.obterTaxaJuros();

            Financiamento financiamento = new Financiamento(valorImovel, prazo, taxaJuros);
            financiamentos.add(financiamento);
        }

        System.out.println("\nLista de Financiamentos:");
        for (Financiamento financiamento : financiamentos) {
            financiamento.exibirDetalhes();
            System.out.println();
        }
    }
}
