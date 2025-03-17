
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


/**
 * Classe que representa um Post no Facebook
 */
public class FBPost {

    /**
     * Variáveis de Instância
     */

    // indica o número total de posts
    private static int ids_totais = 0;

    private int identificador;
    private String utilizador;
    private LocalDateTime instante;

    private String conteudo;
    private int likes;

    private ArrayList<String> comentarios;


    /**
     * Construtores
     */

    /**
     * Construtor por omissão da classe Facebook Post
     */
    public FBPost() {
        this.identificador = FBPost.ids_totais++;
        this.utilizador = "n/a";
        this.instante = LocalDateTime.now();

        this.conteudo = "n/a";
        this.likes = 0;

        this.comentarios = new ArrayList<String>();
    }

    /**
     * Construtor parametrizado da classe Facebook Post
     *
     * @param user nome do utilizador
     * @param conteudo conteudo do Post
     */
    public FBPost(String user, String conteudo) {
        this.identificador = FBPost.ids_totais++;
        this.utilizador = user;
        this.instante = LocalDateTime.now();

        this.conteudo = conteudo;
        this.likes = 0;

        this.comentarios = new ArrayList<String>();
    }

    /**
     * Construtor de cópia para a class Facebook Post
     *
     * @param outro outro Facebook Post
     */
    public FBPost(FBPost outro) {
        if (outro != null) {
            this.identificador = outro.identificador;
            this.utilizador = outro.utilizador;
            this.instante = outro.instante;

            this.conteudo = outro.conteudo;
            this.likes = outro.likes;

            // comentários são strings, por isso shallow clone não é problema
            this.comentarios = new ArrayList<String>(outro.comentarios);
        }
    }

    /**
     * Métodos de Instância
     */

    // getters

    /**
     * Devolve o número total de identificadores
     *
     * @return número total de identificadores
     */
    public static int get_ids_totais() {
        return FBPost.ids_totais;
    }

    /**
     * Devolve o identificador do Post
     *
     * @return identificador do post
     */
    public int get_identificador() {
        return this.identificador;
    }

    /**
     * Devolve o nome do utilizador que publicou o post
     *
     * @return nome do utilizador
     */
    public String get_utilizador() {
        return this.utilizador;
    }

    /**
     * Devolve o instante no qual o post foi publicado
     *
     * @return instante de publicação
     */
    public LocalDateTime get_instante() {
        return this.instante;
    }

    /**
     * Devolve o conteudo do post
     *
     * @return conteudo do post
     */
    public String get_conteudo() {
        return this.conteudo;
    }

    /**
     * Devolve o número de likes do post
     *
     * @return número de likes
     */
    public int get_likes() {
        return this.likes;
    }

    /**
     * Devolve os comentários do post
     *
     * @return lista de comentários
     */
    public List<String> get_comentarios() {
        // são strings, shallow clone não é problema
        return new ArrayList<String>(this.comentarios);
    }

    // setters
    
    /**
     * Altera o nome do utilizador que publicou o post
     *
     * @param nome nome do utilizador
     */
    public void set_utilizador(String nome) {
        this.utilizador = nome;
    }

    /**
     * Altera o conteudo do post
     *
     * @param conteudo novo conteudo do post
     */
    public void set_conteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    // outros métodos

    /**
     * Compara dois objetos
     *
     * @param o objeto a comparar
     * @return true se os objetos forem iguais
     */
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (o == null || this.getClass() != o.getClass())
            return false;
        FBPost outro = (FBPost) o;
        return this.identificador == outro.identificador && this.utilizador.equals(outro.utilizador)
            && this.conteudo.equals(outro.conteudo) && this.instante.equals(outro.instante)
            && this.likes == outro.likes && this.comentarios.equals(outro.comentarios);
    }

    /**
     * Clona um FBPost
     *
     * @return objeto clonado
     */
    public FBPost clone() {
        return new FBPost(this);
    }

    /**
     * Transforma um FBPost numa string
     *
     * @return String com a informação relativa a um FBPost
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("id: ").append(this.identificador);
        sb.append("utilizador: ").append(this.utilizador);
        sb.append("instante: ").append(this.instante);
        sb.append("conteudo: ").append(this.conteudo);
        sb.append("likes: ").append(this.likes);
        sb.append("comentarios: ").append(this.comentarios.toString());

        return sb.toString();
    }
}
