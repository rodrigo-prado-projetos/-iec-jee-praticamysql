<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="UTF-8" %>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
		<!DOCTYPE html>
		<html>

		<head>
			<meta charset="ISO-8859-1">
			<title>Lista de produtos</title>
		</head>

		<body>
			<center>
				<h1>Listar Produtos por uma categoria especifica</h1>
				<form action="listar-produto" method="GET">
					Codigo Categoria: <input type="int" name="codigo_categoria" id="codigo_categoria">
					<input type="submit" value="Buscar">
					Filtrar pelo nome produto: <input type="int" name="nome_produto" id="nome_produto">
					<input type="submit" value="Buscar">
				</form>
				<a href="index.jsp"> Voltar </a>
			</center>
			<div align="center">
				<table border="1" cellpadding="5">
					<caption>
						<h2>Produtos por categoria</h2>
					</caption>
					<tr>
						<th>Codigo</th>
						<th>Nome</th>
						<th>Preco</th>
					</tr>
					<c:forEach var="produto" items="${listaProduto}">
						<tr>
							<td>
								<c:out value="${produto.codigo}" />
							</td>
							<td>
								<c:out value="${produto.nome}" />
							</td>
							<td>
								<c:out value="${produto.preco}" />
							</td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</body>

		</html>