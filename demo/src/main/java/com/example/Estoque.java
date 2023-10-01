//Importacao de bibliotecas e packages
package com.example;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

//Heranca da classe Estoque para a classe produto
public class Estoque extends Produto{
    //Array List de produtos
    private List<Produto> produtos = new ArrayList<>();
    
    //Metodo de adicionar produtos no array e listar os que ja existem
    public void adicionarProduto(Produto novoProduto) {
        produtos.add(novoProduto);
    }

    public List<Produto> listarProdutos() {
        return produtos;
    }

    //Metodo de visualizar estoque
    public void verEstoque() {
        StringBuilder estoqueStr = new StringBuilder();
        for (Produto p : estoque.listarProdutos()) {
            estoqueStr.append("Nome: ").append(p.getNome()).append(", Preço: ").append(p.getPreco()).append(", Quantidade: ").append(p.getQuantidade()).append("\n");
        }
        JOptionPane.showMessageDialog(null, "Estoque:\n" + estoqueStr.toString());
    }
}
    
    

