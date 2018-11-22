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

@WebServlet(name = "AlterarStatusController", urlPatterns = "/alterar-status")
public class AlterarStatusController extends HttpServlet {

    ApoliceDAO dao = new ApoliceDAO();

    String numeroApolice;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String status = request.getParameter("status");
        dao.setStatus(Integer.parseInt(numeroApolice), Apolice.Status.valueOf(status));
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        numeroApolice = request.getParameter("numero");

        if (numeroApolice != null) {
            Apolice apolice = dao.getApolice(Integer.parseInt(numeroApolice));
            request.setAttribute("apolice", apolice);
        }
        goToInitialScreen(request, response);
    }

    private void goToInitialScreen(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher;

        requestDispatcher = getServletContext().getRequestDispatcher("/alterar-status.jsp");
        requestDispatcher.forward(request, response);
    }
}
