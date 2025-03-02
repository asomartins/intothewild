package controller;

import model.Inseto;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class InsetoController {

    /**
     * Percorre o ficheiro para encontrar as linhas de insetos de floresta tropical
     * Instancia os objetos de insetos a partir da leitura do ficheiro
     *
     * @throws FileNotFoundException
     */
    public void criarInsetosFlorestaTropical() throws FileNotFoundException {

        // Caminho do ficheiro de insetos
        File ficheiroInsetos = new File(FicheirosController.obterFicheiroInsetos());

        // Leitor do ficheiro
        Scanner scanner = new Scanner(ficheiroInsetos);

        String linha, nome, especie, pais, idade, linhaVenenoso;

        boolean venenoso = false;

        // Flag de validação para verificar se existem insetos de floresta tropical no ficheiro que será lido
        boolean isInsetoFlorestaTropical = false;

        // Linha de cabeçalho do leitor
        linha = scanner.nextLine();

        // Ciclo para ler o ficheiro
        while (scanner.hasNextLine()) {
            linha = scanner.nextLine();
            String[] itensLinha = linha.split(";");

            //Verifica se a linha atual do ficheiro contém um inseto de floresta tropical
            if (itensLinha[0].equalsIgnoreCase("floresta tropical")) {

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
            }
        }
        if (!isInsetoFlorestaTropical) {
            System.out.println("Não foi possível adicionar os insetos. O ficheiro não possui insetos de floresta tropical!");
        } else {
            System.out.println("\nOs insetos foram criados.");
        }
    }
}
