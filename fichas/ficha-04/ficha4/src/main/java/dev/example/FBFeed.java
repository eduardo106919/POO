package dev.example;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Classe que implementa a timeline de posts do Facebook.
 * @author Eduardo Freitas Fernandes
 */
public class FBFeed {

    // variáveis de instância

    /** timeline de posts do Facebook */
    private List<FBPost> posts;


    // construtores

    /**
     * Construtor por omissão de um FBFeed
     */
    public FBFeed() {
        posts = new ArrayList<>();
    }

    /**
     * Construtor parametrizado de um FBFeed
     * @param posts timeline de posts
     */
    public FBFeed(List<FBPost> posts) {
        this.posts = posts.stream()
                .map(FBPost::clone)
                .collect(Collectors.toList());
    }

    /**
     * Construtor de cópia de um FBFeed
     * @param other FBFeed a copiar
     */
    public FBFeed(FBFeed other) {
        posts = other.posts.stream()
                .map(FBPost::clone)
                .collect(Collectors.toList());
    }


    // métodos de instância

    /**
     * Devolve uma cópia da timeline de posts
     * @return timeline de posts
     */
    public List<FBPost> getPosts() {
        return posts.stream()
                .map(FBPost::clone)
                .collect(Collectors.toList());
    }

    /**
     * Altera a timeline de posts
     * @param posts timeline de posts
     */
    public void setPosts(List<FBPost> posts) {
        this.posts = posts.stream()
                .map(FBPost::clone)
                .collect(Collectors.toList());
    }

    /**
     * Determina o número de posts de um user
     * @param user nome do utilizador
     * @return número de publicações
     */
    public int nrPosts(String user) {
        return (int) posts.stream()
                .filter(p -> p.getUtilizador().equals(user))
                .count();
    }

    /**
     * Determina a lista de posts de um user
     * @param user nome do utilizador
     * @return lista de publicações
     */
    public List<FBPost> postsOf(String user) {
        return posts.stream()
                .filter(p -> p.getUtilizador().equals(user))
                .map(FBPost::clone)
                .collect(Collectors.toList());
    }

    /**
     * Determina a lista de posts de um user num determinado intervalo de tempo
     * @param user nome do utilizador
     * @param inicio data inicial do intervalo
     * @param fim data final do intervalo
     * @return lista de publicações
     */
    public List<FBPost> postsOf(String user, LocalDateTime inicio, LocalDateTime fim) {
        return posts.stream()
                .filter(p -> p.getUtilizador().equals(user))
                .filter(p -> p.getInstante().isAfter(inicio))
                .filter(p -> p.getInstante().isBefore(fim))
                .map(FBPost::clone)
                .collect(Collectors.toList());
    }

    /**
     * Devolve um post dado o seu identificador
     * @param id identificador do post
     * @return cópia do post
     */
    public FBPost getPost(int id) {
        Iterator<FBPost> iterator = posts.iterator();
        FBPost p = null;

        while (iterator.hasNext()) {
            p = iterator.next();
            if (p.getId() == id) {
                return p.clone();
            }
        }

        // não encontrado
        return null;
    }

    /**
     * Insere um comentário num post
     * @param post publicação de referência
     * @param comentario comentário a adicionar
     */
    public void comment(FBPost post, String comentario) {
        Iterator<FBPost> iterator = posts.iterator();
        FBPost p = null;
        boolean found = false;

        while (iterator.hasNext() && !found) {
            p = iterator.next();
            if (p.equals(post)) {
                p.comentar(comentario);
                found = true;
            }
        }
    }

    /**
     * Insere um comentário num post
     * @param postid identificador do post
     * @param comentario comentário a adicionar
     */
    public void comment(int postid, String comentario) {
        Iterator<FBPost> iterator = posts.iterator();
        FBPost p = null;
        boolean found = false;

        while (iterator.hasNext() && !found) {
            p = iterator.next();
            if (p.getId() == postid) {
                p.comentar(comentario);
                found = true;
            }
        }
    }

    /**
     * Adiciona um like a uma publicação
     * @param post post de referência
     */
    public void like(FBPost post) {
        Iterator<FBPost> iterator = posts.iterator();
        FBPost p = null;
        boolean found = false;

        while (iterator.hasNext() && !found) {
            p = iterator.next();
            if (p.equals(post)) {
                p.like();
                found = true;
            }
        }
    }

    /**
     * Adiciona um like a uma publicação
     * @param postid identificador do post
     */
    public void like(int postid) {
        Iterator<FBPost> iterator = posts.iterator();
        FBPost p = null;
        boolean found = false;

        while (iterator.hasNext() && !found) {
            p = iterator.next();
            if (p.getId() == postid) {
                p.like();
                found = true;
            }
        }
    }

    /**
     * Determina as 5 publicações com mais comentários, usando iteradores externos
     * @return lista das 5 publicações mais comentadas
     */
    public List<Integer> top5CommentsExt() {
        // ordenar lista por número de comentários, invertida
        posts.sort((p1, p2) -> Integer.compare(p2.getNrComentarios(), p1.getNrComentarios()));

        int count = 0;
        Iterator<FBPost> iterator = posts.iterator();
        List<Integer> out = new ArrayList<>();

        // selecionar o top 5
        while (count < 5 && iterator.hasNext()) {
            out.add(iterator.next().getNrComentarios());
            count++;
        }

        return out;
    }

    /**
     * Determina as 5 publicações com mais comentários, usando iteradores internos
     * @return lista das 5 publicações mais comentadas
     */
    public List<Integer> top5CommentsInt() {
        return posts.stream()
                .map(FBPost::getNrComentarios)
                .sorted(Comparator.reverseOrder())
                .limit(5)
                .collect(Collectors.toList());
    }

    /**
     * Efetua uma cópia de um FBFeed
     * @return cópia de um FBFeed
     */
    @Override
    public FBFeed clone() {
        return new FBFeed(this);
    }

    /**
     * Devolve uma representação textual de um FBFeed
     * @return representação textual
     */
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        builder.append("FBFeed: {");
        posts.forEach(p -> builder.append(p.toString()).append(" "));
        builder.append("}");

        return builder.toString();
    }

    /**
     * Compara um objeto a um FBFeed
     * @param obj objeto a comparar
     * @return {@code true} se forem iguais, {@code false} caso contrário
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (this.getClass() != obj.getClass()) return false;

        FBFeed other = (FBFeed) obj;
        return posts.equals(other.posts);
    }

}
