
public class Carro {

    /**
     * Variáveis de Instância
     */

    private String marca;
    private String modelo;
    private int anoConstrucao;
    private double consumo100km;
    private double kmsTotais;
    private double consumoMedio;
    private double kmsUltimoPercurso;
    private double consumoUltimoPercurso;
    private double capacidadeRegen;
    private boolean ligado;

    /**
     * Construtores
     */

    /**
     * Construtor por omissão de um Carro
     */
    public Carro() {
        this.marca = "";
        this.modelo = "";
        this.anoConstrucao = 0;
        this.consumo100km = 0;
        this.kmsTotais = 0;
        this.consumoMedio = 0;
        this.kmsUltimoPercurso = 0;
        this.consumoUltimoPercurso = 0;
        this.capacidadeRegen = 0;
        this.ligado = false;
    }

    /**
     * Construtor parametrizado de um Carro
     *
     * @param marca marca do Carro
     */
    public Carro(String marca, String modelo, int anoConstrucao, double consumo100km,
            double kmsTotais, double consumoMedio, double kmsUltimoPercurso,
            double consumoUltimoPercurso, double capacidadeRegen) {
        this.marca = marca;
        this.modelo = modelo;
        this.anoConstrucao = anoConstrucao;
        this.consumo100km = consumo100km;
        this.kmsTotais = kmsTotais;
        this.consumoMedio = consumoMedio;
        this.kmsUltimoPercurso = kmsUltimoPercurso;
        this.consumoUltimoPercurso = consumoUltimoPercurso;
        this.capacidadeRegen = capacidadeRegen;
        this.ligado = false;
    }

    /**
     * Construtor de cópia de um Carro
     *
     * @param outro Carro a copiar
     */
    public Carro(Carro outro) {
        this.marca = outro.marca;
        this.modelo = outro.modelo;
        this.anoConstrucao = outro.anoConstrucao;
        this.consumo100km = outro.consumo100km;
        this.kmsTotais = outro.kmsTotais;
        this.consumoMedio = outro.consumoMedio;
        this.kmsUltimoPercurso = outro.kmsUltimoPercurso;
        this.consumoUltimoPercurso = outro.consumoUltimoPercurso;
        this.capacidadeRegen = outro.capacidadeRegen;
        this.ligado = outro.ligado;
    }

    /**
     * Métodos de Instância
     */

    // getter e setters

    /**
     * Retorna a marca do veículo.
     * 
     * @return a marca.
     */
    public String getMarca() {
        return marca;
    }

    /**
     * Define a marca do veículo.
     * 
     * @param marca a nova marca.
     */
    public void setMarca(String marca) {
        this.marca = marca;
    }

    /**
     * Retorna o modelo do veículo.
     * 
     * @return o modelo.
     */
    public String getModelo() {
        return modelo;
    }

    /**
     * Define o modelo do veículo.
     * 
     * @param modelo o novo modelo.
     */
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    /**
     * Retorna o ano de construção do veículo.
     * 
     * @return o ano de construção.
     */
    public int getAnoConstrucao() {
        return anoConstrucao;
    }

    /**
     * Define o ano de construção do veículo.
     * 
     * @param anoConstrucao o novo ano de construção.
     */
    public void setAnoConstrucao(int anoConstrucao) {
        this.anoConstrucao = anoConstrucao;
    }

    /**
     * Retorna o consumo médio por 100 km.
     * 
     * @return o consumo por 100 km.
     */
    public double getConsumo100km() {
        return consumo100km;
    }

    /**
     * Define o consumo médio por 100 km.
     * 
     * @param consumo100km o novo valor de consumo.
     */
    public void setConsumo100km(double consumo100km) {
        this.consumo100km = consumo100km;
    }

    /**
     * Retorna a quilometragem total do veículo.
     * 
     * @return os kms totais.
     */
    public double getKmsTotais() {
        return kmsTotais;
    }

    /**
     * Define a quilometragem total do veículo.
     * 
     * @param kmsTotais o novo valor de kms totais.
     */
    public void setKmsTotais(double kmsTotais) {
        this.kmsTotais = kmsTotais;
    }

    /**
     * Retorna o consumo médio do veículo.
     * 
     * @return o consumo médio.
     */
    public double getConsumoMedio() {
        return consumoMedio;
    }

    /**
     * Define o consumo médio do veículo.
     * 
     * @param consumoMedio o novo consumo médio.
     */
    public void setConsumoMedio(double consumoMedio) {
        this.consumoMedio = consumoMedio;
    }

    /**
     * Retorna a distância do último percurso.
     * 
     * @return os kms do último percurso.
     */
    public double getKmsUltimoPercurso() {
        return kmsUltimoPercurso;
    }

