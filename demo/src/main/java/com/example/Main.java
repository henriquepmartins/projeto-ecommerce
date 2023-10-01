//Importacao de bibliotecas e packages
package com.example;
import org.json.JSONArray;
import org.json.JSONObject;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.swing.SwingUtilities;

public class Main{
    public static void main(String[] args) {
        //import de valores de variaveis
        try {
            String contentProdutos = new String(Files.readAllBytes(Paths.get("C:demo/src/main/resources/dataProdutos.json")));
            JSONObject jsonDataProdutos = new JSONObject(contentProdutos);
            JSONArray produtos = jsonDataProdutos.getJSONArray("produtos");

            String contentClientes = new String(Files.readAllBytes(Paths.get("C:demo/src/main/resources/dataClientes.json")));
            JSONObject jsonDataClientes = new JSONObject(contentClientes);
            JSONArray clientes = jsonDataClientes.getJSONArray("clientes");

            for (int i = 0; i < produtos.length(); i++) {
                JSONObject produtoJson = produtos.getJSONObject(i);
                String nome = produtoJson.getString("nome");
                int quantidade = produtoJson.getInt("quantidade");
                double preco = produtoJson.getDouble("preco");

                Produto produtoA = new Produto(nome, preco, quantidade);
                Produto.estoque.adicionarProduto(produtoA);
            }
            for (int i = 0; i < clientes.length(); i++) {
                JSONObject clienteJson = clientes.getJSONObject(i);
                String nome = clienteJson.getString("nome");
                int telefone = clienteJson.getInt("telefone");
    
                Cliente cliente = new Cliente(nome, telefone);
                Cliente.listaDeClientes.add(cliente);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        //tela
        SwingUtilities.invokeLater(() -> {
            Main main = new Main();
            Screen screen = new Screen(main);
            screen.setVisible(true);
        });
    }
}
