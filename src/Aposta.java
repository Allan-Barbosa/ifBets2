import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.swing.JOptionPane;

public class Aposta {
  private LocalDate data;
  private Jogo jogo;
  private Cliente cliente;
  private String resultado;
  private float valor;
  private float valorRecebido;

  public Aposta(LocalDate data, Jogo jogo, Cliente cliente, String resultado, float valor, float valorRecebido) {
    this.data = data;
    this.jogo = jogo;
    this.cliente = cliente;
    this.resultado = resultado;
    this.valor = valor;
    this.valorRecebido = valorRecebido;
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

  public float getValorRecebido() {
    return valorRecebido;
  }

  public void setValorRecebido(float valorRecebido) {
    this.valorRecebido = valorRecebido;
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
    String nomes = Jogo.listarJogo(jogos);
    int verificaJogo = 0;
    Jogo jogoCerto = null;
    String jogoApostado = null;
    while (verificaJogo == 0) {
      jogoApostado = JOptionPane
          .showInputDialog("Digite o nome do jogo em que deseja apostar\n" + nomes);
      for (Jogo jogo : jogos) {
        String nomeJogo = jogo.getTimeA() + "vs" + jogo.getTimeB();
        if (nomeJogo.equals(jogoApostado)) {
          jogoCerto = jogo;
          verificaJogo = 1;
          break;
        }
      }
    }
    int verificador = 0;
    Cliente clienteCerto = null;
    while (verificador == 0) {
      String verificaCliente = "0";
      String nomes2 = Cliente.listarCliente(clientes);
      String clienteEscolhido = JOptionPane.showInputDialog("Digite o nome do cliente que fará a aposta\n" + nomes2);
      String RGEscolhido = JOptionPane.showInputDialog("Digite o RG do cliente que fará a aposta");
      for (Cliente cliente : clientes) {
        String nomeCliente = cliente.getNome();
        if (nomeCliente.equals(clienteEscolhido)) {
          if (RGEscolhido.equals(cliente.getRG())) {
            clienteCerto = cliente;
            verificaCliente = "1";
            break;
          }
        }
      }
      if (verificaCliente.equals("1") && apostas.isEmpty()) {
        verificador = 1;
        break;
      } else {
        for (Aposta aposta : apostas) {
          if (verificaCliente.equals("1")) {
            if (aposta.getJogo().equals(jogoCerto)) {
              if ((aposta.getCliente().getRG()).equals(clienteCerto.getRG())) {
                verificador = 0;
                break;
              } else {
                verificador = 1;
              }
            } else {
              verificador = 1;
            }
          }
        }
      }
    }
    String[] jogoSplit = jogoApostado.split(" ");

    String resultadosA = calculaPorcentagemPrevista(apostas, jogoCerto, 0.9f, 0f, 0f, 1);
    String resultadosB = calculaPorcentagemPrevista(apostas, jogoCerto, 0f, 0.9f, 0f, 2);
    String resultadosEmpate = calculaPorcentagemPrevista(apostas, jogoCerto, 0f, 0f, 0.9f, 3);
    int verificadorOpcao = 0;
    String resultado = null;
    while (verificadorOpcao == 0) {
      resultado = JOptionPane
          .showInputDialog("Digite o resultado em que deseja apostar\n" + jogoApostado + "\n 1 - vitória do "
              + jogoSplit[0] + "/ porcentagem prevista: (" + resultadosA + ")\n 2 - vitória do " + jogoSplit[2]
              + "/ porcentagem prevista: (" + resultadosB + ")\n 3 - empate" + "/ porcentagem prevista: ("
              + resultadosEmpate + ")");
      if (resultado.equals("1") || resultado.equals("2") || resultado.equals("3")) {
        verificadorOpcao = 1;
      }
    }
    int verificadorData = 0;
    String dataAposta = null;
    while (verificadorData == 0) {
      dataAposta = JOptionPane.showInputDialog("Digite a data da aposta");
      SimpleDateFormat validacaoData = new SimpleDateFormat("dd/MM/yy");
      try {
        validacaoData.parse(dataAposta);
        verificadorData = 1;
      } catch (ParseException ex) {
        verificadorData = 0;
      }
    }
    String[] data = dataAposta.split("/");
    int ano = Integer.parseInt(data[2]);
    int mes = Integer.parseInt(data[1]);
    int dia = Integer.parseInt(data[0]);

    int verificaNumero = 0;
    String valor = null;
    while (verificaNumero == 0) {
      valor = JOptionPane.showInputDialog("Digite o valor que deseja apostar");
      if (valor.chars().allMatch(Character::isDigit)) {
        verificaNumero = 1;
      }
    }
    float valorApostado = Float.parseFloat(valor);
    Aposta aposta = new Aposta(LocalDate.of(ano, mes, dia), jogoCerto, clienteCerto, resultado, valorApostado, 0);
    apostas.add(aposta);
    return apostas;
  }

  public static void listarApostas(List<Aposta> apostas) {
    String nomes = "-------Apostas--------";
    String resultado = "";
    for (Aposta aposta : apostas) {
      Jogo jogo = aposta.getJogo();
      if (aposta.getResultado().equals("1")) {
        resultado = jogo.getTimeA();
      } else if (aposta.getResultado().equals("2")) {
        resultado = aposta.getJogo().getTimeB();
      } else if (aposta.getResultado().equals("3")) {
        resultado = "empate";
      }
      nomes = nomes + "\ncliente: " + aposta.getCliente().getNome() + "\njogo: "
          + aposta.getJogo().getTimeA() + " vs " + aposta.getJogo().getTimeB()
          + "\nresultado apostado: " + resultado + "\n dinheiro apostado: " + aposta.getValor() + "\ndata: "
          + aposta.getData() + "\n";
    }
    JOptionPane.showMessageDialog(null, nomes);
  }

  public static Jogo jogoEncerrado(List<Jogo> jogos) {
    Jogo jogoCerto = null;
    String nomeJogo = null;
    String nomes = Jogo.listarJogo(jogos);
    int verificaJogo = 0;
    while (verificaJogo == 0) {
      String jogoApostado = JOptionPane
          .showInputDialog("Digite o nome do jogo que deseja encerrar as apostas\n" + nomes);
      for (Jogo jogo : jogos) {
        nomeJogo = jogo.getTimeA() + "vs" + jogo.getTimeB();
        if (nomeJogo.equals(jogoApostado)) {
          jogoCerto = jogo;
          verificaJogo = 1;
          break;
        }
      }
    }
    return jogoCerto;
  }

  public static String calculaPorcentagemPrevista(List<Aposta> apostas, Jogo jogoCerto, float a, float b, float c,
      int x) {
    List<Aposta> apostasEncerradas = new ArrayList<>();
    for (Aposta aposta : apostas) {
      Jogo jogoAposta = aposta.getJogo();
      String nomeJogoCerto = jogoAposta.getTimeA() + jogoAposta.getTimeB();
      String nomeJogoApostado = jogoCerto.getTimeA() + jogoCerto.getTimeB();
      if (nomeJogoCerto.equals(nomeJogoApostado)) {
        apostasEncerradas.add(aposta);
      }
    }
    float apostasVitóriaA = 0.1f + a;
    float apostasEmpate = 0.1f + c;
    float apostasVitóriaB = 0.1f + b;
    float apostasTotal = 1f;
    for (Aposta aposta : apostasEncerradas) {
      apostasTotal += 1f;
      if (aposta.getResultado().equals("1")) {
        apostasVitóriaA += 0.9f;
      }
      if (aposta.getResultado().equals("2")) {
        apostasVitóriaB += 0.9f;
      }
      if (aposta.getResultado().equals("3")) {
        apostasEmpate += 0.9f;
      }
    }
    float porcentagemA = 0;
    float porcentagemB = 0;
    float porcentagemEmpate = 0;
    porcentagemA = 100 * ((1f - (apostasVitóriaA / apostasTotal)) / 2);
    porcentagemB = 100 * ((1f - (apostasVitóriaB / apostasTotal)) / 2);
    porcentagemEmpate = 100 * ((1f - (apostasEmpate / apostasTotal)) / 2);
    int intPorcentagemA = ((int) porcentagemA);
    int intPorcentagemB = ((int) porcentagemB);
    int intPorcentagemEmpate = ((int) porcentagemEmpate);
    String valoresA = String.valueOf(intPorcentagemA);
    String valoresB = String.valueOf(intPorcentagemB);
    String valoresEmpate = String.valueOf(intPorcentagemEmpate);
    String valorEscolhido = null;
    if (x == 1) {
      valorEscolhido = valoresA;
    }
    if (x == 2) {
      valorEscolhido = valoresB;
    }
    if (x == 3) {
      valorEscolhido = valoresEmpate;
    }
    valorEscolhido = valorEscolhido + "%";
    return valorEscolhido;
  }

  public static List<Aposta> encerrarApostas(List<Aposta> apostas, Jogo jogoCerto) {
    List<Aposta> apostasEncerradas = new ArrayList<>();
    Random random = new Random();
    for (Aposta aposta : apostas) {
      Jogo jogoAposta = aposta.getJogo();
      String nomeJogoCerto = jogoAposta.getTimeA() + jogoAposta.getTimeB();
      String nomeJogoApostado = jogoCerto.getTimeA() + jogoCerto.getTimeB();
      if (nomeJogoCerto.equals(nomeJogoApostado)) {
        apostasEncerradas.add(aposta);
      }
    }
    float apostasVitóriaA = 0.1f;
    float apostasEmpate = 0.1f;
    float apostasVitóriaB = 0.1f;
    float apostasTotal = 0f;
    for (Aposta aposta : apostasEncerradas) {
      apostasTotal += 1;
      if (aposta.getResultado().equals("1")) {
        apostasVitóriaA += 0.9f;
      }
      if (aposta.getResultado().equals("2")) {
        apostasVitóriaB += 0.9f;
      }
      if (aposta.getResultado().equals("3")) {
        apostasEmpate += 0.9f;
      }
    }
    float porcentagemA = 0;
    float porcentagemB = 0;
    float porcentagemEmpate = 0;
    porcentagemA = 1f + ((1f - (apostasVitóriaA / apostasTotal)) / 2);
    porcentagemB = 1f + ((1f - (apostasVitóriaB / apostasTotal)) / 2);
    porcentagemEmpate = 1f + ((1f - (apostasEmpate / apostasTotal)) / 2);
    for (Aposta aposta : apostasEncerradas) {
      aposta.getJogo().setVitoriaA(porcentagemA);
      aposta.getJogo().setVitoriaB(porcentagemB);
      aposta.getJogo().setEmpate(porcentagemEmpate);
    }
    int numeroInt = random.nextInt(1, 3);
    String numero = Integer.toString(numeroInt);
    float porcentagem = 0;
    if (numero.equals("1")) {
      porcentagem = porcentagemA;
    } else if (numero.equals("2")) {
      porcentagem = porcentagemB;
    }
    if (numero.equals("3")) {
      porcentagem = porcentagemEmpate;
    }
    for (Aposta aposta : apostasEncerradas) {
      if (aposta.getResultado().equals(numero)) {
        float valor = (aposta.getValor() * porcentagem);
        aposta.setValorRecebido(valor);
      } else {
        aposta.setValorRecebido(0f);
      }
    }
    new Resultados().exibiResultados(apostasEncerradas, jogoCerto);
    for (Aposta aposta : apostasEncerradas) {
      apostas.remove(aposta);
    }
    apostasEncerradas = null;
    return apostas;
  }
}
