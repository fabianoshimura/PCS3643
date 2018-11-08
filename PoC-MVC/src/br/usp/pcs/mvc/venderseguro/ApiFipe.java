package br.usp.pcs.mvc.venderseguro;

import com.google.gson.Gson;
import org.apache.http.HttpHeaders;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import java.io.*;

public class ApiFipe {
  private Parametros parametros;

  public APIResponse[] getMarcas() throws IOException {
    parametros = new ParametrosMarcas();
    String response =  doPOSTRequest(parametros, "http://veiculos.fipe.org.br/api/veiculos/ConsultarMarcas");
    return fromJSON(response);
  }

  public APIResponse[] getModelos(int codigoMarca) throws IOException {
    parametros = new ParametrosModelos(codigoMarca);
    String response =  doPOSTRequest(parametros, "http://veiculos.fipe.org.br/api/veiculos/ConsultarModelos");
    String role = response.substring(response.indexOf(":") + 1, response.indexOf(",\"Anos\""));
    return fromJSON(role);
  }

  public APIResponse[] getAnos(int codigoMarca, int codigoModelo) throws IOException {
    parametros = new ParametrosAno(codigoMarca, codigoModelo);
    String response =  doPOSTRequest(parametros, "http://veiculos.fipe.org.br/api/veiculos/ConsultarAnoModelo");
    return fromJSON(response);
  }

  public FinalAPIResponse getValor(int codigoMarca, int codigoModelo, String ano) throws IOException {
    parametros = new ParametrosValor(codigoMarca, codigoModelo, ano);
    String response = doPOSTRequest(parametros, "http://veiculos.fipe.org.br/api/veiculos/ConsultarValorComTodosParametros");
    Gson gson = new Gson();
    return gson.fromJson(response, FinalAPIResponse.class);
  }

  private String doPOSTRequest(Parametros parameters, String url) throws IOException {
    CloseableHttpClient httpClient = HttpClientBuilder.create().build();
    HttpPost postRequest = new HttpPost(url);

    String json = parameters.toJSON();

    postRequest.setHeader("Host", "veiculos.fipe.org.br");
    postRequest.setHeader("Referer", "http://veiculos.fipe.org.br");
    postRequest.setHeader("Content-Type", "application/json");

    postRequest.setEntity(new StringEntity(json));
    postRequest.setHeader(HttpHeaders.CONTENT_TYPE, "application/json");

    try (CloseableHttpResponse httpResponse = httpClient.execute(postRequest)) {
      String content = EntityUtils.toString(httpResponse.getEntity());

      return content;

    } catch (IOException e) {
      //handle exception
      e.printStackTrace();
    }

    return null;
  }

  private APIResponse[] fromJSON(String content){
    Gson gson = new Gson();
    return gson.fromJson(content, APIResponse[].class);
  }
}

abstract class Parametros {
  public String toJSON() {
    Gson gson = new Gson();
    return gson.toJson(this);
  }

//  abstract APIResponse[] doRequest();
}

class ParametrosMarcas extends Parametros {
  private int codigoTabelaReferencia = 235;
  private int codigoTipoVeiculo = 1;
}

class ParametrosModelos extends ParametrosMarcas {
  public ParametrosModelos(int codigoMarca) {
    this.codigoMarca = codigoMarca;
  }

  private int codigoMarca;

  public int getCodigoMarca() {
    return codigoMarca;
  }

  public void setCodigoMarca(int codigoMarca) {
    this.codigoMarca = codigoMarca;
  }
}

class ParametrosAno extends ParametrosModelos{
  private int codigoModelo;

  public ParametrosAno(int codigoMarca, int codigoModelo) {
    super(codigoMarca);
    this.codigoModelo = codigoModelo;
  }

  public int getCodigoModelo() {
    return codigoModelo;
  }

  public void setCodigoModelo(int codigoModelo) {
    this.codigoModelo = codigoModelo;
  }
}

class ParametrosValor extends ParametrosAno{
  private int codigoTipoCombustivel;
  private int anoModelo;
  private String ano;
  private String tipoConsulta = "tradicional";

  public ParametrosValor(int codigoMarca, int codigoModelo, String ano) {
    super(codigoMarca, codigoModelo);
    setAno(ano);
  }

  public int getCodigoTipoCombustivel() {
    return codigoTipoCombustivel;
  }

  public int getAnoModelo() {
    return anoModelo;
  }

  public String getTipoConsulta() {
    return tipoConsulta;
  }

  public String getAno() {
    return ano;
  }

  public void setAno(String ano) {
    this.ano = ano;
    String[] list = ano.split("-");
    this.anoModelo = Integer.parseInt(list[0]);
    this.codigoTipoCombustivel = Integer.parseInt(list[1]);
  }
}

class FinalAPIResponse {
  private String Valor;
  private String Marca;
  private String Modelo;
  private String AnoModelo;
  private String Combustivel;
  private String CodigoFipe;
  private String MesReferencia;
  private String Autenticacao;
  private String TipoVeiculo;
  private String SiglaCombustivel;
  private String DataConsulta;

  public String getValor() {
    String novo = Valor.replace(".", "").substring(3).replaceAll(",", ".");
    return novo;
  }

  public String getMarca() {
    return Marca;
  }

  public String getModelo() {
    return Modelo;
  }

  public String getAnoModelo() {
    return AnoModelo;
  }

  public String getCombustivel() {
    return Combustivel;
  }

  public String getCodigoFipe() {
    return CodigoFipe;
  }

  public String getMesReferencia() {
    return MesReferencia;
  }

  public String getAutenticacao() {
    return Autenticacao;
  }

  public String getTipoVeiculo() {
    return TipoVeiculo;
  }

  public String getSiglaCombustivel() {
    return SiglaCombustivel;
  }

  public String getDataConsulta() {
    return DataConsulta;
  }
}
