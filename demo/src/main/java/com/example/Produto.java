package com.example;
import javax.swing.JOptionPane;

public class Produto {
    private String nome;
    private double preco;
    private int quantidade;
    private boolean existeProd = false;
    static Estoque estoque = new Estoque();

    public Produto(String nome, double preco, int quantidade) {
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
    }

    public Produto() {
       
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    //funcionalidades
    public void cadastrarProduto() {
        String nomeProduto = JOptionPane.showInputDialog("Informe o nome do produto:");
        checkProduto(nomeProduto);
        if (existeProd) {
            int confirmacao = JOptionPane.showConfirmDialog(null, "Produto já existe. Deseja adicionar mais unidades ao estoque?", "Produto Existente", JOptionPane.YES_NO_OPTION);
            if (confirmacao == JOptionPane.YES_OPTION) {
                int quantidadeAdicional = Integer.parseInt(JOptionPane.showInputDialog("Informe a quantidade que deseja adicionar do produto " + nomeProduto + ":"));
                Produto produtoExistente = encontrarProdutoNoEstoque(nomeProduto);
                produtoExistente.setQuantidade(produtoExistente.getQuantidade() + quantidadeAdicional);
                JOptionPane.showMessageDialog(null, "Nova quantidade adicionada!");
            } else {
                JOptionPane.showMessageDialog(null, "Operação cancelada.");
            }
        } else {
            double precoProduto = Double.parseDouble(JOptionPane.showInputDialog("Informe o preço do produto:"));
            int quantidadeProduto = Integer.parseInt(JOptionPane.showInputDialog("Informe a quantidade do produto:"));
            Produto novoProduto = new Produto(nomeProduto, precoProduto, quantidadeProduto);
            estoque.adicionarProduto(novoProduto);
            JOptionPane.showMessageDialog(null, "Produto cadastrado com sucesso!");
        }
    }
    
    private Produto encontrarProdutoNoEstoque(String nomeProduto) {
        for (Produto p : estoque.listarProdutos()) {
            if (p.getNome().equalsIgnoreCase(nomeProduto)) {
                return p;
            }
        }
        return null;
    }

    public void checkProduto(String nome) {    
        
        for (Produto c : estoque.listarProdutos()) {
            if (c.getNome().equalsIgnoreCase(nome)) {
                existeProd = true;
                break;
            }
            existeProd = false;
        }
    } 
}