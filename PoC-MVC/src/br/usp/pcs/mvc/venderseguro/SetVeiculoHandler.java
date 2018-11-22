package br.usp.pcs.mvc.venderseguro;

import br.usp.pcs.mvc.Apolice;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SetVeiculoHandler extends VenderSeguroHandler {
    private String ano;
    private int modelo;
    private int marca;

    private ApiFipe api = new ApiFipe();

    public SetVeiculoHandler(HttpServletRequest request, HttpServletResponse response, Apolice apolice) {
        super(request, response, apolice);
    }

    @Override
    public void execute() {
        try {
            FinalAPIResponse dadosVeiculo = api.getValor(marca, modelo, ano);
            apolice.setDadosVeiculo(dadosVeiculo.getMarca(), dadosVeiculo.getModelo(),
                    dadosVeiculo.getAnoModelo(), dadosVeiculo.getValor());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean validateInputs() {
        ano = request.getParameter("ano");
        modelo = Integer.parseInt(request.getParameter("modelo"));
        marca = Integer.parseInt(request.getParameter("marca"));

        return ano.length() > 0 && modelo > 0 && marca > 0;
    }

    @Override
    void goToPage(ServletContext context, String url) throws ServletException, IOException {
        request.setAttribute("valorFIPE", apolice.getValorContratacao());

        super.goToPage(context, url);
    }
}
