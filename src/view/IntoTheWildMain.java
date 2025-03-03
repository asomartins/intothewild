package view;

import controller.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class IntoTheWildMain {
    /**
     * Percorre o ficheiro de Abertura do jogo
     * Exibe o menu inicial
     * Chama a função de criação do ambiente
     *
     * @throws FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException {

        //Caminho do ficheiro para exibir a tela de abertura do jogo
        File file = new File(FicheirosController.obterFicheiroIntroJogo());

        //Leitor do ficheiro de animais
        Scanner scanner = new Scanner(file);
        String linha;
        //Percorre o ficheiro
        while (scanner.hasNextLine()) {
            linha = scanner.nextLine();
            System.out.println(linha);
        }

        String opcao;
        Scanner inputUser = new Scanner(System.in);

        //Menu inicial do jogo
        do {
            System.out.println("\n***************************************");
            System.out.println("::: Menu Inicial :::");
            System.out.println("1. Iniciar Jogo");
            System.out.println("2. Sair");
            System.out.println("***************************************");
            System.out.print("Digite a opção: ");

            opcao = inputUser.nextLine();

            switch (opcao) {
                case "1":
                    criarAmbiente();
                    break;
                case "2":
                    System.out.println("Opção selecionada: Sair. Até logo :)");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        }while (!opcao.equals("2")) ;
    }

    /**
     * Menu de seleção do ambiente
     * Permite ao usuário escolher entre 3 opções de ambientes
     * Chama a função de criação dos seres vivos de acordo com o ambiente selecionado
     *
     * @throws FileNotFoundException
     */
    public static void criarAmbiente() throws FileNotFoundException {
        AnimalController animalController = new AnimalController();
        PlantaController plantaController = new PlantaController();
        InsetoController insetoController = new InsetoController();
        MeioAmbiente meioAmbiente;

        String opcao;
        Scanner input = new Scanner(System.in);
        do {
            System.out.println("***************************************************************");
            System.out.println("::: Selecionar Ambiente :::");
            System.out.println("Selecione um ambiente para criar os seres vivos");
            System.out.println("1. Floresta Tropical");
            System.out.println("2. Savana");
            System.out.println("3. Floresta Temperada");
            System.out.println("4. Voltar ao menu inicial");
            System.out.println("***************************************************************");
            System.out.print("Digite a opção: ");
            opcao = input.next();

            switch (opcao) {
                case "1":
                    meioAmbiente = new MeioAmbiente("Floresta Tropical",1000000);
                    animalController.criarAnimaisFlorestaTropical(meioAmbiente);
                    plantaController.criarPlantasFlorestaTropical(meioAmbiente);
                    insetoController.criarInsetosFlorestaTropical(meioAmbiente);
                    meioAmbiente.simulador();
                    break;
                case "2":
                    meioAmbiente = new MeioAmbiente("Savana",5000000);
                    animalController.criarAnimaisSavana(meioAmbiente);
                    plantaController.criarPlantasSavana(meioAmbiente);
                    insetoController.criarInsetosSavana(meioAmbiente);
                    break;
                case "3":
                    meioAmbiente = new MeioAmbiente("Floresta Temperada",4000000);
                    animalController.criarAnimaisFlorestaTemperada(meioAmbiente);
                    plantaController.criarPlantasFlorestaTemperada(meioAmbiente);
                    insetoController.criarInsetosFlorestaTemperada(meioAmbiente);
                    break;
                case "4":
                    System.out.println("Opção selecionada: Voltar ao menu inicial");
                    return;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (!opcao.equals("4"));
    }
}
