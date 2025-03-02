package model;

import model.enums.Familia;
import model.enums.GrauDefesa;

public class Planta extends SerVivo{
    private Familia familia;
    public GrauDefesa grauDefesa;

    public Planta(String especie, int idade, String nome, String pais, Familia familia, GrauDefesa grauDefesa) {
        super(nome, especie, pais, idade);
        this.familia = familia;
        this.grauDefesa = grauDefesa;
    }

    public Familia getFamilia() {
        return familia;
    }

    public GrauDefesa getGrauDefesa() {
        return grauDefesa;
    }
}
