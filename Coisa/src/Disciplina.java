/**
 * Representação do registro das disciplinas do aluno e suas informações.
 * É armazenado o nome da disciplina, horas de estudo e 4 notas.
 *
 * @author Caio Defensor Brasil Da Silva
 */

import java.util.Arrays;

public class Disciplina {

    private String nomeDisciplina;
    private int horasEstudo;
    private double[] notas = {0, 0, 0, 0};

    public Disciplina(String nomeDisciplina) { this.nomeDisciplina = nomeDisciplina; }

    public void cadastraHoras(int horas) {
        horasEstudo += horas;
    }

    public void cadastraNota(int nota, double valorNota) {
        notas[nota-1] = valorNota;
    }

    public double calculaMedia() {
        Double soma = notas[0] + notas[1] + notas[2] + notas[3];
        return (soma / 4);
    }

    public boolean aprovado() {
        if (calculaMedia() >= 7) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Retorna a String que representa a disciplina. No formato: Disciplina Horas de estudo  Media Notas.
     * @return a representação em String do tempo online.
     */
    public String toString() {
        return nomeDisciplina + " " + horasEstudo + " " + calculaMedia() + " " + Arrays.toString(notas);
    }

    public double mediaPonderada(String getNomeDisciplina, int quantNotas, double[] notas, double[] pesos) {
        double soma = 0;
        if (pesos == null) {
            for (int i = 0; i < quantNotas; i++) {
                soma += notas[i];
            }
            return soma / quantNotas;
        }
        for (int i = 0; i < quantNotas; i++) {
            soma += notas[i] * pesos[i];
        }
        return soma/(Arrays.stream(pesos).sum());
    }
}