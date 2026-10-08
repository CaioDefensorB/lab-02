import java.util.Arrays;

public class Disciplina {

    private String nomeDisciplina;
    private int horasEstudo;
    private double[] notas = {0, 0, 0, 0};

    public Disciplina(String nomeDisciplina) {
        this.nomeDisciplina = nomeDisciplina;
    }

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

    public String toString() {
        return nomeDisciplina + " " + horasEstudo + " " + calculaMedia() + " " + Arrays.toString(notas);
    }
    public double[] recebeNotas(double []) {

    }
    public double mediaPonderada(String getNomeDisciplina, double[] notas, double[] pesos) {
        int quantNotas = notas.length;
        double soma = 0;
        if (pesos == null) {
            for (int i = 0; i < quantNotas; i++) {

                soma += notas[i]
            }
            return soma / quantNotas
        }

        for (int i = 0; i < quantNotas; i++) {

            soma += notas[i] * pesos[i]
        }
        return soma/(Arrays.stream(pesos).sum()) ;
    }
}