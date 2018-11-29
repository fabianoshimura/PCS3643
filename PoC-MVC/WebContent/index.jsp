<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%Integer numApolice = (Integer) request.getAttribute("numApolice");%>
<html lang="pt-br">
<head>
  <meta charset="UTF-8">
  <title>Vender Seguro - 1</title>
  <link rel="stylesheet" href="style.css">
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">

</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light ">
  <a class="navbar-brand" href="#">Sistema de Seguros</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse" id="navbarNav">
    <ul class="navbar-nav">
      <li class="nav-item active">
        <a class="nav-link" href="index.jsp">Home <span class="sr-only">(current)</span></a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="vender-seguro">Vender</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="alterar-status">Alterar Status</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="gerar-relatorio">Gerar Relatório</a>
      </li>
    </ul>
  </div>
</nav>
<div class="center">
  <h1>Seja bem vindo ao sistema de seguros!</h1>
  <h2>Selecione o que deseja fazer:</h2>
  <div class="d-flex justify-content-between content">
    <a href="vender-seguro"><button class="btn btn-primary">Vender Seguro</button></a>
    <a href="alterar-status"><button class="btn btn-primary">Alterar Status</button></a>
    <a href="gerar-relatorio"><button class="btn btn-primary">Gerar Relatório</button></a>
  </div>
  <%if (numApolice != null) {%>
  <div class="snackbar success">
    <p>Apólice nº <%=numApolice%> cadastrada com sucesso!</p>
  </div>
  <%}%>
</div>
</body>
</html>
