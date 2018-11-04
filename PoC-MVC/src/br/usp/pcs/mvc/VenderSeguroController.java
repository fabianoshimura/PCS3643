package br.usp.pcs.mvc;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;

@WebServlet(name = "VenderSeguro", urlPatterns = "/vender-seguro")
public class VenderSeguroController extends HttpServlet {

  private Apolice apolice;

  ApiFipe api = new ApiFipe();
  APIResponse[] marcas = {};
  APIResponse[] modelos = {};
  APIResponse[] anos = {};
  HttpServletRequest request;
  HttpServletResponse response;
  Veiculo veiculo = new Veiculo();

  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    this.request = request;
    this.response = response;

    String step = request.getParameter("step");

    if (step == null) {
      step = "0";
    }

    switch (step) {
      case "1":
        try {
          setDadosCliente();
        } catch (ParseException e) {
          e.printStackTrace();
        }
        try {
          marcas = api.getMarcas();
        } catch (IOException e) {
          e.printStackTrace();
        }
        goToVeiculoStep();
        break;
      case "2":
        String ano = request.getParameter("ano");
        veiculo.setAno(ano);
        setDadosVeiculo();
        break;
      case "3":
        break;
      case "4":
        break;
      default:
        goToClienteStep();
        break;
    }
  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    this.request = request;
    this.response = response;

    String marca = request.getParameter("marca");
    if(marca != null) {
      veiculo.setMarca(Integer.parseInt(marca));
      getModelosVeiculos(Integer.parseInt(marca));
      return;
    }
    String modelo = request.getParameter("modelo");
    if(modelo != null) {
      veiculo.setModelo(Integer.parseInt(modelo));
      getAnosVeiculos(Integer.parseInt(modelo));
      return;
    }

    goToClienteStep();
  }

  private void goToClienteStep() throws ServletException, IOException {
    RequestDispatcher requestDispatcher;

    requestDispatcher = getServletContext().getRequestDispatcher("/vender-seguro-cliente.jsp");
    request.setAttribute("nome", "Pedro");
    requestDispatcher.forward(request, response);
  }

  private void goToVeiculoStep() throws ServletException, IOException {
    RequestDispatcher requestDispatcher;

    requestDispatcher = getServletContext().getRequestDispatcher("/vender-seguro-veiculo.jsp");

    request.setAttribute("marcas", marcas);
    request.setAttribute("modelos", modelos);
    request.setAttribute("anos", anos);

    request.setAttribute("veiculo", veiculo);

    requestDispatcher.forward(request, response);
  }

  private void setDadosCliente() throws ServletException, IOException, ParseException {
    apolice = new Apolice();

    apolice.setDadosCliente(request.getParameter("nome"), request.getParameter("email"),
      request.getParameter("cpf"), request.getParameter("endereco"), request.getParameter("data"));
  }

  private void setDadosVeiculo() throws IOException, ServletException {
    FinalAPIResponse response = api.getValor(veiculo.getMarca(), veiculo.getModelo(), veiculo.getAno());
    apolice.setDadosVeiculo(response.getMarca(), response.getModelo(), response.getAnoModelo(), response.getValor());
    goToApoliceStep();
  }

  private void getModelosVeiculos(int marca) throws ServletException {
    try {
      modelos = api.getModelos(marca);
      goToVeiculoStep();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  private void getAnosVeiculos(int modelo) throws ServletException {
    try {
      anos = api.getAnos(veiculo.marca, modelo);
      goToVeiculoStep();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  private void goToApoliceStep() throws ServletException, IOException {
    RequestDispatcher requestDispatcher;

    requestDispatcher = getServletContext().getRequestDispatcher("/vender-seguro-parametros.jsp");

    requestDispatcher.forward(request, response);
  }
}


