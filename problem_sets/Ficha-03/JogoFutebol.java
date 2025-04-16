



public class JogoFutebol {

    /**
     * Variáveis de Instância
     */

    private EstadoJogo estado;
    private int golos_casa;
    private int golos_adversario;

    /**
     * Construtores
     */

    /**
     * Construtor por omissão de um Jogo de Futebol
     */
    public JogoFutebol() {
        this.estado = EstadoJogo.POR_INICIAR;
        this.golos_casa = this.golos_adversario = 0;
    }

    /**
     * Construtor parametrizado de um Jogo de Futebol
     *
     * @param estado estado do JogoFutebol
     * @param casa numero de golos da casa
     * @param adversario numero de golos do adversario
     */
    public JogoFutebol(EstadoJogo estado, int casa, int adversario) {
        this.estado = estado;
        this.golos_casa = casa;
        this.golos_adversario = adversario;
    }

    /**
     * Construtor de copia de um Jogo de Futebol
     *
     * @param outro JogoFutebol a copiar
     */
    public JogoFutebol(JogoFutebol outro) {
        this.estado = outro.estado;
        this.golos_adversario = outro.golos_adversario;
        this.golos_casa = outro.golos_casa;
    }


    /**
     * Métodos de Intância
     */

    // getters
    
    /**
     * Devolve o estado do JogoFutebol
     *
     * @return estado do JogoFutebol
     */
    public EstadoJogo get_estado() {
        return this.estado;
    }

    /**
     * Devolve o numero de golos marcados pela equipa da casa
     *
     * @return numero de golos da casa
     */
    public int get_golos_casa() {
        return this.golos_casa;
    }

    /**
     * Devolve o numero de golos marcados pela equipa adversaria
     *
     * @return numero de golos do adversario
     */
    public int get_golos_adversario() {
        return this.golos_adversario;
    }

    // métodos de utilidade

    /**
     * Compara um objeto com um JogoFutebol
     *
     * @param outro objeto a comparar
     * @return true se forem iguais
     */
    public boolean equals(Object outro) {
        if (this == outro)
            return true;
        if ((outro == null) || (this.getClass() != outro.getClass()))
            return false;
        JogoFutebol temp = (JogoFutebol) outro;
        return this.estado == temp.estado && this.golos_casa == temp.golos_casa
            && this.golos_adversario == temp.golos_adversario;
    }

    /**
     * Devolve uma representacao textual de um JogoFutebol
     *
     * @return representacao textual
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();
        
        sb.append("Estado: ").append(this.estado);
        sb.append("Casa: ").append(this.golos_casa);
        sb.append("Adversario: ").append(this.golos_adversario);

        return sb.toString();
    }

    /**
     * Cria uma cópia de um JogoFutebol
     *
     * @return copia do JogoFutebol
     */
    public JogoFutebol clone() {
        return new JogoFutebol(this);
    }

    // outros métodos

    /**
     * Dá inicio a um jogo
     */
    public void startGame() {
        if (this.estado == EstadoJogo.POR_INICIAR) {
            this.estado = EstadoJogo.A_DECORRER;
            this.golos_casa = this.golos_adversario = 0;
        }
    }

    /**
     * Termina um JogoFutebol
     */
    public void endGame() {
        if (this.estado == EstadoJogo.A_DECORRER) {
            this.estado = EstadoJogo.TERMINADO;
        }
    }

    /**
     * Regista um golo pela equipa da casa
     */
    public void goloVisitado() {
        if (this.estado == EstadoJogo.A_DECORRER) {
            this.golos_casa++;
        }
    }

    /**
     * Regista um golo pela equipa adversaria
     */
    public void goloVisitante() {
        if (this.estado == EstadoJogo.A_DECORRER) {
            this.golos_adversario++;
        }
    }

    /**
     * Devolve o resultado atual
     *
     * @return resultado atual
     */
    public String resultadoAtual() {
        if (estado != EstadoJogo.POR_INICIAR) {
            return this.golos_casa + " : " + this.golos_adversario;
        }

        return "";
    }
}
