package map.Pesquisa;

public class Produto {
    private double preco;
    private String nome;
    private int quantidade;

    public Produto(double preco, String nome, int quantidade) {
        this.preco = preco;
        this.nome = nome;
        this.quantidade = quantidade;
    }

    public double getPreco() {
        return preco;
    }

    public String getNome() {
        return nome;
    }

    public int getQuantidade() {
        return quantidade;
    }

    @Override
    public String toString() {
        return "\nNome = " + nome + "\nPreço = " + preco + "\nQuantidade = " + quantidade;
    }

}
