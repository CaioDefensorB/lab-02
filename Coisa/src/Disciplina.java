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
        Double Soma = notas[0] + notas[1] + notas[2] + notas[3];
        return (Soma / 4);
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

}