    /**
     * Define a distância do último percurso.
     * 
     * @param kmsUltimoPercurso o novo valor.
     */
    public void setKmsUltimoPercurso(double kmsUltimoPercurso) {
        this.kmsUltimoPercurso = kmsUltimoPercurso;
    }

    /**
     * Retorna o consumo do último percurso.
     * 
     * @return o consumo do último percurso.
     */
    public double getConsumoUltimoPercurso() {
        return consumoUltimoPercurso;
    }

    /**
     * Define o consumo do último percurso.
     * 
     * @param consumoUltimoPercurso o novo consumo.
     */
    public void setConsumoUltimoPercurso(double consumoUltimoPercurso) {
        this.consumoUltimoPercurso = consumoUltimoPercurso;
    }

    /**
     * Retorna a capacidade de regeneração de energia.
     * 
     * @return a capacidade de regeneração.
     */
    public double getCapacidadeRegen() {
        return capacidadeRegen;
    }

    /**
     * Define a capacidade de regeneração de energia.
     * 
     * @param capacidadeRegen o novo valor.
     */
    public void setCapacidadeRegen(double capacidadeRegen) {
        this.capacidadeRegen = capacidadeRegen;
    }

    /**
     * Indica se o veículo está ligado.
     * 
     * @return true se estiver ligado, false caso contrário.
     */
    public boolean isLigado() {
        return ligado;
    }

    // métodos de utilidade

    /**
     * Compara um objeto a um Carro
     *
     * @param o objeto a comparar
     * @return true se forem iguais
     */
    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Carro))
            return false;
        Carro c = (Carro) o;
        return anoConstrucao == c.anoConstrucao &&
                Double.compare(c.consumo100km, consumo100km) == 0 &&
                Double.compare(c.kmsTotais, kmsTotais) == 0 &&
                Double.compare(c.consumoMedio, consumoMedio) == 0 &&
                Double.compare(c.kmsUltimoPercurso, kmsUltimoPercurso) == 0 &&
                Double.compare(c.consumoUltimoPercurso, consumoUltimoPercurso) == 0 &&
                Double.compare(c.capacidadeRegen, capacidadeRegen) == 0 &&
                ligado == c.ligado &&
                marca.equals(c.marca) &&
                modelo.equals(c.modelo);
    }

    /**
     * Cria uma cópia de um Carro
     *
     * @return cópia de um Carro
     */
    @Override
    public Carro clone() {
        return new Carro(this);
    }

    /**
     * Devolve uma representacao textual de um Carro
     *
     * @return representacao textual
     */
    @Override
    public String toString() {
        return "Carro{" +
                "marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", anoConstrucao=" + anoConstrucao +
                ", consumo100km=" + consumo100km +
                ", kmsTotais=" + kmsTotais +
                ", consumoMedio=" + consumoMedio +
                ", kmsUltimoPercurso=" + kmsUltimoPercurso +
                ", consumoUltimoPercurso=" + consumoUltimoPercurso +
                ", capacidadeRegen=" + capacidadeRegen +
                ", ligado=" + ligado +
                '}';
    }

    // outros métodos

    /**
     * Método que liga o Carro
     */
    public void ligaCarro() {
        ligado = true;
        resetUltimaViagem();
    }

    /**
     * Método que desliga o Carro
     */
    public void desligaCarro() {
        ligado = false;
    }

    /**
     * Método que força explicitamente um reset do contador de último percurso
     */
    public void resetUltimaViagem() {
        kmsUltimoPercurso = 0;
        consumoUltimoPercurso = 0;
    }

    /**
     * Método que avança X metros a uma velocidade de V km/h
     *
     * @param metros     distancia percorrida
     * @param velocidade velocidade a que Carro se deslocava
     */
    public void avancaCarro(double metros, double velocidade) {
        if (!ligado)
            return;

        double kms = metros / 1000.0;
        double consumo = (consumo100km / 100) * kms;

        kmsTotais += kms;
        kmsUltimoPercurso += kms;
        consumoUltimoPercurso += consumo;

        consumoMedio = (consumoMedio * (kmsTotais - kms) + consumo) / kmsTotais;
    }

    /**
     * Método que trava o carro durante X metros
     *
     * @param metros distância percorrida
     */
    public void travaCarro(double metros) {
        if (!ligado)
            return;

        double kms = metros / 1000.0;
        double regenerado = capacidadeRegen * kms;

        consumoUltimoPercurso -= regenerado;
        consumoMedio = (consumoMedio * kmsTotais - regenerado) / kmsTotais;
    }
}
