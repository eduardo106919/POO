import java.util.List;
import java.util.stream.Collectors;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;


public class CarRentalList {

    /**
     * Variáveis de Instância
     */
    
    private ArrayList<Carro> veiculos;


    /**
     * Construtores
     */

    /**
     * Construtor por omissão de um CarRentalList
     */
    public CarRentalList() {
        this.veiculos = new ArrayList<Carro>();
    }

    /**
     * Construtor parametrizado de um CarRentalList
     *
     * @param veiculos coleção de Carros
     */
    public CarRentalList(Collection<Carro> veiculos) {
        this.veiculos = veiculos.stream().map(Carro::clone).collect(Collectors.toCollection(ArrayList::new));
    }

    /**
     * Construtor de cópia de um CarRentalList
     *
     * @param outro CarRentalList a copiar
     */
    public CarRentalList(CarRentalList outro) {
        this.veiculos = outro.veiculos.stream().map(Carro::clone).collect(Collectors.toCollection(ArrayList::new));
    }


    /**
     * Métodos de Instância
     */

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
        CarRentalList temp = (CarRentalList) outro;
        boolean res = this.veiculos.size() == temp.veiculos.size();

        if (res == true) {
            Iterator<Carro> iterator = temp.veiculos.iterator();
            Carro other = null;

            while (iterator.hasNext()) {
                other = iterator.next();
                res = this.veiculos.contains(other);
            }
        }

        return res;
    }

    /**
     * Devolve uma representacao textual de um CarRentalList
     *
     * @return representacao textual
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();

        this.veiculos.forEach(c -> sb.append(c.toString()));

        return sb.toString();
    }

    /**
     * Cria uma cópia do CarRentalList que recebe a mensagem
     *
     * @return cópia do objeto chamador
     */
    public CarRentalList clone() {
        return new CarRentalList(this);
    }

    // outros métodos

    public boolean existe_carro(String cod) {
        return this.veiculos.stream().anyMatch(c -> c.get_matricula().equals(cod));
    }

}
