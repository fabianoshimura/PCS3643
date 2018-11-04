<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<%@ page import="br.usp.pcs.mvc.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="pt-br">
<head>
  <meta charset="UTF-8">
  <title>Vender Seguro - 2</title>
  <link rel="stylesheet" href="style.css">
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
</head>
<body>
<%APIResponse[] marcas = (APIResponse[]) request.getAttribute("marcas");%>
<%APIResponse[] modelos = (APIResponse[]) request.getAttribute("modelos");%>
<%APIResponse[] anos = (APIResponse[]) request.getAttribute("anos");%>
<%Veiculo veiculo = (Veiculo) request.getAttribute("veiculo");%>
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
<div class="center">
  <h1>Vender Seguro</h1>
  <h2>Preencha os parâmetros da apólice:</h2>
  <div class="content">
    <form id="form-veiculo" action="vender-seguro?step=2" method="post">
      <div class="form-group">
        <label for="marca">Marca:</label>
        <select class="form-control" id="marca" name="marca" form="form-veiculo">
          <option value="0"></option>
          <%
            for (APIResponse marca : marcas) {%>
          <option value="<%=marca.getValue()%>" <%if(Integer.parseInt(marca.getValue()) == veiculo.getMarca()) {%>
                  selected
                  <%}%>><%=marca.getLabel()%></option>
          <%}%>
        </select>
      </div>
      <div class="form-group">
        <label for="modelo">Modelo:</label>
        <select class="form-control" id="modelo" name="modelo" form="form-veiculo">
          <option value="0"></option>
          <%
            for (APIResponse modelo : modelos) {%>
          <option value="<%=modelo.getValue()%>" <%if(Integer.parseInt(modelo.getValue()) == veiculo.getModelo()) {%>
            selected
          <%}%>><%=modelo.getLabel()%></option>
          <%}%>
        </select>
      </div>
      <div class="form-group">
        <label for="ano">Ano:</label>
        <select class="form-control" id="ano" name="ano" form="form-veiculo">
          <option></option>
          <%
            for (APIResponse ano : anos) {%>
          <option value="<%=ano.getValue()%>" <%if(ano.getValue().equals(veiculo.getAno())) {%>
                  selected
                  <%}%>><%=ano.getLabel()%></option>
          <%}%>
        </select>
      </div>
      <div class="d-flex flex-row-reverse">
        <button class="btn btn-primary">Avançar</button>
      </div>
    </form>
  </div>
</div>
<script type="application/javascript">
  var marca = document.getElementById("marca");
  marca.onchange = function (ev) {
    var idMarca = document.getElementById("marca").value;
    window.location.href = "vender-seguro?marca=" + idMarca;
  };

  var modelo = document.getElementById("modelo");
  modelo.onchange = function (ev) {
    var idModelo = document.getElementById("modelo").value;
    window.location.href = "vender-seguro?modelo=" + idModelo;
  };
</script>
</body>
</html>
