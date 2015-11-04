package br.grupointegrado.ads.picaretas.controle;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Douglas
 */
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.getRequestDispatcher("/WEB-INF/paginas/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String acaoParam = req.getParameter("acao");
        if ("login".equals(acaoParam)) {
            login(req, resp);
        } else if ("cadastro".equals(acaoParam)) {
            cadastro(req, resp);
        }
    }

    /**
     * Efetua login com o usuário e senha informados.
     *
     * @param req
     * @param resp
     */
    private void login(HttpServletRequest req, HttpServletResponse resp) {
        try {

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Realiza o cadastro do novo usuário no banco de dados.
     *
     * @param req
     * @param resp
     */
    private void cadastro(HttpServletRequest req, HttpServletResponse resp) {
        try {

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
