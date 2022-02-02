import java.time.LocalDate;

public class Aposta {
  private LocalDate data;
  private Jogo jogo;
  private Cliente cliente;
  private String resultado;
  
  public Aposta(LocalDate data, Jogo jogo, Cliente cliente, String resultado) {
    this.data = data;
    this.jogo = jogo;
    this.cliente = cliente;
    this.resultado = resultado;
  }

  public LocalDate getData() {
    return data;
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

  
}
