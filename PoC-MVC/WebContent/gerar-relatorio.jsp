<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ page import="br.usp.pcs.mvc.*"%>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <title>Gerar Relatório</title>
    <link rel="stylesheet" href="style.css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
</head>
<body>
<%ArrayList<Apolice> apolices = (ArrayList<Apolice>) request.getAttribute("apolices");%>
<%boolean queryError = (boolean) request.getAttribute("queryError");%>
<nav class="navbar navbar-expand-lg navbar-light">
    <a class="navbar-brand" href="index.jsp">Sistema de Seguros</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNav">
        <ul class="navbar-nav">
            <li class="nav-item active">
                <a class="nav-link" href="index.jsp">Home <span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="vender-seguro-cliente.jsp">Vender</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#">Alterar Status</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#">Gerar Relatório</a>
            </li>
        </ul>
    </div>
</nav>
<div class="center big">
    <h1>Gerar Relatório</h1>
    <div class="content">
        <form action="gerar-relatorio" method="get">
            <div class="form-group">
                <label for="inicio">Data inicial:</label>
                <input class="form-control" type="date" id="inicio" name="inicio"/>
                <label for="fim">Data final:</label>
                <input class="form-control" type="date" id="fim" name="fim"/>
            </div>
            <button class="btn btn-primary">Buscar</button>
        </form>
        <br>
        <%if(apolices != null) {%>
        <table class="table">
            <thead>
            <tr>
                <th scope="col">Nº da Apólice</th>
                <th scope="col">Nome Segurado</th>
                <th scope="col">Data de Início</th>
                <th scope="col">Data de Vencimento</th>
                <th scope="col">Marca Veículo</th>
                <th scope="col">Modelo Veículo</th>
                <th scope="col">Valor Prêmio</th>
                <th scope="col">Status</th>
            </tr>
            </thead>
            <tbody>
            <%for(Apolice apolice : apolices) {%>
            <tr>
                <th scope="row"><%=apolice.getNumeroApolice()%></th>
                <td><%=apolice.getNomeSegurado()%></td>
                <td><%=apolice.getDataString(apolice.getDataInicio())%></td>
                <td><%=apolice.getDataString(apolice.getDataVencimento())%></td>
                <td><%=apolice.getMarcaVeiculo()%></td>
                <td><%=apolice.getModeloVeiculo()%></td>
                <td>R$ <%=String.format("%.2f", apolice.getValorPremio())%></td>
                <td><%=apolice.getStatus().toString()%></td>
            </tr>
            <%}%>
            </tbody>
        </table>

        <%}%>
    </div>

    <%if(queryError) {%>
    <div class="snackbar error">
        <p>Não foi encontrada nenhuma apólice nesse período!</p>
    </div>
    <%}%>

</div>
</body>
</html>
