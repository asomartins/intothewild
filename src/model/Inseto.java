package model;

public class Inseto extends SerVivo{
    private boolean venenoso;

    public Inseto(String nome, String especie, String pais, int idade, boolean venenoso) {
        super(nome, especie, pais, idade);
        this.venenoso = venenoso;
    }

    public boolean isVenenoso() {
        return venenoso;
    }

    // Imprime a descrição do inseto
    public void imprimirDescricaoInseto() {
        System.out.println("Venenoso: " + (this.venenoso ? "Sim" : "Não"));
    }
}
