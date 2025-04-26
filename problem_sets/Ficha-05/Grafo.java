import java.util.Map;
import java.util.Set;
import java.util.List;
import java.util.TreeMap;
import java.util.HashSet;
import java.util.Iterator;

public class Grafo {
    /**
     * Variáveis de Instância
     */

    private Map<Integer, Set<Integer>> adj; // "lista" de adjacência


    /**
     * Construtores
     */

    /**
     * Construtor por omissão de um Grafo
     */
    public Grafo() {
        this.adj = new TreeMap<>();
    }

    /**
     * Construtor parametrizado de um Grafo
     *
     * @param adj Mapa de arcos
     */
    public Grafo(Map<Integer, Set<Integer>> adj) {
        this.adj = new TreeMap<>(adj);
    }

    /**
     * Construtor de cópia de um Grafo
     *
     * @param outro Grafo a copiar
     */
    public Grafo(Grafo outro) {
        this(outro.adj);
    }


    /**
     * Métodos de Instância
     */

    // métodos de utilidade

    /**
     * Compara um objeto ao Grafo que recebe a mensagem
     *
     * @param outro objeto a comparar
     * @return true se forem iguais
     */
    public boolean equals(Object outro) {
        if (this == outro)
            return true;
        if ((outro == null) || (this.getClass() != outro.getClass()))
            return false;
        Grafo temp = (Grafo) outro;
        return this.adj.equals(temp.adj);
    }

    /**
     * Devolve uma representacao textual de um Grafo
     *
     * @return representacao textual
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Iterator<Map.Entry<Integer, Set<Integer>>> iterator = this.adj.entrySet().iterator();
        Map.Entry<Integer, Set<Integer>> temp = null;

        while (iterator.hasNext()) {
            temp = iterator.next();
            sb.append(temp.getKey()).append(" ->");
            temp.getValue().forEach(v -> sb.append(" ").append(v));
            sb.append("\n");
        }

        return sb.toString();
    }

    /**
     * Cria uma cópia de um Grafo
     *
     * @return cópia de um Grafo
     */
    public Grafo clone() {
        return new Grafo(this);
    }

    // outros métodos

    /**
     * Adiciona um arco ao grafo
     *
     * @param vOrig vértice de origem
     * @param vDest vértice de destino
     */
    public void addArco(Integer vOrig, Integer vDest) {
        Set<Integer> temp = this.adj.get(vOrig);
        // adicionar a entrada do ponto de origem, se necessário
        if (temp == null) {
            temp = new HashSet<>();
            this.adj.put(vOrig, temp);
        }
        temp.add(vDest);

        temp = this.adj.get(vDest);
        // adicionar a entrada do ponto de destino, se necessário
        if (temp == null) {
            temp = new HashSet<>();
            this.adj.put(vDest, temp);
        }
    }

    /**
     * Determina se um vértice é um sink (não existem arcos a sair dele – ou seja, está-lhe
     * associado um conjunto vazio de vértices na “lista” de adjacência)
     *
     * @param v vértice
     * @return true se for um sink
     */
    public boolean isSink(Integer v) {
        Set<Integer> temp = this.adj.get(v);
        // adicionar a entrada do ponto de origem, se necessário
        if (temp == null) {
            temp = new HashSet<>();
            this.adj.put(v, temp);
        }

        return temp.isEmpty();
    }

    /**
     * Determina se um vértice é um source (não existem arcos a entrar nele).
     *
     * @param v vértice
     * @return true se for um source
     */
    public boolean isSource(Integer v) {
        Iterator<Map.Entry<Integer, Set<Integer>>> iterator = this.adj.entrySet().iterator();
        Map.Entry<Integer, Set<Integer>> temp = null;
        Set<Integer> conj = null;
        boolean source = true;

        while (source && iterator.hasNext()) {
            temp = iterator.next();
            conj = temp.getValue();
            if (!temp.getKey().equals(v)) {
                source = conj.stream().noneMatch(t -> t.equals(v));
            }
        }

        return source;
    }

    /**
     * Calcula o tamanho do grafo (o tamanho de um grafo
     * com "n" vértices e m arcos é n + m)
     *
     * @return tamanho do grafo
     */
    public int size() {
        return this.adj.size() + this.adj.values().stream().mapToInt(Set::size).sum();
    }

    /**
     * Determina se existe um caminho entre os dois
     * vértices passados como parâmetro
     *
     * @param vOrig vértice de origem
     * @param vDest vértice de destino
     * @return true se houver caminho
     */
    // TODO
    public boolean haCaminho(Integer vOrig, Integer vDest) {
        return false;
    }

    /**
     * Calcula o caminho entre dois vértices, devolve null caso não exista caminho
     *
     * @param vOrig vértice de origem
     * @param vDest vértice de destino
     * @return lista da representacao do caminho
     */
    // TODO
    public List<String> getCaminho(Integer vOrig, Integer vDest) {
        if (!this.haCaminho(vOrig, vDest))
            return null;
        return null;
    }

    /**
     * Calcula o conjunto de todos os arcos que saem de um vértice
     *
     * @param v vértice
     * @return conjunto de arcos
     */
    // TODO
    public Set<Map.Entry<Integer, Integer>> fanOut (Integer v) {
        return null;
    }

    /**
     * Calcula o conjunto de todos os arcos que entram num vértice
     *
     * @param v vértice
     * @return conjunto de arcos
     */
    // TODO
    public Set<Map.Entry<Integer, Integer>> fanIn(Integer v) {
        return null;
    }

    /**
     * Determina se o grafo é subgrafo de g (todos os seus vértices
     * e arcos são vértices/arcos de g)
     *
     * @param g Grafo a comparar
     * @return true se for subgrafo
     */
    // TODO
    public boolean subGrafo(Grafo g) {
        return false;
    }
}