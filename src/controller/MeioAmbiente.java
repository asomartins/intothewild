package controller;

import model.Animal;
import model.Inseto;
import model.Planta;
import model.SerVivo;

import java.util.ArrayList;
import java.util.Scanner;

public class MeioAmbiente {
    private String nome;
    private double qtdAguaDisponivel;
    private ArrayList<SerVivo> seresVivos;

    /**
     * Construtor inicializa o ambiente com um nome e uma quantidade definida de água disponível.
     * Prepara uma lista vazia para ser preenchida com os seres vivos que habitam este ambiente.
     *
     * @param nome
     * @param qtdAgua
     */
    public MeioAmbiente(String nome, double qtdAgua) {
        this.nome = nome;
        this.qtdAguaDisponivel = qtdAgua;
        this.seresVivos = new ArrayList<>();
    }

    // A quantidade de água que a planta bebe depende da sua família:
    // árvores bebem 1L, flores bebem 0.1L e ervas bebem 0.25L

    public boolean plantaBebe() {
                Planta plantaAtual = obterPlantaAleatoria();
                double qtdAguaPlanta = 0;

                switch (plantaAtual.getFamilia()) {
                    case ARVORES:
                        qtdAguaPlanta = 1.0;
                        break;
                    case FLORES:
                        qtdAguaPlanta = 0.1;
                        break;
                    case ERVAS:
                        qtdAguaPlanta = 0.25;
                        break;
                    case CARNIVORAS:
                        qtdAguaPlanta = 0.5;
                        break;
                    default:
                        qtdAguaPlanta = 0;
                }

                // Planta bebeu água com sucesso
                if (qtdAguaPlanta <= this.qtdAguaDisponivel) {
                    System.out.println("Quantidade de água disponível no ambiente: " + this.qtdAguaDisponivel);
                    this.qtdAguaDisponivel -= qtdAguaPlanta;
                    System.out.println("A planta " + plantaAtual.getNome() + " bebeu água.");
                    System.out.println("Quantidade de água restante: " + this.qtdAguaDisponivel);
                    return true;
                } else {
                    // Remove planta que não conseguiu beber água
                    System.out.println("Quantidade de água indisponível no ambiente. A planta " + plantaAtual.getNome() + " morreu.");
                    removerSerVivo(plantaAtual);
                    return false;
                }
    }

    // Se houver insetos no ambiente, a planta come um e retorna true
    // Caso contrário, a planta morre de fome e é removida do ambiente, retornando false

    public boolean plantaComeInsetos() {
        return true;
    }

    public void plantaAbanaComVento() {
        System.out.println("Está muito vento!");
    }

    /**
     * Função utilitária para obter um animal aleatoriamente
     * Reutilizada em diferentes ações escolhidas pelo user
     *
     * @return - Animal
     */
    public Animal obterAnimalAleatorio() {

        // Inicializa objeto que vai armazenar um animal da lista de animais
        Animal animalAleatorio = null;

        // Obtém a lista de animais do meio ambiente
        ArrayList<Animal> listaAnimais = obterListaAnimais();

        // Verifica se a lista não está vazia
        if (!listaAnimais.isEmpty()) {

            // Gera um índice aleatório de acordo com o tamanho da lista de animais
            // Esse índice será utilizado para escolher um animal randomicamente
            int indiceRandom = (int) (Math.random() * listaAnimais.size());

            //Encontra um animal aleatório e imprime o barulho
            animalAleatorio = listaAnimais.get(indiceRandom);
        }
        return animalAleatorio;
    }

    /**
     * Função utilitária para obter a lista de animais presentes no ambiente
     * Reutilizada em diferentes ações escolhidas pelo user
     *
     * @return - ArrayList<Animal>
     */
    public ArrayList<Animal> obterListaAnimais() {

        // Cria uma lista para armazenar os animais do ambiente
        ArrayList<Animal> listaAnimais = new ArrayList<>();

        // Para cada ser vivo do ambiente, filtra apenas os que são animais e adiciona na lista de animais
        for (SerVivo serVivoAtual : this.seresVivos) {
            if (serVivoAtual instanceof Animal) {
                Animal animalAtual = (Animal) serVivoAtual;
                listaAnimais.add(animalAtual);
            }
        }

        return listaAnimais;
    }

    /**
     * Função utilitária para obter uma planta aleatoriamente
     * Reutilizada em diferentes ações escolhidas pelo user
     *
     * @return - Planta
     */
    public Planta obterPlantaAleatoria() {

        // Inicializa objeto que vai armazenar uma planta da lista de plantas
        Planta plantaAleatoria = null;

        // Obtém a lista de plantas do meio ambiente
        ArrayList<Planta> listaPlantas = obterListaPlantas();

        // Verifica se a lista não está vazia
        if (!listaPlantas.isEmpty()) {

            // Gera um índice aleatório de acordo com o tamanho da lista de plantas
            // Esse índice será utilizado para escolher uma planta randomicamente
            int indiceRandom = (int) (Math.random() * listaPlantas.size());

            //Encontra um animal aleatório e imprime o barulho
            plantaAleatoria = listaPlantas.get(indiceRandom);
        }
        return plantaAleatoria;
    }

