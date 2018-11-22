package br.usp.pcs.mvc.venderseguro;

import br.usp.pcs.mvc.Apolice;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class GetVeiculoInfoHandler extends VenderSeguroHandler {
    Veiculo veiculo;
    ApiFipe api = new ApiFipe();

    APIResponse[] marcas = {};
    APIResponse[] modelos = {};
    APIResponse[] anos = {};

    public GetVeiculoInfoHandler(HttpServletRequest request, HttpServletResponse response, Apolice apolice, Veiculo veiculo) {
        super(request, response, apolice);
        this.veiculo = veiculo;
    }

    @Override
    void execute() {
        try {
            marcas = api.getMarcas();
            modelos = api.getModelos(veiculo.getMarca());
            anos = api.getAnos(veiculo.getMarca(), veiculo.getModelo());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    boolean validateInputs() {
        try {
            String ano = request.getParameter("ano");
            if (ano != null) {
                veiculo.setAno(ano);
                return true;
            }

            String modelo = request.getParameter("modelo");
            if (modelo != null) {
                veiculo.setModelo(Integer.parseInt(modelo));
                return true;
            }

            String marca = request.getParameter("marca");
            if (marca != null) {
                veiculo.setMarca(Integer.parseInt(marca));
            }

            return true;
        } catch (IllegalStateException e) {
            return false;
        }
    }

    @Override
    void goToPage(ServletContext context, String url) throws ServletException, IOException {
        request.setAttribute("marcas", marcas);
        request.setAttribute("modelos", modelos);
        request.setAttribute("anos", anos);

        request.setAttribute("veiculo", veiculo);

        context.getRequestDispatcher(url).forward(request, response);
    }
}
