package com.example;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class Estoque extends Produto{
    private List<Produto> produtos = new ArrayList<>();
    
    public void adicionarProduto(Produto novoProduto) {
        produtos.add(novoProduto);
    }

    public List<Produto> listarProdutos() {
        return produtos;
    }

    //funcionalidades
    public void verEstoque() {
        StringBuilder estoqueStr = new StringBuilder();
        for (Produto p : estoque.listarProdutos()) {
            estoqueStr.append("Nome: ").append(p.getNome()).append(", Preço: ").append(p.getPreco()).append(", Quantidade: ").append(p.getQuantidade()).append("\n");
        }
        JOptionPane.showMessageDialog(null, "Estoque:\n" + estoqueStr.toString());
    }
}
    
    

