<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="dao.ProdutoDao"%>
<%@ page import="model.Produto"%>
<%@ page import="java.sql.SQLException"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.List"%>



<html lang="pt-br">
    <head>
        <meta charset="UTF-8">
        <title>Busca por ID</title>
    </head>

    <body>
        <h1>Informe o ID do Produto para pesquisa!</h1>
        <form action = "exibirproduto" method="get">
            <label for="desc">ID do Produto:</label>
            <input type="text" name="idProduto">
            <input type="submit" value="buscar">
        </form>
    </body>
</html>
