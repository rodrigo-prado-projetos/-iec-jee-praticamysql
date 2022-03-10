<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="UTF-8" %>
	<!DOCTYPE html>
	<html>

	<head>
		<meta charset="ISO-8859-1">
		<title>Inserir Produto</title>
	</head>

	<body>
		<center>
			<h1>Inserir Produto</h1>
			<form action="inserir-produto" method="POST">
				Nome: <input type="text" name="nome" id="nome">
				Preco: <input type="text" name="preco" id="preco">
				Codigo Categoria: <input type="int" name="codigo_categoria" id="codigo_categoria">
				<input type="submit" value="Inserir">
			</form>
			<a href="index.jsp"> Voltar </a>
		</center>
	</body>

	</html>