package dev.carrental;

/**
 * Interface que atribui uma quantidade de pontos a um Carro, por kilómetro percorrido
 * @author Eduardo Freitas Fernandes
 */
public interface PontosPorKms {

    /**
     * Altera a quantidade de pontos a atribuir por kilómetro percorrido
     * @param pontos quantidade de pontos a atribuir por kilómetro
     */
    void setPontosPorKm(double pontos);

    /**
     * Devolve o quantidade de pontos a atribuir por kilómetro percorrido
     * @return quantidade de pontos a atribuir por kilómetro
     */
    double getPontosPorKm();

    /**
     * Devolve o número de pontos que um Carro adquiriu
     * @return número de pontos adquiridos
     */
    double getPontos();

}
