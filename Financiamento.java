// modelo/Financiamento.java
package modelo;

public class Financiamento {
    private double valorImovel;
    private int prazo;
    private double taxaJuros;

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
}
