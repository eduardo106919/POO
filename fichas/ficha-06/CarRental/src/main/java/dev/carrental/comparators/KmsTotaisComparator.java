package dev.carrental.comparators;

import dev.carrental.carros.Carro;

import java.util.Comparator;

/**
 * Compara dois Carros pelos kilómetros feitos.
 * @author Eduardo Freitas Fernandes
 */
public class KmsTotaisComparator implements Comparator<Carro> {

    /**
     * Compara dois Carros pelos kilómetros feitos
     * @param carro1 Carro 1
     * @param carro2 Carro 2
     * @return positivo se 1 for maior, negativo se 2 for maior, 0 se forem iguais
     */
    @Override
    public int compare(Carro carro1, Carro carro2) {
        int k1 = carro1.getKmsTotais();
        int k2 = carro2.getKmsTotais();

        if (k1 == k2)
            return carro1.getMatricula().compareTo(carro2.getMatricula());
        else
            return k1 - k2;
    }

}
