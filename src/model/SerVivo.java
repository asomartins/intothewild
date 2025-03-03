package model;

public class SerVivo {
    private String nome;
    private String especie;
    private String pais;
    private int idade;

    public SerVivo(String nome, String especie, String pais, int idade) {
        this.nome = nome;
        this.especie = especie;
        this.pais = pais;
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public String getEspecie() {
        return especie;
    }

    // Imprime a descrição do ser vivo
    public void imprimirDescricaoSerVivo() {
        System.out.println("\n********** Descrição do Ser Vivo **********");
        System.out.println("Nome: " + this.nome);
        System.out.println("Espécie: " + this.especie);
        System.out.println("País: " + this.pais);
        System.out.println("Idade: " + this.idade);
    }

    public void simulador() {}
}