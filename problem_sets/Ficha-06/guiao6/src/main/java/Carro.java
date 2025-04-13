

import java.io.Serializable;


/**
 * Classe que representa um Carro
 */
public abstract class Carro implements Serializable, Comparable<Carro> {

    /**
     * Variáveis de Instância
     */

    private static int custo_extra = 15;

    private String matricula;
    private String marca;
    private String modelo;
    private int ano;
    private double velocidade;
    private int autonomia;
    private int kms_totais;
    private int kms_parciais;


    /**
     * Construtores
     */

    /**
     * Construtor por omissão de um Carro
     */
    public Carro() {
        this.matricula = "";
        this.marca = "";
        this.modelo = "";
        this.ano = 0;
        this.velocidade = 0;
        this.autonomia = 0;
        this.kms_totais = 0;
        this.kms_parciais = 0;
    }

    /**
     * Construtor parametrizado de um Carro
     *
     * @param matricula identificador único do Carro
     * @param marca marca do Carro
     * @param modelo modelo do Carro
     * @param ano ano de fabrico do Carro
     * @param velocidade velocidade média do Carro
     */
    public Carro(String matricula, String marca, String modelo, int ano, double velocidade) {
        this();
        if (ano > 0 && velocidade > 0) {
            this.matricula = matricula;
            this.marca = marca;
            this.modelo = modelo;
            this.ano = ano;
            this.velocidade = velocidade;
        }
    }

    /**
     * Construtor de cópia de um Carro
     *
     * @param outro Carro a copiar
     */
    public Carro(Carro outro) {
        this();
        if (outro != null) {
            this.matricula = outro.matricula;
            this.marca = outro.marca;
            this.modelo = outro.modelo;
            this.ano = outro.ano;
            this.velocidade = outro.velocidade;
            this.autonomia = outro.autonomia;
            this.kms_totais = outro.kms_totais;
            this.kms_parciais = outro.kms_parciais;
        }
    }

    /**
     * Métodos de Instância
     */

    // getters
    
    /**
     * Devolve o custo extra aplicado a todos os Carros
     *
     * @return custo extra
     */
    public static int get_custo_extra() {
        return Carro.custo_extra;
    }

    /**
     * Devolve a matrícula do Carro
     *
     * @return matricula do Carro
     */
    public String get_matricula() {
        return this.matricula;
    }

    /**
     * Devolve a marca do Carro
     *
     * @return marca do Carro
     */
    public String get_marca() {
        return this.marca;
    }

    /**
     * Devolve o modelo do Carro
     *
     * @return modelo do Carro
     */
    public String get_modelo() {
        return this.modelo;
    }

    /**
     * Devolve o ano de fabrico do Carro
     *
     * @return ano de fabrico
     */
    public int get_ano() {
        return this.ano;
    }

    /**
     * Devolve a velocidade média do Carro
     *
     * @return velocidade média
     */
    public double get_velocidade() {
        return this.velocidade;
    }

    /**
     * Devolve a autonomia do Carro
     *
     * @return autonomia do Carro
     */
    public int get_autonomia() {
        return this.autonomia;
    }

    /**
     * Devolve o número de kms feitos desde o fabrico do Carro
     *
     * @return kilmetragem do Carro
     */
    public int get_kms_totais() {
        return this.kms_totais;
    }

    /**
     * Devolve o número de kms feitos, desde a última viagem
     *
     * @return kms parciais
     */
    public int get_kms_parciais() {
        return this.kms_parciais;
    }

    // setters

    /**
     * Altera a matricula de um Carro
     *
     * @param matricula matricula do Carro
     */
    public void set_matricula(String matricula) {
        this.matricula = matricula;
    }

    /**
     * Altera a marca do Carro
     *
     * @param marca marca do Carro
     */
    public void set_marca(String marca) {
        this.marca = marca;
    }

    /**
     * Altera o modelo do Carro
     *
     * @param modelo modelo do Carro
     */
    public void set_modelo(String modelo) {
        this.modelo = modelo;
    }

    /**
     * Altera o ano de fabrico do Carro
     *
     * @param ano ano de fabrico
     */
    public void set_ano(int ano) {
        if (ano > 0) {
            this.ano = ano;
        }
    }

    /**
     * Altera a velocidade média do Carro
     *
     * @param velocidade velocidade média
     */
    public void set_velocidade(double velocidade) {
        if (velocidade > 0) {
            this.velocidade = velocidade;
        }
    }

    /**
     * Altera a autonomia do Carro
     *
     * @param autonomia autonomia do Carro
     */
    public void set_autonomia(int autonomia) {
        if (autonomia > 0) {
            this.autonomia = autonomia;
        }
    }

    // métodos de utilidade

    /**
     * Verifica se dois objetos são iguais
     *
     * @param outro objeto a comparar
     * @return true se forem iguais
     */
    @Override
    public boolean equals(Object outro) {
        if (outro == this)
            return true;
        if (outro == null || this.getClass() != outro.getClass())
            return false;

        Carro temp = (Carro) outro;
        return this.matricula.equals(temp.matricula) && this.marca.equals(temp.marca)
            && this.modelo.equals(temp.modelo) && this.ano == temp.ano
            && this.velocidade == temp.velocidade && this.autonomia == temp.autonomia
            && this.kms_totais == temp.kms_totais && this.kms_parciais == temp.kms_parciais;
    }

    /**
     * Devolve uma representação em texto de um Carro
     *
     * @return representação textual de um Carro
     */
    public abstract String toString();
    
    /**
     * Devolve uma cópia do objeto que recebe a mensagem
     *
     * @return cópia de um Carro
     */
    public abstract Carro clone();

    /**
     * Compara um Carro ao receptor da mensagem
     *
     * @param outro Carro a comparar
     * @return 0 se forem iguais, 1 se o receptor for maior, -1 se for menor
     */
    @Override
    public int compareTo(Carro outro) {
        return (int) (this.custo_real() - outro.custo_real());
    }

    // outros métodos

    /**
     * Efetua uma viagems de x kms no Carro
     *
     * @param kms distancia percorrida
     */
    public abstract void viagem(int kms);

    /**
     * Adiciona kms aos contadores totais e parciais
     *
     * @param kms distancia percorrida
     */
    public void adiciona_kms(int kms) {
        this.kms_totais += kms;
        this.kms_parciais += kms;
    }

    /**
     * Efetua um reset ao contador dos kilometros parciais
     */
    public void reset_parcial() {
        this.kms_parciais = 0;
    }

    /**
     * Abastece o Carro totalmente
     */
    public abstract void abastecer_carro();

    /**
     * Calcula o custo real por km do Carro
     *
     * @return custo real por km
     */
    public abstract double custo_real();

}
