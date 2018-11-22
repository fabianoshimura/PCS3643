package br.usp.pcs.mvc.venderseguro;

import br.usp.pcs.mvc.Apolice;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;

public class SetClienteHandler extends VenderSeguroHandler {
    public SetClienteHandler(HttpServletRequest request, HttpServletResponse response, Apolice apolice) {
        super(request, response, apolice);
    }
    private String nome;
    private String email;
    private String cpf;
    private String endereco;
    private String data;

    @Override
    public void execute() {
        try {
            apolice.setDadosCliente(nome, email, cpf, endereco, data);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean validateInputs() {
        nome = request.getParameter("nome");
        email = request.getParameter("email");
        cpf = request.getParameter("cpf");
        endereco = request.getParameter("endereco");
        data = request.getParameter("data");

        return nome != null && email != null && cpf != null && endereco != null && data != null;
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
