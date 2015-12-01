<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    String mensagemErro = (String) request.getAttribute("mensagem_erro");

    String ape = (String) request.getAttribute("ape");
    ape = ape == null ? "" : ape;
    String sen = (String) request.getAttribute("sen");
    sen = sen == null ? "" : sen;
%>
<html>
    <head>
        <%@include file="/WEB-INF/includes/head.jsp" %>               
        <title>Login</title>
    </head>
    <body>
        <div class="container-fluid">
            <div class="row-fluid">

                <% if (mensagemErro != null) {%>
                <p class="erro"><%= mensagemErro%></p>
                <% }%>

                <div class="span6">
                    <form class="form-horizontal" name="form-login" method="POST" action="Login" >
                        <input type="hidden" name="acao" value="login" />
                        <div class="control-group">
                            <div class="controls">
                                <h3>Login</h3>
                            </div>
                        </div>
                        <div class="control-group">
                            <label class="control-label">Apelido/E-mail:</label>
                            <div class="controls">
                                <div class="input-prepend">
                                    <span class="add-on">@</span>
                                    <input type="text" name="apelido" value="<%= ape%>" />
                                </div>
                            </div>
                        </div>

                        <div class="control-group">    
                            <label class="control-label">Senha:</label>
                            <div class="controls" >
                                <input type="password" name="senha" value="<%= sen%>" />  
                            </div>
                        </div>

                        <div class="control-group">
                            <div class="controls">
                                <input class="btn btn-primary" type="submit" value="Entrar" />
                            </div>
                        </div>
                    </form>
                </div>

                <div class="span6">
                    <form class="form-horizontal" name="form-cadastro" method="POST" action="Login" >
                        <input type="hidden" name="acao" value="cadastro" />
                        <div class="control-group">
                            <div class="controls">
                                <h3>Cadastre-se</h3>
                            </div>
                        </div>
                        <div class="control-group">
                            <label class="control-label">Apelido:</label>
                            <div class="controls">
                                <input type="text" name="apelido" value="" />
                            </div>
                        </div>
                        <div class="control-group">
                            <label class="control-label">E-mail:</label>
                            <div class="controls">
                                <div class="input-prepend">
                                    <span class="add-on">@</span>
                                    <input type="text" name="apelido" value="" />
                                </div>
                            </div>
                        </div>
                        <div class="control-group">    
                            <label class="control-label">Senha:</label>
                            <div class="controls" >
                                <input type="password" name="senha" value="" />  
                            </div>
                        </div>

                        <div class="control-group">
                            <div class="controls">
                                <input class="btn btn-primary" type="submit" value="Cadastrar" />
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>

        <%@include file="/WEB-INF/includes/footer.jsp" %>
    </body>
</html>
