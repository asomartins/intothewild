import enums.Dieta;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class IntoTheWildMain {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("ficheiros/aberturajogo.txt");
        Scanner scanner = new Scanner(file);
        String linha;
        while (scanner.hasNextLine()) {
            linha = scanner.nextLine();
            System.out.println(linha);
        }
        System.out.println("******************************************************************************************************************\n");
        System.out.println(
                "Bem-vindo(a) ao jogo dos Seres Vivos! Explore a vida na Floresta Tropical, Savana e \n" +
                "Floresta Temperada. Enfrente os desafios de cada bioma, adapte-se e sobreviva enquanto descobre a \n" +
                "rica biodiversidade ao seu redor. Embarque nesta jornada emocionante agora!\n");
        System.out.println("******************************************************************************************************************");

        String opcao;
        Scanner inputUser = new Scanner(System.in);

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

    public static void criarAmbiente() {
        String opcao;
        Scanner input = new Scanner(System.in);
        do {
            System.out.println("***************************************************************");
            System.out.println("::: Criando o ambiente :::");
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
                    gerarSeresFlorestaTropical();
                    break;
                case "2":
                    //gerarSeresSavana();
                    break;
                case "3":
                    //gerarSeresFlorestaTemperada();
                    break;
                case "4":
                    System.out.println("Opção selecionada: Voltar ao menu inicial");
                    return;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (!opcao.equals("4"));
    }

    public static void gerarSeresFlorestaTropical() {
        System.out.println("Floresta tropical gerada!");
        Animal oncaPintada = new Animal("Zara", "Onça Pintada", "Brasil",5, true, 90.5, 75, Dieta.CARNIVORO,  "Roar");
    }
}
