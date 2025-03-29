
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.List;
import java.util.stream.Collectors;
import java.util.HashMap;
import java.util.ArrayList;

/**
 * Parque de Estacionamento
 */
public class Parque {

    /**
     * Variáveis de Intância
     */

    private String nome;
    private HashMap<String, Lugar> lugares;

    /**
     * Construtores
     */

    /**
     * Construtor por omissão de um Parque
     */
    public Parque() {
        this.nome = "n/a";
        this.lugares = new HashMap<String, Lugar>();
    }

    /**
     * Construtor parametrizado de um Parque
     *
     * @param nome nome do Parque
     * @param lugares mapa de lugares de estacionamento
     */
    public Parque(String nome, Map<String, Lugar> lugares) {
        this();
        if (lugares != null) {
            this.nome = nome;
            
            Iterator<Map.Entry<String, Lugar>> iterator = lugares.entrySet().iterator();
            Map.Entry<String, Lugar> temp = null;

            while (iterator.hasNext()) {
                temp = iterator.next();
                this.lugares.put(temp.getKey(), temp.getValue().clone());
            }
        }
    }

    /**
     * Construtor de cópia de um Parque
     *
     * @param outro parque a copiar
     */
    public Parque(Parque outro) {
        if (outro != null) {
            this.nome = outro.nome;
            this.lugares = new HashMap<String, Lugar>();

            Iterator<Map.Entry<String, Lugar>> iterator = outro.lugares.entrySet().iterator();
            Map.Entry<String, Lugar> store = null;

            while (iterator.hasNext()) {
                store = iterator.next();
                this.lugares.put(store.getKey(), store.getValue().clone());
            }
        }
    }

    /**
     * Métodos de Instância
     */

    // getters

    /**
     * Devolve o nome do parque de estacionamento
     *
     * @return nome do parque
     */
    public String get_nome() {
        return this.nome;
    }

    /**
     * Devolve os lugares do Parque
     *
     * @return Mapa com os lugares e as matriculas
     */
    public Map<String, Lugar> get_lugares() {
        return this.lugares.entrySet()
                           .stream()
                           .collect(Collectors.toMap(
                                        Map.Entry::getKey,
                                        entry -> new Lugar(entry.getValue())
                            ));
    }

    // setters
    
    /**
     * Altera o nome do parque do estacionamento
     *
     * @param nome nome do parque de estacionamento
     */
    public void set_nome(String nome) {
        this.nome = nome;
    }

    // métodos de utilidade

    /**
     * Compara dois objetos
     *
     * @param outro objeto a comparar
     * @return true se forem iguais
     */
    public boolean equals(Object outro) {
        if (this == outro)
            return true;
        if (outro == null || this.getClass() != outro.getClass())
            return false;
        Parque temp = (Parque) outro;
        return this.lugares.equals(temp.lugares);
    }

    /**
     * Devolve uma representação de um Parque, numa string
     *
     * @return representacao de um parque de estacionamento
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();

        Iterator<Map.Entry<String, Lugar>> iterator = this.lugares.entrySet().iterator();
        Map.Entry<String, Lugar> temp = null;

        while (iterator.hasNext()) {
            temp = iterator.next();
            sb.append(temp.getValue().toString());
        }
        
        return sb.toString();
    }

    /**
     * Devolve uma cópia de um Parque de estacionamento
     *
     * @return cópia do parque
     */
    public Parque clone() {
        return new Parque(this);
    }

    // outros métodos

    /**
     * Devolve um conjunto com todas as matriculas dos lugares ocupados
     *
     * @return conjunto de matriculas
     */
    public Set<String> get_matriculas() {
        return this.lugares.keySet();
    }

    /**
     * Regista uma nova ocupação de lugar
     *
     * @param lug Lugar de Estacionamento
     */
    public void adiciona_lugar(Lugar lug) {
        if (lug != null) {
            this.lugares.put(lug.get_matricula(), lug.clone());
        }
    }

    /**
     * Remove uma ocupação do Parque
     *
     * @param matricula Matricula de um veiculo
     */
    public void remove_lugar(String matricula) {
        this.lugares.remove(matricula);
    }

    /**
     * Altera o tempo disponível de um Lugar
     *
     * @param matricula matricula do veiculo
     * @param tempo tempo em minutos
     */
    public void altera_temp(String matricula, int tempo) {
        if (tempo >= 0) {
            Lugar veiculo = this.lugares.get(matricula);
            if (veiculo != null) {
                veiculo.set_minutos(tempo);
            }
        }
    }

        
    public int tempo_total() {
        return this.lugares.entrySet().stream().mapToInt(entry -> entry.getValue().get_minutos()).sum();
    }

    /*
    public int tempo_total() {
        int total = 0;
        Iterator<Map.Entry<String, Lugar>> iterator = this.lugares.entrySet().iterator();

        while (iterator.hasNext()) {
            total += iterator.next().getValue().get_minutos();
        }

        return total;
    }
    */


    public boolean existe_matricula(String matricula) {
        return this.lugares.containsKey(matricula);
    }

    public List<String> matriculas_permanentes_x(int x) {
        return this.lugares.entrySet().stream()
                                      .filter(entry -> entry.getValue().get_permanente() == true && entry.getValue().get_minutos() > x)
                                      .map(entry -> entry.getKey())
                                      .collect(Collectors.toList());
    }

    /*
    public List<String> matriculas_permanentes_x(int x) {
        List<String> resultado = new ArrayList<String>();
        Iterator<Map.Entry<String, Lugar>> iterator = this.lugares.entrySet().iterator();
        Map.Entry<String, Lugar> temp = null;
        
        while (iterator.hasNext()) {
            temp = iterator.next();
            if (temp.getValue().get_permanente() == true && temp.getValue().get_minutos() > x) {
                resultado.add(temp.getKey());
            }
        }

        return resultado;
    }
    */

    public List<Lugar> copia_lugares() {
        return this.lugares.entrySet().stream().map(entry -> entry.getValue().clone()).collect(Collectors.toList());
    }

    public String informacao_lugar(String matricula) {
        Lugar temp = this.lugares.get(matricula);
        if (temp != null) {
            return temp.toString();
        }

        return "";
    }
}
