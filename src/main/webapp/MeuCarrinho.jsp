<%@ page import="Utils.Carrinho" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="Utils.Produto" %>
<%@ page import="Utils.ProdutoSQL" %><%--
  Created by IntelliJ IDEA.
  User: carlo
  Date: 11/10/2020
  Time: 14:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Virtual Store</title>
</head>
<body>
<h1>Meu Carrinho</h1>
<%
    HttpSession s = request.getSession(false);
    Carrinho carrinho = (Carrinho) s.getAttribute("carrinho");
%>
<table border="1">
    <tr>
        <th>Nome</th>
        <th>Descrição</th>
        <th>Preço</th>
        <th>Quantidade</th>
        <th>Carrinho</th>
    </tr>
    <%for (Produto p : carrinho.getProdutos()) { %>
        <tr>
            <td><% out.println(p.getNome()); %></td>
            <td><% out.println(p.getDescricao()); %></td>
            <td><% out.println(p.getPreco()); %></td>
            <td><% out.println(p.getQuantidade());%></td>
            <td><a href="/CarrinhoServlet?nome=<%=p.getNome()%>&&command=remove">Remover</a></td>
        </tr>
    <%}%>
</table>
<br>
<a href="ListaProdutos.jsp">Ver Produtos</a>
<br>
<a href="FinalizaCarrinho.jsp">Finalizar Carrinho</a>
</body>
</html>
