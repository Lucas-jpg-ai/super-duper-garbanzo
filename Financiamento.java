package modelo;

import java.io.Serializable;

public class Financiamento implements Serializable {
    private final double valorImovel;
    private final int prazo;
    private final double taxaJuros;

    public Financiamento(double valorImovel, int prazo, double taxaJuros) {
        this.valorImovel = valorImovel;
        this.prazo = prazo;
        this.taxaJuros = taxaJuros;
    }

    public double getValorImovel() {
        return valorImovel;
    }

    public int getPrazo() {
        return prazo;
    }

    public double getTaxaJuros() {
        return taxaJuros;
    }

    public void exibirDetalhes() {
        System.out.println("Valor do Imóvel: R$" + valorImovel);
        System.out.println("Prazo (meses): " + prazo);
        System.out.println("Taxa de Juros Anual: " + taxaJuros + "%");
    }

    // Método toString para salvar os dados em arquivo de texto
    @Override
    public String toString() {
        return valorImovel + "," + prazo + "," + taxaJuros;
    }
}
