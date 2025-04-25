
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;
import java.time.LocalDate;

public class SistemaVideos implements Comparable<SistemaVideos> {

    /**
     * Variáveis de Instância
     */

    private HashMap<String, VideoYoutube> videos;


    /**
     * Construtores
     */

    /**
     * Construtor por omissão de um Sistema de Videos
     */
    public SistemaVideos() {
        this.videos = new HashMap<>();
    }

    /**
     * Construtor parametrizado de um Sistema de Videos
     *
     * @param videos coleção de videos
     */
    public SistemaVideos(Collection<VideoYoutube> videos) {
        this();
        videos.forEach(v -> this.videos.put(v.get_nome(), v.clone()));
    }

    /**
     * Construtor de cópia de um Sistema de Videos
     *
     * @param outro Sistema de Videos a copiar
     */
    public SistemaVideos(SistemaVideos outro) {
        this();
        outro.videos.entrySet()
                .forEach(e -> this.videos.put(e.getKey(), e.getValue().clone()));
    }


    /**
     * Métodos de Instância
     */

    // getters

    /**
     * Devolve os Videos de Youtube guardados
     *
     * @return lista de Videos
     */
    public List<VideoYoutube> getVideos() {
        return videos.values().stream().map(VideoYoutube::clone).collect(Collectors.toList());
    }

    // setters

    /**
     * Altera os Videos de Youtube guardados
     *
     * @param videos coleção de videos
     */
    public void setVideos(Collection<VideoYoutube> videos) {
        this.videos.clear();
        videos.forEach(v -> this.videos.put(v.get_nome(), v.clone()));
    }

    // métodos de utilidade

    /**
     * Compara um objeto ao Sistema de Videos que recebeu a mensagem
     *
     * @param outro objeto a comparar
     * @return true se forem iguais
     */
    public boolean equals(Object outro) {
        if (outro == this)
            return true;
        if ((outro == null) || (this.getClass() != outro.getClass()))
            return false;
        SistemaVideos temp = (SistemaVideos) outro;
        return this.videos.equals(temp.videos);
    }

    /**
     * Devolve uma representacao textual de um Sistema de Videos
     *
     * @return representacao textual
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();

        this.videos.values().forEach(v -> sb.append(v.toString()));

        return sb.toString();
    }

    /**
     * Devolve uma cópia de um Sistema de Videos
     *
     * @return cópia de um Sistema de Videos
     */
    public SistemaVideos clone() {
        return new SistemaVideos(this);
    }

    /**
     * Estabelece a ordem natural entre dois Sistemas de Videos
     *
     * @param outro Sistema de Videos a comparar
     * @return 0 se forem iguais, -1 se o recetor for menor, 1 caso contrário
     */
    public int compareTo(SistemaVideos outro) {
        return this.videos.size() - outro.videos.size();
    }

    // outros métodos

    /**
     * Adicionar um novo video ao sistema
     *
     * @param v Video a adicionar
     */
    public void addVideo(VideoYoutube v) {
        this.videos.put(v.get_nome(), v.clone());
    }

    /**
     * Dado um código de video devolver a instância associada
     *
     * @param codVideo nome do Video de Youtube
     * @return Instância do Video
     */
    public VideoYoutube getVideo(String codVideo) {
        VideoYoutube temp = this.videos.get(codVideo);
        if (temp != null) {
            return temp.clone();
        }
        return null;
    }

    /**
     * Remover um video dado um código
     *
     * @param codVideo Nome do Video de Youtube
     */
    public void removeVideo(String codVideo) {
        this.videos.remove(codVideo);
    }

    /**
     * Dado um código de video adicionar mais um like ao mesmo
     *
     * @param codVideo Nome do Video de Youtube
     */
    public void addLike(String codVideo) {
        VideoYoutube temp = this.videos.get(codVideo);
        if (temp != null) {
            temp.thumbsUp();
        }
    }

    /**
     * Devolver o código do video com mais likes
     *
     * @return nome do Video mais gostado
     */
    public String topLikes() {
        Comparator<VideoYoutube> comp = (v1, v2) -> Integer.compare(v2.get_likes(), v1.get_likes());

        Optional<VideoYoutube> t = this.videos.values().stream().min(comp);
        if (t.isPresent()) {
            return t.get().get_nome();
        }
        return null;
    }


    /**
     * Devolver o código do video com mais likes num intervalo de tempo
     *
     * @param dinicial dia inicial
     * @param dfinal dia final
     * @return nome do Video
     */
    public String topLikes(LocalDateTime dinicial, LocalDateTime dfinal) {
        Comparator<VideoYoutube> comp = (v1, v2) -> Integer.compare(v2.get_likes(), v1.get_likes());

        Optional<VideoYoutube> t = this.videos.values().stream()
                .filter(v -> v.get_data_carregamento().isAfter(dinicial))
                .filter(v -> v.get_data_carregamento().isAfter(dfinal))
                .min(comp);
        return t.map(VideoYoutube::get_nome).orElse(null);
    }

    /**
     * Devolve o video mais longo
     *
     * @return Video mais longo
     */
    public VideoYoutube videoMaisLongo() {
        Comparator<VideoYoutube> comp = (v1, v2) -> Integer.compare(v2.get_duracao(), v1.get_duracao());
        Optional<VideoYoutube> t = this.videos.values().stream().min(comp);
        return t.map(VideoYoutube::clone).orElse(null);
    }
}
