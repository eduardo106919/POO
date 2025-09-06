package dev.carrental.carros;

import dev.carrental.InfoKms;

import java.io.Serial;
import java.io.Serializable;

/**
 * Classe que representa um veículo.
 * @author Eduardo Freitas Fernandes
 */
public abstract class Carro implements Serializable, InfoKms {

    // variáveis de classe

    @Serial
    private static final long serialVersionUID = 7812961757640069571L;

    /** percentagem de acréscimo ao preço real do Carro */
    private static final Double custoExtra = 0.15;

    // variáveis de instância

    /** código de identificação */
    private String matricula;
    /** marca do veículo */
    private String marca;
    /** modelo do veículo */
    private String modelo;
    /** ano de construção do veículo */
    private Integer anoConstrucao;
    /** velociade média por km */
    private Double velocidadeMedia;
    /** número de kms que o Carro pode fazer */
    protected Integer autonomia;
    /** kms totais realizados */
    private Integer kmsTotais;
    /** kms realizados desde o último reset */
    private Integer kmsParciais;


    // construtores

    /**
     * Construtor por omissão de um Carro
     */
    public Carro() {
        matricula = marca = modelo = "";
        anoConstrucao = autonomia = kmsParciais = kmsTotais = 0;
        velocidadeMedia = 0.0;
    }

    /**
     * Construtor parametrizado de um Carro
     * @param matricula código de identificação
     * @param marca marca do Carro
     * @param modelo modelo do Carro
     * @param anoConstrucao ano de construção do Carro
     * @param velocidadeMedia velocidade média por km
     */
    public Carro(String matricula, String marca, String modelo, int anoConstrucao, double velocidadeMedia) {
        this();
        this.matricula = matricula;
        this.marca = marca;
        this.modelo = modelo;
        this.anoConstrucao = anoConstrucao;
        this.velocidadeMedia = velocidadeMedia;
    }

    /**
     * Construtor de cópia de um Carro
     * @param other Carro a copiar
     */
    public Carro(Carro other) {
        matricula = other.matricula;
        marca = other.marca;
        modelo = other.modelo;
        anoConstrucao = other.anoConstrucao;
        velocidadeMedia = other.velocidadeMedia;
        autonomia = other.autonomia;
        kmsTotais = other.kmsTotais;
        kmsParciais = other.kmsParciais;
    }


    // métodos de classe

    /**
     * Devolve o custo extra aplicado a todos os Carros
     * @return custo extra
     */
    public static double getCustoExtra() {
        return Carro.custoExtra;
    }

    // métodos de instância

    /**
     * Devolve o código de identificação do Carro
     * @return código de identificação
     */
    public String getMatricula() {
        return matricula;
    }

    /**
     * Altera o código de identificação do Carro
     * @param matricula código de identificação
     */
    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    /**
     * Devolve a marca do Carro
     * @return marca do Carro
     */
    public String getMarca() {
        return marca;
    }

    /**
     * Altera a marca do Carro
     * @param marca marca do Carro
     */
    public void setMarca(String marca) {
        this.marca = marca;
    }

    /**
     * Devolve o modelo do Carro
     * @return modelo do Carro
     */
    public String getModelo() {
        return modelo;
    }

    /**
     * Altera o modelo do Carro
     * @param modelo modelo do Carro
     */
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    /**
     * Devolve o ano de construção do Carro
     * @return ano de construção do Carro
     */
    public int getAnoConstrucao() {
        return anoConstrucao;
    }

    /**
     * Altera o ano de construção do Carro
     * @param anoConstrucao ano de construção do Carro
     */
    public void setAnoConstrucao(int anoConstrucao) {
        this.anoConstrucao = anoConstrucao;
    }

    /**
     * Devolve a velocidade média por km
     * @return velocidade média por km
     */
    public double getVelocidadeMedia() {
        return velocidadeMedia;
    }

    /**
     * Altera a velocidade média por km
     * @param velocidadeMedia velocidade média por km
     */
    public void setVelocidadeMedia(double velocidadeMedia) {
        this.velocidadeMedia = velocidadeMedia;
    }

    /**
     * Devolve a autonomia do Carro
     * @return autonomia do Carro
     */
    public int getAutonomia() {
        return autonomia;
    }

    /**
     * Devolve o número de kms totais realizados
     * @return número de kms totais realizados
     */
    public int getKmsTotais() {
        return kmsTotais;
    }

    /**
     * Devolve o número de kms feitos desde o último reset
     * @return kms feitos desde o último reset
     */
    public int getKmsParciais() {
        return kmsParciais;
    }

    /**
     * Percorre uma certa distância
     * @param distancia número de kms a percorrer
     */
    public void percorreDistancia(int distancia) {
        kmsTotais += distancia;
        kmsParciais += distancia;
    }

    /**
     * Efetua uma viagem de certa distância
     * @param distancia distância percorrida
     */
    public abstract void viagem(int distancia);

    /**
     * Abastece o depósito do Carro
     */
    public abstract void abastecer();

    /**
     * Determina o consumo de combustível por km
     * @return consumo de combustível por km
     */
    public abstract double consumoKm();

    /**
     * Determina o custo por km do Carro
     * @return custo por km do Carro
     */
    public abstract double custoKm();

    /**
     * Determina o custo real por km do Carro
     * @return custo real por km do Carro
     */
    public abstract double custoRealKm();

    /**
     * Coloca o contador dos kms parciais a zero
     */
    public void resetContador() {
        kmsParciais = 0;
    }

    /**
     * Efetua uma cópia de um Carro
     * @return cópia de um Carro
     */
    public abstract Carro clone();

    /**
     * Devolve uma representação textual de um Carro
     * @return representação textual
     */
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        builder.append("--- Carro ---\n");
        builder.append("{matricula: ");
        builder.append(matricula);
        builder.append(", marca: ");
        builder.append(marca);
        builder.append(", modelo: ");
        builder.append(modelo);
        builder.append(", ano construção: ");
        builder.append(anoConstrucao);
        builder.append(", velocidade média: ");
        builder.append(velocidadeMedia);
        builder.append(", autonomia: ");
        builder.append(autonomia);
        builder.append(", kms totais: ");
        builder.append(kmsTotais);
        builder.append(", kms parciais: ");
        builder.append(kmsParciais);
        builder.append("}\n");

        return builder.toString();
    }

    /**
     * Compara um objeto a um Carro
     * @param obj objeto a comparar
     * @return {@code true} se forem iguais, {@code false} caso contrário
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (this.getClass() != obj.getClass()) return false;

        Carro other = (Carro) obj;
        return matricula.equals(other.matricula) && marca.equals(other.marca)
            && modelo.equals(other.modelo) && anoConstrucao.equals(other.anoConstrucao)
            && velocidadeMedia.equals(other.velocidadeMedia) && autonomia.equals(other.autonomia)
            && kmsTotais.equals(other.kmsTotais) && kmsParciais.equals(other.kmsParciais);
    }

    /**
     * Determina um código hash correspondente ao Carro
     * @return código hash
     */
    @Override
    public int hashCode() {
        int hash = 31;

        hash += matricula.hashCode();
        hash += marca.hashCode();
        hash += modelo.hashCode();
        hash += anoConstrucao.hashCode();
        hash += velocidadeMedia.hashCode();
        hash += autonomia.hashCode();
        hash += kmsTotais.hashCode();
        hash += kmsParciais.hashCode();

        return hash;
    }

}
