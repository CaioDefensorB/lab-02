/**
 * Representação do registro das disciplinas do aluno e as suas informações.
 * É armazenado o nome da disciplina, horas de estudo e 4 notas.
 *
 * @author Caio Defensor Brasil Da Silva
 */

import java.util.Arrays;

public class Disciplina {

    /**
     * Nome da disciplina em “String”, horas de estudo em inteiro, arrays de notas e pesos.
     */
    private String nomeDisciplina;
    private int horasEstudo;
    private double[] notas;
    private int[] pesos;

    /**
     * Constrói a Disciplina a partir do nome da disciplina.
     * @param nomeDisciplina nome da disciplina.
     */
    public Disciplina(String nomeDisciplina) {
        this.nomeDisciplina = nomeDisciplina;
        this.horasEstudo = 0;
        this.notas = new double[4];
        this.pesos = new int[]{1, 1, 1, 1};
    }

    /**
     * Constrói a Disciplina a partir do nome da disciplina e do número de notas.
     * @param nomeDisciplina nome da disciplina.
     * @param numeroDeNotas numero de notas da disciplina.
     */
    public Disciplina(String nomeDisciplina, int numeroDeNotas) {
        this.nomeDisciplina = nomeDisciplina;
        this.horasEstudo = 0;
        this.notas = new double[numeroDeNotas];
        this.pesos = new int[numeroDeNotas];
        for (int i =0; i < numeroDeNotas; i++) {
            pesos[i] = 1;
        }
    }

    /**
     * Constrói a Disciplina a partir do nome da disciplina, número de notas e pesos.
     * @param nomeDisciplina nome da disciplina.
     * @param numeroDeNotas numero de notas da disciplina.
     * @param pesosRecebidos pesos de cada nota da disciplina.
     */
    public Disciplina(String nomeDisciplina, int numeroDeNotas, int[] pesosRecebidos) {
        this.nomeDisciplina = nomeDisciplina;
        this.horasEstudo = 0;
        this.notas = new double[numeroDeNotas];
        this.pesos = new int[numeroDeNotas];
        if (pesosRecebidos == null) {
            for (int i = 0; i < numeroDeNotas; i++) {
                pesos[i] = 1;
            }
        } else {
            for (int i = 0; i < numeroDeNotas; i++) {
                pesos[i] = pesosRecebidos[i];
            }
        }
    }

    /**
     * Cadastra quantas horas o aluno estudou na disciplina.
     * @param horas quantidade de horas estudadas.
     */
    public void cadastraHoras(int horas) { horasEstudo += horas; }

    /**
     * Cadastra a nota na posição.
     * @param nota posição onde a nota vai ser adicionada.
     * @param valorNota nota do aluno em certa avaliação.
     */
    public void cadastraNota(int nota, double valorNota) {
        notas[nota-1] = valorNota;
    }

    /**
     * Calcula a média do aluno na disciplina.
     * @return retorna a media do aluno na disciplina
     */
    public double calculaMedia() {
        double soma = 0;
        for (int i = 0; i < notas.length; i++) {
            soma += notas[i] * pesos[i];
        }
        return soma / Arrays.stream(pesos).sum();
    }

    /**
     * Verifica se o aluno foi aprovado ou não.
     * @return tipo booleano, true se o aluno foi aprovado ou false se foi reprovado.
     */
    public boolean aprovado() {
        if (calculaMedia() >= 7) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Retorna a “String” que representa a disciplina. No formato: Disciplina Horas de estudo Media Notas.
     * @return a representação em “String” do tempo online.
     */
    public String toString() {
        return nomeDisciplina + " " + horasEstudo + " " + calculaMedia() + " " + Arrays.toString(notas);
    }
}