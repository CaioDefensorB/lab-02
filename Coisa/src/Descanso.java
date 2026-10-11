/**
 * Representação da rotina do estudante, e verificação da sua situação.
 * É armazenado horas de descanso e numeros de semanas.
 * O aluno podendo estar cansado (media horas de descando >= 26) ou descansado (media media horas descanso < 26).
 *
 * @author Caio Defensor Brasil Da Silva
 */

public class Descanso {

    /**
     * horas de descanso e o numero de semanas em inteiros
     */
    private int horasDescanso;
    private int numeroSemanas;

    /**
     * Constroi o descanso a partir de horas de descanso e um numero de semanas.
     */
    public Descanso() {
        this.horasDescanso = 0;
        this.numeroSemanas = 0;
    }

    /**
     * Define a quantidade de horas de descanso o aluno teve.
     * @param valor as horas de descanso que o aluno teve.
     */
    public void defineHorasDescanso(int valor) {
        this.horasDescanso = valor;
    }

    /**
     * Define o numero de semanas que o aluno teve determinada quantidade de horas de descanso
     * @param valor as semanas que pertecem ao periodo das horas de descanso contabilizadas
     */
    public void defineNumeroSemanas(int valor) {
        this.numeroSemanas = valor;
    }

    /**
     * Faz uma media de horas descansadas por semana.
     * Se for maior ou igual a 26 define que o aluno esta descansado, se não cansado
     * @return se o aluno está cansado ou descansado(sua situação)
     */
    public String getStatusGeral() {
        if (numeroSemanas != 0 && (horasDescanso / numeroSemanas) >= 26) {return "descansado";}
        return "cansado";
    }
}