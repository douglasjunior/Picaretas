<%@page import="br.grupointegrado.ads.picaretas.modelo.Produto"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    List<Produto> produtos = (List<Produto>) request.getAttribute("produtos");
    String mensagemErro = (String) request.getAttribute("mensagem_erro");
%>
<html>
    <head>
        <%@include file="/WEB-INF/includes/head.jsp" %>  
        <title>Consulta de produtos</title>
    </head>
    <body>
        <h1>Consulta de produtos</h1>
        <% if (mensagemErro != null) {%>
        <p class="erro"><%= mensagemErro%></p>
        <% }%>
        <form method="GET" action="Consulta" >
            <label>Busca:</label>
            <input type="text" name="busca" value="" />
            <input type="submit" value="Buscar" />
        </form>
        <br />
        <table>
            <tr>
                <th colspan="2">Produto</th>
                <th>Valor</th>
                <th>Categoria</th>
                <th>Data/hora</th>
            </tr>

            <%
                if (produtos != null) {
                    for (Produto prod : produtos) {
            %>
            <tr>
                <td>imagem</td>
                <td><%= prod.getDescricao() %></td>
                <td><%= prod.getValorString() %></td>
                <td><%= prod.getCategoria().getDescricao() %></td>
                <td><%= prod.getDataPostagemString() %></td>
            </tr>    
            <%
                    }
                }
            %>
        </table>

        <% if (mensagemErro != null) {%>
        <script lang="javascript">
            alert('<%= mensagemErro%>');
        </script>
        <% }%>
    </body>
</html>
