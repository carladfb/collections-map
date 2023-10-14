package map.Pesquisa;

import java.util.HashMap;
import java.util.Map;

public class EstoqueProdutos {
    private Map<Long, Produto> estoqueProdutos;

    public EstoqueProdutos() {
        this.estoqueProdutos = new HashMap<>();
    }

    public void adicionarProduto(long cod, String nome, int quantidade, double preco) {
        estoqueProdutos.put(cod, new Produto(preco, nome, quantidade));
    }

    public void exibirProdutos() {
        System.out.println(estoqueProdutos);
    }

    public double calcularValorTotalEstoque() {
        double valorTotalEstoque = 0;
        if (!estoqueProdutos.isEmpty()) {
            for (Produto p : estoqueProdutos.values()) {
                valorTotalEstoque = p.getQuantidade() * p.getPreco();
            }
        }
        return valorTotalEstoque;
    }

    public Produto obterProdutoMaisCaro() {
        Produto produtoMaisCaro = null;
        double maiorPreco = Double.MIN_VALUE;
        if (!estoqueProdutos.isEmpty()) {
            for (Produto p : estoqueProdutos.values()) {
                if (p.getPreco() > maiorPreco) {
                    produtoMaisCaro = p;
                    maiorPreco = p.getPreco();
                }
            }
        }
        return produtoMaisCaro;
    }

    public Produto obterProdutoMaisBarato() {
        Produto produtoMaisBarato = null;
        double menorPreco = Double.MAX_VALUE;
        for (Produto p : estoqueProdutos.values()) {
            if (p.getPreco() < menorPreco) {
                produtoMaisBarato = p;
                menorPreco = p.getPreco();
            }
        }
        return produtoMaisBarato;
    }

    public Produto obterProdutoMaiorQuantidadeValorTotalNoEstoque() {
        Produto produtoMaiorQuantidadeValorNoEstoque = null;
        double maiorValorTotalProdutoEstoque = 0d;
        if (!estoqueProdutos.isEmpty()) {
            for (Map.Entry<Long, Produto> entry : estoqueProdutos.entrySet()) {
                double valorProdutoEmEstoque = entry.getValue().getPreco() * entry.getValue().getQuantidade();
                if (valorProdutoEmEstoque > maiorValorTotalProdutoEstoque) {
                    maiorValorTotalProdutoEstoque = valorProdutoEmEstoque;
                    produtoMaiorQuantidadeValorNoEstoque = entry.getValue();
                }
            }
        }
        return produtoMaiorQuantidadeValorNoEstoque;
    }

    public static void main(String[] args) {
        EstoqueProdutos estoque = new EstoqueProdutos();

        estoque.adicionarProduto(4562, "Placa Mãe", 1, 895.99);
        estoque.adicionarProduto(6541, "Memória RAM", 5, 256.99);
        estoque.adicionarProduto(9852, "Processador", 10, 1500.99);
        estoque.adicionarProduto(1563, "SSD", 2, 460.99);
        
        estoque.exibirProdutos();

        System.out.println("\nValor total do estoque: R$" + estoque.calcularValorTotalEstoque());

        Produto produtoMaisCaro = estoque.obterProdutoMaisCaro();
        System.out.println("\nProduto mais caro: " + produtoMaisCaro);

        Produto produtoMaisBarato = estoque.obterProdutoMaisBarato();
        System.out.println("\nProduto mais barato: " + produtoMaisBarato);

        Produto produtoMaiorQuantidadeValorTotal = estoque.obterProdutoMaiorQuantidadeValorTotalNoEstoque();
        System.out.println("\nProduto com maior quantidade em valor no estoque: " + produtoMaiorQuantidadeValorTotal);
    }
}
