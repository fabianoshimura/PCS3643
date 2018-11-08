package br.usp.pcs.mvc.venderseguro;

import br.usp.pcs.mvc.Apolice;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SetClienteHandler extends VenderSeguroHandler {
    public SetClienteHandler(HttpServletRequest request, HttpServletResponse response, Apolice apolice) {
        super(request, response, apolice);
    }

    @Override
    public void execute() {

    }

    @Override
    public boolean validateInputs() {
        return true;
    }

    @Override
    void goToPage(ServletContext context, String url) throws ServletException, IOException {
        request.setAttribute("marcas", new APIResponse[0]);
        request.setAttribute("modelos", new APIResponse[0]);
        request.setAttribute("anos", new APIResponse[0]);

        request.setAttribute("veiculo", new Veiculo());

        context.getRequestDispatcher(url).forward(request, response);
    }
}
