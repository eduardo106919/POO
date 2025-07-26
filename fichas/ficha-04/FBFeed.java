
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;



public class FBFeed {

    /**
     * Variáveis de Instância
     */

    private ArrayList<FBPost> posts;


    /**
     * Construtores
     */

    /**
     * Construtor por omissão de um FBFeed
     */
    public FBFeed() {
        this.posts = new ArrayList<FBPost>();
    }
    
    /**
     * Construtor parametrizado de um FBFeed
     *
     * @param posts colecao de posts
     */
    public FBFeed(Collection<FBPost> posts) {
        this.posts = posts.stream().map(FBPost::clone).collect(Collectors.toCollection(ArrayList::new));
    }

    /**
     * Construtor de cópia de um FBFeed
     *
     * @param outro FBFeed a copiar
     */
    public FBFeed(FBFeed outro) {
        this.posts = outro.posts.stream().map(FBPost::clone).collect(Collectors.toCollection(ArrayList::new));
    }


    /**
     * Métodos de Instância
     */

    // getters
    
    /**
     * Devolve a lista de posts
     *
     * @return lista de posts
     */
    public List<FBPost> get_posts() {
        return this.posts.stream().map(FBPost::clone).collect(Collectors.toList());
    }

    // setters
    
    /**
     * Altera os posts
     *
     * @param posts colecao de posts
     */
    public void set_posts(Collection<FBPost> posts) {
        this.posts = posts.stream().map(FBPost::clone).collect(Collectors.toCollection(ArrayList::new));
    }

    // métodos de utilidade

    /**
     * Compara um objeto a um FBFeed
     *
     * @param outro objeto a comparar
     * @return true se forem iguais
     */
    public boolean equals(Object outro) {
        if (this == outro)
            return true;
        if ((outro == null) || (this.getClass() != outro.getClass()))
            return false;
        FBFeed temp = (FBFeed) outro;
        return this.posts.equals(temp.posts);
    }

    /**
     * Devolve uma representacao textual de um FBFeed
     *
     * @return representacao textual
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();

        this.posts.forEach(p -> sb.append(p.toString()));

        return sb.toString();
    }

    /**
     * Cria uma cópia de um FBFeed
     *
     * @return cópia de um FBFeed
     */
    public FBFeed clone() {
        return new FBFeed(this);
    }

    // outros métodos

    /**
     * Determinar o número de posts de um user
     *
     * @param user nome do user
     * @return número de posts de um user
     */
    public int nrPosts(String user) {
        return (int) this.posts.stream().filter(p -> p.get_autor().equals(user)).count();
    }

    /**
     * Determinar a lista de posts de um user
     *
     * @param user nome do user
     * @return lista de posts de um user
     */
    public List<FBPost> postsOf(String user) {
        return this.posts.stream().filter(p -> p.get_autor().equals(user)).map(FBPost::clone).collect(Collectors.toList());
    }

    /**
     * Determinar a lista de posts de um user num determinado intervalo de tempo
     *
     * @param user nome do user
     * @param inicio data inicial
     * @param fim data do fim
     * @return lista de posts
     */
    public List<FBPost> postsOf(String user, LocalDateTime inicio, LocalDateTime fim) {
        return this.posts.stream()
                         .filter(p -> p.get_autor().equals(user))
                         .filter(p -> p.get_instante_criacao().isAfter(inicio))
                         .filter(p -> p.get_instante_criacao().isBefore(fim))
                         .map(FBPost::clone)
                         .collect(Collectors.toList());
    }

    /**
     * Obter um post dado o seu identificador
     *
     * @param id identificador do FBPost
     * @return FBPost
     */
    public FBPost getPost(int id) {
        Iterator<FBPost> iterator = this.posts.iterator();
        FBPost temp = null;

        while (iterator.hasNext()) {
            temp = iterator.next();
            if (temp.get_identificador() == id) {
                return temp.clone();
            }
        }

        return null;
    }

    /**
     * Inserir um comentário num post 
     *
     * @param post Facebook post
     * @param comentario comentario a adicionar
     */
    public void comment(FBPost post, String comentario) {
        int index = this.posts.indexOf(post);
        if (index >= 0) {
            this.posts.get(index).adiciona_comentario(comentario);
        }
    }
    
    /**
     * Inserir um comentário num post
     *
     * @param postid identificador do post
     * @param comentario comentario a adicionar
     */
    public void comment(int postid, String comentario) {
        Iterator<FBPost> iterator = this.posts.iterator();
        FBPost temp = null;
        boolean found = false;

        while (!found && iterator.hasNext()) {
            temp = iterator.next();
            if (temp.get_identificador() == id) {
                temp.adiciona_comentario(comentario);
                found = true;
            }
        }
    }

    /**
     * Adicionar um like a um post
     *
     * @param post FBPost
     */
    public void like(FBPost post) {
        int index = this.posts.indexOf(post);
        if (index >= 0) {
            this.posts.get(index).like();
        }
    }

    /**
     * Adicionar um like a um post
     *
     * @param postid identificador do FBPost
     */
    public void like(int postid) {
        Iterator<FBPost> iterator = this.posts.iterator();
        FBPost temp = null;
        boolean found = false;

        while (!found && iterator.hasNext()) {
            temp = iterator.next();
            if (temp.get_identificador() == postid) {
                temp.like();
                found = true;
            }
        }
    }

    /**
     * Determinar a lista dos 5 posts (identificador) com mais comentários
     * Versão de Iteradores Internos
     *
     * @return 5 posts com mais comentários
     */
    // TODO
    public List<Integer> top5Comments_E() {
        return null;
    }

    /**
     * Determinar a lista dos 5 posts (identificador) com mais comentários
     * Versão de Iteradores Externos
     *
     * @return 5 posts com mais comentários
     */
    public List<Integer> top5Comments_I() {
        return this.posts.stream()
                         .sorted((p1, p2) -> Integer.compare(p2.get_nr_comentarios(), p1.get_nr_comentarios())) // ordem decrescente
                         .mapToInt(FBPost::get_identificador)
                         .limit(5)
                         .collect(Collectors.toList());
    }
}

