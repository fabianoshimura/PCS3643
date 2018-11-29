<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ page import="br.usp.pcs.mvc.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <title>Alterar Status</title>
    <link rel="stylesheet" href="style.css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
</head>
<body>
<%Apolice apolice = (Apolice) request.getAttribute("apolice");%>
<%boolean error = (boolean) request.getAttribute("error");%>
<%boolean success = (boolean) request.getAttribute("success");%>
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
                <a class="nav-link" href="#">Gerar Relat�rio</a>
            </li>
        </ul>
    </div>
</nav>
<div class="center">
    <h1>Alterar Status</h1>
    <div class="content">
        <form action="alterar-status" method="get">
            <div class="form-group">
                <label for="numero">Numero da ap�lice:</label>
                <input class="form-control" type="text" id="numero" name="numero"/>
            </div>
            <button class="btn btn-primary">Buscar</button>
        </form>
    <%if(apolice != null) {%>
        <h2>Informa��es da Ap�lice</h2>
        <div class="info">
            <h3>Informa��es Gerais:</h3>
            <p><strong>Corretora de Seguros:</strong> PF - Shimura & Darvas Ltda.</p>
            <p><strong>Nome do Corretor:</strong> Pedro Darvas</p>
            <p><strong>Data de Inicio:</strong> <%=apolice.getDataString(apolice.getDataInicio())%></p>
            <p><strong>Data de Vencimento:</strong> <%=apolice.getDataString(apolice.getDataVencimento())%></p>
        </div>
        <div class="info">
            <h3>Informa��es do Cliente:</h3>
            <p><strong>Nome: </strong><%=apolice.getNomeSegurado()%></p>
            <p><strong>E-mail: </strong><%=apolice.getEmail()%></p>
            <p><strong>CPF: </strong><%=apolice.getCPF()%></p>
            <p><strong>Endere�o: </strong><%=apolice.getEndereco()%></p>
            <p><strong>Data de Nascimento: </strong><%=apolice.getDataString(apolice.getDataNascimento())%></p>
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
            <p><strong>Pr�mio L�quido: </strong>R$ <%=String.format("%.2f", apolice.getValorPremioSemImposto())%></p>
            <p><strong>Imposto Calculado (IOF): </strong>R$ <%=String.format("%.2f", apolice.getImpostoPremio())%></p>
            <p><strong>Pr�mio Total: </strong>R$ <%=String.format("%.2f", apolice.getValorPremio())%></p>
        </div>
        <form action="alterar-status" method="post" id="form-status">
            <div class="form-group">
                <label for="status">Status:</label>
                <select class="form-control" id="status" name="status" form="form-status">
                    <option></option>
                    <%
                        for (Apolice.Status status : Apolice.Status.values()) {%>
                    <option value="<%=status.toString()%>" <%if(status.equals(apolice.getStatus())) {%>
                            selected
                            <%}%>><%=status.toString()%></option>
                    <%}%>
                </select>
                <br>
                <button class="btn btn-primary">Alterar Status</button>
            </div>
        </form>

        <%}%>
    </div>

    <%if(error) {%>
    <div class="snackbar error">
        <p>Este status � inv�lido!</p>
    </div>
    <%}%>

    <%if(success) {%>
    <div class="snackbar success">
        <p>Status alterado com sucesso!</p>
    </div>
    <%}%>
    <%if(queryError) {%>
    <div class="snackbar error">
        <p>Ap�lice n�o encontrada!</p>
    </div>
    <%}%>

</div>
</body>
</html>
