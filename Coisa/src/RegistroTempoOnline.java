/**
 * Representação do tempo online e verificação se o tempo é superior ou não ao esperado.
 * É armazenado o nome da disciplina, o tempo online usado e esperado.
 *
 * @author Caio Defensor Brasil Da Silva -
 */

public class RegistroTempoOnline {

    private String nomeDisciplina;
    private int tempoOnlineUsado;
    private int tempoOnlineEsperado;

    public RegistroTempoOnline(String nomeDisciplina) {
        this.nomeDisciplina = nomeDisciplina;
        this.tempoOnlineUsado = 0;
        this.tempoOnlineEsperado = 120;
    }

    public RegistroTempoOnline(String nomeDisciplina, int tempoOnlineEsperado) {
        this.nomeDisciplina = nomeDisciplina;
        this.tempoOnlineUsado = 0;
        this.tempoOnlineEsperado = tempoOnlineEsperado;
    }

    public void adicionaTempoOnline(int tempo) {
        this.tempoOnlineUsado += tempo;
    }

    public boolean atingiuMetaTempoOnline() {
        if (tempoOnlineUsado >= tempoOnlineEsperado) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Retorna a String que representa o tempo online. No formato: Disciplina Tempo usado / Tempo esperado.
     * @return a representação em String do tempo online.
     */
    public String toString() {
        return nomeDisciplina + " " + tempoOnlineUsado + "/" + tempoOnlineEsperado;
    }
}