package dev.carrental.carros;

import dev.carrental.PontosPorKms;

import java.io.Serial;
import java.io.Serializable;

/**
 * Classe que representa um Carro, movido a energia
 * @author Eduardo Freitas Fernandes
 */
public class CarroEletrico extends Carro implements Serializable, Comparable<CarroEletrico>, PontosPorKms {

    // variáveis de classe

    @Serial
    private static final long serialVersionUID = 9062610258491706143L;

    // variáveis de instância

    /** tamanho da bateria */
    private Double bateria;
    /** quantidade de energia disponível na bateria */
    private Double bateriaAtual;
    /** consumo de energia a cada 100 kms */
    private Double consumoKWh100Km;
    /** preço por KWh da energia */
    private Double precoKWh;
    /** número de pontos atribuidos */
    private Double pontos;
    /** quantidade de pontos a atribuir por kilómetro */
    private Double pontosPorKm = 2.5;


    // construtores

    /**
     * Construtor por omissão de um Carro Elétrico
     */
    public CarroEletrico() {
        super();
        bateria = bateriaAtual = consumoKWh100Km = precoKWh = 0.0;
        pontos = 0.0;
    }

    /**
     * Construtor parametrizado de um Carro Elétrico
     * @param matricula código de identificação
     * @param marca marca do Carro
     * @param modelo modelo do Carro
     * @param anoConstrucao ano de construção do Carro
     * @param velocidadeMedia velocidade média por km
     * @param bateria tamanho do bateria
     * @param consumoKWh100Km consumo aos 100 kms
     * @param precoKWh preço por KWh da energia
     */
    public CarroEletrico(String matricula,
                          String marca,
                          String modelo,
                          int anoConstrucao,
                          double velocidadeMedia,
                          double bateria,
                          double consumoKWh100Km,
                          double precoKWh) {
        super(matricula, marca, modelo, anoConstrucao, velocidadeMedia);
        this.bateria = this.bateriaAtual = bateria;
        this.consumoKWh100Km = consumoKWh100Km;
        this.precoKWh = precoKWh;
        this.pontos = 0.0;
        this.abastecer();
    }

    /**
     * Construtor de cópia de um Carro Elétrico
     * @param other Carro Elétrico a copiar
     */
    public CarroEletrico(CarroEletrico other) {
        super(other);
        bateria = other.bateria;
        bateriaAtual = other.bateriaAtual;
        consumoKWh100Km = other.consumoKWh100Km;
        precoKWh = other.precoKWh;
        pontos = other.pontos;
        pontosPorKm = other.pontosPorKm;
    }


    // métodos de instância

    /**
     * Devolve o tamanho da bateria do Carro
     * @return tamanho da bateria do Carro
     */
    public double getBateria() {
        return bateria;
    }

    /**
     * Altera o tamanho da bateria do Carro
     * @param bateria tamanho da bateria do Carro
     */
    public void setBateria(double bateria) {
        this.bateria = bateria;
    }

    /**
     * Devolve a quantidade de energia disponível na bateria do Carro
     * @return quantidade de energia disponível na bateria
     */
    public double getBateriaAtual() {
        return bateriaAtual;
    }

    /**
     * Devolve o consumo por KWh a cada 100 kms
     * @return consumo por KWh a cada 100 kms
     */
    public double getConsumoKWh100Km() {
        return consumoKWh100Km;
    }

    /**
     * Altera o consumo por KWh a cada 100 kms
     * @param consumoKWh100Km consumo por KWh a cada 100 kms
     */
    public void setConsumoKWh100Km(double consumoKWh100Km) {
        this.consumoKWh100Km = consumoKWh100Km;
    }

    /**
     * Devolve o preço por KWh da energia
     * @return preço por KWh da energia
     */
    public double getPrecoKWh() {
        return precoKWh;
    }

    /**
     * Altera o preço por KWh da energia
     * @param precoKWh preço por KWh da energia
     */
    public void setPrecoKWh(double precoKWh) {
        this.precoKWh = precoKWh;
    }

    /**
     * Efetua uma viagem de certa distância
     * @param distancia distância percorrida
     */
    public void viagem(int distancia) {
        super.percorreDistancia(distancia);
        bateriaAtual -= distancia * this.consumoKm();
        this.autonomia = (int) (bateriaAtual / this.consumoKm());

        pontos += pontosPorKm * distancia;
    }

    /**
     * Abastece a bateria do Carro
     */
    public void abastecer() {
        bateriaAtual = bateria;
        this.autonomia = (int) (bateriaAtual / this.consumoKm());
    }

    /**
     * Determina o consumo de energia por km
     * @return consumo de energia por km
     */
    public double consumoKm() {
        return consumoKWh100Km / 100;
    }

    /**
     * Determina o custo por km do Carro
     * @return custo por km do Carro
     */
    public double custoKm() {
        return (consumoKWh100Km / 100) * precoKWh;
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
     * Devolve a percentagem de bateria disponível
     * @return percentagem de bateria disponível
     */
    public int getPercentagemBateria() {
        return (int) ((bateriaAtual / bateria) * 100);
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
    public CarroEletrico clone() {
        return new CarroEletrico(this);
    }

    /**
     * Devolve uma representação textual de um Carro Elétrico
     * @return representação textual
     */
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        builder.append(super.toString());
        builder.append("--- Carro Elétrico ---\n");
        builder.append("{bateria: ");
        builder.append(bateria);
        builder.append(", bateria atual: ");
        builder.append(bateriaAtual);
        builder.append(", consumo em KWh aos 100 kms: ");
        builder.append(consumoKWh100Km);
        builder.append(", preço por KWh: ");
        builder.append(precoKWh);
        builder.append("}\n");

        return builder.toString();
    }

    /**
     * Compara um objeto a um Carro Elétrico
     * @param obj objeto a comparar
     * @return {@code true} se forem iguais, {@code false} caso contrário
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (this.getClass() != obj.getClass()) return false;
        if (!super.equals(obj)) return false;

        CarroEletrico other = (CarroEletrico) obj;
        return bateria.equals(other.bateria) && bateriaAtual.equals(other.bateriaAtual)
            && consumoKWh100Km.equals(other.consumoKWh100Km) && precoKWh.equals(other.precoKWh)
            && pontos.equals(other.pontos) && pontosPorKm.equals(other.pontosPorKm);
    }

    /**
     * Determina um código hash correspondente ao Carro Elétrico
     * @return código hash
     */
    @Override
    public int hashCode() {
        int hash = super.hashCode();

        hash += bateria.hashCode();
        hash += bateriaAtual.hashCode();
        hash += consumoKWh100Km.hashCode();
        hash += precoKWh.hashCode();
        hash += pontos.hashCode();
        hash += pontosPorKm.hashCode();

        return hash;
    }

    /**
     * Estabele a ordem natural entre Carros Elétricos
     * @param other Carro Elétrico a comparar
     * @return positivo se this > other, negativo caso contrário, 0 se forem iguais
     */
    @Override
    public int compareTo(CarroEletrico other) {
        int k1 = this.getKmsTotais();
        int k2 = other.getKmsTotais();

        if (k1 == k2)
            return (int) (other.getBateria() - this.getBateria());
        else
            return k1 - k2;
    }

}
