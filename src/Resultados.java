import java.util.List;

import javax.swing.JOptionPane;

public class Resultados {
  public List<Aposta> exibiResultados(List<Aposta> apostasEncerradas, Jogo jogo) {
  String nomes = ("Resultado das apostas do jogo " + jogo.getTimeA()+" vs " + jogo.getTimeB());
    for (Aposta aposta : apostasEncerradas) {
      nomes = nomes + ("\n-------Aposta-------\n"+"cliente: "+ aposta.getCliente().getNome() + "\ndata da aposta: " +aposta.getData() + "\nvalor apostado: " +aposta.getValor()+"\nvalor recebido: "+aposta.getValorRecebido());
    }
    
    JOptionPane.showMessageDialog(null, nomes);
    return apostasEncerradas;
  }
}