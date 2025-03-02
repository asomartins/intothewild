package controller;

import model.Animal;
import model.enums.Dieta;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class AnimalController {

    /**
     * Percorre o ficheiro para encontrar as linhas de animais de floresta tropical
     * Instancia os objetos de animais a partir da leitura do ficheiro
     *
     * @throws FileNotFoundException
     */
    public void criarAnimaisFlorestaTropical() throws FileNotFoundException {

        // Caminho do ficheiro de animais
        File ficheiroAnimais = new File(FicheirosController.obterFicheiroAnimais());

        // Leitor do ficheiro
        Scanner scanner = new Scanner(ficheiroAnimais);

        String linha, nome, especie, pais, idade, linhaFome, peso, inteligencia, linhaDieta, barulho;
        boolean fome = false;

        // Flag para verificar se existem animais de floresta tropical no ficheiro que será lido
        boolean isAnimalFlorestaTropical = false;

        Dieta dieta = null;

        // Linha de cabeçalho do leitor
        linha = scanner.nextLine();

        // Ciclo para ler o ficheiro
        while (scanner.hasNextLine()) {
            linha = scanner.nextLine();
            String[] itensLinha = linha.split(";");

            //Verifica se a linha atual do ficheiro contém um animal da floresta tropical
            if (itensLinha[0].equalsIgnoreCase("floresta tropical")) {

                isAnimalFlorestaTropical = true;

                nome = itensLinha[1];
                especie = itensLinha[2];
                pais = itensLinha[3];
                idade = itensLinha[4];
                linhaFome = itensLinha[5];
                peso = itensLinha[6];
                inteligencia = itensLinha[7];
                linhaDieta = itensLinha[8];
                barulho = itensLinha[9];

                switch (linhaDieta.toLowerCase()){
                    case "carnívoro":
                        dieta = Dieta.CARNIVORO;
                        break;
                    case "herbívoro":
                        dieta = Dieta.HERBIVORO;
                        break;
                    case "onívoro":
                        dieta = Dieta.ONIVORO;
                        break;
                }

                if (linhaFome.equalsIgnoreCase("sim")) {
                    fome = true;
                }

                Animal animal = new Animal(nome, especie, pais, Integer.parseInt(idade), fome, Double.parseDouble(peso), Integer.parseInt(inteligencia), dieta, barulho);
                animal.imprimirDescricaoSerVivo();
                animal.imprimirDescricaoAnimal();

            }
        }
        if (!isAnimalFlorestaTropical) {
            System.out.println("Não foi possível adicionar os animais. O ficheiro não possui animais de floresta tropical!");
        } else {
            System.out.println("\nOs animais foram criados.");
        }
    }
}
