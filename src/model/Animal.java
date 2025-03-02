package model;

import model.enums.Dieta;

public class Animal extends SerVivo{
    private boolean fome;
    private double peso;
    private int inteligencia;
    private Dieta dieta;
    private String barulho;

    public Animal(String nome, String especie, String pais, int idade, boolean fome, double peso, int inteligencia, Dieta dieta, String barulho) {
        super(nome, especie, pais, idade);
        this.fome = fome;
        this.peso = peso;
        this.inteligencia = inteligencia;
        this.dieta = dieta;
        this.barulho = barulho;
    }

    public boolean isFome() {
        return fome;
    }

    public double getPeso() {
        return peso;
    }

    public Dieta getDieta() {
        return dieta;
    }

    public void setFome(boolean fome) {
        this.fome = fome;
    }

    public Animal lutar(Animal adversario) {
        if (this.peso > adversario.peso) {
            return this;
        } else if (this.peso < adversario.peso) {
            return adversario;
        } else if (this.peso == adversario.peso) {
            if (this.inteligencia > adversario.inteligencia) {
                return this;
            } else if (this.inteligencia < adversario.inteligencia) {
                return adversario;
            }
        }
        return null;
    }
}
