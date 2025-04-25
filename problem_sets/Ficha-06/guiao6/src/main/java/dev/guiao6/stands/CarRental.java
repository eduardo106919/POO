
package dev.guiao6.stands;

import dev.guiao6.cars.Carro;
import dev.guiao6.cars.CarroEletrico;
import dev.guiao6.comparators.ComparatorCarroKms;

import java.util.Map;
import java.util.Set;
import java.util.List;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Comparator;
import java.util.Collection;
import java.util.stream.Collectors;

/**
 * Classe que representa o conjunto de Carros de um Stand de Aluguer
 */
public class CarRental {

    /**
     * Variáveis de Instância
     */

    private HashMap<String, Carro> veiculos;
    private HashMap<String, Comparator<Carro>> comparadores;


    /**
     * Construtores
     */

    /**
     * Construtor por omissão de CarRental
     */
    public CarRental() {
        this.veiculos = new HashMap<String, Carro>();
        this.comparadores = new HashMap<String, Comparator<Carro>>();
    }

    /**
     * Construtor parametrizado de CarRental
     *
     * @param veiculos coleção de Carros
     */
    public CarRental(Collection<Carro> veiculos, Collection<Comparator<Carro>> comparadores) {
        this();
        veiculos.forEach(c -> this.veiculos.put(c.get_matricula(), c.clone()));
        comparadores.forEach(c -> this.comparadores.put(c.getClass().getTypeName(), c));
    }

    /**
     * Construtor de cópia de CarRental
     *
     * @param outro CarRental a copiar
     */
    public CarRental(CarRental outro) {
        this();
        if (outro != null) {
            Iterator<Map.Entry<String, Carro>> iterator = outro.veiculos.entrySet().iterator();
            Map.Entry<String, Carro> temp = null;

            while (iterator.hasNext()) {
                temp = iterator.next();
                this.veiculos.put(temp.getKey(), temp.getValue().clone());
            }

            this.comparadores = new HashMap<String, Comparator<Carro>>(outro.comparadores);
        }
    }


    /**
     * Métodos de Instância
     */

    // getters

    /**
     * Devolve os comparadores do Stand
     *
     * @return lista de comparadores
     */
    public List<Comparator<Carro>> get_comparadores() {
        return this.comparadores.values().stream().collect(Collectors.toList());
    }

    // métodos de utilidade

    /**
     * Compara um objeto ao CarRental que recebe a mensagem
     *
     * @param outro objeto a comparar
     * @return true se forem iguais
     */
    @Override
    public boolean equals(Object outro) {
        if (this == outro)
            return true;
        if (outro == null || this.getClass() != outro.getClass())
            return false;
        CarRental temp = (CarRental) outro;
        boolean res = this.veiculos.size() == temp.veiculos.size() && this.comparadores.equals(temp.comparadores);

        if (res == true) {
            Iterator<Map.Entry<String, Carro>> iterator = temp.veiculos.entrySet().iterator();
            Map.Entry<String, Carro> other = null;

            while (res != false && iterator.hasNext()) {
                other = iterator.next();
                res = this.veiculos.get(other.getKey()).equals(other.getValue());
            }
        }

        return res;
    }

    /**
     * Devolve uma representacao textual de um CarRental
     *
     * @return representacao textual
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("Veiculos:\n");
        this.veiculos.values().forEach(c -> sb.append(c.toString()));
        sb.append("Comparadores:\n");
        this.comparadores.keySet().forEach(k -> sb.append(k));

        return sb.toString();
    }

    /**
     * Cria uma cópia do CarRental que recebe a mensagem
     *
     * @return cópia do CarRental
     */
    @Override
    public CarRental clone() {
        return new CarRental(this);
    }

    // outros métodos

    /**
     * Adiciona um comparador ao stand
     *
     * @param comp comparador a adicionar
     */
    public void adiciona_comparador(Comparator<Carro> comp) {
        this.comparadores.put(comp.getClass().getTypeName(), comp);
    }

    /**
     * Remove um comparador do stand, dado o seu nome
     *
     * @param criterio nome do comparador
     */
    public void remove_comparador(String criterio) {
        this.comparadores.remove(criterio);
    }

    /**
     * Verifica se um Carro existe, dada a sua matricula
     *
     * @param cod Matricula do Carro
     * @return true se o Carro existir
     */
    public boolean existe_carro(String cod) {
        return this.veiculos.get(cod) != null;
    }

    /**
     * Determina o número de Carros no stand
     *
     * @return número de Carros
     */
    public int quantos() {
        return this.veiculos.size();
    }

    /**
     * Determina o número de Carros de uma certa marca
     *
     * @param marca Marca de Carros
     * @return número de Carros
     */
    public int quantos(String marca) {
        return (int) this.veiculos.values().stream().filter(c -> c.get_marca().equals(marca)).count();
    }

    /**
     * Devolve uma cópia de um Carro, dada a sua matrícula
     *
     * @param cod Matricula do Carro
     * @return cópia do Carro
     */
    public Carro get_carro(String cod) {
        Carro temp = this.veiculos.get(cod);
        if (temp != null) {
            return temp.clone();
        }

        return null;
    }

    /**
     * Adiciona um Carro ao stand
     *
     * @param veiculo Carro a adicionar
     */
    public void adiciona(Carro veiculo) {
        if (veiculo != null) {
            this.veiculos.put(veiculo.get_matricula(), veiculo.clone());
        }
    }

