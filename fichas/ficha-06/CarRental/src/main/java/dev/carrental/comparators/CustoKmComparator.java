package dev.carrental.comparators;

import dev.carrental.carros.Carro;

import java.util.Comparator;

/**
 * Compara dois Carros pelo seu custo por km.
 * @author Eduardo Freitas Fernandes
 */
public class CustoKmComparator implements Comparator<Carro> {

    /**
     * Compara dois Carros pelo seu custo por km
     * @param carro1 Carro 1
     * @param carro2 Carro 2
     * @return positivo se 1 for maior, negativo se 2 for maior, 0 se forem iguais
     */
    @Override
    public int compare(Carro carro1, Carro carro2) {
        double c1 = carro1.custoKm();
        double c2 = carro2.custoKm();

        if (c1 == c2)
            return carro1.getMatricula().compareTo(carro2.getMatricula());
        else
            return (int) (c1 - c2);
    }

}
