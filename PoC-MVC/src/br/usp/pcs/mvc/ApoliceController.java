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

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher;

        ArrayList<Apolice> apolices = new ArrayList<Apolice>();

        apolices.add(new Apolice("Volkswagen", "UP!", "2015", 15000.0,
                TipoFranquiaCasco.Obrigatoria, true, 20000.0, 10000.0, 10000.0,
                1, "Pedro Darvas", "123.456.789-10", "pedro.darvas@usp.br",
                "Politecnica", new Date(865641600), Status.Ativa));

        apolices.add(new Apolice("Volkswagen", "GOL", "2017", 15000.0,
                TipoFranquiaCasco.Obrigatoria, true, 20000.0, 10000.0, 10000.0,
                2, "Fabiano Shimura", "123.456.789-10", "fabiano.shimura@usp.br",
                "Politecnica", new Date(865641600), Status.Ativa));

        apolices.add(new Apolice("BMW", "UP!", "2018", 15000.0,
                TipoFranquiaCasco.Obrigatoria, true, 20000.0, 10000.0, 10000.0,
                3, "Kechi Hirama", "123.456.789-10", "kechi.hirama@usp.br",
                "Politecnica", new Date(865641600), Status.Ativa));

        apolices.add(new Apolice("Fiat", "Uno", "2011", 15000.0,
                TipoFranquiaCasco.Obrigatoria, true, 20000.0, 10000.0, 10000.0,
                4, "Selma Melnikoff", "123.456.789-10", "selma.melnikoff@usp.br",
                "Politecnica", new Date(865641600), Status.Ativa));

        apolices.add(new Apolice("Volkswagen", "Chevette", "1900", 15000.0,
                TipoFranquiaCasco.Obrigatoria, true, 20000.0, 10000.0, 10000.0,
                5, "Cristiano Ronaldo", "123.456.789-10", "cristiano.ronaldo@usp.br",
                "Politecnica", new Date(865641600), Status.Ativa));

        apolices.add(new Apolice("Volkswagen", "UP!", "2015", 15000.0,
                TipoFranquiaCasco.Obrigatoria, true, 20000.0, 10000.0, 10000.0,
                13, "Fernando Haddad", "123.456.789-10", "pedro.darvas@usp.br",
                "Politecnica", new Date(865641600), Status.Ativa));

        if (request.getParameter("numeroApolice") != null) {
            int numeroApolice = Integer.parseInt(request.getParameter("numeroApolice"));

            requestDispatcher = getServletContext().getRequestDispatcher("/detalhe.jsp");
            Apolice apoliceDetail = null;

            for (Apolice apolice : apolices) {
                if (apolice.getNumeroApolice() == numeroApolice) {
                    apoliceDetail = apolice;
                    break;
                }
            }

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