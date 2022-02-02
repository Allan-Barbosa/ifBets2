import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class App {
    public static void main(String[] args) throws Exception {
        List<Cliente> clientes = new ArrayList<>();
        List<Jogo> jogos = new ArrayList<>();
        while (true) {
            String opcao = JOptionPane
                    .showInputDialog("Escolha sua opção: \n 1 - cliente \n 2 - jogo \n 3 - aposta \n 0 - encerrar");
            if (opcao.equals("1")) {
                String escolha = JOptionPane.showInputDialog(
                        "Escolha sua opção: \n 1 - cadastrar cliente \n 2 - listar clientes \n 3 - alterar cliente \n 4 - remover cliente \n 0 - encerrar");
                if (escolha.equals("1")) {
                    // melhorar.
                    String nome = JOptionPane.showInputDialog("Digite seu nome");
                    Cliente cliente = new Cliente(nome, "email",
                            new Endereco("lagradouro", 0, "bairro", "cidade", "uf"), LocalDate.of(1111, 11, 11));
                    clientes.add(cliente);
                }
                if (escolha.equals("2")) {
                    String nomes = "";
                    for (Cliente cliente : clientes) {
                        nomes = nomes + cliente.getNome() + "\n";
                    }
                    JOptionPane.showMessageDialog(null, nomes);
                } else if (escolha.equals("3")) {
                    String nomes = "";
                    for (Cliente cliente : clientes) {
                        nomes = nomes + cliente.getNome() + "\n";
                    }
                    String clientemod = JOptionPane
                            .showInputDialog("Digite o nome do cliente que deseja modificar. \n" + nomes);
                    Cliente clientecerto = null;
                    for (Cliente cliente : clientes) {
                        String nomemod = cliente.getNome();
                        if (clientemod.equals(nomemod)) {
                            clientecerto = cliente;
                        }
                    }
                    String modificar = JOptionPane.showInputDialog(
                            "Digite a opção que deseja modificar: \n 1 - nome \n 2 - email \n 3 - endereço \n 0 - encerrar");
                    if (modificar.equals("1")) {
                        String novonome = JOptionPane.showInputDialog("Digite o novo nome.");
                        clientecerto.setNome(novonome);
                    }else if (modificar.equals("2")) {
                        String novoemail = JOptionPane.showInputDialog("Digite o novo email.");
                        clientecerto.setNome(novoemail);
                    }
                    // implementar mais tarde
                    // else if (modificar.equals("3")) {
                    //     String novoendereco = JOptionPane.showInputDialog("Digite o novo endereço.");
                    //     clientecerto.setNome(novoendereco);
                    // }
                }else if (escolha.equals("4")) {
                    String nomes = "";
                    for (Cliente cliente : clientes) {
                        nomes = nomes + cliente.getNome() + "\n";
                    }
                    String clientemod = JOptionPane
                            .showInputDialog("Digite o nome do cliente que deseja remover. \n" + nomes);
                    for (Cliente cliente : clientes) {
                        String nomemod = cliente.getNome();
                        if (clientemod.equals(nomemod)) {
                            // descobrir porque dá erro. com 3 clientes a exclusão funciona; com 2 dá erro, mas funciona se eu criar outra lista; com 1 dá erro das duas formas
                            clientes.remove(cliente);
                        }
                    }
                }else if (escolha.equals("0")) {
                    break;
                }
            }
            else if (opcao.equals("2")) {
                String escolha = JOptionPane.showInputDialog(
                    "Escolha sua opção: \n 1 - cadastrar jogo \n 2 - listar jogos \n 3 - alterar jogo \n 4 - remover jogo \n 0 - encerrar");
                    if (escolha.equals("1")) {
                        // melhorar.
                        String nome = JOptionPane.showInputDialog("Digite 'nome do time A' vs 'nome do time B'");
                        String[] n = nome.split("vs"); 
                        Jogo jogo = new Jogo(n[0], n[1], LocalDateTime.now().plusDays(1).plusMonths(1).plusHours(2), 0.2f, 0.2f, 0.5f);
                        jogos.add(jogo);
                    }
                    if (escolha.equals("2")) {
                        String nomes = "";
                        for (Jogo jogo : jogos) {
                            nomes = nomes + jogo.getTimeA() + " vs " + jogo.getTimeB() + "\n";
                        }
                        JOptionPane.showMessageDialog(null, nomes);
                    } else if (escolha.equals("3")) {
                        String nomes = "";
                        for (Cliente cliente : clientes) {
                            nomes = nomes + cliente.getNome() + "\n";
                        }
                        String clientemod = JOptionPane
                                .showInputDialog("Digite o nome do cliente que deseja modificar. \n" + nomes);
                        Cliente clientecerto = null;
                        for (Cliente cliente : clientes) {
                            String nomemod = cliente.getNome();
                            if (clientemod.equals(nomemod)) {
                                clientecerto = cliente;
                            }
                        }
                        String modificar = JOptionPane.showInputDialog(
                                "Digite a opção que deseja modificar: \n 1 - nome \n 2 - email \n 3 - endereço \n 0 - encerrar");
                        if (modificar.equals("1")) {
                            String novonome = JOptionPane.showInputDialog("Digite o novo nome.");
                            clientecerto.setNome(novonome);
                        }else if (modificar.equals("2")) {
                            String novoemail = JOptionPane.showInputDialog("Digite o novo email.");
                            clientecerto.setNome(novoemail);
                        }
                        // implementar mais tarde
                        // else if (modificar.equals("3")) {
                        //     String novoendereco = JOptionPane.showInputDialog("Digite o novo endereço.");
                        //     clientecerto.setNome(novoendereco);
                        // }
                    }else if (escolha.equals("4")) {
                        String nomes = "";
                        for (Cliente cliente : clientes) {
                            nomes = nomes + cliente.getNome() + "\n";
                        }
                        String clientemod = JOptionPane
                                .showInputDialog("Digite o nome do cliente que deseja remover. \n" + nomes);
                        for (Cliente cliente : clientes) {
                            String nomemod = cliente.getNome();
                            if (clientemod.equals(nomemod)) {
                                // descobrir porque dá erro. com 3 clientes a exclusão funciona; com 2 dá erro, mas funciona se eu criar outra lista; com 1 dá erro das duas formas
                                clientes.remove(cliente);
                            }
                        }
                    }else if (escolha.equals("0")) {
                        break;
                    }
            }
            
            else if (opcao.equals("0")) {
                break;
            }
        }
    }
}