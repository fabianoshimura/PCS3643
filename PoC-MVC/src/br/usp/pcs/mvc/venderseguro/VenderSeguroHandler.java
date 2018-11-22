package br.usp.pcs.mvc.venderseguro;

import br.usp.pcs.mvc.Apolice;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

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
    abstract boolean validateInputs();

    void goToPage(ServletContext context, String url) throws ServletException, IOException {
        context.getRequestDispatcher(url).forward(request, response);
    }
}
