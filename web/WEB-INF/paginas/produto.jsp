<%@page import="java.util.List"%>
<%@page import="br.grupointegrado.ads.picaretas.modelo.Categoria"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    String mensagemErro = (String) request.getAttribute("mensagem_erro");
    List<Categoria> categorias = (List<Categoria>) request.getAttribute("categorias");
%>
<html>
    <head>
        <%@include file="/WEB-INF/includes/head.jsp" %>
        <title>Produto</title>
    </head>
    <body>
        <%@include file="/WEB-INF/includes/logout.jsp"%>
        <h1>Produto</h1>
        <% if (mensagemErro != null) {%>
        <p class="erro"><%= mensagemErro%></p>
        <% }%>
        <form action="Produto" method="POST">
            <input type="hidden" name="id" value="" />
            <label>Categoria</label><br />
            <select name="categoria">
                <option value="0">(Selecione)</option>
                <%
                    if (categorias != null) {
                        for (Categoria c : categorias) {
                %>
                <option value="<%= c.getId()%>" ><%= c.getDescricao()%></option>
                <%
                        }
                    }
                %>
            </select>
            <br /><br />
            <label>Descrição</label><br />
            <input type="text" name="descricao" value="" />
            <br /><br />
            <label>Detalhes</label><br />
            <textarea name="detalhes" rows="10" cols="50" ></textarea>
            <br /><br />
            <label>Valor</label><br />
            <input type="text" name="valor" value="" />
            <br /><br />
            <input type="submit" value="Publicar" />
        </form>
    </body>
</html>
