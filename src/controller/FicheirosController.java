package controller;

public class FicheirosController {

    private static final String FICHEIRO_INTRO_JOGO = "ficheiros/introJogo.txt";
    private static final String FICHEIRO_ANIMAIS = "ficheiros/animais.txt";
    private static final String FICHEIRO_PLANTAS = "ficheiros/plantas.txt";
    private static final String FICHEIRO_INSETOS = "ficheiros/insetos.txt";

    public static String obterFicheiroIntroJogo() {
        return FICHEIRO_INTRO_JOGO;
    }
      public static String obterFicheiroAnimais() {
        return FICHEIRO_ANIMAIS;
    }

    public static String obterFicheiroPlantas() {
        return FICHEIRO_PLANTAS;
    }

    public static String obterFicheiroInsetos() {
        return FICHEIRO_INSETOS;
    }
}
