package br.grupointegrado.ads.picaretas.modelo;

import br.grupointegrado.ads.picaretas.util.Util;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Douglas
 */
public class ProdutoDao extends Dao<Produto> {

    public ProdutoDao(Connection conexao) {
        super(conexao);
    }

    @Override
    public void inserir(Produto objeto) throws SQLException {
        String sql = " INSERT INTO produto (descricao, detalhes, valor, id_categoria, "
                + " data_postagem, id_usuario) VALUES (?, ?, ?, ?, ?, ?) ";

        executaSql(sql,
                objeto.getDescricao(),
                objeto.getDetalhes(),
                objeto.getValor(),
                objeto.getCategoria().getId(),
                Util.dataParaTimestamp(objeto.getDataPostagem()),
                objeto.getUsuario().getId());
    }

    @Override
    public void remover(Produto objeto) throws SQLException {
        String sql = "DELETE FROM produto WHERE id = ?";

        executaSql(sql, objeto.getId());
    }

    @Override
    public void atualizar(Produto objeto) throws SQLException {
        String sql = " UPDATE produto SET descricao = ?, detalhes = ?, valor = ?, "
                + " id_categoria = ?, data_postagem = ?, id_usuario = ?, vendido = ? "
                + " WHERE id = ? ";

        executaSql(sql,
                objeto.getDescricao(),
                objeto.getDetalhes(),
                objeto.getValor(),
                objeto.getCategoria().getId(),
                Util.dataParaTimestamp(objeto.getDataPostagem()),
                objeto.getUsuario().getId(),
                objeto.isVendido(),
                objeto.getId());
    }

    @Override
    public Produto montaObjeto(ResultSet resultado) throws SQLException {
        Produto p = new Produto();

        p.setId(resultado.getInt("id"));
        p.setDescricao(resultado.getString("descricao"));
        p.setDetalhes(resultado.getString("detalhes"));
        p.setValor(resultado.getFloat("valor"));
        p.setDataPostagem(resultado.getTimestamp("data_postagem"));
        p.setVendido(resultado.getBoolean("vendido"));

        p.setCategoria(new Categoria());
        
        UsuarioDao usuarioDao = new UsuarioDao(conexao);
        Usuario usuario = usuarioDao.consultaId(resultado.getInt("id_usuario"));
        p.setUsuario(usuario);

        return p;
    }

    @Override
    public Produto consultaId(int... ids) throws SQLException {
        String sql = " SELECT * FROM produto WHERE id = ? ";

        List<Produto> produtos = consultaSql(sql, ids[0]);

        if (produtos.isEmpty()) {
            return null;
        }

        return produtos.get(0);
    }

    public List<Produto> consultaDescricao(String descricao) throws SQLException {
        String sql = " SELECT * FROM produto WHERE descricao LIKE ? ";

        return consultaSql(sql, "%" + descricao + "%");
    }
}
