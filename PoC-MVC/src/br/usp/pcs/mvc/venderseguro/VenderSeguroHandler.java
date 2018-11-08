package br.usp.pcs.mvc.venderseguro;

import br.usp.pcs.mvc.Apolice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class VenderSeguroHandler {
    protected HttpServletRequest request;
    protected HttpServletResponse response;
    protected Apolice apolice;



    public VenderSeguroHandler(HttpServletRequest request, HttpServletResponse response, Apolice apolice) {
        this.request = request;
        this.response = response;
        this.apolice = apolice;
    }

    abstract void execute();
    abstract void validateInputs();
}
