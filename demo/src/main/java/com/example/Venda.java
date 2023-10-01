//Importacao de bibliotecas e packages
package com.example;
import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.List;

//Heranca da classe Venda para classe produto
public class Venda extends Produto{
    private Produto produto = new Produto();
    private List<String> historicoVendas = new ArrayList<>();
    private List<Double> lucroBruto = new ArrayList<>();;
    private int quantidadeVendida;

//Criacao de construtores
    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Venda(Produto produto, int quantidadeVendida) {
        this.produto = produto;
        this.quantidadeVendida = quantidadeVendida;
    }

    public Venda() {

    }
    //Metodo de vender produtos por meio do arraylist ja criado
    public String venderProdutoA(Produto produto) {
        produto.setQuantidade(produto.getQuantidade() - quantidadeVendida);
        double precoUnitario = produto.getPreco(); 
        double lucroVenda = precoUnitario * quantidadeVendida;
        lucroBruto.add(lucroVenda);
        String venda = "Venda realizada: " + quantidadeVendida + " unidades de " + produto.getNome();
        historicoVendas.add(venda);
        return venda;
    }
    
    public void venderProduto() {
        String nomeProduto = JOptionPane.showInputDialog("Informe o nome do produto a ser vendido:");
        quantidadeVendida = Integer.parseInt(JOptionPane.showInputDialog("Informe a quantidade vendida:"));
    
        Produto produtoVendido = encontrarProdutoNoEstoque(nomeProduto);
    
        if (produtoVendido != null) {
            if (produtoVendido.getQuantidade() >= quantidadeVendida) {
                String resultadoVenda = venderProdutoA(produtoVendido); 
                
                JOptionPane.showMessageDialog(null, resultadoVenda);
            } else {
                JOptionPane.showMessageDialog(null, "Quantidade insuficiente em estoque.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Produto não encontrado.");
        }
    }
    //Metodo para encontrar produto no estoque e listar-lo
    private Produto encontrarProdutoNoEstoque(String nomeProduto) {
        for (Produto p : estoque.listarProdutos()) {
            if (p.getNome().equalsIgnoreCase(nomeProduto)) {
                return p;
            }
        }
        return null;
    }

    public void listarHistoricoVendas() {
        StringBuilder historico = new StringBuilder("Histórico de Vendas:\n");
        for (String venda : historicoVendas) {
            historico.append(venda).append("\n");
        }
        JOptionPane.showMessageDialog(null, historico.toString());
    }
    
    //Metodo para calcular lucro bruto do vendedor
    public double calcularLucroBruto() {
        double lucroTotal = 0.0;
        for (Double lucroVenda : lucroBruto) {
            lucroTotal += lucroVenda;
        }
        return lucroTotal;
    }

    public List<Double> getLucroBruto() {
        return null;
    }
    


}
