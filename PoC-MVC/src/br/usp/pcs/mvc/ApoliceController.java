package br.usp.pcs.mvc;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

@WebServlet("/apolices")
public class ApoliceController extends HttpServlet {
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher;

        ArrayList<Apolice> apolices;

        ApoliceDAO dao = new ApoliceDAO();

        apolices = dao.getAll();

        if (request.getParameter("numeroApolice") != null) {
            int numeroApolice = Integer.parseInt(request.getParameter("numeroApolice"));

            requestDispatcher = getServletContext().getRequestDispatcher("/detalhe.jsp");
            Apolice apoliceDetail;

            apoliceDetail = dao.getApolice(numeroApolice);

            if (apoliceDetail == null) {
                throw new Error("Not Found");
            }

            request.setAttribute("apolice", apoliceDetail);
        } else {
            requestDispatcher = getServletContext().getRequestDispatcher("/lista.jsp");

            request.setAttribute("apolices", apolices);
        }

        requestDispatcher.forward(request, response);
    }
}