import controller.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import static view.MenuInicialJogo.exibirMenuInicialJogo;

public class IntoTheWildMain {
    /**
     * Função principal de abertura do jogo Into the Wild
     * Percorre o ficheiro para exibir uma Introdução e mensagem de boas vindas
     * Chama o menu inicial
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
        scanner.close();

        exibirMenuInicialJogo();
    }
}
