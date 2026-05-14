
public class PodCastUM implements Serializable {

    private Map<String, PodCast> podcasts; // Nome PodCast -> PodCast
    private Map<Integer, Utilizador> utilizadores; // Número Utilizador -> Utilizador
    // outras variáveis que considere necessárias

    public void subscrevePodCast(int numUtilizador, String nomePodcast) throws IllegalArgumentException {
        // Verificar se o utilizador existe
        if (!utilizadores.containsKey(numUtilizador)) {
            throw new IllegalArgumentException("Utilizador não encontrado.");
        }

        // Verificar se o podcast existe
        if (!podcasts.containsKey(nomePodcast)) {
            throw new IllegalArgumentException("Podcast não encontrado.");
        }

        PodCast podcast = podcasts.get(nomePodcast);
        Utilizador utilizador = utilizadores.get(numUtilizador);
        utilizador.adicionaPodcast(podcast);

    }

    public String podCastMaisEscutado() {
        return podcasts.values().stream().max(PodCast::compareTo).map(p -> p.getNomePodCast()).orElse(null);
    }

}

public class Registo implements Comparable<Registo>, Serializable {

    // variáveis de instância
    private Episodio episodio;
    private LocalDate data;
    private int tempoEscutado;

    public Registo(Episodio episodio, LocalDate data, int tempoEscutado) {
        this.episodio = episodio;
        this.data = data;
        this.tempoEscutado = tempoEscutado;
    }

}

public class PodCast implements Serializable, Comparable<PodCast> {

    private String nomePodCast;
    private List<Episodio> episodios; // Ordenada por ordem de disponibilização do episódio

    public int getTempoTotal() {
        return episodios.stream().mapToInt(Episodio::getDuracao).sum();
    }

    public int getNrEpisodios() {
        return episodios.size();
    }

    public int compareTo(PodCast outro) {
        int tempoTotal = this.getTempoTotal();
        int outroTempoTotal = outro.getTempoTotal();

        if (tempoTotal == outroTempoTotal) {
            int nrEpisodios = this.getNrEpisodios();
            int outroNrEpisodios = outro.getNrEpisodios();

            if (nrEpisodios == outroNrEpisodios) {
                return this.nomePodCast.compareTo(outro.nomePodCast);
            }

            return -(nrEpisodios - outroNrEpisodios);
        }

        return tempoTotal - outroTempoTotal;
    }

}

public class Episodio implements Serializable {

    private int duracao;
    private String titulo;
    private LocalDate data;
    private byte[] conteudo;

}

public class Utilizador implements Serializable {

    private static int idCounter = 0;

    private final int numero = idCounter++;
    private String nome;
    private Set<String> podcasts;
    private Set<Registo> registos;

    public Utilizador(String nome, List<String> podcasts) {
        this.nome = nome;
        this.podcasts = new HashSet<>(podcasts);
        this.registos = new HashSet<>();
    }

    public void adicionaPodCast(PodCast p) {
        // ...
    }

    public void ouvirEpisodio(PodCast pod, int numEpisodio, int numMinutosEscutados) {
        List<Episodio> episodios = pod.getEpisodios();
        if (episodios != null && numEpisodio >= 0 && numEpisodio < episodios.size()) {
            Episodio episodio = episodios.get(numEpisodio);
            Registo registo = new Registo(episodio, LocalDate.now(), numMinutosEscutados);
            registos.add(registo);
        }
    }

}

public class UtilizadorPremium extends Utilizador {

    private Set<Episodio> episodios;

    public UtilizadorPremium(String nome, List<String> podcasts) {
        super(nome, podcasts);
        this.episodios = new HashSet<>();
    }

    public void guardaLocalmente(Episodio e) throws NaoExisteEspacoException {
        if (episodios.size() >= 20) {
            throw new NaoExisteEspacoException();
        }
        episodios.add(e);
    }

}
