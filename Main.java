package main;

import java.io.*;
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

        try {
            // Salvar dados em arquivo de texto
            salvarDadosEmArquivoTexto(financiamentos, "financiamentos.txt");

            // Ler dados de arquivo de texto e exibir
            System.out.println("\n--- Dados lidos do arquivo de texto ---");
            lerDadosDeArquivoTexto("financiamentos.txt");

            // Salvar dados serializados
            salvarDadosSerializados(financiamentos, "financiamentos.ser");

            // Ler dados serializados e exibir
            System.out.println("\n--- Dados lidos do arquivo serializado ---");
            List<Financiamento> financiamentosLidos = lerDadosSerializados("financiamentos.ser");
            for (Financiamento f : financiamentosLidos) {
                f.exibirDetalhes();
                System.out.println();
            }
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Erro ao processar os dados: " + e.getMessage());
        }
        
    }

    // Método para salvar os dados dos financiamentos em um arquivo de texto
    public static void salvarDadosEmArquivoTexto(List<Financiamento> financiamentos, String nomeArquivo) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nomeArquivo))) {
            for (Financiamento f : financiamentos) {
                writer.write(f.toString());
                writer.newLine();
            }
        }
    }

    // Método para ler os dados de um arquivo de texto
    public static void lerDadosDeArquivoTexto(String nomeArquivo) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(nomeArquivo))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                System.out.println(linha);
            }
        }
    }

    // Método para salvar os dados dos financiamentos em um arquivo serializado
    public static void salvarDadosSerializados(List<Financiamento> financiamentos, String nomeArquivo) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(nomeArquivo))) {
            oos.writeObject(financiamentos);
        }
    }

    // Método para ler os dados serializados de um arquivo
    @SuppressWarnings("unchecked")
    public static List<Financiamento> lerDadosSerializados(String nomeArquivo) throws IOException, ClassNotFoundException {
        List<Financiamento> financiamentos;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(nomeArquivo))) {
            financiamentos = (List<Financiamento>) ois.readObject();
        }
        return financiamentos;
    }
}
