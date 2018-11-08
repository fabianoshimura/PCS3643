package br.usp.pcs.mvc.venderseguro;

import br.usp.pcs.mvc.Apolice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SetClienteHandler extends VenderSeguroHandler {
    public SetClienteHandler(HttpServletRequest request, HttpServletResponse response, Apolice apolice) {
        super(request, response, apolice);
    }

    @Override
    public void execute() {

    }

    @Override
    public void validateInputs() {

    }
}
