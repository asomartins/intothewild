package view;

import java.io.FileNotFoundException;
import java.util.Scanner;

import static view.MenuSelecaoAmbiente.exibirMenuSelecaoAmbiente;

public class MenuInicialJogo {

    /**
     * Exibe o menu inicial do jogo
     *
     * @throws FileNotFoundException
     */
    public static void exibirMenuInicialJogo() throws FileNotFoundException {

        String opcao;
        Scanner inputUser = new Scanner(System.in);

        //Menu inicial do jogo
        do {
            System.out.println("\n***************************************");
            System.out.println("::: Menu Inicial :::");
            System.out.println("1. Selecionar Ambiente");
            System.out.println("2. Sair");
            System.out.println("***************************************");
            System.out.print("Digite a opção: ");

            opcao = inputUser.nextLine();

            switch (opcao) {
                case "1":
                    exibirMenuSelecaoAmbiente();
                    break;
                case "2":
                    System.out.println("Opção selecionada: Sair. Até logo :)");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (!opcao.equals("2"));
    }
}