    /**
     * Função utilitária para obter a lista de plantas presentes no ambiente
     * Reutilizada em diferentes ações escolhidas pelo user
     *
     * @return - ArrayList<Planta>
     */
    public ArrayList<Planta> obterListaPlantas() {

        // Cria uma lista para armazenar as plantas do ambiente
        ArrayList<Planta> listaPlantas = new ArrayList<>();

        // Para cada ser vivo do ambiente, filtra apenas os que são plantas e adiciona na lista de plantas
        for (SerVivo serVivoAtual : this.seresVivos) {
            if (serVivoAtual instanceof Planta) {
                Planta plantaAtual = (Planta) serVivoAtual;
                listaPlantas.add(plantaAtual);
            }
        }

        return listaPlantas;
    }

     // Imprime na tela o barulho de um animal aleatório

    public void animalFazBarulho() {
        if (obterAnimalAleatorio() != null) {
            System.out.println("\n********** Barulho aleatório **********");
            System.out.println("Animal: " + obterAnimalAleatorio().getNome());
            System.out.println("Barulho: " + obterAnimalAleatorio().getBarulho());
            System.out.println("****************************************\n");
        } else {
            System.out.println("Não há animais no ambiente.");
        }
    }

    // Imprime na tela "O (nome do animal) movimentou-se"

    public void animalMovimenta() {
        if (obterAnimalAleatorio() != null) {
            System.out.println(obterAnimalAleatorio().getNome() + " movimentou-se");
        } else {
            System.out.println("Não há animais no ambiente.");
        }
    }

    /**
     * Verifica se há água suficiente para o animal beber
     * Se houver, diminui a quantidade de água no ambiente e retorna true
     * Caso contrário, o animal morre de sede e é removido do ambiente, retornando false.
     * A quantidade de água que o animal bebe depende do seu peso: 0.025L por kg
     *
     * @return - boolean
     */
    public boolean animalBebe() {
        Animal animalAtual = obterAnimalAleatorio();
        double qtdAguaNecessariaAnimal = animalAtual.getPeso() * 0.025;

        // Animal bebeu água
        if (qtdAguaNecessariaAnimal <= this.qtdAguaDisponivel) {
            System.out.println("Quantidade de água disponível no ambiente: " + this.qtdAguaDisponivel);
            this.qtdAguaDisponivel -= qtdAguaNecessariaAnimal;
            System.out.println("O animal " + animalAtual.getNome() + " bebeu água.");
            System.out.println("Quantidade de água restante: " + this.qtdAguaDisponivel);
            return true;
        } else {
            // Remove animal que não conseguiu beber água
            System.out.println("Quantidade de água indisponível no ambiente. O animal " + animalAtual.getNome() + " morreu de sede.");
            removerSerVivo(animalAtual);
            return false;
        }
    }

    /**
     * Função que seleciona um animal aleatoriamente para alimentá-lo com os seres vivos disponíveis.
     * Cria uma cópia da lista de seres vivos para evitar modificações durante a iteração.
     * Se um animal é alimentado com sucesso, o ser vivo consumido é removido da lista original.
     * Insetos venenosos são removidos da lista se consumidos, mesmo se resultarem na morte do animal.
     */
    public void animalCome() {
        Animal animalAtual = obterAnimalAleatorio();
        ArrayList<SerVivo> copiaSeresVivos = new ArrayList<>(seresVivos);

        if (animalAtual == null) {
            System.out.println("Nenhum animal disponível para alimentar.");
            return;
        }

        for (SerVivo adversario : copiaSeresVivos) {
            if (adversario != animalAtual && animalAtual.isFome()) {
                boolean consumiu = animalConsumiu(animalAtual, adversario);
                if (consumiu || (adversario instanceof Inseto && ((Inseto) adversario).isVenenoso())) {
                    // Remove o adversário da lista original se foi consumido ou se é um inseto venenoso consumido que matou o animal
                    removerSerVivo(adversario);
                    break;
                }
            }
        }
    }

    /**
     * Verifica se o animal está com fome e, se estiver,
     * tenta comer outro ser vivo do ambiente, seguindo as seguintes regras:
     * Se o animal for carnívoro, ele tenta comer outro animal ou inseto.
     * Se o animal for herbívoro, ele tenta comer uma planta.
     * Se o animal for onívoro, ele tenta comer qualquer ser vivo.
     * Ao tentar comer uma planta, a inteligência do animal influencia sua capacidade
     * de evitar os mecanismos de defesa da planta.
     * Ao tentar comer outro animal, o peso e a inteligência dos dois animais
     * são usados para determinar quem vence a luta.
     * Ao tentar comer um inseto venenoso, o animal morre
     *
     * @param animalAtual
     * @param adversario
     *
     * @return boolean
     */

