package br.grupointegrado.ads.picaretas.modelo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class CategoriaDao extends Dao<Categoria> {

    public CategoriaDao(Connection conexao) {
        super(conexao);
    }

    @Override
    public void inserir(Categoria objeto) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void remover(Categoria objeto) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void atualizar(Categoria objeto) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Categoria consultaId(int... ids) throws SQLException {
        String sql = "SELECT * FROM categoria WHERE id = ?";

        List<Categoria> categorias = consultaSql(sql, ids[0]);

        if (categorias.isEmpty()) {
            return null;
        }

        return categorias.get(0);
    }

    public List<Categoria> consultaTodas() throws SQLException {
        String sql = "SELECT * FROM categoria ORDER BY descricao";

        List<Categoria> categorias = consultaSql(sql);

        return categorias;
    }

    @Override
    public Categoria montaObjeto(ResultSet resultado) throws SQLException {
        Categoria categoria = new Categoria();

        categoria.setId(resultado.getInt("id"));
        categoria.setDescricao(resultado.getString("descricao"));

        return categoria;
    }
}
