package br.usp.pcs.mvc.venderseguro;

import br.usp.pcs.mvc.Apolice;
import br.usp.pcs.mvc.ApoliceDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "VenderSeguro", urlPatterns = "/vender-seguro")
public class VenderSeguroController extends HttpServlet {

    Apolice apolice = new Apolice();
    Veiculo veiculo = new Veiculo();
    String currentUrl = "/vender-seguro-cliente.jsp";
    String urlToGo;
    ApoliceDAO dao = new ApoliceDAO();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        handleRequest(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        handleRequest(request, response);
    }

    private void handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        VenderSeguroHandler handler;

        String action = request.getParameter("action");

        if (action == null) {
            goToInitialScreen(request, response);
            return;
        }

        switch (action) {
            case "setCliente":
                handler = new SetClienteHandler(request, response, apolice);
                urlToGo = "/vender-seguro-veiculo.jsp";
                break;
            case "setVeiculo":
                handler = new SetVeiculoHandler(request, response, apolice);
                urlToGo = "/vender-seguro-parametros.jsp";
                break;
            case "getVeiculo":
                handler = new GetVeiculoInfoHandler(request, response, apolice, veiculo);
                urlToGo = "/vender-seguro-veiculo.jsp";
                break;
            case "setParametros":
                handler = new SetParametrosHandler(request, response, apolice);
                urlToGo = "/valores.jsp";
                break;
            case "salvarApolice":
                dao.insertApolice(apolice);
            default:
                goToInitialScreen(request, response);
                return;
        }

        if (!handler.validateInputs()) {
            request.setAttribute("error", true);
            handler.goToPage(getServletContext(), currentUrl);
            return;
        }

        handler.execute();
        currentUrl = urlToGo;
        handler.goToPage(getServletContext(), urlToGo);
    }

    private void goToInitialScreen(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher;

        requestDispatcher = getServletContext().getRequestDispatcher("/vender-seguro-cliente.jsp");
        requestDispatcher.forward(request, response);
    }
}


