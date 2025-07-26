package dev.guiao6.comparators;

import dev.guiao6.cars.Carro;
import java.util.Comparator;

public class ComparatorCarroCustoReal implements Comparator<Carro> {

    /**
     * Compara dois Carros pelo custo real por km. Desempate é feito pela matrícula
     * @param c1 Primeiro Carro
     * @param c2 Segundo Carro
     * @return 0 se forem iguais, −1 se c1 for menor, 1 caso contrario
     */
    public int compare(Carro c1, Carro c2) {
        double custo1 = c1.custo_real();
        double custo2 = c2.custo_real();

        if (custo1 == custo2) {
            return c1.get_matricula().compareTo(c2.get_matricula());
        }

        return Double.compare(custo1, custo2);
    }
}