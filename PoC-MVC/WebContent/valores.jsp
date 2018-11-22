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
<%Apolice apolice = (Apolice) request.getAttribute("apolice");%>
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
        <a class="nav-link" href="#">Gerar Relat�rio</a>
      </li>
    </ul>
  </div>
</nav>
<div class="center">
  <h1>Vender Seguro</h1>
  <div class="content">
    <h2>Informa��es da Ap�lice:</h2>
    <div class="info">
      <h3>Informa��es do Cliente:</h3>
      <p><strong>Nome: </strong><%=apolice.getNomeSegurado()%></p>
      <p><strong>E-mail: </strong><%=apolice.getEmail()%></p>
      <p><strong>CPF: </strong><%=apolice.getCPF()%></p>
      <p><strong>Endere�o: </strong><%=apolice.getEndereco()%></p>
      <p><strong>Data de Nascimento: </strong><%=apolice.getDataNascimentoString()%></p>
    </div>
    <div class="info">
      <h3>Informa��es do Ve�culo:</h3>
      <p><strong>Marca: </strong><%=apolice.getMarcaVeiculo()%></p>
      <p><strong>Modelo: </strong><%=apolice.getModeloVeiculo()%></p>
      <p><strong>Ano: </strong><%=apolice.getAnoVeiculo()%></p>
    </div>
    <div class="info">
      <h3>Informa��es da Ap�lice:</h3>
      <p><strong>Valor de Contrata��o: </strong>R$<%=apolice.getValorContratacao()%></p>
      <p><strong>Coberturas: </strong><%=apolice.getCoberturasString()%></p>
      <p><strong>Franquias: </strong></p>
      <div class="franquia">
        <p><strong>Franquia Casco: </strong> <%=apolice.getTipoFranquiaCasco()%></p>
        <p><strong>Franquia Acess�rios: </strong> <%=apolice.getFranquiaAcessorios() ? "Sim" : "Nao"%></p>
      </div>
    </div>
    <div class="info">
      <h3>Valores Calculados:</h3>
      <p><strong>Franquia Casco: </strong>R$ <%=String.format("%.2f", apolice.getValorFranquiaCasco())%></p>
      <p><strong>Franquia Acessorios: </strong>R$ <%=String.format("%.2f", apolice.getValorFranquiaAcessorios())%></p>
      <p><strong>Pr�mio Total: </strong>R$ <%=String.format("%.2f", apolice.getValorPremio())%></p>
    </div>
    <div class="d-flex flex-row-reverse d-flex justify-content-between">
      <a href="vender-seguro?action=salvarApolice"><button class="btn btn-primary ">Confirmar Venda</button></a>
      <a href="index.jsp"><button class="btn btn-primary ">Cancelar Venda</button></a>
    </div>
  </div>
</div>
</body>
</html>
