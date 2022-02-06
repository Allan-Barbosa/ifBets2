import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class App {
    public static void main(String[] args) throws Exception {
        List<Cliente> clientes = new ArrayList<>();
        List<Jogo> jogos = new ArrayList<>();
        List<Aposta> apostas = new ArrayList<>();
        while (true) {
            String opcao = JOptionPane
                    .showInputDialog("Escolha sua opção: \n 1 - cliente \n 2 - jogo \n 3 - aposta \n 0 - encerrar");
            if (opcao.equals("1")) {
                // Opções de cliente
                String escolha = JOptionPane.showInputDialog(
                        "Escolha sua opção: \n 1 - cadastrar cliente \n 2 - listar clientes \n 3 - alterar cliente \n 4 - remover cliente \n 5 - criar cliente (simplificado) \n 0 - encerrar");
                if (escolha.equals("1")) {
                    Cliente.cadastrarCliente(clientes);
                } else if (escolha.equals("2")) {
                    String nomes = Cliente.listarCliente(clientes);
                    JOptionPane.showMessageDialog(null, nomes);
                } else if (escolha.equals("3")) {
                    Cliente.modificarCliente(clientes);
                } else if (escolha.equals("4")) {
                    Cliente.removerCliente(clientes);
                } else if (escolha.equals("5")) {
                    Cliente.cadastrarClienteSimplificado(clientes);
                } else if (escolha.equals("0")) {
                    break;
                }
            } else if (opcao.equals("2")) {
                String escolha = JOptionPane.showInputDialog(
                        "Escolha sua opção: \n 1 - cadastrar jogo \n 2 - listar jogos \n 3 - alterar jogo \n 4 - remover jogo 5 - cadastrar jogo (simplificado) \n 0 - encerrar");
                if (escolha.equals("1")) {
                    Jogo.cadastrarJogo(jogos);
                } else if (escolha.equals("2")) {
                    String nomes = Jogo.listarJogo(jogos);
                    JOptionPane.showMessageDialog(null, nomes);
                } else if (escolha.equals("3")) {
                    Jogo.modificarJogo(jogos);
                } else if (escolha.equals("4")) {
                    Jogo.removerJogo(jogos);
                } else if (escolha.equals("5")) {
                    Jogo.cadastrarJogoSimplificado(jogos);
                } else if (escolha.equals("0")) {
                    break;
                }
            } else if (opcao.equals("3")) {
                String escolha = JOptionPane.showInputDialog(
                        "Escolha sua opção: \n 1 - criar aposta \n 2 - listar apostas \n 3 - encerrar apostas \n 0 - encerrar");
                if (escolha.equals("1")) {
                    Aposta.cadastrarAposta(apostas, jogos, clientes);
                } else if (escolha.equals("2")) {
                    Aposta.listarApostas(apostas);
                } else if (escolha.equals("3")) {
                    Jogo.modificarJogo(jogos);
                }

                else if (escolha.equals("0")) {
                    break;
                }
            }
            else if (opcao.equals("0")) {
                break;
            }
        }
    }
}