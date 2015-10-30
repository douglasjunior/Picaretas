package br.grupointegrado.ads.picaretas.modelo;

/**
 * Classe que representa a entidade Imagem no banco de dados
 *
 * @author Douglas
 */
public class Imagem {

    private int id;
    private byte[] conteudo;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public byte[] getConteudo() {
        return conteudo;
    }

    public void setConteudo(byte[] conteudo) {
        this.conteudo = conteudo;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + this.id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Imagem other = (Imagem) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }
}
