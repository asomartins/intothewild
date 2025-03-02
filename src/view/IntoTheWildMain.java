package view;

import controller.FicheirosController;
import controller.AnimalController;
import controller.InsetoController;
import controller.PlantaController;

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
                    animalController.criarAnimaisFlorestaTropical();
                    plantaController.criarPlantasFlorestaTropical();
                    insetoController.criarInsetosFlorestaTropical();
                    break;
                case "2":
                    //criarSeresSavana();
                    break;
                case "3":
                    //criarSeresFlorestaTemperada();
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