    public boolean animalConsumiu(Animal animalAtual, SerVivo adversario) {
        if (animalAtual != adversario && animalAtual.isFome()) {
            switch (animalAtual.getDieta()) {
                case CARNIVORO:
                    if (adversario instanceof Animal) {
                        System.out.println("Animal com fome: " + animalAtual.getNome());
                        System.out.println("Animal a ser consumido: " + adversario.getNome());
                        Animal vencedor = lutar(animalAtual, (Animal) adversario);
                        System.out.println("Quem ganhou a luta: " + vencedor.getNome());
                        animalAtual.setFome(false);
                        return true;
                    } else if (adversario instanceof Inseto) {
                        Inseto inseto = (Inseto) adversario;
                        if (inseto.isVenenoso()) {
                            System.out.println("Inseto venenoso consumido: " + inseto.getNome());
                            System.out.println(animalAtual.getNome() + " morreu.");
                            removerSerVivo(animalAtual);
                            return false;
                        } else {
                            System.out.println("Animal com fome: " + animalAtual.getNome());
                            System.out.println("Inseto a ser consumido: " + inseto.getNome());
                            animalAtual.setFome(false);
                            return true;
                        }
                    }
                    break;
                case HERBIVORO:
                    if (adversario instanceof Planta) {
                        System.out.println("Animal com fome: " + animalAtual.getNome());
                        System.out.println("Planta a ser consumida: " + adversario.getNome());
                        animalAtual.setFome(false);
                        return true;
                    }
                    break;
                case ONIVORO:
                    if (adversario instanceof Animal) {
                        System.out.println("Animal com fome: " + animalAtual.getNome());
                        System.out.println("Ser vivo a ser consumido: " + adversario.getNome());
                        Animal vencedor = lutar(animalAtual, (Animal) adversario);
                        System.out.println("Quem ganhou a luta: " + vencedor.getNome());
                        animalAtual.setFome(false);
                        return true;
                    } else if (adversario instanceof Inseto) {
                        Inseto inseto = (Inseto) adversario;
                        if (inseto.isVenenoso()) {
                            System.out.println("Inseto venenoso consumido: " + inseto.getNome());
                            System.out.println(animalAtual.getNome() + " morreu.");
                            removerSerVivo(animalAtual);
                            return false;
                        } else {
                            System.out.println("Animal com fome: " + animalAtual.getNome());
                            System.out.println("Inseto a ser consumido: " + inseto.getNome());
                            animalAtual.setFome(false);
                            return true;
                        }
                    } else if (adversario instanceof Planta) {
                            System.out.println("Animal com fome: " + animalAtual.getNome());
                            System.out.println("Planta a ser consumida: " + adversario.getNome());
                            animalAtual.setFome(false);
                            return true;
                        }
                    break;
            }
        }
        return false;
    }

    /**
     * Calcula e determina o vencedor de uma luta entre dois animais com base em seu peso e inteligência.
     * O peso tem uma influência de 60% e a inteligência de 40% no resultado da luta.
     *
     * @param animalComFome
     * @param adversario
     * @return O animal vencedor da luta. Retorna null em caso de empate.
     */
    public Animal lutar(Animal animalComFome, Animal adversario) {
        double animalComFomePontuacao = (animalComFome.getPeso() * 0.7) + (animalComFome.getInteligencia() * 0.3);
        double adversarioPontuacao = (adversario.getPeso() * 0.7) + (adversario.getInteligencia() * 0.3);

        if (animalComFomePontuacao > adversarioPontuacao) {
            return animalComFome;
        } else if (animalComFomePontuacao < adversarioPontuacao) {
            return adversario;
        } else if (animalComFomePontuacao == adversarioPontuacao) {
            return animalComFome;
        }

        return null;
    }

    /**
     * Imprime na tela um de três barulhos aleatoriamente
     */
    public void insetoChateia() {
        String[] barulhos = {"Bzzzz bzzzz", "Tic tic tic tic", "Pssssss"};
        int indiceRandom = (int) (Math.random() * barulhos.length);
        System.out.println(barulhos[indiceRandom]);
    }

    public void adicionarSerVivo(SerVivo serVivoAtual) {
        this.seresVivos.add(serVivoAtual);
    }

    public void removerSerVivo(SerVivo serVivoAtual) {
        this.seresVivos.remove(serVivoAtual);
    }

