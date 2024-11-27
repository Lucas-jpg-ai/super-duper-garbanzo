// util/InterfaceUsuario.java
package util;

import java.util.Scanner;

public class InterfaceUsuario {
    private final Scanner scanner = new Scanner(System.in);

    public double obterValorImovel() {
        double valor;
        do {
            System.out.print("Informe o valor do imóvel (positivo): ");
            valor = scanner.nextDouble();
            if (valor <= 0) System.out.println("Valor inválido. Tente novamente.");
        } while (valor <= 0);
        return valor;
    }

    public int obterPrazo() {
        int prazo;
        do {
            System.out.print("Informe o prazo do financiamento em meses (positivo): ");
            prazo = scanner.nextInt();
            if (prazo <= 0) System.out.println("Prazo inválido. Tente novamente.");
        } while (prazo <= 0);
        return prazo;
    }

    public double obterTaxaJuros() {
        double taxa;
        do {
            System.out.print("Informe a taxa de juros anual (positiva): ");
            taxa = scanner.nextDouble();
            if (taxa <= 0) System.out.println("Taxa inválida. Tente novamente.");
        } while (taxa <= 0);
        return taxa;
    }
}
