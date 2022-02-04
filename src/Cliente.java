import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class Cliente {
    private String nome;
    private String email;
    private Endereco endereco;
    private LocalDate dataNascimento;

    public Cliente(String nome, String email, Endereco endereco, LocalDate dataNascimento) {
        this.nome = nome;
        this.email = email;
        this.endereco = endereco;
        this.dataNascimento = dataNascimento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public static List cadastrarCliente(List clientes) {
        String nome = JOptionPane.showInputDialog("Digite seu nome");
        String email = JOptionPane.showInputDialog("Digite seu email");
        String logradouro = JOptionPane.showInputDialog("Digite seu logradouro");
        String numero = JOptionPane.showInputDialog("Digite o número da sua casa");
        int numeroCasa = Integer.parseInt(numero);
        String bairro = JOptionPane.showInputDialog("Digite seu bairro");
        String cidade = JOptionPane.showInputDialog("Digite sua cidade");
        String uf = JOptionPane.showInputDialog("Digite seu estado");
        String dataDeNascimento = JOptionPane.showInputDialog("Digite sua data de nascimento");
        String[] data = dataDeNascimento.split("/");
        int ano = Integer.parseInt(data[2]);
        int mes = Integer.parseInt(data[1]);
        int dia = Integer.parseInt(data[0]);
        Cliente cliente = new Cliente(nome, email,
                new Endereco(logradouro, numeroCasa, bairro, cidade, uf), LocalDate.of(ano, mes, dia));
        clientes.add(cliente);
        return clientes;
    }

    public static String listarCliente(List<Cliente> clientes) {
        String nomes = "";
        for (Cliente cliente : clientes) {
            nomes = nomes + cliente.getNome() + "\n";
        }
        return nomes;
    }

    public static List<Cliente> modificarCliente(List<Cliente> clientes) {
        String nomes = listarCliente(clientes);
        String clientemod = JOptionPane.showInputDialog("Digite o nome do cliente que deseja modificar. \n" + nomes);
        Cliente clientecerto = null;
        for (Cliente cliente : clientes) {
            String nomemod = cliente.getNome();
            if (clientemod.equals(nomemod)) {
                clientecerto = cliente;
            }
        }
        String modificar = JOptionPane.showInputDialog(
                "Digite a opção que deseja modificar: \n 1 - nome \n 2 - email \n 3 - endereço \n 4 - data de nascimento");
        if (modificar.equals("1")) {
            String novonome = JOptionPane.showInputDialog("Digite o novo nome.");
            clientecerto.setNome(novonome);
        } else if (modificar.equals("2")) {
            String novoemail = JOptionPane.showInputDialog("Digite o novo email.");
            clientecerto.setEmail(novoemail);
        } else if (modificar.equals("3")) {
            String logradouro = JOptionPane.showInputDialog("Digite seu logradouro");
            String numero = JOptionPane.showInputDialog("Digite o número da sua casa");
            int numeroCasa = Integer.parseInt(numero);
            String bairro = JOptionPane.showInputDialog("Digite seu bairro");
            String cidade = JOptionPane.showInputDialog("Digite sua cidade");
            String uf = JOptionPane.showInputDialog("Digite seu estado");
            Endereco enderecoNovo = new Endereco(logradouro, numeroCasa, bairro, cidade, uf);
            clientecerto.setEndereco(enderecoNovo);
        } else if (modificar.equals("4")) {
            String dataDeNascimento = JOptionPane.showInputDialog("Digite sua data de nascimento");
            String[] data = dataDeNascimento.split("/");
            int ano = Integer.parseInt(data[2]);
            int mes = Integer.parseInt(data[1]);
            int dia = Integer.parseInt(data[0]);
            LocalDate dataNova = LocalDate.of(ano, mes, dia);
            clientecerto.setDataNascimento(dataNova);
        }
        return clientes;
    }

    public static List<Cliente> removerCliente(List<Cliente> clientes) {
        String nomes = listarCliente(clientes);
        String clientemod = JOptionPane
                .showInputDialog("Digite o nome do cliente que deseja remover. \n" + nomes);
        for (Cliente cliente : clientes) {
            String nomemod = cliente.getNome();
            if (clientemod.equals(nomemod)) {
                clientes.remove(cliente);
                break;
            }
        }
        return clientes;
    }

    public static List cadastrarClienteSimplificado(List clientes) {
        String nome = JOptionPane.showInputDialog("Digite seu nome");
        Cliente cliente = new Cliente(nome, "email",
                new Endereco("lagradouro", 0, "bairro", "cidade", "uf"), LocalDate.of(1111, 11, 11));
        clientes.add(cliente);
        return clientes;
    }
}
