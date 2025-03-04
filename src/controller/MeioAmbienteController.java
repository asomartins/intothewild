package controller;

import java.io.FileNotFoundException;

public class MeioAmbienteController {

    private AnimalController animalController = new AnimalController();
    private PlantaController plantaController = new PlantaController();
    private InsetoController insetoController = new InsetoController();

    // Instancia o objeto meio ambiente
    // Chama a função de criação dos seres vivos de acordo com o ambiente criado
    // Invoca o simulador de meio ambiente
    public MeioAmbiente criarAmbiente(String tipoAmbiente, double capacidadeAgua) throws FileNotFoundException {
        MeioAmbiente meioAmbiente = new MeioAmbiente(tipoAmbiente, capacidadeAgua);
        inicializarSeresAmbiente(meioAmbiente, tipoAmbiente);
        meioAmbiente.simulador();
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