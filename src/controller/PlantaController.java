package controller;

import model.Planta;
import model.enums.Familia;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class PlantaController {

    /**
     * Percorre o ficheiro para encontrar as linhas de plantas de floresta tropical
     * Instancia os objetos de plantas a partir da leitura do ficheiro
     * Adiciona as plantas criadas no meio ambiente
     *
     * @throws FileNotFoundException
     */
    public void criarPlantasFlorestaTropical(MeioAmbiente meioAmbiente) throws FileNotFoundException {

        // Caminho do ficheiro de plantas
        File ficheiroPlantas = new File(FicheirosController.obterFicheiroPlantas());

        // Leitor do ficheiro
        Scanner scanner = new Scanner(ficheiroPlantas);

        String linha, nome, especie, pais, idade, linhaFamilia, grauDefesa;

        // Flag para verificar se existem plantas de floresta tropical no ficheiro que será lido
        boolean isPlantaFlorestaTropical = false;

        Familia familia = null;

        // Linha de cabeçalho do leitor
        linha = scanner.nextLine();

        // Ciclo para ler o ficheiro
        while (scanner.hasNextLine()) {
            linha = scanner.nextLine();
            String[] itensLinha = linha.split(";");

            //Verifica se a linha atual do ficheiro contém uma planta de floresta tropical
            if (itensLinha[0].equalsIgnoreCase("Floresta Tropical")) {

                isPlantaFlorestaTropical = true;

                nome = itensLinha[1];
                especie = itensLinha[2];
                pais = itensLinha[3];
                idade = itensLinha[4];
                linhaFamilia = itensLinha[5];
                grauDefesa = itensLinha[6];

                switch (linhaFamilia.toLowerCase()) {
                    case "árvores":
                        familia = Familia.ARVORES;
                        break;
                    case "flores":
                        familia = Familia.FLORES;
                        break;
                    case "ervas":
                        familia = Familia.ERVAS;
                        break;
                    case "carnívoras":
                        familia = Familia.CARNIVORAS;
                        break;
                }

                Planta planta = new Planta(nome, especie, pais, Integer.parseInt(idade), familia, Integer.parseInt(grauDefesa));
                planta.imprimirDescricaoSerVivo();
                planta.imprimirDescricaoPlanta();

                meioAmbiente.adicionarSerVivo(planta);
            }
        }
        if (!isPlantaFlorestaTropical) {
            System.out.println("Não foi possível adicionar as plantas. O ficheiro não possui plantas de Floresta Tropical!");
        } else {
            System.out.println("\nAs plantas foram criadas com sucesso.");
        }
    }

    /**
     * Percorre o ficheiro para encontrar as linhas de plantas de Savana
     * Instancia os objetos de plantas a partir da leitura do ficheiro
     * Adiciona as plantas criadas no meio ambiente
     *
     * @throws FileNotFoundException
     */
    public void criarPlantasSavana(MeioAmbiente meioAmbiente) throws FileNotFoundException {

        // Caminho do ficheiro de plantas
        File ficheiroPlantas = new File(FicheirosController.obterFicheiroPlantas());

        // Leitor do ficheiro
        Scanner scanner = new Scanner(ficheiroPlantas);

        String linha, nome, especie, pais, idade, linhaFamilia, grauDefesa;

        // Flag para verificar se existem plantas de Savana no ficheiro que será lido
        boolean isPlantaSavana = false;

        Familia familia = null;

        // Linha de cabeçalho do leitor
        linha = scanner.nextLine();

        // Ciclo para ler o ficheiro
        while (scanner.hasNextLine()) {
            linha = scanner.nextLine();
            String[] itensLinha = linha.split(";");

            //Verifica se a linha atual do ficheiro contém uma planta de Savana
            if (itensLinha[0].equalsIgnoreCase("Savana")) {

                isPlantaSavana = true;

                nome = itensLinha[1];
                especie = itensLinha[2];
                pais = itensLinha[3];
                idade = itensLinha[4];
                linhaFamilia = itensLinha[5];
                grauDefesa = itensLinha[6];

                switch (linhaFamilia.toLowerCase()) {
                    case "árvores":
                        familia = Familia.ARVORES;
                        break;
                    case "flores":
                        familia = Familia.FLORES;
                        break;
                    case "ervas":
                        familia = Familia.ERVAS;
                        break;
                    case "carnívoras":
                        familia = Familia.CARNIVORAS;
                        break;
                }

                Planta planta = new Planta(nome, especie, pais, Integer.parseInt(idade), familia, Integer.parseInt(grauDefesa));
                planta.imprimirDescricaoSerVivo();
                planta.imprimirDescricaoPlanta();

                meioAmbiente.adicionarSerVivo(planta);
            }
        }
        if (!isPlantaSavana) {
            System.out.println("Não foi possível adicionar as plantas. O ficheiro não possui plantas de Savana!");
        } else {
            System.out.println("\nAs plantas foram criadas com sucesso.");
        }
    }

    /**
     * Percorre o ficheiro para encontrar as linhas de plantas de Floresta Temperada
     * Instancia os objetos de plantas a partir da leitura do ficheiro
     * Adiciona as plantas criadas no meio ambiente
     *
     * @throws FileNotFoundException
     */
    public void criarPlantasFlorestaTemperada(MeioAmbiente meioAmbiente) throws FileNotFoundException {

        // Caminho do ficheiro de plantas
        File ficheiroPlantas = new File(FicheirosController.obterFicheiroPlantas());

        // Leitor do ficheiro
        Scanner scanner = new Scanner(ficheiroPlantas);

        String linha, nome, especie, pais, idade, linhaFamilia, grauDefesa;

        // Flag para verificar se existem plantas de Floresta Temperada no ficheiro que será lido
        boolean isFlorestaTemperada = false;

        Familia familia = null;

        // Linha de cabeçalho do leitor
        linha = scanner.nextLine();

        // Ciclo para ler o ficheiro
        while (scanner.hasNextLine()) {
            linha = scanner.nextLine();
            String[] itensLinha = linha.split(";");

            //Verifica se a linha atual do ficheiro contém uma planta de Floresta Temperada
            if (itensLinha[0].equalsIgnoreCase("Savana")) {

                isFlorestaTemperada = true;

                nome = itensLinha[1];
                especie = itensLinha[2];
                pais = itensLinha[3];
                idade = itensLinha[4];
                linhaFamilia = itensLinha[5];
                grauDefesa = itensLinha[6];

                switch (linhaFamilia.toLowerCase()) {
                    case "árvores":
                        familia = Familia.ARVORES;
                        break;
                    case "flores":
                        familia = Familia.FLORES;
                        break;
                    case "ervas":
                        familia = Familia.ERVAS;
                        break;
                    case "carnívoras":
                        familia = Familia.CARNIVORAS;
                        break;
                }

                Planta planta = new Planta(nome, especie, pais, Integer.parseInt(idade), familia, Integer.parseInt(grauDefesa));
                planta.imprimirDescricaoSerVivo();
                planta.imprimirDescricaoPlanta();

                meioAmbiente.adicionarSerVivo(planta);
            }
        }
        if (!isFlorestaTemperada) {
            System.out.println("Não foi possível adicionar as plantas. O ficheiro não possui plantas de Floresta Temperada!");
        } else {
            System.out.println("\nAs plantas foram criadas com sucesso.");
        }
    }
}
