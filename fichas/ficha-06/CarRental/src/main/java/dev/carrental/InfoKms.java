package dev.carrental;

/**
 * Interface que devolve informação sobre a kilometragem de um Carro.
 * @author Eduardo Freitas Fernandes
 */
public interface InfoKms {

    /**
     * Devolve o número total de kilómetros percorridos por um Carro
     * @return número total de kilómetros percorridos
     */
    int getKmsTotais();

    /**
     * Devolve o custo por km de um Carro
     * @return custo por km de um Carro
     */
    double custoKm();

}
