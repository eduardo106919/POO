
import java.util.Arrays;

public class Musica {

    /**
     * Variáveis de Instância
     */

    private String nome;
    private String interprete;
    private String autor;
    private String editora;

    private String[] letra;
    private int letra_count;

    private String[] pauta;
    private int pauta_count;

    private int duracao; // em segundos
    private int reproducoes;

    /**
     * Construtores
     */

    /**
     * Construtor por omissão de uma Musica
     */
    public Musica() {
        this.nome = "";
        this.interprete = "";
        this.autor = "";
        this.editora = "";

        this.letra = new String[10];
        this.pauta = new String[10];
        this.letra_count = this.pauta_count = 0;

        this.duracao = 0;
        this.reproducoes = 0;
    }

    /**
     * Construtor paramtrizado de uma Musica
     *
     * @param nome nome da Musica
     * @param interprete cantor da Musica
     * @param autor autor da Musica
     * @param editora nome da editora da Musica
     * @param letra linhas de texto do poema da Musica
     * @param pauta linhas de texto da pauta da Musica
     * @param duracao duracao em segundos da Musica
     */
    public Musica(String nome, String interprete, String autor, String editora, String[] letra, String[] pauta, int duracao) {
        this.nome = nome;
        this.interprete = interprete;
        this.autor = autor;
        this.editora = editora;

        this.letra = letra.clone();
        this.letra_count = letra.length;

        this.pauta = pauta.clone();
        this.pauta_count = pauta.length;

        this.duracao = duracao;
        this.reproducoes = 0;
    }

    /**
     * Construtor de cópia de uma Musica
     *
     * @param outro Musica a copiar
     */
    public Musica(Musica outro) {
        this.nome = outro.nome;
        this.interprete = outro.interprete;
        this.autor = outro.autor;
        this.editora = outro.editora;
        
        this.letra = outro.letra.clone();
        this.letra_count = outro.letra_count;

        this.pauta = outro.pauta.clone();
        this.pauta_count = outro.pauta_count;

        this.duracao = outro.duracao;
        this.reproducoes = outro.reproducoes;
    }

    /**
     * Métodos de Instância
     */

    // getters
    
    /**
     * Devolve o nome da Musica
     *
     * @return nome da Musica
     */
    public String get_nome() {
        return this.nome;
    }

    /**
     * Devolve o interprete da Musica
     *
     * @return interprete da Musica
     */
    public String get_interprete() {
        return this.interprete;
    }

    /**
     * Devolve o autor da Musica
     *
     * @return autor da Musica
     */
    public String get_autor() {
        return this.autor;
    }

    /**
     * Devolve o nome da editora da Musica
     *
     * @return nome da editora da Musica
     */
    public String get_editora() {
        return this.editora;
    }

    /**
     * Devolve a letra da Musica
     *
     * @return letra da Musica
     */
    public String[] get_letra() {
        return this.letra.clone();
    }

    /**
     * Devolve a pauta musical da Musica
     *
     * @return pauta musical da Musica
     */
    public String[] get_pauta() {
        return this.pauta.clone();
    }

    /**
     * Devolve a duracao em segundos da Musica
     *
     * @return duracao da Musica
     */
    public int get_duracao() {
        return this.duracao;
    }

    /**
     * Devolve o numero de reproducoes da Musica
     *
     * @return numero de audicoes da Musica
     */
    public int get_reproducoes() {
        return this.reproducoes;
    }

    // setters
    
    /**
     * Altera o nome da Musica
     *
     * @param nome nome da Musica
     */
    public void set_nome(String nome) {
        this.nome = nome;
    }

    /**
     * Altera o interprete da Musica
     *
     * @param interprete interprete da Musica
     */
    public void set_interprete(String interprete) {
        this.interprete = interprete;
    }

    /**
     * Altera o autor da Musica
     *
     * @param autor autor da Musica
     */
    public void set_autor(String autor) {
        this.autor = autor;
    }

    /**
     * Altera o nome da editora da Musica
     *
     * @param editora nome da editora da Musica
     */
    public void set_editora(String editora) {
        this.editora = editora;
    }

    /**
     * Altera a letra da Musica
     *
     * @param letra letra da Musica
     */
    public void set_letra(String[] letra) {
        this.letra = letra.clone();
        this.letra_count = letra.length;
    }

    /**
     * Altera a pauta musical da Musica
     *
     * @param pauta pauta musical da Musica
     */
    public void set_pauta(String[] pauta) {
        this.pauta = pauta.clone();
        this.pauta_count = pauta.length;
    }

    /**
     * Altera a duracao, em segundos, da Musica
     *
     * @param duracao duracao da Musica
     */
    public void set_duracao(int duracao) {
        this.duracao = duracao;
    }

    // métodos de utilidade

