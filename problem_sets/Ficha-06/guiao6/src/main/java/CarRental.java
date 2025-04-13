

import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.List;
import java.util.Iterator;
import java.util.stream.Collectors;
import java.util.HashMap;
import java.util.TreeMap;
import java.util.HashSet;

/**
 * Classe que representa o conjunto de Carros de um Stand de Aluguer
 */
public class CarRental {

    /**
     * Variáveis de Instância
     */

    private HashMap<String, Carro> veiculos;


    /**
     * Construtores
     */

    /**
     * Construtor por omissão de CarRental
     */
    public CarRental() {
        this.veiculos = new HashMap<String, Carro>();
    }

    /**
     * Construtor parametrizado de CarRental
     *
     * @param veiculos coleção de Carros
     */
    public CarRental(Collection<Carro> veiculos) {
        this();
        veiculos.forEach(c -> this.veiculos.put(c.get_matricula(), c.clone()));
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
        }
    }


    /**
     * Métodos de Instância
     */

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
        boolean res = this.veiculos.size() == temp.veiculos.size();

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

        this.veiculos.values().forEach(c -> sb.append(c.toString()));

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

    public boolean existe_carro(String cod) {
        return this.veiculos.get(cod) != null;
    }
    
    public int quantos() {
        return this.veiculos.size();
    }

    public int quantos(String marca) {
        return (int) this.veiculos.values().stream().filter(c -> c.get_marca().equals(marca)).count();
    }

    public Carro get_carro(String cod) {
        Carro temp = this.veiculos.get(cod);
        if (temp != null) {
            return temp.clone();
        }

        return null;
    }

    public void adiciona(Carro veiculo) {
        if (veiculo != null) {
            this.veiculos.put(veiculo.get_matricula(), veiculo.clone());
        }
    }

    public List<Carro> get_carros() {
        return this.veiculos.values().stream().map(Carro::clone).collect(Collectors.toList());
    }

    public void adiciona(Set<Carro> vs) {
        if (vs != null) {
            vs.forEach(c -> this.veiculos.put(c.get_matricula(), c.clone()));
        }
    }

    public void registar_viagem(String cod, int kms) {
        Carro temp = this.veiculos.get(cod);
        if (temp != null) {
            temp.viagem(kms);
        }
    }

    public void atestar_carro(String cod) {
        Carro temp = this.veiculos.get(cod);
        if (temp != null) {
            temp.abastecer_carro();
        }
    }

    public Carro carro_mais_economico() {
        return this.veiculos.values().stream().sorted((c1, c2) -> Double.compare(c1.custo_real(), c2.custo_real())).toList().getFirst();
    }

    public double media_custo_km() {
        return this.veiculos.values().stream().mapToDouble(Carro::custo_real).sum() / this.veiculos.size();
    }

    public double custo_real_carro(String cod) {
        Carro temp = this.veiculos.get(cod);

        if (temp != null) {
            return temp.custo_real();
        }

        return 0;
    }

    public Set<Carro> carros_com_alcance(int kms) {
        return this.veiculos.values().stream().filter(c -> c.get_autonomia() >= kms).collect(Collectors.toSet());
    }

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

}
