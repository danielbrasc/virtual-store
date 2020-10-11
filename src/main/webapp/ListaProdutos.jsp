<%--
  Created by IntelliJ IDEA.
  User: carlo
  Date: 10/10/2020
  Time: 17:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" session="true" %>
<%@ page import="Utils.*" %>
<%@ page import="java.util.ArrayList" %>
<html>
<head>
    <title>Virtual Store</title>
</head>
<body>
    <%HttpSession s = request.getSession();%>
    <%s.setAttribute("SessionID" ,s.getId());%>
    <a href="Login.jsp" <%s.invalidate();%>>Sair</a>
    <h1 align="center">Lista Produtos</h1>
    <table>
        <tr>
            <th>Nome</th>
            <th>Descrição</th>
            <th>Preço</th>
            <th>Estoque</th>
            <th>Carrinho</th>
            <%ArrayList<Produto> listaProdutos;%>
            <%=listaProdutos = ProdutoSQL.listar()%>
            <%for (Produto p: listaProdutos) {
                out.println(p.getNome());
                out.println(p.getDescricao());
                out.println(p.getPreco());
                out.println( p.getEstoque());
            }%>

        </tr>
    </table>
</body>
</html>
