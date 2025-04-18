

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;




public class FBPost {

    /**
     * Variáveis de Instância
     */

    private static int posts_contador = 0;

    private int identificador;
    private String autor;
    private LocalDateTime instante_criacao;
    private String conteudo;
    private int likes;
    private ArrayList<String> comentarios;


    /**
     * Construtores
     */

    /**
     * Construtor por omissão de um FBPost
     */
    public FBPost() {
        this.identificador = FBPost.posts_contador;
        this.autor = "";
        this.instante_criacao = LocalDateTime.now();
        this.conteudo = "";
        this.likes = 0;
        this.comentarios = new ArrayList<String>();
    }

    /**
     * Construtor parametrizado de um FBPost
     *
     * @param autor nome do utilizador que fez o post
     * @param conteudo conteudo do post
     */
    public FBPost(String autor, String conteudo) {
        this();
        this.autor = autor;
        this.conteudo = conteudo;
    }

    /**
     * Construtor de cópia de um FBPost
     *
     * @param outro FBPost a copiar
     */
    public FBPost(FBPost outro) {
        this.identificador = outro.identificador;
        this.autor = outro.autor;
        this.instante_criacao = outro.instante_criacao;
        this.conteudo = outro.conteudo;
        this.likes = outro.likes;
        this.comentarios = new ArrayList<String>(outro.comentarios);
    }

    /**
     * Métodos de Instância
     */

    // getters
    
    /**
     * Devolve o número de FBPosts únicos existentes
     *
     * @return número de FBPosts existentes
     */
    public static int get_fbpost_contador() {
        return FBPost.posts_contador;
    }

    /**
     * Devolve o identificador do FBPost
     *
     * @return identificador
     */
    public int get_identificador() {
        return this.identificador;
    }

    /**
     * Devolve o nome do utilizador que publicou o post
     *
     * @return nome do utilizador
     */
    public String get_autor() {
        return this.autor;
    }

    /**
     * Devolve o instante no qual o post foi criado
     *
     * @return instante de criação
     */
    public LocalDateTime get_instante_criacao() {
        return this.instante_criacao;
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
     * Devolve o número de likes no post
     *
     * @return número de likes
     */
    public int get_likes() {
        return this.likes;
    }

    /**
     * Devolve os comentarios do post
     *
     * @return comentarios
     */
    public List<String> get_comentarios() {
        return this.comentarios.stream().collect(Collectors.toList());
    }

    // setters
    
    /**
     * Altera o nome do utilizador que fez o post
     *
     * @param autor nome do utilizador
     */
    public void set_autor(String autor) {
        this.autor = autor;
    }

    /**
     * Altera o conteudo do post
     *
     * @param conteudo conteudo do post
     */
    public void set_conteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    // métodos de utilidade

    /**
     * Compara um objeto a um FBPost
     *
     * @param outro objeto a comparar
     * @return true se forem iguais
     */
    public boolean equals(Object outro) {
        if (this == outro)
            return true;
        if ((outro == null) || (this.getClass() != outro.getClass()))
            return false;
        FBPost temp = (FBPost) outro;
        return this.identificador == temp.identificador && this.autor.equals(temp.autor)
            && this.instante_criacao.equals(temp.instante_criacao) && this.conteudo.equals(temp.conteudo)
            && this.likes == temp.likes && this.comentarios.equals(temp.comentarios);
    }

    /**
     * Devolve uma representacao textual de um FBPost
     *
     * @return representacao textual
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("Id: ").append(this.identificador);
        sb.append("Autor: ").append(this.autor);
        sb.append("Instante: ").append(this.instante_criacao.toString());
        sb.append("Conteudo: ").append(this.conteudo);
        sb.append("Likes: ").append(this.likes);
        this.comentarios.forEach(s -> sb.append(s));

        return sb.toString();
    }

    /**
     * Cria uma cópia de um FBPost
     *
     * @return cópia de um FBPost
     */
    public FBPost clone() {
        return new FBPost(this);
    }

    // outros métodos

    /**
     * Dá um like no FBPost
     */
    public void like() {
        this.likes++;
    }

    /**
     * Adiciona um comentário a um FBPost
     *
     * @param coment comentario a adicionar
     */
    public void adiciona_comentario(String coment) {
        this.comentarios.add(coment);
    }

    /**
     * Devolve o número de comentários
     *
     * @return número de comentarios
     */
    public int get_nr_comentarios() {
        return this.comentarios.size();
    }
}
