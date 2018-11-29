<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="pt-br">
<head>
  <meta charset="UTF-8">
  <title>Vender Seguro - 2</title>
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
  <link rel="stylesheet" href="style.css">
</head>
<body>
<%Double valorFIPE = (Double) request.getAttribute("valorFIPE");%>
<%boolean error = (boolean) request.getAttribute("error");%>
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
    <h2>Preencha os parâmetros da apólice</h2>
    <form action="vender-seguro?action=setParametros" method="post">
      <div class="form-group row">
        <label for="valor" class="col-sm-4">Valor de Contratação:</label>
        <div class="col-sm-4">
          <select class="form-control form-control-sm" id="valor">
            <option></option>
            <option selected value="fipe">Valor Mercado Referenciado (FIPE)</option>
            <option value="determinado">Valor Determinado</option>
          </select>
        </div>
        <label for="valor-contratacao" class="col-sm-1">R$</label>
        <input class="col-sm-3 form-control" type="number" name="valor-contratacao" id="valor-contratacao" disabled default-value="<%=valorFIPE%>" value="<%=valorFIPE%>">
      </div>
      <div class="form-group d-flex align-items-center">
        <label>Coberturas:</label>
        <div class="form-check">
          <input class="form-check-input" type="checkbox" value="" name="danos-materiais" id="danos-materiais">
          <label class="form-check-label" for="danos-materiais">
            Danos Materiais
          </label>
        </div>
        <div class="form-check">
          <input class="form-check-input" type="checkbox" value="" name="danos-corporais" id="danos-corporais">
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
            <select class="form-control form-control-sm" name="franquia-casco" id="franquia-casco">
              <option></option>
              <option value="Majorada">Majorada</option>
              <option value="Obrigatoria">Obrigatória</option>
              <option value="Reduzida">Reduzida</option>
            </select>
          </div>
        </div>
        <div class="form-group row franquia">
          <label for="franquia-acessorios" class="col-sm-4">Franquia Acessórios:</label>
          <div class="col-sm-8">
            <select class="form-control form-control-sm" id="franquia-acessorios" name="franquia-acessorios">
              <option></option>
              <option>Sim</option>
              <option>Não</option>
            </select>
          </div>
        </div>
        <div class="form-group row franquia hidden" id="valor-acessorios-container">
          <label class="col-sm-4" for="valor-acessorios">Valor dos acessórios:</label>
          <input class="form-control col-sm-4" type="number" id="valor-acessorios" name="valor-acessorios"/>
        </div>
      </div>
      <div class="d-flex flex-row-reverse">
        <button class="btn btn-primary">Calcular Valores</button>
      </div>
    </form>
  </div>
  <%if(error) {%>
  <div class="snackbar error">
    <p>Preencha todos os parâmetros corretamente para prosseguir!</p>
  </div>
  <%}%>
</div>
<script type="application/javascript">
  var valor = document.getElementById("valor");

  valor.onchange = function (ev) {
    var tipoValor = document.getElementById("valor").value;
    var campoValor = document.getElementById("valor-contratacao");
    if (tipoValor === 'fipe') {
      campoValor.setAttribute('disabled', 'true');
      campoValor.value = campoValor.getAttribute('default-value');
    }
    if (tipoValor === 'determinado') {
      campoValor.removeAttribute('disabled');
      campoValor.value = "";
    }
  };

  var acessorios = document.getElementById("franquia-acessorios");

  acessorios.onchange = function (ev) {
    var acessoriosSelecionado = document.getElementById("franquia-acessorios").value;
    var valorAcessorios = document.getElementById("valor-acessorios-container");

    if (acessoriosSelecionado === "Sim") {
      valorAcessorios.classList.remove('hidden');
    } else {
      valorAcessorios.classList.add('hidden');
    }
  }

</script>
</body>
</html>
