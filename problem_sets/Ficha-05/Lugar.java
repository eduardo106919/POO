
/**
 * Classe que representa um Lugar de estacionamento
 */
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
     * Construtor por omissão de um Lugar de Estacionamento
     */
    public Lugar() {
        this.matricula = "n/a";
        this.nome = "n/a";
        this.minutos = 0;
        this.permanente = false;
    }

    /**
     * Construtor parametrizado de um lugar de Estacionamento
     *
     * @param matricula matricula do veiculo
     * @param nome nome do proprietario do veiculo
     * @param minutos tempo atribuido ao Lugar
     * @param permanente se o lugar é permanente ou de aluguer
     */
    public Lugar(String matricula, String nome, int minutos, boolean permanente) {
        this();
        if (minutos > 0) {
            this.matricula = matricula;
            this.nome = nome;
            this.minutos = minutos;
            this.permanente = permanente;
        }
    }

    /**
     * Construtor de cópia de um Lugar
     *
     * @param outro Lugar a copiar
     */
    public Lugar(Lugar outro) {
        this();
        if (outro != null) {
            this.matricula = outro.matricula;
            this.nome = outro.nome;
            this.minutos = outro.minutos;
            this.permanente = outro.permanente;
        }
    }

    /**
     * Métodos de Instância
     */

    // getters
    
    /**
     * Devolve a matricula do veiculo estacionado
     *
     * @return matricula do carro
     */
    public String get_matricula() {
        return this.matricula;
    }

    /**
     * Devolve o nome do proprietario do veiculo
     *
     * @return nome do proprietario
     */
    public String get_nome() {
        return this.nome;
    }

    /**
     * Devolve o número de minutos atribuido ao lugar
     *
     * @return numero de minutos
     */
    public int get_minutos() {
        return this.minutos;
    }

    /**
     * Devolve o indicador se o lugar é permanente ou não
     *
     * @return indicador de permanência
     */
    public boolean get_permanente() {
        return this.permanente;
    }

    // setters
    
    public void set_matricula(String matricula) {
        this.matricula = matricula;
    }

    public void set_nome(String nome) {
        this.nome = nome;
    }

    public void set_minutos(int minutos) {
        if (minutos > 0) {
            this.minutos = minutos;
        }
    }

    public void set_permanente(boolean permanente) {
        this.permanente = permanente;
    }

    // métodos de utilidade
    
    /**
     * Compara dois objetos
     *
     * @param outro objeto a comparar
     * @return true se forem iguais
     */
    public boolean equals(Object outro) {
        if (this == outro)
            return true;
        if (outro == null || this.getClass() != outro.getClass())
            return false;
        Lugar temp = (Lugar) outro;
        return this.matricula.equals(temp.matricula) && this.nome.equals(temp.nome)
            && this.minutos == temp.minutos && this.permanente == temp.permanente;
    }

    /**
     * Devolve uma representação de um Lugar numa String
     *
     * @return representação de Lugar
     */
    public String toString() {
        return "matricula: " + this.matricula + "\nnome: " + this.nome + "\nminutos: " + this.minutos + "\npermanente: " + this.permanente;
    }

    /**
     * Clona o objeto chamador
     *
     * @return cópia do objeto
     */
    public Lugar clone() {
        return new Lugar(this);
    }
}
