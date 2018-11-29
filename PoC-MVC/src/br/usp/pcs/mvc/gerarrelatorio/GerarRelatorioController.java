package br.usp.pcs.mvc.gerarrelatorio;

import br.usp.pcs.mvc.Apolice;
import br.usp.pcs.mvc.ApoliceDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@WebServlet(name = "GerarRelatorioController", urlPatterns="/gerar-relatorio")
public class GerarRelatorioController extends HttpServlet {
    ApoliceDAO dao = new ApoliceDAO();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("queryError", false);

        String inicioString = request.getParameter("inicio");
        String fimString = request.getParameter("fim");

        if (inicioString != null && fimString != null) {
            try {
                Date inicio = parseDate(request.getParameter("inicio"));
                Date fim = parseDate(request.getParameter("fim"));

                List<Apolice> apolices = dao.getApolicesPorData(inicio, fim);
                request.setAttribute("apolices", apolices);
            } catch (ParseException | SQLException e) {
                request.setAttribute("queryError", true);
            }
        }

        goToInitialScreen(request, response);
    }

    private void goToInitialScreen(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher;

        requestDispatcher = getServletContext().getRequestDispatcher("/gerar-relatorio.jsp");
        requestDispatcher.forward(request, response);
    }

    private Date parseDate(String data) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        return format.parse(data);
    }
}
