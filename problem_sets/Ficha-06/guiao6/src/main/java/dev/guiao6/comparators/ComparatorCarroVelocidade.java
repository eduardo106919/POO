package dev.guiao6.comparators;

import dev.guiao6.cars.Carro;
import java.util.Comparator;

public class ComparatorCarroVelocidade implements Comparator<Carro> {

    /**
     * Compara dois Carros pela velocidade média. Desempate é feito pela matrícula
     * @param c1 Primeiro Carro
     * @param c2 Segundo Carro
     * @return 0 se forem iguais, −1 se c1 for menor, 1 caso contrario
     */
    public int compare(Carro c1, Carro c2) {
        double v1 = c1.get_velocidade();
        double v2 = c2.get_velocidade();

        if (v1 == v2) {
            return c1.get_matricula().compareTo(c2.get_matricula());
        }

        return Double.compare(v1, v2);
    }
}