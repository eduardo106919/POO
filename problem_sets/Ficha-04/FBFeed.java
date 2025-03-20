
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

/**
 * Classe que representa o Facebook Feed
 */
public class FBFeed {

    /**
     * Variáveis de Instância
     */

    private ArrayList<FBPost> posts;


    /**
     * Construtores
     */

    /**
     * Construtor por omissão de FBFeed
     */
    public FBFeed() {
        this.posts = new ArrayList<FBPost>();
    }

    /**
     * Construtor de cópia de Facebook Feed
     *
     * @param outro outro facebook feed
     */
    public FBFeed(FBFeed outro) {
        if (outro != null) {
            this.posts = new ArrayList<FBPost>(outro.posts);
        }
    }


    /**
     * Métodos de Instância
     */

    // getters
    
    /**
     * Devolve os posts do feed
     *
     * @return posts do facebook feed
     */
    public List<FBPost> get_posts() {
        return new ArrayList<FBPost>(this.posts);
    }

    // other methods


    /**
     * Determina o número de posts publicados por um utilizador
     *
     * @param user nome do utilizador
     * @return número de posts
     */
    public int numero_posts(String user) {
        int count = 0;
        Iterator<FBPost> iterator = this.posts.iterator();

        while (iterator.hasNext()) {
            if (iterator.next().get_utilizador().equals(user))
                count++;
        }

        return count;
    }

    /**
     * Determina a lista de posts feitos por um utilizador
     *
     * @param user nome do utilizador
     * @return lista de posts
     */
    public List<FBPost> posts_of(String user) {
        ArrayList<FBPost> list = new ArrayList<FBPost>();
        Iterator<FBPost> iterator = this.posts.iterator();

        while (iterator.hasNext()) {
            if (iterator.next().get_utilizador().equals(user))
                list.add(iterator.next().clone());
        }

        return list;
    }

    /**
     * Determina os posts que um utilizador postou, num periodo de tempo
     *
     * @param user nome do utilizador
     * @param inicio limite inferior do periodo de tempo
     * @param fim limite superior do periodo de tempo
     * @return lista de posts
     */
    public List<FBPost> posts_of_time(String user, LocalDateTime inicio, LocalDateTime fim) {
        ArrayList<FBPost> list = new ArrayList<FBPost>();
        Iterator<FBPost> iterator = this.posts.iterator();

        FBPost temp;
        while (iterator.hasNext()) {
            temp = iterator.next();
            if (temp.get_utilizador().equals(user) && temp.get_instante().isAfter(inicio) && temp.get_instante().isBefore(fim))
                list.add(iterator.next().clone());
        }

        return list;
    }

    /**
     * Devolve um Post, dado o seu identificador
     *
     * @param id identificador do post
     * @return post
     */
    public FBPost get_post(int id) {
        FBPost res = null;

        Iterator<FBPost> iterator = this.posts.iterator();
        boolean found = false;
        while (found == false && iterator.hasNext()) {
            res = iterator.next();
            if (iterator.next().get_identificador() == id)
                found = true;
        }
        
        if (found == false)
            res = null;
        return res.clone();
    }

    /**
     * Adiciona um comentátio a um Post do Facebook
     *
     * @param post_id identificador do post
     * @param coment comentario a adicionar
     */
    public void comment(int post_id, String coment) {
        boolean found = false;
        Iterator<FBPost> iterator = this.posts.iterator();
        FBPost temp = null;

        while (found == false && iterator.hasNext()) {
            temp = iterator.next();
            if (temp.get_identificador() == post_id) {
                found = true;
                temp.adiciona_comentario(coment);
            }
        }
    }

    /**
     * Adiciona um comentário a um Post do Facebook
     *
     * @param post post do facebook
     * @param comentario comentario a adicionar
     */
    public void comment(FBPost post, String comentario) {
        boolean found = false;
        Iterator<FBPost> iterator = this.posts.iterator();
        FBPost temp = null;

        while (found == false && iterator.hasNext()) {
            temp = iterator.next();
            if (temp.equals(post)) {
                found = true;
                temp.adiciona_comentario(comentario);
            }
        }
    }

    /**
     * Adiciona um like a um post do facebook
     *
     * @param post facebook post
     */
    public void like(FBPost post) {
        if (post != null) {
            boolean found = false;
            Iterator<FBPost> iterator = this.posts.iterator();
            FBPost temp = null;

            while (found == false && iterator.hasNext()) {
                temp = iterator.next();
                if (temp.equals(post)) {
                    found = true;
                    temp.like();
                }
            }
        }
    }

    /**
     * Adiciona um like a um post do facebook
     *
     * @param post_id identificador do post
     */
    public void like(int post_id) {
        boolean found = false;
        Iterator<FBPost> iterator = this.posts.iterator();
        FBPost temp = null;

        while (found == false && iterator.hasNext()) {
            temp = iterator.next();
            if (temp.get_identificador() == post_id) {
                found = true;
                temp.like();
            }
        }
    }

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
        FBFeed outro = (FBFeed) o;

        return this.posts.equals(outro.posts);
    }

    /**
     * Clona um objeto
     *
     * @return objeto clonado
     */
    public FBFeed clone() {
        return new FBFeed(this);
    }

    /**
     * Transforma um FBFeed numa String
     *
     * @return string com a informação de um FBFeed
     */
    public String toString() {
        return this.posts.toString();
    }
}
