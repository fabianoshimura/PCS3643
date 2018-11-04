<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="pt-br">
<head>
  <meta charset="UTF-8">
  <title>Vender Seguro - 2</title>
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
  <h2>Preencha as informações do veículo</h2>
  <div class="content">
    <form action="valores.html">
      <div class="form-group row">
        <label for="valor" class="col-sm-4">Valor de Contratação:</label>
        <div class="col-sm-8">
          <select class="form-control form-control-sm" id="valor">
            <option></option>
            <option>Valor Mercado Referenciado (FIPE)</option>
            <option>Valor Determinado</option>
          </select>
        </div>
      </div>
      <div class="form-group d-flex align-items-center">
        <label>Coberturas:</label>
        <div class="form-check">
          <input class="form-check-input" type="checkbox" value="" id="danos-materiais">
          <label class="form-check-label" for="danos-materiais">
            Danos Materiais
          </label>
        </div>
        <div class="form-check">
          <input class="form-check-input" type="checkbox" value="" id="danos-corporais">
          <label class="form-check-label" for="danos-corporais">
            Danos Corporais
          </label>
        </div>
      </div>
      <div>
        <label>Franquias:</label>
        <div class="form-group row franquia">
          <label for="franquia-casco" class="col-sm-4">Franquia Casco:</label>
          <div class="col-sm-8">
            <select class="form-control form-control-sm" id="franquia-casco">
              <option></option>
              <option>Majorada</option>
              <option>Obrigatória</option>
              <option>Reduzida</option>
            </select>
          </div>
        </div>
        <div class="form-group row franquia">
          <label for="franquia-acessorios" class="col-sm-4">Franquia Acessórios:</label>
          <div class="col-sm-8">
            <select class="form-control form-control-sm" id="franquia-acessorios">
              <option></option>
              <option>Sim</option>
              <option>Não</option>
            </select>
          </div>
        </div>
      </div>
      <div class="d-flex flex-row-reverse">
        <button class="btn btn-primary">Calcular Valores</button>
      </div>
    </form>
  </div>
</div>
</body>
</html>