    /**
     * Devolve uma lista com todos os Carros do stand
     *
     * @return lista de Carros
     */
    public List<Carro> get_carros() {
        return this.veiculos.values().stream().map(Carro::clone).collect(Collectors.toList());
    }

    /**
     * Adiciona um conjunto de Carros ao stand
     *
     * @param vs conjunto de Carros a adicionar
     */
    public void adiciona(Set<Carro> vs) {
        if (vs != null) {
            vs.forEach(c -> this.veiculos.put(c.get_matricula(), c.clone()));
        }
    }

    /**
     * Regista uma viagem num Carro, dada a sua matricula
     *
     * @param cod Matricula do Carro
     * @param kms distancia percorrida
     */
    public void registar_viagem(String cod, int kms) {
        Carro temp = this.veiculos.get(cod);
        if (temp != null) {
            temp.viagem(kms);
        }
    }

    /**
     * Atesta um Carro do stand, dada a sua matricula
     *
     * @param cod matricula do Carro
     */
    public void atestar_carro(String cod) {
        Carro temp = this.veiculos.get(cod);
        if (temp != null) {
            temp.abastecer_carro();
        }
    }

    /**
     * Determina o Carro mais economico do stand
     *
     * @return cópia do Carro
     */
    public Carro carro_mais_economico() {
        return this.veiculos.values().stream()
                .sorted((c1, c2) -> Double.compare(c1.custo_real(), c2.custo_real()))
                .collect(Collectors.toList())
                .getFirst();
    }

    /**
     * Calcular a média de custo por quilómetro de todos os carros da empresa
     *
     * @return media de custo por kilometro
     */
    public double media_custo_km() {
        return this.veiculos.values().stream()
                .mapToDouble(Carro::custo_real)
                .sum() / this.veiculos.size();
    }

    /**
     * Calcula o custo real por km de um carro de acordo com a regra
     * enunciada anteriormente.
     *
     * @param cod Codigo do Carro
     * @return custo real do Carro
     */
    public double custo_real_carro(String cod) {
        Carro temp = this.veiculos.get(cod);

        if (temp != null) {
            return temp.custo_real();
        }

        return 0;
    }

    /**
     * Determinar o conjunto dos carros que podem ser requisitados para
     * efectuar uma viagem de um determinado número de kms
     *
     * @param kms distancia percorrida
     * @return conjunto de carros
     */
    public Set<Carro> carros_com_alcance(int kms) {
        return this.veiculos.values().stream()
                .filter(c -> c.get_autonomia() >= kms)
                .collect(Collectors.toSet());
    }

    /**
     * Determinar o conjunto dos carros eléctricos cujo nível de bateria é
     * de pelo menos uma percentagem
     *
     * @param nivel_minimo nivel minimo da bateria
     * @return conjunto de carros eletricos
     */
    public Set<CarroEletrico> com_bateria(int nivel_minimo) {
        CarroEletrico temp = null;
        Iterator<Carro> iterator = this.veiculos.values().iterator();
        HashSet<CarroEletrico> result = new HashSet<CarroEletrico>();
        Carro other = null;

        while (iterator.hasNext()) {
            other = iterator.next();
            if (temp.getClass().getTypeName().equals("CarroEletrico")) {
                temp = (CarroEletrico) other;
                if (temp.get_bateria_atual() >= nivel_minimo)
                    result.add(temp);
            }
        }
        
        return result;
    }

    /**
     * Determina o carro com mais kms percorridos. Em caso de empate aquele que
     * tiver a matrícula com menor valor alfabético.
     *
     * @return Carro com mais quilometros
     */
    public Carro carroComMaisKms() {
        ComparatorCarroKms comp = new ComparatorCarroKms();
        return this.veiculos.values().stream()
                .sorted(comp)
                .findFirst().get().clone();
    }

    /**
     * Obter um conjunto de Carros Eletricos ordenado de acordo com a ordem
     * natural dos carros eléctricos
     *
     * @return conjunto de CarroEletrico
     */
    public Set<CarroEletrico> getEletricosOrd() {
        return this.veiculos.values().stream()
                .filter(c -> c.getClass().getTypeName().equals("CarroEletrico"))
                .map(c -> (CarroEletrico) c.clone())
                .sorted((c1, c2) -> ((CarroEletrico) c1).compareTo(c2))
                .collect(Collectors.toSet());
    }

    /**
     * Obter um iterador de Carro, ordenado conforme o critério indicado
     *
     * @param criterio criterio de ordenacao
     * @return iterador de Carros
     */
    public Iterator<Carro> ordenarCarros(String criterio) {
        Comparator<Carro> comp = this.comparadores.get(criterio);
        if (comp != null) {
            List<Carro> temp = this.veiculos.values().stream()
                    .map(Carro::clone)
                    .collect(Collectors.toList());
            temp.sort(comp);
            return temp.iterator();
        }

        return null;
    }

    /**
     * Obter um Map em que se associa a um valor de autonomia (em kms) a
     * lista dos carros que possuem essa autonomia
     *
     * @return mapa que associa a autonomia a uma lista de veiculos
     */
    public Map<Integer, List<Carro>> carrosPorAutonomia() {
        return this.veiculos.values().stream()
                .collect(Collectors.groupingBy(Carro::get_autonomia,
                                               Collectors.mapping(Carro::clone, Collectors.toList())));
    }
}
