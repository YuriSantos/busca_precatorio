<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!-- Latest compiled and minified CSS -->
<!DOCTYPE HTML>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<link rel="stylesheet" href="/bootstrap.css">
<script language="JavaScript" type="text/javascript">
	function validaFormulario(){
		if (document.pesquisa.nomeBeneficiario.value==""){
			alert("Preencha o nome!");
			pesquisa.nomeBeneficiario.focus();
			return false;
		}
		if (document.pesquisa.cpf.value==""){
			alert("Preencha o CPF/CNPJ");
			pesquisa.cpf.focus();
			return false;
		}
		if ((document.pesquisa.cpf.value.length < 11) ||  (document.pesquisa.cpf.value.length > 14)) {
			alert("O CPF deve conter 11 dígitos e o CNPJ 14 dígitos");
			pesquisa.cpf.focus();
			return false;
		}
		
		return true;
	}
</script>
	
	<div class="container" style="background-color:#FFF">
		<h3 class="box-title"><strong><span class="label"><font color = "Black">RPVs e Precatórios Depositados há mais de dois anos e ainda não levantados</font></span></strong></h3><br />
		<c:url var="url" value="/filtrar" />
		<c:url var="voltar" value="/listar"/>
		<form:form id="listar" action="${url}" method="get" name="pesquisa" modelAttribute="filtro" onSubmit="return validaFormulario();">
			<div class="row">
				<div class="col-md-1"><span class="label"><font color = "Black">Nome:</font></span></div>
				<div class="col-md-5">
					<form:input maxlength="100" name="nomeBeneficiario" path="nomeBeneficiario" size="100"
						class="form-control" placeholder="Digite o nome" />
				</div>
				<div class="col-md-1"><span class="label"><font color = "Black">CPF/CNPJ:</font></span></div>
				<div class="col-md-2">
					<form:input maxlength="30" name="cpf" path="cpf" size="30"
						class="form-control" placeholder="Somente números" />
				</div>
				
			</div>
			<br>
				<div class="col-md-3">
					<input type="submit" value="Pesquisar" class="btn btn-primary">
				</div>
				
				
				
		</form:form>
		<form:form id="voltar" action="${voltar}" method="get">
					<div class="col-md-3">
					<input type="submit" value="Limpar" class="btn btn-primary">
				</div>
				</form:form>
			<c:choose>
				<c:when test="${contaOk != null}">		
					<table border="1" class="table table-striped">
						<tr>
						<h4>Conta(s) no nome solicitado:</h4>
							<th class="warning">Nome</th>
							<th class="warning">CPF/CNPJ</th>
							<th class="warning">Banco</th>
							<th class="warning">Agência</th>
							<th class="warning">Número da Conta</th>
							<th class="warning">RPV</th>
							<th class="warning">Processo Judicial</th>
							<th class="warning">Data do Depósito</th>
							<th class="warning">Saldo</th>
						</tr>
						<c:forEach items="${contaOk}" var="conta">
							<tr>
								<td class="active">${conta.nomeBeneficiario}</td>
								<td class="active">${conta.cpf}</td>
								<td class="active">${conta.banco}</td>
								<td class="active">${conta.agencia}</td>
								<td class="active">${conta.numeroDaConta}</td>
								<td class="active">${conta.sequencial}</td>
								<td class="active">${conta.processoJudicial}</td>
								<td class="active"><fmt:formatDate pattern="dd/MM/yyyy" value="${conta.dataDoDeposito}"/></td>
								<td class="active">${conta.saldoClass}</td>
							</tr>
						</c:forEach>
					</table>
				</c:when>  
				
			</c:choose>
	</div>
	<br>
	<br>
	<h4 class="container">1 - Instruções para a pesquisa:</h4>
	<p class="container">Colocar o nome completo na pesquisa e o CPF ou CNPJ</p>
	<p class="container">Digitar os 11 números do CPF ou os 14 do CNPJ</p>
	<p class="container">Não utilizar pontos, espaços ou barras(exemplo: se o CPF é 123.456.789-10, digitar: 12345678910)</p>
	<p class="container">Não utilizar pontos e acentos</p>
	<br>
	<h4 class="container">2 - Informações adicionais:</h4>
	<p class="container">Constatada a existência de RPV ou Precatório expedido há mais de dois anos e ainda não sacado, o beneficiário poderá, através de advogado, requerer a expedição de novo requistório.</p>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<footer class="container">
		<p>Desenvolvido por Yuri Santos - JFPB &copy; 2018. Todos os direitos reservados.</p>
	</footer>