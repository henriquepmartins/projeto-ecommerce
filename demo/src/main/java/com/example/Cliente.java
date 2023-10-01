//Importacao de bibliotecas e packages
package com.example;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

//Criacao da classe Cliente
public class Cliente {
    private String nome;
    private int telefone;
    private boolean clienteJaCadastrado = false;
    static List<Cliente> listaDeClientes = new ArrayList<>();

//Criacao de construtores
    public Cliente(String nome, int telefone) {
        this.nome = nome;
        this.telefone = telefone;
    }
    public Cliente() {
       
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getTelefone() {
        return telefone;
    }

    public void setTelefone(int telefone) {
        this.telefone = telefone;
    }


    //Metodos de cadastro, visualizar e checagem de clientes
    public void cadastrarCliente() {
        String nome = JOptionPane.showInputDialog("Informe o nome do cliente:");
        int telefone = Integer.parseInt(JOptionPane.showInputDialog("Informe o telefone do cliente:"));
        Cliente novoCliente = new Cliente(nome, telefone);
        checkCliente(nome, telefone);
        if (clienteJaCadastrado != true) {
           listaDeClientes.add(novoCliente); 
           JOptionPane.showMessageDialog(null,"Cliente cadastrado com sucesso!");
        }  
    }

    public void verClientes() {
        StringBuilder clientesStr = new StringBuilder();
        for (Cliente c : listaDeClientes) {
            clientesStr.append("Nome: ").append(c.getNome()).append(", Telefone: ").append(c.getTelefone()).append("\n");
        }
        JOptionPane.showMessageDialog(null, "Clientes:\n" + clientesStr.toString());
    }

    public void checkCliente(String nome, int telefone) {     
        for (Cliente c : listaDeClientes) {
            if (c.getNome().equalsIgnoreCase(nome) && c.getTelefone() == telefone ) {
                clienteJaCadastrado = true;
                JOptionPane.showMessageDialog(null, "Cliente já cadastrado.");
                break;
            }
            if (c.getTelefone() == telefone) {
                clienteJaCadastrado = true;
                JOptionPane.showMessageDialog(null, "Número já cadastrado.");
                break;
            }
            clienteJaCadastrado = false;
        }
    }
}