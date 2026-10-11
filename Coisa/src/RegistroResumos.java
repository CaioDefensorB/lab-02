/**
 * Representação dos registros dos resumos
 * Podendo verificar se existe, imrpimir, buscar por uma parte no conteudo, adicionar, pegar e contar.
 * É armazenado os resumos e a quantidade de resumos.
 *
 *
 * @author Caio Defensor Brasil Da Silva
 */

import java.util.Arrays;

public class RegistroResumos {

    private Resumo[] resumos;
    private int quantidadeResumos;
    private int proximaPosicao;

    public RegistroResumos(int numeroDeResumos) {
        this.resumos = new Resumo[numeroDeResumos];
        this.quantidadeResumos = 0;
        this.proximaPosicao = 0;
    }

    public void adiciona(String tema, String conteudo) {
        for (int i = 0; i < quantidadeResumos; i++) {
            if (resumos[i].getTema().equals(tema)) {
                resumos[i].setConteudo(conteudo);
                return;
            }
        }
        resumos[proximaPosicao] = new Resumo(tema, conteudo);

        if (quantidadeResumos < resumos.length) {
            quantidadeResumos += 1;
        }
        proximaPosicao = (proximaPosicao + 1) % resumos.length;
    }

    public String[] pegaResumos() {
        String[] resumoCompleto = new String[quantidadeResumos];
        for (int i = 0; i < quantidadeResumos; i++) {
            resumoCompleto[i] = resumos[i].toString();
        }
        return resumoCompleto;
    }

    public String imprimeResumos() {
        String texto = "- " + quantidadeResumos + " resumo(s) cadastrado(s)\n";
        if (quantidadeResumos >= 1) {
            texto += "- " + resumos[0].getTema();
        }
        for (int i = 1; i < quantidadeResumos; i++) {
            texto = texto + " | " + resumos[i].getTema();
        }
            return texto;
    }

    public boolean temResumo(String tema) {
        for (int i = 0; i < quantidadeResumos; i++) {
            if (resumos[i].getTema().equals(tema)) {
                return true;
            }
        }
        return false;
    }

    public int conta() { return quantidadeResumos; }

// pesquisei como usar o in que ja utilizava em pyhton//
    public String[] busca(String chaveDeBusca) {
        String[] temasEncontrados = new String[quantidadeResumos];
        int posicao = 0;
        String chave = chaveDeBusca.toLowerCase();
        for (int i =0; i < quantidadeResumos; i++) {
            String conteudoIndentificavel = (resumos[i].getConteudo()).toLowerCase();
            if (conteudoIndentificavel.contains(chave)) {
                temasEncontrados[posicao] = resumos[i].getTema();
                posicao++;
            }
        }
        Arrays.sort(temasEncontrados);
        return temasEncontrados;
    }
}