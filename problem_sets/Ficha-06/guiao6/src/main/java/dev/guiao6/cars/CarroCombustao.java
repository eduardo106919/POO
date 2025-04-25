
package dev.guiao6.cars;



/**
 * Classe que representa um Carro a Combustão, a diesel ou gasolina
 */
public class CarroCombustao extends Carro {

    /**
     * Variáveis de Instância
     */

    private double deposito; // capacidade máxima do deposito
    private double deposito_atual; // quantidade em litros atual
    private double consumo; // aos 100 kms
    private double preco_combustivel;


    /**
     * Construtores
     */

    /**
     * Construtor por omissão de um Carro de Combustão
     */
    public CarroCombustao() {
        super();
        this.deposito = 0;
        this.deposito_atual = 0;
        this.consumo = 0;
        this.preco_combustivel = 0;
    }

    /**
     * Construtor parametrizado de um Carro Elétrico
     *
     * @param matricula matricula do Carro
     * @param modelo modelo do veiculo
     * @param marca marca do veiculo
     * @param ano ano de fabrico do Carro
     * @param velocidade_media velocidade media do Carro
     * @param deposito capacidade máxima do deposito do Carro
     * @param consumo consumo de combustivel por 100 km
     * @param preco_combustivel preco do combustivel por km
     */
    public CarroCombustao(String matricula, String modelo, String marca, int ano, double velocidade_media, double deposito, double consumo, double preco_combustivel) {
        super(matricula, marca, modelo, ano, velocidade_media);
        this.deposito = deposito;
        // Carro é iniciado com deposito cheio
        this.deposito_atual = deposito;
        this.consumo = consumo;
        this.preco_combustivel = preco_combustivel;
        this.atualiza_autonomia();
    }

    /**
     * Construtor de cópia de um Carro de Combustão
     *
     * @param outro Carro a copiar
     */
    public CarroCombustao(CarroCombustao outro) {
        super(outro);
        this.deposito = outro.deposito;
        this.deposito_atual = outro.deposito_atual;
        this.consumo = outro.consumo;
        this.preco_combustivel = outro.preco_combustivel;
    }


    /**
     * Métodos de Instância
     */
    
    // getters
    
    /**
     * Devolve o número de litros de combustivel no deposito do Carro
     *
     * @return número de litros no deposito
     */
    public double get_deposito() {
        return this.deposito;
    }

    /**
     * Devolve a quantidade de combustível no deposito
     *
     * @return quantidade atual no deposito
     */
    public double get_deposito_atual() {
        return this.deposito_atual;
    }

    /**
     * Devolve o consumo de combustivel aos 100 km
     *
     * @return consumo do Carro
     */
    public double get_consumo() {
        return this.consumo;
    }

    /**
     * Devolve o preco do combustivel por litro
     *
     * @return preco do combustivel
     */
    public double get_preco_combustivel() {
        return this.preco_combustivel;
    }

    // setters
    
    /**
     * Altera o número de litros no deposito do Carro
     *
     * @param deposito número de litros
     */
    public void set_deposito(double deposito) {
        this.deposito = deposito;

        // atualizar o deposito atual e autonomia
        if (deposito < this.deposito_atual) {
            this.abastecer_carro();
        }
    }

    /**
     * Altera o consumo de combustivel aos 100 kms
     *
     * @param consumo consumo de combustivel aos 100 kms
     */
    public void set_consumo(double consumo) {
        this.consumo = consumo;
    }

    /**
     * Altera o preco de combustivel por litro
     *
     * @param preco preco do combustivel por litro
     */
    public void set_preco_combustivel(double preco) {
        this.preco_combustivel = preco;
    }

    // métodos de utilidade

    /**
     * Compara um objeto, ao objeto que recebe a mensage
     *
     * @param outro objeto a comparar
     * @return true se forem iguais
     */
    public boolean equals(Object outro) {
        if (this == outro)
            return true;
        if (outro == null || this.getClass() != outro.getClass())
            return false;
        CarroCombustao temp = (CarroCombustao) outro;
        return super.equals(temp) && this.deposito == temp.deposito && this.deposito_atual == temp.deposito_atual
            && this.consumo == temp.consumo && this.preco_combustivel == temp.preco_combustivel;
    }

    /**
     * Devolve uma representação textual de um Carro
     *
     * @return representação textual
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("[Matricula] ").append(super.get_matricula()).append(", ");
        sb.append("[Marca] ").append(super.get_marca()).append(", ");
        sb.append("[Modelo] ").append(super.get_modelo()).append(", ");
        sb.append("[Ano] ").append(super.get_ano()).append(", ");
        sb.append("[Velocidade] ").append(super.get_velocidade()).append(", ");
        sb.append("[Autonomia] ").append(super.get_autonomia()).append(", ");
        sb.append("[Kms totais] ").append(super.get_kms_totais()).append(", ");
        sb.append("[Kms parciais] ").append(super.get_kms_parciais()).append(", ");

        sb.append("[Deposito] ").append(this.deposito).append(", ");
        sb.append("[Deposito Atual] ").append(this.deposito_atual).append(", ");
        sb.append("[Consumo] ").append(this.consumo).append(", ");
        sb.append("[Preco] ").append(this.preco_combustivel).append("\n");

        return sb.toString();
    }

    /**
     * Cria uma cópia do Carro que recebe a mensagem
     *
     * @return cópia do receptor
     */
    public CarroCombustao clone() {
        return new CarroCombustao(this);
    }

    // outros métodos

    /**
     * Determina o consumo de combustivel por km
     *
     * @return consumo por kilometro
     */
    private double consumo_km() {
        return this.consumo / 100;
    }

    /**
     * Determina o custo por kilometro
     *
     * @return custo por kilometro
     */
    private double custo_km() {
        return (this.consumo / 100) * this.preco_combustivel;
    }

    /**
     * Atualiza a autonomia do Carro
     */
    private void atualiza_autonomia() {
        super.set_autonomia((int) (this.deposito_atual / this.consumo_km()));
    }

    /**
     * Atualiza a quantidade de combustivel disponivel no deposito
     *
     * @param kms percorrida
     */
    private void atualiza_deposito_atual(int kms) {
        this.deposito_atual -= kms / this.consumo_km();
    }

    /**
     * Efetua uma viagem de x kilometros
     *
     * @param kms distancia percorrida
     */
    public void viagem(int kms) {
        if (kms > 0) {
            this.atualiza_deposito_atual(kms);
            this.atualiza_autonomia();
            super.adiciona_kms(kms);
        }
    }

    /**
     * Abastece o deposito do Carro
     */
    public void abastecer_carro() {
        this.deposito_atual = this.deposito;
        this.atualiza_autonomia();
    }

    /**
     * Calcula o custo real por kilometro
     *
     * @return custo real
     */
    public double custo_real() {
        return this.custo_km() + this.custo_km() * (Carro.get_custo_extra() / 100);
    }

}
