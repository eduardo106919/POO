package dev.example;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Post de um utilizador no Facebook.
 * @author Eduardo Freitas Fernandes
 */
public class FBPost {

    // variáveis de classe

    /** número total de posts únicos */
    private static int totalPosts = 0;

    // variáveis de instância

    /** identificador único do post */
    private final int id;
    /** nome do utilizador */
    private String utilizador;
    /** instante de publicação do post */
    private LocalDateTime instante;
    /** conteudo do post */
    private String conteudo;
    /** número de likes do post */
    private int likes;
    /** lista de comentários associados ao post */
    private List<String> comentarios;


    // construtores

    /**
     * Construtor por omissão de um FBPost
     */
    public FBPost() {
        id = FBPost.totalPosts++;
        utilizador = conteudo = "";
        instante = LocalDateTime.now();
        likes = 0;
        comentarios = new ArrayList<>();
    }

    /**
     * Construtor parametrizado de um FBPost
     * @param utilizador nome do utilizador
     * @param instante instante de publicação
     * @param conteudo conteudo do post
     * @param likes número de likes
     * @param comentarios lista de comentários
     */
    public FBPost(String utilizador,
                  LocalDateTime instante,
                  String conteudo,
                  int likes,
                  List<String> comentarios) {
        this.id = FBPost.totalPosts++;
        this.utilizador = utilizador;
        this.conteudo = conteudo;
        this.instante = instante;
        this.likes = likes;
        this.comentarios = new ArrayList<>(comentarios);
    }

    /**
     * Construtor de cópia de um FBPost
     * @param other FBPost a copiar
     */
    public FBPost(FBPost other) {
        id = other.id;
        utilizador = other.utilizador;
        conteudo = other.conteudo;
        instante = other.instante;
        likes = other.likes;
        comentarios = new ArrayList<>(other.comentarios);
    }


    // métodos de instância

    /**
     * Devolve o número total de posts únicos
     * @return número total de posts
     */
    public static int getTotalPosts() {
        return totalPosts;
    }

    /**
     * Devolve o identificador único do post
     * @return identificador único
     */
    public int getId() {
        return id;
    }

    /**
     * Devolve o nome do utilizador que publicou o post
     * @return nome do utilizador
     */
    public String getUtilizador() {
        return utilizador;
    }

    /**
     * Altera o nome do utilizador que publicou o post
     * @param utilizador nome do utilizador
     */
    public void setUtilizador(String utilizador) {
        this.utilizador = utilizador;
    }

    /**
     * Devolve o instante que o post foi publicado
     * @return instante que o post foi publicado
     */
    public LocalDateTime getInstante() {
        return instante;
    }

    /**
     * Altera o instante que o post foi publicado
     * @param instante instante que o post foi publicado
     */
    public void setInstante(LocalDateTime instante) {
        this.instante = instante;
    }

    /**
     * Devolve o conteúdo do post
     * @return conteúdo do post
     */
    public String getConteudo() {
        return conteudo;
    }

    /**
     * Altera o conteúdo do post
     * @param conteudo conteúdo do post
     */
    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    /**
     * Devolve o número de likes do post
     * @return número de likes
     */
    public int getLikes() {
        return likes;
    }

    /**
     * Altera o número de likes do post
     * @param likes número de likes
     */
    public void setLikes(int likes) {
        this.likes = likes;
    }

    /**
     * Devolve a lista de comentários do post
     * @return lista de comentários
     */
    public List<String> getComentarios() {
        return new ArrayList<>(comentarios);
    }

    /**
     * Altera a lista de comentários do post
     * @param comentarios lista de comentários
     */
    public void setComentarios(List<String> comentarios) {
        this.comentarios = new ArrayList<>(comentarios);
    }

    /**
     * Adiciona um comentário ao post
     * @param comentario comentário a adicionar
     */
    public void comentar(String comentario) {
        comentarios.add(comentario);
    }

    /**
     * Adiciona um like ao post
     */
    public void like() {
        likes++;
    }

    /**
     * Devolve o número de comentários no post
     * @return número de comentários
     */
    public int getNrComentarios() {
        return comentarios.size();
    }

    /**
     * Efetua uma cópia de um FBPost
     * @return cópia de um FBPost
     */
    @Override
    public FBPost clone() {
        return new FBPost(this);
    }

    /**
     * Devolve uma representação textual de um FBPost
     * @return representação textual
     */
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        builder.append("FBPost: {");
        builder.append("id: ").append(id);
        builder.append(", utilizador: ").append(utilizador);
        builder.append(", instante: ").append(instante.toString());
        builder.append(", conteudo: ").append(conteudo);
        builder.append(", likes: ").append(likes);
        builder.append(", comentarios: ");
        comentarios.forEach(c -> builder.append(c).append(" "));
        builder.append("}");

        return builder.toString();
    }

    /**
     * Compara um objeto a um FBPost
     * @param obj objeto a comparar
     * @return {@code true} se forem iguais, {@code false} caso contrário
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (this.getClass() != obj.getClass()) return false;

        FBPost other = (FBPost) obj;
        return id == other.id && utilizador.equals(other.utilizador)
                && instante.equals(other.instante) && conteudo.equals(other.conteudo)
                && likes == other.likes && comentarios.equals(other.comentarios);
    }

}
