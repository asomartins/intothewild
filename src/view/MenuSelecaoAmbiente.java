package view;

import controller.*;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MenuSelecaoAmbiente {

    /**
     * Menu de seleção do ambiente
     * Permite ao usuário escolher entre 3 opções de ambientes
     * Chama a função de criação dos seres vivos de acordo com o ambiente selecionado
     *
     * @throws FileNotFoundException
     */
    public static void exibirMenuSelecaoAmbiente() throws FileNotFoundException {
        AnimalController animalController = new AnimalController();
        PlantaController plantaController = new PlantaController();
        InsetoController insetoController = new InsetoController();
        MeioAmbiente meioAmbiente = null;

        String opcao;
        Scanner input = new Scanner(System.in);
        do {
            System.out.println("\n***************************************************************");
            System.out.println("::: Seleção de Ambiente :::\n");
            System.out.println("Selecione um ambiente para criar os seres vivos:");
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
                    System.out.println("\nFloresta Tropical criada!");
                    System.out.println("\nCriando seres vivos no ambiente...");
                    animalController.criarAnimaisFlorestaTropical(meioAmbiente);
                    plantaController.criarPlantasFlorestaTropical(meioAmbiente);
                    insetoController.criarInsetosFlorestaTropical(meioAmbiente);
                    break;
                case "2":
                    meioAmbiente = new MeioAmbiente("Savana",5000000);
                    System.out.println("\nSavana criada!");
                    System.out.println("\nCriando seres vivos no ambiente...");
                    animalController.criarAnimaisSavana(meioAmbiente);
                    plantaController.criarPlantasSavana(meioAmbiente);
                    insetoController.criarInsetosSavana(meioAmbiente);
                    break;
                case "3":
                    meioAmbiente = new MeioAmbiente("Floresta Temperada",4000000);
                    System.out.println("\nFloresta Temperada criada!");
                    System.out.println("\nCriando seres vivos no ambiente...");
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

            if (meioAmbiente != null) {
                meioAmbiente.simulador();
            }

        } while (!opcao.equals("4"));
    }
}
