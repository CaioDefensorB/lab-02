/**
 * Representação de um resumo, identificado pelo tema.
 * É armazenado tema(identificador do resumo) e conteudo.
 *
 * @author Caio Defensor Brasil Da Silva
 */

public class Resumo {

    /**
     * Tema e conteudo do resumo, no formato de texto.
     */
    private String tema;
    private String conteudo;

    /**
     * Constrói o resumo a partir de um tema e conteudo.
     * @param tema o tema do resumo.
     * @param conteudo o conteúdo do resumo.
     */
    public Resumo(String tema, String conteudo) {
        this.tema = tema;
        this.conteudo = conteudo;
    }

    /**
     * Retorna o tema do resumo.
     * @return tema.
     */
    public String getTema() {
        return tema;
    }

    /**
     * Retorna o conteudo do resumo.
     * @return conteúdo.
     */
    public String getConteudo() {
        return conteudo;
    }

    /**
     * Possibilita a mudança do conteudo.
     */
    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    /**
     * Retorna a “String” que representa o resumo. No formato: Tema : Conteúdo.
     * @return a representação em “String” do resumo.
     */
    public String toString() {
        return tema + ": " + conteudo;
    }
}