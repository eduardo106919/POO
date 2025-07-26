


public class Lampada {

    /**
     * Variáveis de Instância
     */

    private Modo estado;
    private double consumo_on;
    private double consumo_eco;
    // consumo_off = 0
    private double consumo_total;
    private double consumo_periodo;
    private long stamp;

    /**
     * Construtores
     */

    /**
     * Construtor por omissão de uma Lampada
     */
    public Lampada() {
        this.estado = Modo.OFF;
        this.consumo_on = this.consumo_eco = 1;
        this.consumo_total = this.consumo_periodo = 0;
        this.stamp = System.currentTimeMillis();
    }

    /**
     * Construtor parametrizado de uma Lampada
     *
     * @param estado estado da Lampada
     * @param consumo_on consumo por milisegundo no modo ON
     * @param consumo_eco consumo por milisegundo no modo ECO
     */
    public Lampada(Modo estado, double consumo_on, double consumo_eco) {
        this.estado = estado;
        this.consumo_on = consumo_on;
        this.consumo_eco = consumo_eco;
        this.consumo_total = this.consumo_periodo = 0;
        this.stamp = System.currentTimeMillis();
    }

    /**
     * Construtor de cópia de uma Lampada
     *
     * @param outro Lampada a copiar
     */
    public Lampada(Lampada outro) {
        this.estado = outro.estado;
        this.consumo_on = outro.consumo_on;
        this.consumo_eco = outro.consumo_eco;
        this.consumo_total = outro.consumo_total;
        this.consumo_periodo = outro.consumo_periodo;
        this.stamp = outro.stamp;
    }

    /**
     * Métodos de Instância
     */

    // getters
    
    /**
     * Devolve o estado da Lampada
     *
     * @return estada da Lampada
     */
    public Modo get_estado() {
        return this.estado;
    }

    /**
     * Devolve o consumo por milisegundo da Lampada no modo ON
     *
     * @return consumo no modo ON
     */
    public double get_consumo_on() {
        return this.consumo_on;
    }

    /**
     * Devolve o consumo por milisegundo da Lampada no modo ECO
     *
     * @return consumo no modo ECO
     */
    public double get_consumo_eco() {
        return this.consumo_eco;
    }

    /**
     * Devolve o consumo total da Lampada
     *
     * @return consumo total
     */
    public double get_consumo_total() {
        return this.consumo_total;
    }

    /**
     * Devolve o consumo desde o ultimo reset
     *
     * @return consumo desde o ultimo reset
     */
    public double get_consumo_periodo() {
        return this.consumo_periodo;
    }

    /**
     * Devolve o stamp do ultimo reset
     *
     * @return stamp do ultimo reset
     */
    public long get_stamp() {
        return this.stamp;
    }

    // setters
    
    /**
     * Altera o estado da Lampada
     *
     * @param estado novo estado
     */
    public void set_estado(Modo estado) {
        this.atualiza_consumo();
        this.estado = estado;
    }

    /**
     * Altera o consumo por milisegundo no modo ON
     *
     * @param consumo_on consumo no modo ON
     */
    public void set_consumo_on(double consumo_on) {
        this.atualiza_consumo();
        this.consumo_on = consumo_on;
    }

    /**
     * Altera o consumo por milisegundo no modo ECO
     *
     * @param consumo_eco consumo no modo ECO
     */
    public void set_consumo_eco(double consumo_eco) {
        this.atualiza_consumo();
        this.consumo_eco = consumo_eco;
    }

    // métodos de utilidade

    /**
     * Compara um objecto a uma Lampada
     *
     * @param outro objeto a comparar
     * @return true se forem iguais
     */
    public boolean equals(Object outro) {
        if (this == outro)
            return true;
        if ((outro == null) || (this.getClass() != outro.getClass()))
            return false;
        Lampada temp = (Lampada) outro;
        return this.estado == temp.estado && this.stamp == temp.stamp
            && this.consumo_on == temp.consumo_on && this.consumo_eco == temp.consumo_eco
            && this.consumo_total == temp.consumo_total && this.consumo_periodo == temp.consumo_periodo;
    }

    /**
     * Devolve uma representacao textual de uma Lampada
     *
     * @return representacao textual
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("Modo: ").append(this.estado);
        sb.append("\nConsumo ON: ").append(this.consumo_on);
        sb.append("\nConsumo ECO: ").append(this.consumo_eco);
        sb.append("\nConsumo total: ").append(this.consumo_total);
        sb.append("\nConsumo periodo: ").append(this.consumo_periodo);
        sb.append("\nStamp: ").append(this.stamp);

        return sb.toString();
    }

    /**
     * Cria uma copia de uma Lampada
     *
     * @return copia da Lampada
     */
    public Lampada clone() {
        return new Lampada(this);
    }

    // outros métodos

    /**
     * Atualiza o consumo da Lampada
     */
    private void atualiza_consumo() {
        long periodo = System.currentTimeMillis() - this.stamp;

        // adicionar consumo
        if (this.estado == Modo.ON) {
            this.consumo_total += this.consumo_on * periodo;
            this.consumo_periodo += this.consumo_on * periodo;
        } else if (this.estado == Modo.ECO) {
            this.consumo_total += this.consumo_eco * periodo;
            this.consumo_periodo += this.consumo_eco * periodo;
        }

        // atualizar stamp
        this.stamp = System.currentTimeMillis();
    }

    /**
     * Efetua um reset ao perido de contagem
     */
    public void resetPeriodo() {
        this.atualiza_consumo();
        this.consumo_periodo = 0;
    }

    /**
     * Liga a Lampada no consumo maximo
     */
    public void lampON() {
        this.atualiza_consumo();
        this.estado = Modo.ON;
    }

    /**
     * Desliga a Lampada
     */
    public void lampOFF() {
        this.atualiza_consumo();
        this.estado = Modo.OFF;
    }

    /**
     * Liga a Lampada no modo Economico
     */
    public void lampECO() {
        this.atualiza_consumo();
        this.estado = Modo.ECO;
    }

    /**
     * Devolve o consumo total desde a criacao da Lampada
     *
     * @return consumo total
     */
    public double totalConsumo() {
        this.atualiza_consumo();
        return this.consumo_total;
    }

    /**
     * Devolve o consumo desde o ultimo reset
     *
     * @return consumo periodo
     */
    public double periodoConsumo() {
        this.atualiza_consumo();
        return this.consumo_periodo;
    }
}
