import java.time.LocalDate;
import java.util.List;

import javax.swing.JOptionPane;

public class Aposta {
  private LocalDate data;
  private Jogo jogo;
  private Cliente cliente;
  private String resultado;
  private float valor;

  public Aposta(LocalDate data, Jogo jogo, Cliente cliente, String resultado, float valor) {
    this.data = data;
    this.jogo = jogo;
    this.cliente = cliente;
    this.resultado = resultado;
    this.valor = valor;
  }

  public LocalDate getData() {
    return data;
  }

  public float getValor() {
    return valor;
  }

  public void setValor(float valor) {
    this.valor = valor;
  }

  public void setData(LocalDate data) {
    this.data = data;
  }

  public Jogo getJogo() {
    return jogo;
  }

  public void setJogo(Jogo jogo) {
    this.jogo = jogo;
  }

  public Cliente getCliente() {
    return cliente;
  }

  public void setCliente(Cliente cliente) {
    this.cliente = cliente;
  }

  public String getResultado() {
    return resultado;
  }

  public void setResultado(String resultado) {
    this.resultado = resultado;
  }

  public static List<Aposta> cadastrarAposta(List<Aposta> apostas, List<Jogo> jogos, List<Cliente> clientes) {
    String nomes2 = Cliente.listarCliente(clientes);
    String clienteEscolhido = JOptionPane.showInputDialog("Digite o nome do cliente que fará a aposta\n" + nomes2);
    Cliente clienteCerto = null;
    for (Cliente cliente : clientes) {
      String nomeCliente = cliente.getNome();
      if (nomeCliente.equals(clienteEscolhido)) {
        clienteCerto = cliente;
        break;
      }
    }
    String nomes = Jogo.listarJogo(jogos);
    String jogoApostado = JOptionPane
        .showInputDialog("Digite o nome do jogo em que deseja apostar\n" + nomes);
    Jogo jogoCerto = null;
    for (Jogo jogo : jogos) {
      String nomeJogo = jogo.getTimeA() + " vs " + jogo.getTimeB();
      if (nomeJogo.equals(jogoApostado)) {
        jogoCerto = jogo;
        break;
      }
    }

    String resultado = JOptionPane
        .showInputDialog("Digite o resultado em que deseja apostar\n" + jogoApostado + "\n 1 - vitória do "
            + jogoCerto.getTimeA() + "\n 2 - vitória do time " + jogoCerto.getTimeB() + "\n 3 - empate");
    String dataAposta = JOptionPane.showInputDialog("Digite a data da aposta");
    String[] data = dataAposta.split("/");
    int ano = Integer.parseInt(data[2]);
    int mes = Integer.parseInt(data[1]);
    int dia = Integer.parseInt(data[0]);
    String valor = JOptionPane
        .showInputDialog("Digite o valor que deseja apostar");
    float valorApostado = Float.parseFloat(valor);
    Aposta aposta = new Aposta(LocalDate.of(ano, mes, dia), jogoCerto, clienteCerto, resultado, valorApostado);
    apostas.add(aposta);
    return apostas;
  }

  public static void listarApostas(List<Aposta> apostas) {
    String nomes = "";
    String resultado = "";
    for (Aposta aposta : apostas) {
      if (aposta.getResultado().equals("1")){
        resultado = aposta.getJogo().getTimeA();
      }
      if (aposta.getResultado().equals("2")){
        resultado = aposta.getJogo().getTimeB();
      }
      if (aposta.getResultado().equals("3")){
        resultado = "empate";
      }
      nomes = nomes + "-------Aposta--------\n cliente:" + aposta.getCliente().getNome() + "\njogo:" + aposta.getJogo().getTimeA() +" vs " + aposta.getJogo().getTimeB()
          + "\nresultado apostado:" + resultado + "\n dinheiro apostado:" + aposta.getValor() + "\ndata:"
          + aposta.getData();
    }
  }
}
