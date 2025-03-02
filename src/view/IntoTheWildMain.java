package view;

import controller.GerenciadorArquivos;
import model.*;
import model.enums.Dieta;

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
        File file = new File(GerenciadorArquivos.obterFicheiroIntroJogo());

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
                    criarSeresFlorestaTropical();
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


    /**
     * Percorre os ficheiros de animais, plantas e insetos
     * Cria os seres vivos no ambiente floresta tropical
     *
     * @throws FileNotFoundException
     */
    public static void criarSeresFlorestaTropical() throws FileNotFoundException {
        System.out.println("Floresta tropical gerada!");
        /*model.Animal oncaPintada = new model.Animal("Nala", "Onça Pintada (Panthera onca)", "Brasil",5, true, 90.5, 75, Dieta.CARNIVORO,  "Roar");
        model.Animal capivara = new model.Animal("Cappy", "Capivara (Hydrochoerus hydrochaeris)", "Brasil", 3, false, 45, 30, Dieta.HERBIVORO, "Squeak");
        model.Animal preguica = new model.Animal("Sid", "Preguiça (Bradypus variegatus)", "Brasil", 5, false, 8.0, 40, Dieta.HERBIVORO, "Som suave");
        model.Animal macacoAranha = new model.Animal("George", "Macaco-aranha (Ateles geoffroyi)", "Costa Rica", 7, true, 9.2, 82, Dieta.HERBIVORO, "Chiados");
        model.Animal aguia = new model.Animal("Hera", "Águia (Harpia harpyja)", "Brasil", 4, true, 7.5, 88, Dieta.CARNIVORO, "Grito agudo");*/

        // Caminho do ficheiro de animais
        File ficheiroAnimais = new File(GerenciadorArquivos.obterFicheiroAnimais());

        // Leitor do ficheiro
        Scanner scanner = new Scanner(ficheiroAnimais);

        String linha, nome, especie, pais, idade, fome, peso, inteligencia, tipoDieta, barulho;
        Dieta dieta = null;

        // Linha de cabeçalho do leitor
        linha = scanner.nextLine();

        // Ciclo para ler o ficheiro
        while (scanner.hasNextLine()) {
            linha = scanner.nextLine();
            String[] itensLinha = linha.split(";");
            nome = itensLinha[0];
            especie = itensLinha[1];
            pais = itensLinha[2];
            idade = itensLinha[3];
            fome = itensLinha[4];
            peso = itensLinha[5];
            inteligencia = itensLinha[6];
            tipoDieta = itensLinha[7];
            barulho = itensLinha[8];

            switch (tipoDieta){
                case "Carnívoro":
                    dieta = Dieta.CARNIVORO;
                    break;
                case "Herbívoro":
                    dieta = Dieta.HERBIVORO;
                    break;
                case "Onívoro":
                    dieta = Dieta.ONIVORO;
                    break;
            }

            Animal animal = new Animal(nome, especie, pais, Integer.parseInt(idade), Boolean.parseBoolean(fome), Double.parseDouble(peso), Integer.parseInt(inteligencia), dieta, barulho);
            animal.imprimirDescricaoSerVivo();
        }
    }
}
