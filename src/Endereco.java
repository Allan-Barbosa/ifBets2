public class Endereco {
  private String lagradouro;
  private int numero;
  private String bairro;
  private String cidade;
  private String uf;

  public Endereco(String lagradouro, int numero, String bairro, String cidade, String uf) {
    this.lagradouro = lagradouro;
    this.numero = numero;
    this.bairro = bairro;
    this.cidade = cidade;
    this.uf = uf;
  }

  public String getLagradouro() {
    return lagradouro;
  }
  public void setLagradouro(String lagradouro) {
    this.lagradouro = lagradouro;
  }
  public int getNumero() {
    return numero;
  }
  public void setNumero(int numero) {
    this.numero = numero;
  }
  public String getBairro() {
    return bairro;
  }
  public void setBairro(String bairro) {
    this.bairro = bairro;
  }
  public String getCidade() {
    return cidade;
  }
  public void setCidade(String cidade) {
    this.cidade = cidade;
  }
  public String getUf() {
    return uf;
  }
  public void setUf(String uf) {
    this.uf = uf;
  }
}
