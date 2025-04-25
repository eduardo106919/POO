
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;



public class VideoYoutube {

    /**
     * Variáveis de Instância
     */

    private String nome;
    private byte[] conteudo;
    private LocalDateTime data_carregamento;
    private int resolucao;
    private int duracao; // em segundos
    private String[] comentarios;
    private int nr_comentarios;
    private int likes;
    private int dislikes;


    /**
     * Construtores
     */

    /**
     * Construtor por omissão de um Video de Youtube
     */
    public VideoYoutube() {
        this.nome = "";
        this.conteudo = new byte[10];
        this.data_carregamento = LocalDateTime.now();
        this.resolucao = 0;
        this.duracao = 0;
        this.comentarios = new String[10];
        this.nr_comentarios = 0;
        this.likes = this.dislikes = 0;
    }

    /**
     * Construtor parametrizado de um Video de Youtube
     *
     * @param nome nome do VideoYoutube
     * @param conteudo conteudo do VideoYoutube
     * @param resolucao resolucao do VideoYoutube
     * @param duracao duracao do VideoYoutube
     */
    public VideoYoutube(String nome, byte[] conteudo, int resolucao, int duracao) {
        this();
        this.nome = nome;
        this.conteudo = conteudo.clone();
        this.resolucao = resolucao;
        this.duracao = duracao;
    }

    /**
     * Construtor de cópia de um Video de Youtube
     *
     * @param outro VideoYoutube a copiar
     */
    public VideoYoutube(VideoYoutube outro) {
        this.nome = outro.nome;
        this.conteudo = outro.conteudo.clone();
        this.data_carregamento = outro.data_carregamento;
        this.resolucao = outro.resolucao;
        this.duracao = outro.duracao;
        this.comentarios = outro.comentarios.clone();
        this.nr_comentarios = outro.nr_comentarios;
        this.likes = outro.likes;
        this.dislikes = outro.dislikes;
    }


    /**
     * Métodos de Instância
     */

    // getters

    /**
     * Devolve o nome do VideoYoutube
     *
     * @return nome do VideoYoutube
     */
    public String get_nome() {
        return this.nome;
    }

    /**
     * Devolve o conteudo do VideoYoutube
     *
     * @return conteudo do VideoYoutube
     */
    public byte[] get_conteudo() {
        return this.conteudo.clone();
    }

    /**
     * Devolve a data de carregamento do VideoYoutube
     *
     * @return data de carregamento
     */
    public LocalDateTime get_data_carregamento() {
        return this.data_carregamento;
    }

    /**
     * Devolve a resolucao do VideoYoutube
     *
     * @return resolucao do VideoYoutube
     */
    public int get_resolucao() {
        return this.resolucao;
    }

    /**
     * Devolve a duracao do VideoYoutube
     *
     * @return duracao do VideoYoutube
     */
    public int get_duracao() {
        return this.duracao;
    }

    /**
     * Devolve os comentarios do VideoYoutube
     *
     * @return comentarios do VideoYoutube
     */
    public String[] get_comentarios() {
        return Arrays.copyOfRange(this.comentarios, 0, this.nr_comentarios);
    }

    /**
     * Devolve o numero de likes no VideoYoutube
     *
     * @return numero de likes
     */
    public int get_likes() {
        return this.likes;
    }

    /**
     * Devolve o numero de dislikes no VideoYoutube
     *
     * @return numero de dislikes
     */
    public int get_dislikes() {
        return this.dislikes;
    }

    // setters
    
    /**
     * Altera o nome do VideoYoutube
     *
     * @param nome nome do VideoYoutube
     */
    public void set_nome(String nome) {
        this.nome = nome;
    }

    /**
     * Altera o conteudo do VideoYoutube
     *
     * @param conteudo conteudo do VideoYoutube
     */
    public void set_conteudo(byte[] conteudo) {
        this.conteudo = conteudo.clone();
    }

    /**
     * Altera a resolucao do VideoYoutube
     *
     * @param resolucao resolucao do VideoYoutube
     */
    public void set_resolucao(int resolucao) {
        this.resolucao = resolucao;
    }

    /**
     * Altera a duracao do VideoYoutube
     *
     * @param duracao duracao do VideoYoutube
     */
    public void set_duracao(int duracao) {
        this.duracao = duracao;
    }

    // métodos de utilidade

    /**
     * Compara um objeto ao VideoYoutube que recebe a mensagem
     *
     * @param outro objeto a comparar
     * @return true se forem iguais
     */
    public boolean equals(Object outro) {
        if (this == outro)
            return true;
        if ((outro == null) || (this.getClass() != outro.getClass()))
            return false;
        VideoYoutube temp = (VideoYoutube) outro;
        return this.nome.equals(temp.nome) && Arrays.equals(this.conteudo, temp.conteudo)
            && this.data_carregamento.equals(temp.data_carregamento)
            && this.resolucao == temp.resolucao && this.duracao == temp.duracao
            && this.nr_comentarios == temp.nr_comentarios && Arrays.equals(this.comentarios, temp.comentarios)
            && this.likes == temp.likes && this.dislikes == temp.dislikes;
    }

    /**
     * Devolve uma representacao textual de um VideoYoutube
     *
     * @return representacao textual
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("Nome: ").append(this.nome);
        sb.append("\nData carregamento: ").append(this.data_carregamento);
        sb.append("\nResolucao: ").append(this.resolucao);
        sb.append("\nDuracao: ").append(this.duracao);
        sb.append("\nLikes: ").append(this.likes);
        sb.append("\nDislikes: ").append(this.dislikes);
        sb.append(Arrays.toString(this.comentarios));

        return sb.toString();
    }

    /**
     * Cria uma cópia do VideoYoutube que recebe a mensagem
     *
     * @return cópia do VideoYoutube
     */
    public VideoYoutube clone() {
        return new VideoYoutube(this);
    }

    // outros métodos

    /**
     * Método que insere um comentário ao vídeo
     *
     * @param comentario comentario a adicionar
     */
    public void insereComentario(String comentario) {
        // array cheio
        if (this.nr_comentarios == this.comentarios.length) {
            String[] temp = new String[this.nr_comentarios * 2];

            for (int i = 0; i < this.nr_comentarios; i++) {
                temp[i] = this.comentarios[i];
            }

            this.comentarios = temp;
        }

        this.comentarios[this.nr_comentarios] = comentario;
        this.nr_comentarios++;
    }

    /**
     * Método que determina quantos dias passaram deste que o vídeo foi publicado
     *
     * @return número de dias passados
     */
    public long qtsDiasDepois() {
        return ChronoUnit.DAYS.between(this.data_carregamento, LocalDateTime.now());
    }

    /**
     * Método que faz um like
     */
    public void thumbsUp() {
        this.likes++;
    }

    /**
     * Método que faz um dislike
     */
    public void thumbsDown() {
        this.dislikes++;
    }

    /**
     * Método que devolve o conteúdo do vídeo pronto para ser depois
     * enviado para um qualquer render
     *
     * @return conteudo processado
     */
    public String processa() {
        return Arrays.toString(this.conteudo);
    }
}

