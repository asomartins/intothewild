import java.util.Scanner;

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

    public String getEspecie() {
        return especie;
    }

    public void imprimirDescricaoSerVivo() {
        System.out.println("********** Ser Vivo **********");
        System.out.println("Nome: " + nome);
        System.out.println("Espécie: " + especie);
        System.out.println("País: "+ pais);
        System.out.println("Idade: "+ idade);
    }
    public void simulador() {}
}