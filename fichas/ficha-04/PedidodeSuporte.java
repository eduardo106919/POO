
import java.time.Duration;
import java.time.LocalDateTime;


public class PedidodeSuporte {

    /**
     * Variáveis de Instância
     */

    private String cliente;
    private LocalDateTime data;
    private String assunto;
    private String descricao;

    private boolean resolvido;
    private String funcionario;
    private LocalDateTime conclusao;
    private String informacao;


    /**
     * Construtores
     */

    /**
     * Construtor por omissão de um Pedido de Suporte
     */
    public PedidodeSuporte() {
        this.cliente = "";
        this.data = LocalDateTime.now();
        this.assunto = "";
        this.descricao = "";
        this.resolvido = false;
        this.funcionario = "";
        this.conclusao = LocalDateTime.now();
        this.informacao = "";
    }

    /**
     * Construtor parametrizado de um Pedido de Suporte por terminar
     *
     * @param cliente nome do cliente
     * @param assunto assunto do pedido
     * @param descricao descricao do pedido
     */
    public PedidodeSuporte(String cliente, String assunto, String descricao) {
        this();
        this.cliente = cliente;
        this.assunto = assunto;
        this.descricao = descricao;
    }

    /**
     * Construtor parametrizado de um Pedido de Suporte terminado
     *
     * @param cliente nome do cliente
     * @param assunto assunto do pedido
     * @param descricao descricao do pedido
     * @param inicio data do pedido
     * @param funcionario funcionario responsavel pelo pedido
     * @param informacao informacao para o cliente
     * @param fim data de resolucao do pedido
     */
    public PedidodeSuporte(String cliente, String assunto, String descricao, LocalDateTime inicio, String funcionario, String informacao, LocalDateTime fim) {
        this(cliente, assunto, descricao);
        this.resolvido = true;
        this.data = inicio;
        this.funcionario = funcionario;
        this.informacao = informacao;
        this.conclusao = fim;
    }

    /**
     * Construtor de cópia para um Pedido de Suporte
     *
     * @param outro PedidodeSuporte a copiar
     */
    public PedidodeSuporte(PedidodeSuporte outro) {
        this.cliente = outro.cliente;
        this.assunto = outro.assunto;
        this.descricao = outro.descricao;
        this.data = outro.data;
        this.resolvido = outro.resolvido;
        this.funcionario = outro.funcionario;
        this.conclusao = outro.conclusao;
        this.informacao = outro.informacao;
    }

    /**
     * Métodos de Instância
     */

    // getters
    
    /**
     * Devolve o nome do cliente
     *
     * @return nome do cliente
     */
    public String get_cliente() {
        return cliente;
    }

    /**
     * Devolve o assunto do pedido
     *
     * @return assunto do pedido
     */
    public String get_assunto() {
        return assunto;
    }

    /**
     * Devolve a descricao do pedido
     *
     * @return descricao do pedido
     */
    public String get_descricao() {
        return descricao;
    }

    /**
     * Devolve a data em que o pedido foi feito
     *
     * @return data do pedido
     */
    public LocalDateTime get_data() {
        return data;
    }

    /**
     * Devolve o nome do funcionario responsavel pelo pedido
     *
     * @return nome do funcionario
     */
    public String get_funcionario() {
        return funcionario;
    }

    /**
     * Devolve a informacao a transmitir ao cliente
     *
     * @return informacao a transmitir
     */
    public String get_informacao() {
        return informacao;
    }

    /**
     * Devolve a data de resolucao do pedido
     *
     * @return data de resolucao
     */
    public LocalDateTime get_data_resolucao() {
        return conclusao;
    }

    /**
     * Indica se o pedido está resolvido ou não
     *
     * @return true se estiver resolvido
     */
    public boolean get_resolvido() {
        return resolvido;
    }

    // setters
    
    /**
     * Altera o nome do cliente
     *
     * @param nome nome do cliente
     */
    public void set_cliente(String cliente) {
        this.cliente = cliente;
    }

    /**
     * Altera o assunto do pedido
     *
     * @param assunto assunto do pedido
     */
    public void set_assunto(String assunto) {
        this.assunto = assunto;
    }

    /**
     * Altera a descricao do pedido
     *
     * @param descricao descricao do pedido
     */
    public void set_descricao(String descricao) {
        this.descricao = descricao;
    }

    // métodos de utilidade

    /**
     * Compara um objeto a um PedidodeSuporte
     *
     * @param outro objeto a comparar
     * @return true se forem iguais
     */
    public boolean equals(Object outro) {
        if (this == outro)
            return true;
        if ((outro == null) || (this.getClass() != outro.getClass()))
            return false;
        PedidodeSuporte temp = (PedidodeSuporte) outro;
        return this.cliente.equals(temp.cliente) && this.assunto.equals(temp.assunto)
            && this.descricao.equals(temp.descricao) && this.data.equals(temp.data)
            && this.resolvido == temp.resolvido && this.funcionario.equals(temp.funcionario)
            && this.informacao.equals(temp.informacao) && this.conclusao.equals(temp.conclusao);
    }

    /**
     * Devolve uma representacao textual de um PedidodeSuporte
     *
     * @return representacao textual
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("Cliente: ").append(this.cliente);
        sb.append("Assunto: ").append(this.assunto);
        sb.append("Descricao: ").append(this.descricao);
        sb.append("Data: ").append(this.data.toString());
        if (this.resolvido == true) {
            sb.append("Funcionario: ").append(this.funcionario);
            sb.append("Informacao: ").append(this.informacao);
            sb.append("Conclusao: ").append(this.conclusao);
        }

        return sb.toString();
    }

    /**
     * Cria uma cópia de um PedidodeSuporte
     *
     * @return cópia de um PedidodeSuporte
     */
    public PedidodeSuporte clone() {
        return new PedidodeSuporte(this);
    }

    // outros métodos
        
    /**
     * Resolve um PedidodeSuporte
     *
     * @param funcionario nome do funcionario
     * @param informacao informacao a transmitir
     */
    public void resolver(String funcionario, String informacao) {
        if (this.resolvido == false) {
            this.resolvido = true;
            this.funcionario = funcionario;
            this.informacao = informacao;
            this.conclusao = LocalDateTime.now();
        }
    }

    /**
     * Determina o tempo de resolucao de um Pedido de Suporte terminado
     *
     * @return tempo de resolucao
     */
    public long tempo_resolucao() {
        if (this.resolvido) {
            return Duration.between(this.data, this.conclusao).toMinutes();
        }
        return -1;
    }
}
