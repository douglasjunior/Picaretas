package br.grupointegrado.ads.picaretas.controle;

import br.grupointegrado.ads.picaretas.modelo.Produto;
import br.grupointegrado.ads.picaretas.modelo.ProdutoDao;
import java.io.IOException;
import java.sql.Connection;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ConsultaServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String buscaParam = req.getParameter("busca");

            Connection conexao = (Connection) req.getAttribute("conexao");
            ProdutoDao dao = new ProdutoDao(conexao);

            List<Produto> produtos = dao.consultaDescricao(buscaParam);

            req.setAttribute("produtos", produtos);
        } catch (Exception ex) {
            ex.printStackTrace();
            req.setAttribute("mensagem_erro", "Não foi possível carregar os dados.");
        }
        req.getRequestDispatcher("/WEB-INF/paginas/consulta.jsp").forward(req, resp);
    }
}
