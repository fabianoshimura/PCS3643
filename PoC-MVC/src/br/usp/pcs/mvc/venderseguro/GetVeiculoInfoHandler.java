package br.usp.pcs.mvc.venderseguro;

import br.usp.pcs.mvc.Apolice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GetVeiculoInfoHandler extends VenderSeguroHandler{
    Veiculo veiculo;
    public GetVeiculoInfoHandler(HttpServletRequest request, HttpServletResponse response, Apolice apolice, Veiculo veiculo) {
        super(request, response, apolice);
        this.veiculo = veiculo;
    }

    @Override
    void execute() {

    }

    @Override
    void validateInputs() {

    }
}
