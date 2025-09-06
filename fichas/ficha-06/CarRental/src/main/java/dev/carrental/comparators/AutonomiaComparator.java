package dev.carrental.comparators;

import dev.carrental.carros.Carro;

import java.util.Comparator;

/**
 * Compara dois Carros pela autonomia.
 * @author Eduardo Freitas Fernandes
 */
public class AutonomiaComparator implements Comparator<Carro> {

    /**
     * Compara dois Carros pela autonomia
     * @param carro1 Carro 1
     * @param carro2 Carro 2
     * @return positivo se 1 for maior, negativo se 2 for maior, 0 se forem iguais
     */
    @Override
    public int compare(Carro carro1, Carro carro2) {
        int c1 = carro1.getAutonomia();
        int c2 = carro2.getAutonomia();

        if (c1 == c2)
            return carro1.getMatricula().compareTo(carro2.getMatricula());
        else
            return (c1 - c2);
    }

}
