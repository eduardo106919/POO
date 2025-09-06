package dev.carrental.carros;

/**
 *
 * @author Eduardo Freitas Fernandes
 */
public class CarroHibrido extends Carro {

    // variáveis de instância



    // construtores

    public CarroHibrido(CarroHibrido other) {

    }


    // métodos de instância

    /**
     * Efetua uma viagem de certa distância
     *
     * @param distancia distância percorrida
     */
    @Override
    public void viagem(int distancia) {

    }

    /**
     * Abastece o depósito do Carro
     */
    @Override
    public void abastecer() {

    }

    /**
     * Determina o consumo de combustível por km
     *
     * @return consumo de combustível por km
     */
    @Override
    public double consumoKm() {
        return 0;
    }

    /**
     * Determina o custo por km do Carro
     *
     * @return custo por km do Carro
     */
    @Override
    public double custoKm() {
        return 0;
    }

    /**
     * Determina o custo real por km do Carro
     *
     * @return custo real por km do Carro
     */
    @Override
    public double custoRealKm() {
        return 0;
    }

    /**
     * Efetua uma cópia de um Carro Hibrido
     * @return cópia de um Carro Hibrido
     */
    @Override
    public CarroHibrido clone() {
        return new CarroHibrido(this);
    }

}
