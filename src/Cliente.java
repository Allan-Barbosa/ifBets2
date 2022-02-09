import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.List;

import javax.swing.JOptionPane;

public class Cliente {
    private String nome;
    private String email;
    private Endereco endereco;
    private LocalDate dataNascimento;
    private String RG;

    public Cliente(String nome, String email, Endereco endereco, LocalDate dataNascimento, String RG) {
        this.nome = nome;
        this.email = email;
        this.endereco = endereco;
        this.dataNascimento = dataNascimento;
        this.RG = RG;
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

    public String getRG() {
        return RG;
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

    public static List<Cliente> cadastrarCliente(List<Cliente> clientes) {
        String nome = JOptionPane.showInputDialog("Digite seu nome");
        String email = JOptionPane.showInputDialog("Digite seu email");
        int verificaNumero = 0;
        String numero = null;
        while (verificaNumero == 0) {
            numero = JOptionPane.showInputDialog("Digite o número da sua casa");
            if (numero.chars().allMatch(Character::isDigit)) {
                verificaNumero = 1;
            }
        }
        int numeroCasa = Integer.parseInt(numero);
        String bairro = JOptionPane.showInputDialog("Digite seu bairro");
        String cidade = JOptionPane.showInputDialog("Digite sua cidade");
        String uf = JOptionPane.showInputDialog("Digite seu estado");
        int verificadorData = 0;
        String dataDeNascimento = null;
        while (verificadorData == 0) {
            dataDeNascimento = JOptionPane.showInputDialog("Digite sua data de nascimento");
            SimpleDateFormat validacaoData = new SimpleDateFormat("dd/MM/yy");
            try {
                validacaoData.parse(dataDeNascimento);
                verificadorData = 1;
            } catch (ParseException ex) {
                verificadorData = 0;
            }
        }
        String[] data = dataDeNascimento.split("/");
        int ano = Integer.parseInt(data[2]);
        int mes = Integer.parseInt(data[1]);
        int dia = Integer.parseInt(data[0]);
        String RG = null;
        int verificador = 0;
        while (verificador == 0) {
            RG = JOptionPane.showInputDialog("Digite seu RG");
            if (clientes.isEmpty()) {
                break;
            }
            for (Cliente cliente : clientes) {
                String clienteRG = cliente.getRG();
                if (clienteRG.equals(RG)) {
                    verificador = 0;
                    break;
                } else {
                    verificador = 1;
                }
            }
        }
        Cliente cliente = new Cliente(nome, email,
                new Endereco(numeroCasa, bairro, cidade, uf), LocalDate.of(ano, mes, dia), RG);
        clientes.add(cliente);
        return clientes;
    }

    public static String listarCliente(List<Cliente> clientes) {
        String nomes = "-------Clientes-------";
        for (Cliente cliente : clientes) {
            nomes = nomes + "\nnome: " + cliente.getNome() + "\nemail: " + cliente.getEmail() + "\nendereço: " + "casa "
                    + cliente.getEndereco().getNumero() + "/" + cliente.getEndereco().getBairro() + "/"
                    + cliente.getEndereco().getCidade() + "/" + cliente.getEndereco().getUf() + "\ndata de nascimento: "
                    + cliente.getDataNascimento() + "\n------------------------------";
        }
        return nomes;
    }

    public static List<Cliente> modificarCliente(List<Cliente> clientes) {
        String nomes = listarCliente(clientes);
        Cliente clientecerto = null;
        while (clientecerto == null) {
            String clienteMod = JOptionPane
                    .showInputDialog("Digite o nome do cliente que deseja modificar. \n" + nomes);
            for (Cliente cliente : clientes) {
                String nomeMod = cliente.getNome();
                if (clienteMod.equals(nomeMod)) {
                    clientecerto = cliente;
                    break;
                }
            }
        }
        String modificar = JOptionPane.showInputDialog(
                "Digite a opção que deseja modificar: \n 1 - nome \n 2 - email \n 3 - endereço \n 4 - data de nascimento");
        if (modificar.equals("1")) {
            String novoNome = JOptionPane.showInputDialog("Digite o novo nome.");
            clientecerto.setNome(novoNome);
        } else if (modificar.equals("2")) {
            String novoEmail = JOptionPane.showInputDialog("Digite o novo email.");
            clientecerto.setEmail(novoEmail);
        } else if (modificar.equals("3")) {
            int verificaNumero = 0;
            String numero = null;
            while (verificaNumero == 0) {
                numero = JOptionPane.showInputDialog("Digite o número da sua casa");
                if (numero.chars().allMatch(Character::isDigit)) {
                    verificaNumero = 1;
                }
            }
            int numeroCasa = Integer.parseInt(numero);
            String bairro = JOptionPane.showInputDialog("Digite seu bairro");
            String cidade = JOptionPane.showInputDialog("Digite sua cidade");
            String uf = JOptionPane.showInputDialog("Digite seu estado");
            Endereco enderecoNovo = new Endereco(numeroCasa, bairro, cidade, uf);
            clientecerto.setEndereco(enderecoNovo);
        } else if (modificar.equals("4")) {
            int verificadorData = 0;
            String dataDeNascimento = null;
            while (verificadorData == 0) {
                dataDeNascimento = JOptionPane.showInputDialog("Digite sua data de nascimento");
                SimpleDateFormat validacaoData = new SimpleDateFormat("dd/MM/yy");
                try {
                    validacaoData.parse(dataDeNascimento);
                    verificadorData = 1;
                } catch (ParseException ex) {
                    verificadorData = 0;
                }
            }
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
        String clienteMod = JOptionPane
                .showInputDialog("Digite o nome do cliente que deseja remover. \n" + nomes);
        for (Cliente cliente : clientes) {
            String nomeMod = cliente.getNome();
            if (clienteMod.equals(nomeMod)) {
                clientes.remove(cliente);
                break;
            }
        }
        return clientes;
    }

    public static List<Cliente> cadastrarClienteSimplificado(List<Cliente> clientes) {
        String nome = JOptionPane.showInputDialog("Digite seu nome");
        int verificador = 0;
        String RG = null;
        while (verificador == 0) {
            RG = JOptionPane.showInputDialog("Digite seu RG");
            if (clientes.isEmpty()) {
                break;
            }
            for (Cliente cliente : clientes) {
                String clienteRG = cliente.getRG();
                if (clienteRG.equals(RG)) {
                    verificador = 0;
                    break;
                } else {
                    verificador = 1;
                }
            }
        }
        Cliente cliente = new Cliente(nome, "email",
                new Endereco(0, "bairro", "cidade", "uf"), LocalDate.of(1111, 11, 11), RG);
        clientes.add(cliente);
        return clientes;
    }
}