    /**
     * Devolve uma representacao textual de uma Musica
     *
     * @return representacao textual de uma Musica
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("Nome: ").append(this.nome);
        sb.append("\nInterprete: ").append(this.interprete);
        sb.append("\nAutor: ").append(this.autor);
        sb.append("\nEditora: ").append(this.editora);
        sb.append("\nLetra:\n");
        for (int i = 0; i < this.letra_count; i++) {
            sb.append(this.letra[i]).append("\n");
        }
        sb.append("Pauta:\n");
        for (int i = 0; i < this.pauta_count; i++) {
            sb.append(this.pauta[i]).append("\n");
        }
        sb.append("Duracao: ").append(this.duracao);
        sb.append("\nReproducoes: ").append(this.reproducoes);

        return sb.toString();
    }

    /**
     * Compara um objeto à Musica que recebe a mensagem
     *
     * @param outro objeto a comparar
     * @return true se forem iguais
     */
    public boolean equals(Object outro) {
        if (this == outro)
            return true;
        if (outro == null || this.getClass() != outro.getClass())
            return false;
        Musica temp = (Musica) outro;
        return this.nome.equals(temp.nome) && this.interprete.equals(temp.interprete)
            && this.autor.equals(temp.autor) && this.editora.equals(temp.editora)
            && this.letra_count == temp.letra_count && Arrays.equals(this.letra, temp.letra)
            && this.pauta_count == temp.pauta_count && Arrays.equals(this.pauta, temp.pauta)
            && this.duracao == temp.duracao && this.reproducoes == temp.reproducoes;
    }

    /**
     * Cria uma cópia da Musica que recebe a mensagem
     *
     * @return cópia de uma Musica
     */
    public Musica clone() {
        return new Musica(this);
    }

    // outros métodos

    /**
     * Adiciona uma reproducao à Musica
     */
    public void reproduzir() {
        this.reproducoes++;
    }

    /**
     * Método que determina quantas linhas tem o poema da música
     *
     * @return número de linhas do poema
     */
    public int qtsLinhasPoema() {
        return this.letra_count;
    }

    /**
     * Método que determina o número de caracteres do poema
     *
     * @return número de caracteres do poema
     */
    public int numeroCarateres() {
        int total = 0;
        for (int i = 0; i < this.letra_count; i++) {
            total += this.letra[i].length();
        }

        return total;
    }

    /**
     * Adiciona uma nova linha de texto ao poema, especificando
     * em que posição do poema é que a nova linha deverá ficar
     *
     * @param posicao posicao especifica
     * @param novaLinha linha de texto a adicionar
     */
    public void addLetra(int posicao, String novaLinha) {
        int i;
        // array está cheio
        if (this.letra_count == this.letra.length) {
            String[] temp = new String[this.letra_count * 2];

            for (i = 0; i < this.letra_count; i++) {
                temp[i] = this.letra[i];
            }

            this.letra = temp;
        }

        // posicao é maior que número de linhas
        if (posicao > this.letra_count) {
            posicao = this.letra_count;
        }

        // puxar todas as linhas uma cada para a direita
        for (i = this.letra_count; i > posicao; i--) {
            this.letra[i] = this.letra[i - 1];
        }

        // colocar novaLinha na posicao desejada
        this.letra[posicao] = novaLinha;
        this.letra_count++;
    }

    /**
     * Método que determina a linha do poema com mais caracteres
     *
     * @return linha do poema com mais caracteres
     */
    public String linhaMaisLonga() {
        if (this.letra_count == 0) {
            return null;
        }

        int max = 0;
        for (int i = 1; i < this.letra_count; i++) {
            if (this.letra[i].length() > this.letra[max].length()) {
                max = i;
            }
        }

        return this.letra[max];
    }

    /**
     * Método que determina as três letras mais utilizadas no poema
     *
     * @return três letras mais utilizadas
     */
    public String[] letrasMaisUtilizadas() {
        int[] count = new int[this.letra_count];
        int i, j;
        int max = Integer.MIN_VALUE;

        // contar cada linha
        for (i = 0; i < this.letra_count; i++) {
            count[i] = 0;
            for (j = 0; j < this.letra_count; j++) {
                if (this.letra[i].equals(this.letra[j])) {
                    count[i]++;
                }
            }

            if (count[i] > max) {
                max = i;
            }
        }

        String[] res = new String[3];
        int temp = 0;

        // selecionar as tres mais usadas
        for (i = 0; i < 3; i++) {
            res[i] = this.letra[max];
            temp = max;
            max = 0;

            for (j = 0; j < this.letra_count; j++) {
                if (j != temp && this.letra[temp].equals(this.letra[j]) == false && count[j] > count[max]) {
                    max = j;
                }
            }
        }

        return res;
    }
}
