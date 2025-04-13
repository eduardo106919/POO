
/**
 * Deteta a pressão de uma divisão de uma casa
 */
public class Sensor {

    /**
     * Variáveis de Instância
     */

    private double pressao;


    /**
     * Construtores
     */

    /**
     * Construtor por omissão de uma Sensor
     */
    public Sensor() {
        this.pressao = 0;
    }

    /**
     * Construtor parametrizado de um Sensor
     * A pressao deve ser não negativa
     *
     * @param pressao pressao da divisao
     */
    public Sensor(double pressao) {
        this.pressao = 0;

        // pressao tem de ser positiva
        if (pressao > 0) {
            this.pressao = pressao;
        }
    }

    /**
     * Construtor de cópia de um Sensor
     * Sensor passado tem de ser não nulo
     *
     * @param outro Sensor a copiar
     */
    public Sensor(Sensor outro) {
        this.pressao = 0;

        if (outro != null) {
            this.pressao = outro.pressao;
        }
    }

    /**
     * Métodos de Instância
     */

    // getters
    
    /**
     * Devolve a pressão da divisão
     *
     * @return pressão da divisão
     */
    public double get_pressao() {
        return this.pressao;
    }

    // setters
    
    /**
     * Altera a pressão de uma divisão
     * Valor deve ser não negativo
     * 
     * @param valor pressão da divisão
     * @return true se o valor passado for válido
     */
    public boolean set_pressao(double valor) {
        if (valor >= 0) {
            this.pressao = valor;
        }

        return valor >= 0;
    }

    // outros métodos

    /**
     * Compara dois Sensores
     *
     * @param outro objeto a comparar
     * @return true se forem iguais
     */
    public boolean equals(Object outro) {
        if (this == outro)
            return true;
        if (outro == null || this.getClass() != outro.getClass())
            return false;
        Sensor temp = (Sensor) outro;
        return this.pressao == temp.pressao;
    }

    /**
     * Devolve a representacao em String de um Sensor
     *
     * @return String com a informacao de um Sensor
     */
    public String toString() {
        return "pressão: " + this.pressao;
    }

    /**
     * Efetua uma cópia do objeto receptor da mensagem
     *
     * @return cópia do objeto
     */
    public Sensor clone() {
        return new Sensor(this);
    }
}
