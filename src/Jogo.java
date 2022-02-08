import java.time.LocalDateTime;
import java.util.List;

import javax.swing.JOptionPane;

public class Jogo {
  private String timeA;
  private String timeB;
  private LocalDateTime data;
  private float vitoriaA;
  private float vitoriaB;
  private float empate;

  public Jogo(String timeA, String timeB, LocalDateTime data, float vitoriaA, float vitoriaB, float empate) {
    this.timeA = timeA;
    this.timeB = timeB;
    this.data = data;
    this.vitoriaA = vitoriaA;
    this.vitoriaB = vitoriaB;
    this.empate = empate;
  }

  public String getTimeA() {
    return timeA;
  }

  public void setTimeA(String timeA) {
    this.timeA = timeA;
  }

  public String getTimeB() {
    return timeB;
  }

  public void setTimeB(String timeB) {
    this.timeB = timeB;
  }

  public LocalDateTime getData() {
    return data;
  }

  public void setData(LocalDateTime data) {
    this.data = data;
  }

  public float getVitoriaA() {
    return vitoriaA;
  }

  public void setVitoriaA(float vitoriaA) {
    this.vitoriaA = vitoriaA;
  }

  public float getVitoriaB() {
    return vitoriaB;
  }

  public void setVitoriaB(float vitoriaB) {
    this.vitoriaB = vitoriaB;
  }

  public float getEmpate() {
    return empate;
  }

  public void setEmpate(float empate) {
    this.empate = empate;
  }

  public static List<Jogo> cadastrarJogo(List<Jogo> jogos) {
    String nome = JOptionPane.showInputDialog("Digite:'nome do time A 'vs' nome do time B'");
    String[] nomeTimes = nome.split(" vs ");
    String dia = JOptionPane.showInputDialog("Digite o dia do jogo");
    String mes = JOptionPane.showInputDialog("Digite o mês do jogo");
    String hora = JOptionPane.showInputDialog("Digite a hora do jogo");
    int d = Integer.parseInt(dia);
    int m = Integer.parseInt(mes);
    int h = Integer.parseInt(hora);
    Jogo jogo = new Jogo(nomeTimes[0], nomeTimes[1], LocalDateTime.now().plusDays(d).plusMonths(m).plusHours(h), 0f,
        0f, 0f);
    jogos.add(jogo);
    return jogos;
  }

  public static String listarJogo(List<Jogo> jogos) {
    String nomes = "-------Jogos-------\n";
    for (Jogo jogo : jogos) {
      nomes = nomes + jogo.getTimeA() + " vs " + jogo.getTimeB() + "\n------------------------------\n";
    }
    return nomes;
  }

  public static List<Jogo> modificarJogo(List<Jogo> jogos) {
    String nomes = listarJogo(jogos);
    String jogoMod = JOptionPane
        .showInputDialog("Digite o nome do jogo que deseja modificar \n" + nomes);
    Jogo jogoCerto = null;
    for (Jogo jogo : jogos) {
      String nomeMod = jogo.getTimeA() + " vs " + jogo.getTimeB();
      if (jogoMod.equals(nomeMod)) {
        jogoCerto = jogo;
        break;
      }
    }
    String modificar = JOptionPane.showInputDialog(
        "Digite a opção que deseja modificar: \n 1 - nome \n 2 - data do jogo");
    if (modificar.equals("1")) {
      String nome = JOptionPane.showInputDialog("Digite:'nome do time A 'vs' nome do time B'");
      String[] novosNomesTimes = nome.split(" vs ");
      jogoCerto.setTimeA(novosNomesTimes[0]);
      jogoCerto.setTimeB(novosNomesTimes[1]);
    } else if (modificar.equals("2")) {
      String dia = JOptionPane.showInputDialog("Digite o dia do jogo");
      String mes = JOptionPane.showInputDialog("Digite o mês do jogo");
      String hora = JOptionPane.showInputDialog("Digite a hora do jogo");
      int d = Integer.parseInt(dia);
      int m = Integer.parseInt(mes);
      int h = Integer.parseInt(hora);
      LocalDateTime novaData = LocalDateTime.now().plusDays(d).plusMonths(m).plusHours(h);
      jogoCerto.setData(novaData);
    }
    return jogos;
  }

  public static List<Jogo> removerJogo(List<Jogo> jogos) {
    String nomes = listarJogo(jogos);
    String jogoMod = JOptionPane
        .showInputDialog("Digite o nome do jogo que deseja remover \n" + nomes);
    for (Jogo jogo : jogos) {
      String nomeMod = jogo.getTimeA() + " vs " + jogo.getTimeB();
      if (jogoMod.equals(nomeMod)) {
        jogos.remove(jogo);
        break;
      }
    }
    return jogos;
  }

  public static List<Jogo> cadastrarJogoSimplificado(List<Jogo> jogos) {
    String nome = JOptionPane.showInputDialog("Digite:'nome do time A' vs 'nome do time B'");
    String[] n = nome.split("vs");
    Jogo jogo = new Jogo(n[0], n[1], LocalDateTime.now().plusDays(1).plusMonths(1).plusHours(2), 0f,
        0f, 0f);
    jogos.add(jogo);
    return jogos;
  }
}
