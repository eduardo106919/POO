


public class Lugar {

    /**
     * Variáveis de Instância
     */

    /** Matricula do veiculo estacionado */
    private String matricula;
    /** Nome do proprietario */
    private String nome;
    /** Tempo atribuido ao lugar, em minutos */
    private int minutos;
    /** Indica se lugar é permanente, ou de aluguer */
    private boolean permanente;

    /**
     * Construtores
     */

    /**
     * Construtor por omissão de um Lugar de estacionamento
     */
    public Lugar() {
        this.matricula = "";
        this.nome = "";
        this.minutos = 10;
        this.permanente = false;
    }

    /**
     * Construtor parametrizado de um Lugar de estacionamento
     *
     * @param matricula matricula do veiculo
     * @param nome dono do veiculo
     * @param minutos tempo atribuido
     * @param permanente indica se o lugar é alugado ou permanente
     */
    public Lugar(String matricula, String nome, int minutos, boolean permanente) {
        this.matricula = matricula;
        this.nome = nome;
        this.minutos = minutos;
        this.permanente = permanente;
    }

    /**
     * Construtor de cópia de um Lugar de estacionamento
     *
     * @param outro Lugar a copiar
     */
    public Lugar(Lugar outro) {
        this.matricula = outro.matricula;
        this.nome = outro.nome;
        this.minutos = outro.minutos;
        this.permanente = outro.permanente;
    }

    /**
     * Métodos de Instância
     */

    // getters
    
    /**
     * Devolve a matricula do veiculo
     *
     * @return matricula do veiculo
     */
    public String get_matricula() {
        return this.matricula;
    }

    /**
     * Devolve o nome do dono do veiculo
     *
     * @return nome do dono do veiculo
     */
    public String get_nome() {
        return this.nome;
    }

    /**
     * Devolve o numero de minutos atribuidos ao veiculo
     *
     * @return numero de minutos
     */
    public int get_minutos() {
        return this.minutos;
    }

    /**
     * Indica se o lugar é permanente ou alugado
     *
     * @return true se for permanente
     */
    public boolean get_permanente() {
        return this.permanente;
    }

    // setters
    
    /**
     * Altera a matricula do veiculo estacionado
     *
     * @param matricula matricula do veiculo
     */
    public void set_matricula(String matricula) {
        this.matricula = matricula;
    }

    /**
     * Altera o nome do dono do veiculo
     *
     * @param nome nome do dono
     */
    public void set_nome(String nome) {
        this.nome = nome;
    }

    /**
     * Altera o numero de minutos atribuidos
     *
     * @param minutos numero de minutos
     */
    public void set_minutos(int minutos) {
        this.minutos = minutos;
    }

    /**
     * Define o Lugar como permanente
     */
    public void set_permanente() {
        this.permanente = true;
    }

    /**
     * Define o Lugar como alugado
     */
    public void set_alugado() {
        this.permanente = false;
    }

    // métodos de utilidade

    /**
     * Compara um objeto a uma Lugar de estacionamento
     *
     * @param outro objeto a comparar
     * @return true se forem iguais
     */
    public boolean equals(Object outro) {
        if (this == outro)
            return true;
        if ((outro == null) || (this.getClass() != outro.getClass()))
            return false;
        Lugar temp = (Lugar) outro;
        return this.matricula.equals(temp.matricula) && this.nome.equals(temp.nome)
            && this.minutos == temp.minutos && this.permanente == temp.permanente;
    }

    /**
     * Devolve uma representacao textual de um Lugar
     *
     * @return representacao textual
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("Matricula: ").append(this.matricula);
        sb.append("\nNome: ").append(this.nome);
        sb.append("\nMinutos: ").append(this.minutos);
        sb.append("\nPermanente: ").append(this.permanente);

        return sb.toString();
    }

    /**
     * Cria uma cópia de um Lugar
     *
     * @return cópia de um Lugar
     */
    public Lugar clone() {
        return new Lugar(this);
    }
}
