<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.Date"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="br.usp.pcs.mvc.Apolice"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lista Apólice</title>
</head>
<body>

<h1> Lista Apolice  </h1>

<table>
        <tr>
            <th>Numero Apolice</th>
            <th>Nome Cliente</th>
        </tr>
        <%
            ArrayList<Apolice> apolices = (ArrayList<Apolice>) request.getAttribute("apolices");
            for(Apolice apolice : apolices) {%>
        <tr>
            <td><%=apolice.getNumeroApolice()%></td>
            <td><a href="apolices?numeroApolice=<%=apolice.getNumeroApolice()%>"><%=apolice.getNomeSegurado()%></a></td>
            
            
            
            
        </tr>
        <%}%>
    </table>














</body>
</html>