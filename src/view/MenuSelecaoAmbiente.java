package view;

import controller.MeioAmbienteController;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MenuSelecaoAmbiente {

    /**
     * Menu de seleção do ambiente
     * Permite ao usuário escolher entre 3 opções de ambientes
     * Chama a função de criação do ambiente
     *
     * @throws FileNotFoundException
     */
    public static void exibirMenuSelecaoAmbiente() throws FileNotFoundException {

        MeioAmbienteController meioAmbienteController = new MeioAmbienteController();

        Scanner input = new Scanner(System.in);
        String opcao;

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
                    meioAmbienteController.criarAmbiente("Floresta Tropical",1000000);
                    break;
                case "2":
                    meioAmbienteController.criarAmbiente("Savana",5000000);
                    break;
                case "3":
                    meioAmbienteController.criarAmbiente("Floresta Temperada",4000000);
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
