<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ page import="br.usp.pcs.mvc.Apolice"%>
 <%@ page import="java.util.Date"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Detalhe Apolice</title>
</head>
<body>

<h1> Detalhe Apolice  </h1>


<%Apolice apolice = (Apolice) request.getAttribute("apolice");%>
    <h1>Detalhe</h1>
    
    <p><strong>marcaVeiculo: </strong><%=apolice.getMarcaVeiculo()%></p>
    <p><strong>modeloVeiculo: </strong><%=apolice.getModeloVeiculo()%></p>
    <p><strong>anoVeiculo: </strong><%=apolice.getAnoVeiculo()%></p>
    <p><strong>valorContratacao: </strong><%=apolice.getValorContratacao()%></p>
    <p><strong>tipoFranquiaCasco: </strong><%=apolice.getTipoFranquiaCasco()%></p>
    <p><strong>franquiaAcessorios: </strong><%=apolice.getFranquiaAcessorios()%></p>
    <p><strong>valorFranquia: </strong><%=apolice.getValorFranquia()%></p>
    <p><strong>valorPremio: </strong><%=apolice.getValorPremio()%></p>
    <p><strong>valorSegurado: </strong><%=apolice.getValorSegurado()%></p>
    <p><strong>numeroApolice: </strong><%=apolice.getNumeroApolice()%></p>
    <p><strong>nomeSegurado: </strong><%=apolice.getNomeSegurado()%></p>
    <p><strong>CPF: </strong><%=apolice.getCPF()%></p>
    <p><strong>email: </strong><%=apolice.getEmail()%></p>
    <p><strong>endereco: </strong><%=apolice.getEndereco()%></p>
    <p><strong>dataNascimento: </strong><%=apolice.getDataNascimento()%></p>
    <p><strong>status: </strong><%=apolice.getStatus()%></p>

<a href="apolices">
 Voltar
</a>


</body>
</html>