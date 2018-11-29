package br.usp.pcs.mvc.alterarstatus;

import br.usp.pcs.mvc.Apolice;
import br.usp.pcs.mvc.ApoliceDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@WebServlet(name = "AlterarStatusController", urlPatterns = "/alterar-status")
public class AlterarStatusController extends HttpServlet {

    ApoliceDAO dao = new ApoliceDAO();

    String numeroApolice;

    Apolice apolice;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Apolice.Status status = Apolice.Status.valueOf(request.getParameter("status"));
        request.setAttribute("success", false);
        request.setAttribute("error", false);
        request.setAttribute("queryError", false);

        switch (status) {
            case Cancelada:
            case Ativa:
                if (new Date().after(apolice.getDataVencimento())) {
                    setError(request, response);
                    return;
                }
                break;
            case Encerrada:
                if (new Date().before(apolice.getDataVencimento())) {
                    setError(request, response);
                    return;
                }
                break;
        }

        apolice = dao.setStatus(Integer.parseInt(numeroApolice), status);
        request.setAttribute("apolice", apolice);
        request.setAttribute("success", true);
        goToInitialScreen(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        numeroApolice = request.getParameter("numero");
        request.setAttribute("success", false);
        request.setAttribute("error", false);
        request.setAttribute("queryError", false);

        if (numeroApolice != null) {
            try {
                apolice = dao.getApolice(Integer.parseInt(numeroApolice));
                request.setAttribute("apolice", apolice);
            } catch(java.sql.SQLException | NumberFormatException e) {
                request.setAttribute("queryError", true);
            }
        }
        goToInitialScreen(request, response);
    }

    private void goToInitialScreen(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher;

        requestDispatcher = getServletContext().getRequestDispatcher("/alterar-status.jsp");
        requestDispatcher.forward(request, response);
    }

    private void setError(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher;

        request.setAttribute("error", true);
        request.setAttribute("apolice", apolice);

        requestDispatcher = getServletContext().getRequestDispatcher("/alterar-status.jsp");
        requestDispatcher.forward(request, response);
    }
}
