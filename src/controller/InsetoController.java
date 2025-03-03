package controller;

import model.Inseto;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class InsetoController {

    /**
     * Percorre o ficheiro para encontrar as linhas de insetos de Floresta Tropical
     * Instancia os objetos de insetos a partir da leitura do ficheiro
     * Adiciona os insetos criados no meio ambiente
     *
     * @throws FileNotFoundException
     */
    public void criarInsetosFlorestaTropical(MeioAmbiente meioAmbiente) throws FileNotFoundException {

        // Caminho do ficheiro de insetos
        File ficheiroInsetos = new File(FicheirosController.obterFicheiroInsetos());

        // Leitor do ficheiro
        Scanner scanner = new Scanner(ficheiroInsetos);

        String linha, nome, especie, pais, idade, linhaVenenoso;

        boolean venenoso = false;

        // Flag de validação para verificar se existem insetos de Floresta Tropical no ficheiro que será lido
        boolean isInsetoFlorestaTropical = false;

        // Linha de cabeçalho do leitor
        linha = scanner.nextLine();

        // Ciclo para ler o ficheiro
        while (scanner.hasNextLine()) {
            linha = scanner.nextLine();
            String[] itensLinha = linha.split(";");

            //Verifica se a linha atual do ficheiro contém um inseto de Floresta Tropical
            if (itensLinha[0].equalsIgnoreCase("Floresta Tropical")) {

                isInsetoFlorestaTropical = true;

                nome = itensLinha[1];
                especie = itensLinha[2];
                pais = itensLinha[3];
                idade = itensLinha[4];
                linhaVenenoso = itensLinha[5];

                if(linhaVenenoso.equalsIgnoreCase("sim")) {
                    venenoso = true;
                }

                Inseto inseto = new Inseto(nome, especie, pais, Integer.parseInt(idade), venenoso);
                inseto.imprimirDescricaoSerVivo();
                inseto.imprimirDescricaoInseto();

                meioAmbiente.adicionarSerVivo(inseto);
            }
        }
        if (!isInsetoFlorestaTropical) {
            System.out.println("Não foi possível adicionar os insetos. O ficheiro não possui insetos de Floresta Tropical!");
        } else {
            System.out.println("\nOs insetos foram criados.");
        }
    }

    /**
     * Percorre o ficheiro para encontrar as linhas de insetos de Savana
     * Instancia os objetos de insetos a partir da leitura do ficheiro
     * Adiciona os insetos criados no meio ambiente
     *
     * @throws FileNotFoundException
     */
    public void criarInsetosSavana(MeioAmbiente meioAmbiente) throws FileNotFoundException {

        // Caminho do ficheiro de insetos
        File ficheiroInsetos = new File(FicheirosController.obterFicheiroInsetos());

        // Leitor do ficheiro
        Scanner scanner = new Scanner(ficheiroInsetos);

        String linha, nome, especie, pais, idade, linhaVenenoso;

        boolean venenoso = false;

        // Flag de validação para verificar se existem insetos de Savana no ficheiro que será lido
        boolean isInsetoSavana = false;

        // Linha de cabeçalho do leitor
        linha = scanner.nextLine();

        // Ciclo para ler o ficheiro
        while (scanner.hasNextLine()) {
            linha = scanner.nextLine();
            String[] itensLinha = linha.split(";");

            //Verifica se a linha atual do ficheiro contém um inseto de Savana
            if (itensLinha[0].equalsIgnoreCase("Savana")) {

                isInsetoSavana = true;

                nome = itensLinha[1];
                especie = itensLinha[2];
                pais = itensLinha[3];
                idade = itensLinha[4];
                linhaVenenoso = itensLinha[5];

                if(linhaVenenoso.equalsIgnoreCase("sim")) {
                    venenoso = true;
                }

                Inseto inseto = new Inseto(nome, especie, pais, Integer.parseInt(idade), venenoso);
                inseto.imprimirDescricaoSerVivo();
                inseto.imprimirDescricaoInseto();

                meioAmbiente.adicionarSerVivo(inseto);
            }
        }
        if (!isInsetoSavana) {
            System.out.println("Não foi possível adicionar os insetos. O ficheiro não possui insetos de Savanal!");
        } else {
            System.out.println("\nOs insetos foram criados.");
        }
    }

    /**
     * Percorre o ficheiro para encontrar as linhas de insetos de Floresta Temperada
     * Instancia os objetos de insetos a partir da leitura do ficheiro
     * Adiciona os insetos criados no meio ambiente
     *
     * @throws FileNotFoundException
     */
    public void criarInsetosFlorestaTemperada(MeioAmbiente meioAmbiente) throws FileNotFoundException {

        // Caminho do ficheiro de insetos
        File ficheiroInsetos = new File(FicheirosController.obterFicheiroInsetos());

        // Leitor do ficheiro
        Scanner scanner = new Scanner(ficheiroInsetos);

        String linha, nome, especie, pais, idade, linhaVenenoso;

        boolean venenoso = false;

        // Flag de validação para verificar se existem insetos de Floresta Temperada no ficheiro que será lido
        boolean isInsetoFlorestaTemperada = false;

        // Linha de cabeçalho do leitor
        linha = scanner.nextLine();

        // Ciclo para ler o ficheiro
        while (scanner.hasNextLine()) {
            linha = scanner.nextLine();
            String[] itensLinha = linha.split(";");

            //Verifica se a linha atual do ficheiro contém um inseto de Floresta Temperada
            if (itensLinha[0].equalsIgnoreCase("Floresta Temperada")) {

                isInsetoFlorestaTemperada = true;

                nome = itensLinha[1];
                especie = itensLinha[2];
                pais = itensLinha[3];
                idade = itensLinha[4];
                linhaVenenoso = itensLinha[5];

                if(linhaVenenoso.equalsIgnoreCase("sim")) {
                    venenoso = true;
                }

                Inseto inseto = new Inseto(nome, especie, pais, Integer.parseInt(idade), venenoso);
                inseto.imprimirDescricaoSerVivo();
                inseto.imprimirDescricaoInseto();

                meioAmbiente.adicionarSerVivo(inseto);
            }
        }
        if (!isInsetoFlorestaTemperada) {
            System.out.println("Não foi possível adicionar os insetos. O ficheiro não possui insetos de Floresta Temperada!");
        } else {
            System.out.println("\nOs insetos foram criados.");
        }
    }

}
