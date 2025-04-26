
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Collection;
import java.util.stream.Collectors;
import java.time.LocalDateTime;

public class FBFeedMap {

    /**
     * Variáveis de Instância
     */

    /** Associa um nome de utilizador aos posts por ele criados */
    private Map<String, List<FBPost>> posts;


    /**
     * Construtores
     */

    /**
     * Construtor por omissão de um FBFeedMap
     */
    public FBFeedMap() {
        this.posts = new HashMap<>();
    }

    /**
     * Construtor parametrizado de um FBFeedMap
     *
     * @param posts coleção de posts
     */
    public FBFeedMap(Collection<FBPost> posts) {
        this();
        Iterator<FBPost> iterator = posts.iterator();
        FBPost temp = null;
        List<FBPost> l = null;

        while (iterator.hasNext()) {
            temp = iterator.next();
            l = this.posts.get(temp.get_autor());
            if (l == null) {
                l = new ArrayList<>();
                this.posts.put(temp.get_autor(), l);
            }

            l.add(temp.clone());
        }
    }

    /**
     * Construtor de cópia de um FBFeedMap
     *
     * @param outro FBFeedMap a copiar
     */
    public FBFeedMap(FBFeedMap outro) {
        this();
        Iterator<Map.Entry<String, List<FBPost>>> iterator = outro.posts.entrySet().iterator();
        Map.Entry<String, List<FBPost>> temp = null;
        List<FBPost> l = null;

        while (iterator.hasNext()) {
            temp = iterator.next();
            this.posts.put(temp.getKey(), temp.getValue().stream()
                                .map(FBPost::clone)
                                .collect(Collectors.toList()));
        }
    }


    /**
     * Métodos de Instância
     */

    // getters

    /**
     * Devolve os posts guardados
     *
     * @return lista de posts
     */
    public List<FBPost> getPosts() {
        List<FBPost> temp = new ArrayList<>();
        this.posts.values().forEach(temp::addAll);

        return temp.stream().map(FBPost::clone).collect(Collectors.toList());
    }

    // setters

    public void setPosts(Collection<FBPost> posts) {
        this.posts.clear();

        Iterator<FBPost> iterator = posts.iterator();
        FBPost temp = null;
        List<FBPost> l = null;

        while (iterator.hasNext()) {
            temp = iterator.next();
            l = this.posts.get(temp.get_autor());
            if (l == null) {
                l = new ArrayList<>();
                this.posts.put(temp.get_autor(), l);
            }

            l.add(temp.clone());
        }
    }

    // métodos de utilidade

    /**
     * Compara um objeto ao FBFeedMap que recebe a mensagem
     *
     * @param outro objeto a comparar
     * @return true se forem iguais
     */
    public boolean equals(Object outro) {
        if (this == outro)
            return true;
        if ((outro == null) || (this.getClass() != outro.getClass()))
            return false;
        FBFeedMap temp = (FBFeedMap) outro;
        return this.posts.equals(temp.posts);
    }

    /**
     * Transforma uma lista de posts numa String
     *
     * @param lp lista de posts
     * @return String com o resultado final
     */
    private String toStringAux(List<FBPost> lp) {
        StringBuilder sb = new StringBuilder();

        lp.forEach(p -> sb.append(p.toString()));

        return sb.toString();
    }

    /**
     * Devolve uma representacao textual de um FBFeedMap
     *
     * @return representacao textual
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();

        this.posts.entrySet().forEach(
                e -> sb.append("User: ")
                                           .append(e.getKey())
                                           .append("Posts: ")
                                           .append(this.toStringAux(e.getValue()))
        );

        return sb.toString();
    }

    /**
     * Cria uma cópia de um FBFeedMap
     *
     * @return cópia de um FBFeedMap
     */
    public FBFeedMap clone() {
        return new FBFeedMap(this);
    }

    // outros métodos

    /**
     * Permite adicionar um post de um utilizador
     *
     * @param user nome do utilizador
     * @param post post a adicionar
     */
    public void addPost(String user, FBPost post) {


    }

    /**
     * Remove os posts de um utilizador entre duas datas.
     *
     * @param user nome do utilizador
     * @param di data inicial
     * @param df data final
     */
    public void removePosts(String user, LocalDateTime di, LocalDateTime df) {

    }

    /**
     * Determina quantos posts foram publicados durante um período de tempo
     *
     * @param di data inicial
     * @param df data final
     * @return número de posts
     */
    public int postsNumPeriodo(LocalDateTime di, LocalDateTime df) {
        return 0;
    }

    /**
     * Determina o utilizador mais activo num determinado período de tempo
     *
     * @param di data inicial
     * @param df data inicial
     * @return nome do utilizador
     */
    public String utilizadorMaisActivo(LocalDateTime di, LocalDateTime df) {
        return "";
    }

    /**
     * Determina a timeline do sistema ordenando cronologicamente todos os posts
     *
     * @return lista de posts
     */
    public List<FBPost> timelineGlobal() {
        return null;
    }

    /**
     * Valida que não existe nenhum utilizador que tenham
     * feito mais que um post num determinado instante
     *
     * @return true se não existe utilizador ...
     */
    public boolean validaPostsSimultaneos() {
        return false;
    }
}
