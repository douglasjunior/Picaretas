<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="/WEB-INF/includes/head.jsp" %>  
        <title>Consulta de produtos</title>
    </head>
    <body>
        <h1>Consulta de produtos</h1>
        <form method="GET" action="Consulta" >
            <label>Busca:</label>
            <input type="text" name="busca" value="" />
            <input type="submit" value="Buscar" />
        </form>
        <br />
        <table  >
            <tr>
                <th colspan="2">Produto</th>
                <th>Valor</th>
                <th>Categoria</th>
                <th>Data/hora</th>
            </tr>
            
            <tr>
                <td>1</td>
                <td>2222222222222222222222222222</td>
                <td>3</td>
                <td>4</td>
                <td>5</td>
            </tr>

        </table>
    </body>
</html>
