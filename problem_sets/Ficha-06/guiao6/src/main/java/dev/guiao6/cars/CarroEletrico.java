package dev.guiao6.cars;

/**
 * Classe que representa um Carro a Combustão, a diesel ou gasolina
 */
public class CarroEletrico extends Carro implements Comparable<CarroEletrico> {

    /**
     * Variáveis de Instância
     */

    private double bateria; // capacidade máxima do deposito
    private double bateria_atual; // quantidade em litros atual
    private double consumo; // aos 100 kms
    private double preco_energia;

    /**
     * Construtores
     */

    /**
     * Construtor por omissão de um Carro Elétrico
     */
    public CarroEletrico() {
        super();
        this.bateria = 0;
        this.bateria_atual = 0;
        this.consumo = 0;
        this.preco_energia = 0;
    }

    /**
     * Construtor parametrizado de um Carro Elétrico
     *
     * @param matricula        matricula do Carro
     * @param modelo           modelo do veiculo
     * @param marca            marca do veiculo
     * @param ano              ano de fabrico do Carro
     * @param velocidade_media velocidade media do Carro
     * @param bateria          capacidade máxima da bateria do Carro
     * @param consumo          consumo em kWh em 100 km
     * @param preco_energia    preco da energia por kWh
     */
    public CarroEletrico(String matricula, String modelo, String marca, int ano, double velocidade_media,
            double bateria, double consumo, double preco_energia) {
        super(matricula, marca, modelo, ano, velocidade_media);
        this.bateria = bateria;
        // Carro é iniciado com a bateria cheia
        this.bateria_atual = bateria;
        this.consumo = consumo;
        this.preco_energia = preco_energia;
        this.atualiza_autonomia();
    }

    /**
     * Construtor de cópia de um Carro Elétrico
     *
     * @param outro Carro a copiar
     */
    public CarroEletrico(CarroEletrico outro) {
        super(outro);
        if (outro != null) {
            this.bateria = outro.bateria;
            this.bateria_atual = outro.bateria_atual;
            this.consumo = outro.consumo;
            this.preco_energia = outro.preco_energia;
        }
    }

    /**
     * Métodos de Instância
     */

    // getters

    /**
     * Devolve o capacidade máxima de energia que a bateria do Carro pode ter
     *
     * @return capacidade em kWh da bateria
     */
    public double get_bateria() {
        return this.bateria;
    }

    /**
     * Devolve a quantidade atual de energia na bateria
     *
     * @return quantidade atual de energia
     */
    public double get_bateria_atual() {
        return this.bateria_atual;
    }

    /**
     * Devolve o consumo de energia aos 100 km
     *
     * @return consumo do Carro
     */
    public double get_consumo() {
        return this.consumo;
    }

    /**
     * Devolve o preco da energia por km
     *
     * @return preco do combustivel
     */
    public double get_preco_energia() {
        return this.preco_energia;
    }

    // setters

    /**
     * Altera a capacidade máxima da bateria do Carro Eletrico
     *
     * @param bateria capacidade da bateria
     */
    public void set_deposito(double bateria) {
        this.bateria = bateria;

        // atualizar o deposito atual e autonomia
        if (bateria < this.bateria_atual) {
            this.abastecer_carro();
        }
    }

    /**
     * Altera o consumo de energia aos 100 kms
     *
     * @param consumo consumo de energia aos 100 kms
     */
    public void set_consumo(double consumo) {
        this.consumo = consumo;
    }

    /**
     * Altera o preco de energia por kWh
     *
     * @param preco preco da energia por kWh
     */
    public void set_preco_energia(double preco) {
        this.preco_energia = preco;
    }

    // métodos de utilidade

    /**
     * Compara um objeto, ao objeto que recebe a mensagem
     *
     * @param outro objeto a comparar
     * @return true se forem iguais
     */
    public boolean equals(Object outro) {
        if (this == outro)
            return true;
        if (outro == null || this.getClass() != outro.getClass())
            return false;
        CarroEletrico temp = (CarroEletrico) outro;
        return super.equals(temp) && this.bateria == temp.bateria && this.bateria_atual == temp.bateria_atual
                && this.consumo == temp.consumo && this.preco_energia == temp.preco_energia;
    }

    /**
     * Devolve uma representação textual de um Carro Eletrico
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

        sb.append("[Bateria] ").append(this.bateria).append(", ");
        sb.append("[Bateria Atual] ").append(this.bateria_atual).append(", ");
        sb.append("[Consumo] ").append(this.consumo).append(", ");
        sb.append("[Preco energia] ").append(this.preco_energia).append("\n");

        return sb.toString();
    }

    /**
     * Cria uma cópia do Carro que recebe a mensagem
     *
     * @return cópia do receptor
     */
    public CarroEletrico clone() {
        return new CarroEletrico(this);
    }

    /**
     * Estabele a ordem natural de um Carro Eletrico
     *
     * @param car Carro Eletrico a comparar
     * @return 0 se forem iguais, -1 se o receptor for menor, caso contrario 1
     */
    public int compareTo(CarroEletrico car) {
        int k1 = this.get_kms_totais();
        int k2 = car.get_kms_totais();

        if (k1 == k2) {
            return (int) (car.get_bateria() - this.get_bateria());
        }

        return k1 - k2;
    }

    // outros métodos

    /**
     * Determina o consumo de energia por km
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
        return (this.consumo / 100) * this.preco_energia;
    }

    /**
     * Atualiza a autonomia do Carro Eletrico
     */
    private void atualiza_autonomia() {
        super.set_autonomia((int) (this.bateria_atual / this.consumo_km()));
    }

    /**
     * Atualiza a quantidade de energia na bateria
     *
     * @param kms distancia percorrida
     */
    private void atualiza_bateria_atual(int kms) {
        this.bateria_atual -= kms / this.consumo_km();
    }

    /**
     * Efetua uma viagem de x kilometros
     *
     * @param kms distancia percorrida
     */
    public void viagem(int kms) {
        if (kms > 0) {
            this.atualiza_bateria_atual(kms);
            this.atualiza_autonomia();
            super.adiciona_kms(kms);
        }
    }

    /**
     * Carrega até ao máximo a bateria do Carro Eletrico
     */
    public void abastecer_carro() {
        this.bateria_atual = this.bateria;
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
