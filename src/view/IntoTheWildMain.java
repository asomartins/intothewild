package view;

import controller.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import static view.MenuSelecaoAmbiente.exibirMenuSelecaoAmbiente;

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
                    exibirMenuSelecaoAmbiente();
                    break;
                case "2":
                    System.out.println("Opção selecionada: Sair. Até logo :)");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        }while (!opcao.equals("2")) ;
    }


}