    public void listarSeresVivos() {
        System.out.println("\n********** Seres Vivos Presentes no Ambiente **********");

        for (SerVivo serVivoAtual : this.seresVivos) {
            serVivoAtual.imprimirDescricaoSerVivo();
            if (serVivoAtual instanceof Animal animal) {
                animal.imprimirDescricaoAnimal();
            }
            else if (serVivoAtual instanceof Inseto inseto) {
                inseto.imprimirDescricaoInseto();
            }
            else if (serVivoAtual instanceof Planta planta) {
                planta.imprimirDescricaoPlanta();
            }
        }
    }

    /**
     * Imprime na tela a descrição da catástrofe que ocorreu no ambiente
     */
    public void gerarCatastrofeNatural() {
        String seca = "Estamos enfrentando uma grave catástrofe natural: uma intensa seca tem devastado nossa região, " +
                "impactando severamente nossos recursos e modos de vida.";
        String chuva = "Uma catástrofe natural ocorreu: chuvas torrenciais têm transformado o ambiente selvagem, causando inundações e " +
                "deslizamentos que ameaçam a fauna e a flora local.";
        String erupcao = "Uma catástrofe natural dramática está em curso: uma erupção vulcânica tem lançado cinzas e lava, alterando drasticamente a " +
                "paisagem e colocando em risco a vida selvagem da região.";

        String[] catastrofes = {seca, chuva, erupcao};

        int indiceRandom = (int) (Math.random() * catastrofes.length);

        System.out.println(catastrofes[indiceRandom]);

        // Seca
        if (indiceRandom == 0) {
            this.qtdAguaDisponivel = 0;
            System.out.println("Quantidade água disponível no ambiente: "+this.qtdAguaDisponivel);
            System.out.println("Dica: Peça ao universo para gerar uma intensa chuva :)");
        }

        // Chuva
        if (indiceRandom == 1) {
            this.qtdAguaDisponivel += 1000000;
            System.out.println("A chuva aumentou a disponibilidade de água no ambiente: "+this.qtdAguaDisponivel);
            System.out.println("Dica: Aproveite para hidratar os seres vivos :)");
        }

    }

    // Função para simular 3 eventos diferentes em 3 dias consecutivos
    public void simulador() {
        Scanner input = new Scanner(System.in);
        String opcao;
        int dia = 1;

        while (dia <= 3) {
            System.out.println("\n******************* Simulador - Dia " + dia + " *******************\n");
            for (int evento = 1; evento <= 3; evento++) {
                System.out.println("\n::: Evento: " + evento + ":::\n");
                System.out.println("Escolha uma opção:");
                System.out.println("1. Gerar catástrofe natural");
                System.out.println("2. Alimentar animal");
                System.out.println("3. Hidratar animal");
                System.out.println("4. Movimentar um animal");
                System.out.println("5. Barulho de animal");
                System.out.println("6. Barulho de inseto");
                System.out.println("7. Planta abana com vento");
                System.out.println("8. Hidratar Planta");
                System.out.println("9. Sair");
                System.out.println("***********************************************************");
                System.out.print("Digite a opção: ");
                opcao = input.next();

                switch (opcao) {
                    case "1":
                        gerarCatastrofeNatural();
                        break;
                    case "2":
                        animalCome();
                        break;
                    case "3":
                        animalBebe();
                        break;
                    case "4":
                        animalMovimenta();
                        break;
                    case "5":
                        animalFazBarulho();
                        break;
                    case "6":
                        insetoChateia();
                        break;
                    case "7":
                        plantaAbanaComVento();
                        break;
                    case "8":
                        plantaBebe();
                        break;
                    case "9":
                        System.out.println("Opção selecionada: Voltar ao Menu Meio Ambiente");
                        return;
                    default:
                        System.out.println("Opção inválida!");
                        break;
                }
                if (evento == 3) {
                    // Ao final do dia, o sistema encontra um animal com fome e tenta alimentá-lo.
                    System.out.println("\n************ Verificação automática - Animal com fome ************\n");
                    animalCome();
                    System.out.println("\n****************************************************************\n");
                    System.out.println();
                }
            }
            dia++;
        }
    }

    public void exibirMenuMeioAmbiente() {
        Scanner input = new Scanner(System.in);
        String opcao;

        do {
            System.out.println("\n******************* Menu Meio Ambiente *******************\n");
            System.out.println("Escolha uma opção:");
            System.out.println("1. Simulador");
            System.out.println("2. Listar Seres Vivos");
            System.out.println("3. Sair");
            System.out.println("***************************************************************");
            System.out.print("Digite a opção: ");
            opcao = input.next();

            switch (opcao) {
                case "1":
                    simulador();
                    break;
                case "2":
                    listarSeresVivos();
                    break;
                case "3":
                    System.out.println("Opção selecionada: Sair. Até logo :)");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (!opcao.equals("3"));
    }
}