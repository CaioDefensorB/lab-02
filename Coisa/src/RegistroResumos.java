/**
 * Representação dos registros dos resumos
 * Podendo verificar se existe, imprimir, buscar por uma parte no conteudo, adicionar, pegar e contar.
 * É armazenado os resumos e a quantidade de resumos.
 *
 * @author Caio Defensor Brasil Da Silva
 */

import java.util.Arrays;

public class RegistroResumos {

    /**
     * resumos é um array de Resumo, quantidade de resumos e proxima posição em inteiros.
     */
    private Resumo[] resumos;
    private int quantidadeResumos;
    private int proximaPosicao;

    /**
     * Constrói o Registro de Resumos a partir do número de resumos.
     * Quantidade de resumos e proxima posição começam em 0.
     * @param numeroDeResumos quantidade de resumos
     */
    public RegistroResumos(int numeroDeResumos) {
        this.resumos = new Resumo[numeroDeResumos];
        this.quantidadeResumos = 0;
        this.proximaPosicao = 0;
    }

    /**
     * Confere se não tem nenhum resumo com o mesmo tema a ser adicionado.
     * Se já existir o mesmo tema do resumo a ser adicionado é adicionado o novo conteudo do mesmo tema no lugar do anterior.
     * Adiciona um resumo na primeira posição livre ou partir da primeira se for maior que o array.
     * Conta a quantidade de resumos.
     * @param tema tema do resumo.
     * @param conteudo conteúdo do resumo.
     */
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

    /**
     * Transfere todos os resumos adicionados para um novo array
     * @return array de todos os resumos adicionados
     */
    public String[] pegaResumos() {
        String[] resumoCompleto = new String[quantidadeResumos];
        for (int i = 0; i < quantidadeResumos; i++) {
            resumoCompleto[i] = resumos[i].toString();
        }
        return resumoCompleto;
    }

    /**
     * Junta todos oes resumos para imprimir.
     * @return resumos no formato: - Quantidade resumo(s) cadastrado(s)
     * - Tema1 | Tema2 ...
     */
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

    /**
     * Verifica se tem um resumo conforme o tema.
     * @param tema tema do resumo a ser encontrado
     * @return tipo booleano, true se existe o resumo com esse tema ou false se não.
     */
    public boolean temResumo(String tema) {
        for (int i = 0; i < quantidadeResumos; i++) {
            if (resumos[i].getTema().equals(tema)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Conta a quantidade de resumos.
     * @return quantidade de resumos.
     */
    public int conta() { return quantidadeResumos; }

    /**
     * Busca uma parte escrita em algum conteudo.
     * Após achar todos os conteúdos que tem o que se procura é criado um array
     * do tamanho da quantidade de temas que tem no seu conteúdo a parte buscada, podendo assim ordenar o array.
     * @param chaveDeBusca “String” que procura.
     * @return Temas ordenados que tem no conteúdo o que se procura.
     */
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
        String[] resultado = new String[posicao];
        for (int i = 0; i < posicao; i++) {
            resultado[i] = temasEncontrados[i];
        }
        Arrays.sort(resultado);
        return resultado;
    }
}