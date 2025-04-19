
import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;


public class Parque {

    /**
     * Variáveis de Instância
     */

    private String nome;
    private HashMap<String, Lugar> lugares;


    /**
     * Construtores
     */

    /**
     * Construtor por omissão de um Parque de Estacionamento
     */
    public Parque() {
        this.nome = "";
        this.lugares = new HashMap<String, Lugar>();
    }

    /**
     * Construtor parametrizado de um Parque de Estacionamento
     *
     * @param nome nome do Parque
     * @param lugares colecao de lugares
     */
    public Parque(String nome, Collection<Lugar> lugares) {
        this();
        this.nome = nome;
        Iterator<Lugar> iterator = lugares.iterator();
        Lugar temp = null;

        while (iterator.hasNext()) {
            temp = iterator.next();
            this.lugares.put(temp.get_matricula(), temp.clone());
        }
    }

    /**
     * Construtor de cópia de um Parque de Estacionamento
     *
     * @param outro Parque a copiar
     */
    public Parque(Parque outro) {
        this();
        this.nome = outro.nome;
        Iterator<Map.Entry<String, Lugar>> iterator = outro.lugares.entrySet().iterator();
        Map.Entry<String, Lugar> temp = null;

        while (iterator.hasNext()) {
            temp = iterator.next();
            this.lugares.put(temp.getKey(), temp.getValue().clone());
        }
    }
    
    /**
     * Métodos de Instância
     */

    // getters
    
    /**
     * Devolve o nome do Parque de Estacionamento
     *
     * @return nome do Parque
     */
    public String get_nome() {
        return this.nome;
    }

    // setters
    
    /**
     * Altera o nome do Parque de Estacionamento
     *
     * @param nome nome do Parque
     */
    public void set_nome(String nome) {
        this.nome = nome;
    }

    /**
     * Altera os lugares do Parque de Estacionamento
     *
     * @param lugares colecao de lugares
     */
    public void set_lugares(Collection<Lugar> lugares) {
        this.lugares = new HashMap<String, Lugar>();
        Iterator<Lugar> iterator = lugares.iterator();
        Lugar temp = null;

        while (iterator.hasNext()) {
            temp = iterator.next();
            this.lugares.put(temp.get_matricula(), temp.clone());
        }
    }

    // métodos de utilidade

    /**
     * Compara um objeto a um Parque de Estacionamento
     *
     * @param outro objeto a comparar
     * @return true se forem iguais
     */
    public boolean equals(Object outro) {
        if (this == outro)
            return true;
        if ((outro == null) || (this.getClass() != outro.getClass()))
            return false;
        Parque temp = (Parque) outro;
        return this.nome.equals(temp.nome) && this.lugares.equals(temp.lugares);
    }

    /**
     * Devolve uma representacao textual de um Parque de Estacionamento
     *
     * @return representacao textual
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("Nome: ").append(this.nome);
        this.lugares.values().forEach(l -> sb.append(l.toString()));

        return sb.toString();
    }

    /**
     * Cria uma cópia de um Parque de Estacionamento
     *
     * @return cópia de um Parque de Estacionamento
     */
    public Parque clone() {
        return new Parque(this);
    }

    // outros métodos

    /**
     * Método que devolve todas as matriculas dos lugares ocupados
     *
     * @return conjunto de matriculas
     */
    public Set<String> get_matriculas() {
        return this.lugares.keySet();
    }

    /**
     * Método que regista uma nova ocupação de Lugar
     *
     * @param l Lugar a adicionar
     */
    public void adiciona_lugar(Lugar l) {
        this.lugares.put(l.get_matricula(), l.clone());
    }

    /**
     * Método que remove o Lugar de dada matricula
     *
     * @param matricula matricula do Lugar a remover
     */
    public void remove_lugar(String matricula) {
        this.lugares.remove(matricula);
    }

    /**
     * Método que altera o tempo disponível de um lugar, para uma dada matricula
     *
     * @param matricula matricula do Lugar
     * @param tempo tempo a adicionar
     */
    public void altera_tempo(String matricula, int tempo) {
        Lugar temp = this.lugares.get(matricula);
        if (temp != null) {
            temp.set_minutos(tempo);
        }
    }

    /**
     * Devolve a quantidade total de minutos
     * Versão de Iteradores Internos
     *
     * @return total de minutos
     */
    public int total_minutos_I() {
        return this.lugares.values().stream().mapToInt(Lugar::get_minutos).sum();
    }

    /**
     * Devolve a quantidade total de minutos
     * Versão de Iteradores Externos
     *
     * @return total de minutos
     */
    public int total_minutos_E() {
        Iterator<Lugar> iterator = this.lugares.values().iterator();
        int total = 0;

        while (iterator.hasNext()) {
            total += iterator.next().get_minutos();
        }

        return total;
    }

    /**
     * Método que verifica existe lugar atribuído a uma dada matrícula
     *
     * @param matricula matricula correspondente ao Lugar
     * @return true se o Lugar existir
     */
    public boolean existe_lugar(String matricula) {
        return this.lugares.containsKey(matricula);
    }

    /**
     * Devolve uma lista com as matriculas dos lugares com tempo atribuido maior que x
     * Versão de Iteradores Internos
     *
     * @return lista de matriculas
     */
    public List<String> duracao_mais_x_I(int x) {
        return this.lugares.values().stream()
                                    .filter(l -> l.get_minutos() > x)
                                    .map(Lugar::get_matricula)
                                    .collect(Collectors.toList());
    }

    /**
     * Devolve uma lista com as matriculas dos lugares com tempo atribuido maior que x
     * Versão de Iteradores Externos
     *
     * @return lista de matriculas
     */
    public List<String> duracao_mais_x_E(int x) {
        List<String> res = new ArrayList<String>();
        Iterator<Map.Entry<String, Lugar>> iterator = this.lugares.entrySet().iterator();
        Map.Entry<String, Lugar> temp = null;

        while (iterator.hasNext()) {
            temp = iterator.next();
            if (temp.getValue().get_minutos() > x) {
                res.add(temp.getKey());
            }
        }

        return res;
    }

    /**
     * Método que devolve uma cópia dos lugares
     *
     * @return cópia dos lugares
     */
    public List<Lugar> get_lugares() {
        return this.lugares.values().stream().map(Lugar::clone).collect(Collectors.toList());
    }

    /**
     * Método que devolve a informação de um lugar para uma dada matricula
     *
     * @param matricula matricula correspondente a um Lugar
     * @return Lugar correspondente à matricula
     */
    public Lugar get_lugar(String matricula) {
        Lugar temp = this.lugares.get(matricula);
        if (temp != null) {
            return temp.clone();
        }

        return null;
    }
}
