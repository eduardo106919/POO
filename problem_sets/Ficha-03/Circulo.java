

/**
 * Circulo, representado por um centro e um raio
 */
public class Circulo {

    /**
     * Variáveis de Instância
     */

    private double x;
    private double y;
    private double raio;
    
    /**
     * Construtores
     */

    /**
     * Construtor por omissão de um Circulo
     */
    public Circulo() {
        this.x = 0;
        this.y = 0;
        this.raio = 0;
    }

    /**
     * Construtor parametrizado de um Circulo
     *
     * @param x coordenada horizontal do centro
     * @param y coordenada vertical do centro
     * @param raio distância do centro à fronteira
     */
    public Circulo(double x, double y, double raio) {
        this.x = x;
        this.y = y;
        this.raio = raio;
    }

    /**
     * Construtor de cópia de um Circulo
     * O circulo deve ser válido para as operacoes serem efetuadas
     *
     * @param outro circulo a copiar
     */
    public Circulo(Circulo outro) {
        // se o circulo existir
        if (outro != null) {
            this.x = outro.x;
            this.y = outro.y;
            this.raio = outro.raio;
        } else {
            this.x = this.y = this.raio = 0;
        }
    }

    /**
     * Métodos de Instância
     */

    // getters
    
    /**
     * Devolve a coordenada horizontal do centro do circulo
     *
     * @return coordenada horizontal do centro
     */
    public double get_x() {
        return this.x;
    }

    /**
     * Devolve a coordenada vertical do centro do circulo
     *
     * @return coordenada vertical do centro
     */
    public double get_y() {
        return this.y;
    }

    /**
     * Devolve a distância do centro à fronteira do circulo
     *
     * @return raio do circulo
     */
    public double get_raio() {
        return this.raio;
    }

    // setters

    /**
     * Altera a coordenada horizontal do centro do circulo
     *
     * @param x nova coordenada horizontal
     */
    public void set_x(double x) {
        this.x = x;
    }

    /**
     * Altera a coordenada vertical do centro do circulo
     *
     * @param y nova coordenada vertical
     */
    public void set_y(double y) {
        this.y = y;
    }

    /**
     * Altera o raio do circulo
     * O raio deve ser não negativo para alteracoes serem efetuadas
     *
     * @param raio novo raio do circulo
     */
    public void set_raio(double raio) {
        // raio deve ser positivo
        if (raio >= 0) {
            this.raio = raio;
        }
    }

    // outros métodos

    /**
     * Altera o centro do circulo
     *
     * @param x coordenada horizontal
     * @param y corrdenada vertical
     */
    public void altera_centro(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Calcula a área do circulo
     *
     * @return area do circulo
     */
    public double calcula_area() {
        return Math.PI * Math.pow(this.raio, 2);
    }

    /**
     * Calcula o perimetro do circulo
     *
     * @return perimetro do circulo
     */
    public double calcula_perimetro() {
        return 2 * Math.PI * this.raio;
    }

    /**
     * Compara dois Circulos
     *
     * @param outro objeto comparado com o receptor da mensagem
     * @return true se forem iguais
     */
    public boolean equals(Object outro) {
        if (this == outro)
            return true;
        if (outro == null || this.getClass() != outro.getClass())
            return false;
        Circulo temp = (Circulo) outro;
        return this.x == temp.x && this.y == temp.y && this.raio == temp.raio;
    }

    /**
     * Efetua uma cópia do objeto receptor da mensagem
     *
     * @return objeto clone
     */
    public Circulo clone() {
        return new Circulo(this);
    }

    /**
     * Devolve a representacao em String de um Circulo
     *
     * @return String com a informacao de uma Circulo
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("x: ").append(this.x);
        sb.append("\ny: ").append(this.y);
        sb.append("\nraio: ").append(this.raio);

        return sb.toString();
    }
}
