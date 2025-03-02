package model;

public class Inseto extends SerVivo{
    private boolean venenoso;

    public Inseto(String especie, int idade, String nome, String pais, boolean venenoso) {
        super(nome, especie, pais, idade);
        this.venenoso = venenoso;
    }
}
