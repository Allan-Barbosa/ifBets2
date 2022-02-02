import java.time.LocalDateTime;

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

  
}
