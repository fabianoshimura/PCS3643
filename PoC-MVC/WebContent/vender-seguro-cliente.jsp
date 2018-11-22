<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
  <div class="content">
    <h2>Preencha as informações do cliente</h2>
    <form action="vender-seguro?action=setCliente" method="post">
      <div class="form-group">
        <label for="nome">Nome:</label>
        <input class="form-control" type="text" id="nome" name="nome"/>
      </div>
      <div class="form-group">
        <label for="email">E-mail:</label>
        <input class="form-control" type="email" id="email" name="email"/>
      </div>
      <div class="form-group">
        <label for="cpf">CPF:</label>
        <input class="form-control" type="number" id="cpf" name="cpf"/>
      </div>
      <div class="form-group">
        <label for="endereco">Endereço:</label>
        <input class="form-control" type="text" id="endereco" name="endereco"/>
      </div>
      <div class="form-group">
        <label for="data">Data de Nascimento:</label>
        <input class="form-control" type="date" id="data" name="data"/>
      </div>
      <div class="d-flex flex-row-reverse">
        <button class="btn btn-primary">Avançar</button>
      </div>
    </form>
  </div>
</div>
</body>
</html>
