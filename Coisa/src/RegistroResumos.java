public class RegistroResumos {

    private String[] temas;
    private String[] conteudos;
    private int quantidadeResumos;
    private int proximaPosicao;

    public RegistroResumos(int numeroDeResumos) {
        this.temas = new String[numeroDeResumos];
        this.conteudos = new String[numeroDeResumos];
        this.quantidadeResumos = 0;
        this.proximaPosicao = 0;

    }

    public void adicionaResumo(String tema, String conteudo) {
        for (int i = 0; i < quantidadeResumos; i++) {
            if (temas[i].equals(tema)) {
                conteudos[i] = conteudo;
                return;
            }
        }
        temas[proximaPosicao] = tema;
        conteudos[proximaPosicao] = conteudo;

        if (quantidadeResumos < temas.length) {
            quantidadeResumos += 1;
        }
        proximaPosicao = (proximaPosicao + 1) % temas.length;
    }

    public String[] pegaResumos() {
        String[] resumos = new String[quantidadeResumos];
        for (int i = 0; i < quantidadeResumos; i++) {
            resumos[i] = temas[i] + ": " + conteudos[i];
        }
        return resumos;
    }

    public String imprimeResumos() {
        String texto = "- " + quantidadeResumos + " resumo(s) cadastrado(s)\n";
        if (quantidadeResumos >= 1) {
            texto += "- " + temas[0];
        }
        for (int i = 1; i < quantidadeResumos; i++) {
            texto = texto +  " | " + temas[i];
        }
            return texto;
    }

    public int contaResumos() {
        return quantidadeResumos;
    }

    public boolean temResumo(String tema) {
        for (int i = 0; i < quantidadeResumos; i++) {
            if (temas[i].equals(tema)) {
                return true;
            }
        }
        return false;
    }
}