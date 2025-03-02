package model;

import model.enums.Familia;

public class Planta extends SerVivo{
    private Familia familia;
    private int grauDefesa;

    public Planta(String nome, String especie, String pais, int idade, Familia familia, int grauDefesa) {
        super(nome, especie, pais, idade);
        this.familia = familia;
        this.grauDefesa = grauDefesa;
    }

    public Familia getFamilia() {
        return familia;
    }

    public int getGrauDefesa() {
        return grauDefesa;
    }

    // Imprime a descrição da planta
    public void imprimirDescricaoPlanta() {
        System.out.println("Família: " + this.familia);
        System.out.println("Grau de Defesa: " + this.grauDefesa);
    }
}
