package br.grupointegrado.ads.picaretas.modelo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Douglas
 */
public class UsuarioDao extends Dao<Usuario> {

    public UsuarioDao(Connection conexao) {
        super(conexao);
    }

    @Override
    public void inserir(Usuario objeto) throws SQLException {
        String sql = " INSERT INTO usuario (email, apelido, senha, telefone) "
                + " VALUES (?, ?, ?, ?) ";

        executaSql(sql,
                objeto.getEmail(),
                objeto.getApelido(),
                objeto.getSenha(),
                objeto.getTelefone());
    }

    @Override
    public void remover(Usuario objeto) throws SQLException {
        String sql = " DELETE FROM usuario WHERE id = ? ";

        executaSql(sql, objeto.getId());
    }

    @Override
    public void atualizar(Usuario objeto) throws SQLException {
        String sql = " UPDATE usuario SET email = ?, apelido = ?, senha = ?, telefone = ? "
                + " WHERE id = ? ";

        executaSql(sql,
                objeto.getEmail(),
                objeto.getApelido(),
                objeto.getSenha(),
                objeto.getTelefone(),
                objeto.getId());
    }

    public void atualizarImagem(Usuario usuario, Imagem imagem) throws SQLException {
        String sql = " UPDATE usuario SET id_imagem = ? WHERE id = ? ";
        executaSql(sql,
                imagem.getId(),
                usuario.getId());
    }

    @Override
    public Usuario montaObjeto(ResultSet resultado) throws SQLException {
        Usuario u = new Usuario();

        u.setId(resultado.getInt("id"));
        u.setApelido(resultado.getString("apelido"));
        u.setEmail(resultado.getString("email"));
        u.setTelefone(resultado.getString("telefone"));
        u.setSenha(resultado.getString("senha"));

        return u;
    }

    public Usuario consultaEmailSenha(String apelidoEmail, String senha) throws SQLException {
        String sql = " SELECT * FROM usuario WHERE senha = ? AND "
                + " ( apelido = ? OR email = ? ) ";

        List<Usuario> usuarios = consultaSql(sql,
                senha,
                apelidoEmail,
                apelidoEmail);

        // se a lista está vazia, então retorna nulo
        if (usuarios.isEmpty())
            return null;
        // se existem objetos na lista, então retorna o primeiro
        return usuarios.get(0);
    }
}
