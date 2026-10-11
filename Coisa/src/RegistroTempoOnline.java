/**
 * Representação do tempo online e verificação se o tempo é superior ou não ao esperado.
 * É armazenado o nome da disciplina, o tempo online usado e esperado.
 *
 * @author Caio Defensor Brasil Da Silva -
 */

public class RegistroTempoOnline {

    /**
     * Nome da disciplina em String, Tempo usado em inteiro e tempo esperado em inteiro.
     */
    private String nomeDisciplina;
    private int tempoOnlineUsado;
    private int tempoOnlineEsperado;

    /**
     * Constroi o Tempo online do aluno a partir do nome da disciplina.
     * O tempo usado começa em 0 e o esperado em 120.
     * @param nomeDisciplina o nome da disciplina.
     */
    public RegistroTempoOnline(String nomeDisciplina) {
        this.nomeDisciplina = nomeDisciplina;
        this.tempoOnlineUsado = 0;
        this.tempoOnlineEsperado = 120;
    }

    /**
     * Registra o tempo esperado e a disciplina.
     * @param nomeDisciplina nome da disciplina.
     * @param tempoOnlineEsperado tempo esperado de uso do aluno.
     */
    public RegistroTempoOnline(String nomeDisciplina, int tempoOnlineEsperado) {
        this.nomeDisciplina = nomeDisciplina;
        this.tempoOnlineUsado = 0;
        this.tempoOnlineEsperado = tempoOnlineEsperado;
    }

    /**
     * Adiciona o tempo que foi usado.
     * @param tempo = tempo que o aluno usou a mais.
     */
    public void adicionaTempoOnline(int tempo) {
        this.tempoOnlineUsado += tempo;
    }

    /**
     * Verifica de o aluno atingiu o tempo esperado ou não.
     * @return retorna um tipo booleano, verdadeiro para se o aluno atingiu o tempo esperado e falso para o contrário.
     */
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