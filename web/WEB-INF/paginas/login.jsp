<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="/WEB-INF/includes/head.jsp" %>               
        <title>Login</title>
    </head>
    <body>
        <h1>Login</h1>
        <form name="form-login" method="POST" action="Login" >
            <input type="hidden" name="acao" value="login" />
            <label>Usuário/E-mail:</label>
            <input type="text" name="usuario" value="" />
            <br />
            <label>Senha:</label>
            <input type="password" name="senha" value="" />
            <br />
            <input type="submit" value="Entrar" />
        </form>
        <h1>Cadastro</h1>
        <form name="form-cadastro" method="POST" action="Login" >
            <input type="hidden" name="acao" value="cadastro" />
            <label>Usuário:</label>
            <input type="text" name="usuario" value="" />
            <br />
            <label>E-mail:</label>
            <input type="text" name="email" value="" />
            <br />
            <label>Senha:</label>
            <input type="password" name="senha" value="" />
            <br />
            <input type="submit" value="Cadastrar" />
        </form>
    </body>
</html>
