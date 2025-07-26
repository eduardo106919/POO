package dev.guiao6.comparators;

import dev.guiao6.cars.Carro;
import java.util.Comparator;


public class ComparatorCarroKms implements Comparator<Carro> {

    /**
     * Compara dois Carros pelo quilometros feitos. Desempate é feito pela matrícula
     * @param c1 Primeiro Carro
     * @param c2 Segundo Carro
     * @return 0 se forem iguais, −1 se c1 for menor, 1 caso contrario
     */
    public int compare(Carro c1, Carro c2) {
        int k1 = c1.get_kms_totais();
        int k2 = c2.get_kms_totais();

        if (k1 == k2) {
            return c1.get_matricula().compareTo(c2.get_matricula());
        }

        return k2 - k1;
    }
}
