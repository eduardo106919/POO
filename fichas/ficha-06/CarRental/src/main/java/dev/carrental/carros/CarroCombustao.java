package dev.carrental.carros;

import dev.carrental.PontosPorKms;

import java.io.Serial;
import java.io.Serializable;

/**
 * Classe que representa um Carro, movido a combustão.
 * @author Eduardo Freitas Fernandes
 */
public class CarroCombustao extends Carro implements Serializable, PontosPorKms {

    // variáveis de classe

    @Serial
    private static final long serialVersionUID = -5672522185551790214L;

    // variáveis de instância

    /** tamanho do depósito de combustível */
    private Double deposito;
    /** quantidade de combustível disponível no depósito */
    private Double depositoAtual;
    /** consumo de combustível a cada 100 kms */
    private Double consumoLitros100Km;
    /** preço por litro do combustível */
    private Double precoLitro;
    /** número de pontos atribuidos */
    private Double pontos;
    /** quantidade de pontos a atribuir por kilómetro */
    private Double pontosPorKm = 1.0;


    // construtores

    /**
     * Construtor por omissão de um Carro a Combustão
     */
    public CarroCombustao() {
        super();
        deposito = depositoAtual = consumoLitros100Km = precoLitro = 0.0;
        pontos = 0.0;
    }

    /**
     * Construtor parametrizado de um Carro a Combustão
     * @param matricula código de identificação
     * @param marca marca do Carro
     * @param modelo modelo do Carro
     * @param anoConstrucao ano de construção do Carro
     * @param velocidadeMedia velocidade média por km
     * @param deposito tamanho do depósito
     * @param consumoLitros100Km consumo aos 100 kms
     * @param precoLitro preço por litro do combustível
     */
    public CarroCombustao(String matricula,
                          String marca,
                          String modelo,
                          int anoConstrucao,
                          double velocidadeMedia,
                          double deposito,
                          double consumoLitros100Km,
                          double precoLitro) {
        super(matricula, marca, modelo, anoConstrucao, velocidadeMedia);
        this.deposito = this.depositoAtual = deposito;
        this.consumoLitros100Km = consumoLitros100Km;
        this.precoLitro = precoLitro;
        this.pontos = 0.0;
        this.abastecer();
    }

    /**
     * Construtor de cópia de um Carro a Combustão
     * @param other Carro a Combustão a copiar
     */
    public CarroCombustao(CarroCombustao other) {
        super(other);
        deposito = other.deposito;
        depositoAtual = other.depositoAtual;
        consumoLitros100Km = other.consumoLitros100Km;
        precoLitro = other.precoLitro;
        pontos = other.pontos;
        pontosPorKm = other.pontosPorKm;
    }


    // métodos de instância

    /**
     * Devolve o tamanho do depósito do Carro
     * @return tamanho do depósito do Carro
     */
    public double getDeposito() {
        return deposito;
    }

    /**
     * Altera o tamanho do depósito do Carro
     * @param deposito tamanho do depósito do Carro
     */
    public void setDeposito(double deposito) {
        this.deposito = deposito;
    }

    /**
     * Devolve a quantidade de combustível disponível no depósito
     * @return quantidade de combustível disponível no depósito
     */
    public double getDepositoAtual() {
        return depositoAtual;
    }

    /**
     * Devolve o consumo de combustível a cada 100 kms
     * @return consumo de combustível a cada 100 kms
     */
    public double getConsumoLitros100Km() {
        return consumoLitros100Km;
    }

    /**
     * Altera o consumo de combustível a cada 100 kms
     * @param consumoLitros100Km consumo de combustível a cada 100 kms
     */
    public void setConsumoLitros100Km(double consumoLitros100Km) {
        this.consumoLitros100Km = consumoLitros100Km;
    }

    /**
     * Devolve o preço do combustível por litro
     * @return preço do combustível por litro
     */
    public double getPrecoLitro() {
        return precoLitro;
    }

    /**
     * Altera o preço do combustível por litro
     * @param precoLitro preço do combustível por litro
     */
    public void setPrecoLitro(double precoLitro) {
        this.precoLitro = precoLitro;
    }

    /**
     * Efetua uma viagem de certa distância
     * @param distancia distância percorrida
     */
    public void viagem(int distancia) {
        super.percorreDistancia(distancia);
        depositoAtual -= distancia * this.consumoKm();
        this.autonomia = (int) (depositoAtual / this.consumoKm());

        pontos += pontosPorKm * distancia;
    }

    /**
     * Abastece o depósito do Carro
     */
    public void abastecer() {
        depositoAtual = deposito;
        this.autonomia = (int) (depositoAtual / this.consumoKm());
    }

    /**
     * Determina o consumo de combustível por km
     * @return consumo de combustível por km
     */
    public double consumoKm() {
        return consumoLitros100Km / 100;
    }

    /**
     * Determina o custo por km do Carro
     * @return custo por km do Carro
     */
    public double custoKm() {
        return (consumoLitros100Km / 100) * precoLitro;
    }

    /**
     * Determina o custo real por km do Carro
     * @return custo real por km do Carro
     */
    public double custoRealKm() {
        double custo = this.custoKm();
        return custo + custo * Carro.getCustoExtra();
    }

    /**
     * Altera a quantidade de pontos a atribuir por kilómetro percorrido
     * @param pontos quantidade de pontos a atribuir por kilómetro
     */
    public void setPontosPorKm(double pontos) {
        this.pontosPorKm = pontos;
    }

    /**
     * Devolve o quantidade de pontos a atribuir por kilómetro percorrido
     * @return quantidade de pontos a atribuir por kilómetro
     */
    public double getPontosPorKm() {
        return pontosPorKm;
    }

    /**
     * Devolve o número de pontos que um Carro adquiriu
     * @return número de pontos adquiridos
     */
    public double getPontos() {
        return pontos;
    }

    /**
     * Efetua uma cópia de um Carro
     * @return cópia de um Carro
     */
    @Override
    public CarroCombustao clone() {
        return new CarroCombustao(this);
    }

    /**
     * Devolve uma representação textual de um Carro a Combustão
     * @return representação textual
     */
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        builder.append(super.toString());
        builder.append("--- Carro Combustão ---\n");
        builder.append("{depósito: ");
        builder.append(deposito);
        builder.append(", depósito atual: ");
        builder.append(depositoAtual);
        builder.append(", consumo em litros aos 100 kms: ");
        builder.append(consumoLitros100Km);
        builder.append(", preço por litro: ");
        builder.append(precoLitro);
        builder.append("}\n");

        return builder.toString();
    }

    /**
     * Compara um objeto a um Carro a Combustão
     * @param obj objeto a comparar
     * @return {@code true} se forem iguais, {@code false} caso contrário
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (this.getClass() != obj.getClass()) return false;
        if (!super.equals(obj)) return false;

        CarroCombustao other = (CarroCombustao) obj;
        return deposito.equals(other.deposito) && depositoAtual.equals(other.depositoAtual)
            && consumoLitros100Km.equals(other.consumoLitros100Km) && precoLitro.equals(other.precoLitro)
            && pontos.equals(other.pontos) && pontosPorKm.equals(other.pontosPorKm);
    }

    /**
     * Determina um código hash correspondente ao Carro a Combustão
     * @return código hash
     */
    @Override
    public int hashCode() {
        int hash = super.hashCode();

        hash += deposito.hashCode();
        hash += depositoAtual.hashCode();
        hash += consumoLitros100Km.hashCode();
        hash += precoLitro.hashCode();
        hash += pontos.hashCode();
        hash += pontosPorKm.hashCode();

        return hash;
    }

}
