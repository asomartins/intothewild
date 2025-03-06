package controller;

import java.io.FileNotFoundException;

public class MeioAmbienteController {

    private AnimalController animalController = new AnimalController();
    private PlantaController plantaController = new PlantaController();
    private InsetoController insetoController = new InsetoController();

    /**
     * Cria e inicializa um ambiente específico com base no tipo de ambiente e na capacidade de água fornecida.
     * Exibe o menu para controle dos eventos do meio ambiente
     *
     * @param tipoAmbiente
     * @param capacidadeAgua
     * @return meioAmbiente
     * @throws FileNotFoundException
     *
     */
    public MeioAmbiente criarAmbiente(String tipoAmbiente, double capacidadeAgua) throws FileNotFoundException {
        MeioAmbiente meioAmbiente = new MeioAmbiente(tipoAmbiente, capacidadeAgua);
        inicializarSeresAmbiente(meioAmbiente, tipoAmbiente);
        meioAmbiente.exibirMenuMeioAmbiente();
        return meioAmbiente;
    }

    // Chama as funções de criação de diferentes seres vivos ao ambiente escolhido pelo user
    public void inicializarSeresAmbiente(MeioAmbiente meioAmbiente, String tipoAmbiente) throws FileNotFoundException {
        switch (tipoAmbiente) {
            case "Floresta Tropical":
                System.out.println("\nFloresta Tropical criada!");
                System.out.println("\nCriando seres vivos no ambiente...");
                animalController.criarAnimaisFlorestaTropical(meioAmbiente);
                plantaController.criarPlantasFlorestaTropical(meioAmbiente);
                insetoController.criarInsetosFlorestaTropical(meioAmbiente);
                break;
            case "Savana":
                System.out.println("\nSavana criada!");
                System.out.println("\nCriando seres vivos no ambiente...");
                animalController.criarAnimaisSavana(meioAmbiente);
                plantaController.criarPlantasSavana(meioAmbiente);
                insetoController.criarInsetosSavana(meioAmbiente);
                break;
            case "Floresta Temperada":
                System.out.println("\nFloresta Temperada criada!");
                System.out.println("\nCriando seres vivos no ambiente...");
                animalController.criarAnimaisFlorestaTemperada(meioAmbiente);
                plantaController.criarPlantasFlorestaTemperada(meioAmbiente);
                insetoController.criarInsetosFlorestaTemperada(meioAmbiente);
                break;
            default:
                System.out.println("Ambiente desconhecido.");
        }
    }
}