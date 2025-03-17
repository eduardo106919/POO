
import java.time.LocalDateTime;


/**
 * Pedido de Suporte Informático
 */
public class PedidodeSuporte {

    /**
     * Variáveis de Instância
     */

    private String cliente;
    private LocalDateTime instante_pedido;
    private String assunto;
    private String descricao;

    private String funcionario;
    private LocalDateTime instante_concluido;
    private String informacao;


    /**
     * Construtores
     */

    /**
     * Constructor por omissão de um Pedido de Suporte Informático
     */
    public PedidodeSuporte() {
        this.cliente = "n/a";
        this.instante_pedido = LocalDateTime.now();
        this.assunto = "n/a";
        this.descricao = "n/a";

        this.funcionario = "n/a";
        this.instante_concluido = null;
        this.informacao = "n/a";
    }

    /**
     * Construtor parametrizado de um Pedido de Suporte Informático
     *
     * @param cliente nome do cliente
     * @param assunto assunto do pedido
     * @param descricao descricao do pedido
     */
    public PedidodeSuporte(String cliente, String assunto, String descricao) {
        this.cliente = cliente;
        this.instante_pedido = LocalDateTime.now();
        this.assunto = assunto;
        this.descricao = descricao;

        this.funcionario = "n/a";
        this.instante_concluido = null;
        this.informacao = "n/a";
    }

    /**
     * Construtor de cópia de um Pedido de Suporte Informático
     *
     * @param outro outro pedido de suporte
     */
    public PedidodeSuporte(PedidodeSuporte outro) {
        this.cliente = outro.cliente;
        this.instante_pedido = outro.instante_pedido;
        this.assunto = outro.assunto;
        this.descricao = outro.descricao;

        this.funcionario = outro.funcionario;
        this.instante_concluido = outro.instante_concluido;
        this.informacao = outro.informacao;
    }

    /**
     * Métodos de Instância
     */


    // getters

    /**
     * Devolve o nome do cliente que efetuou o pedido
     *
     * @return nome do cliente
     */
    public String get_cliente() {
        return this.cliente;
    }

    /**
     * Devolve o instante em que o pedido foi efetuado
     *
     * @return instante em que o pedido foi submetido
     */
    public LocalDateTime get_instante_pedido() {
        return this.instante_pedido;
    }

    /**
     * Devolve o assunto do pedido
     *
     * @return assunto do pedido
     */
    public String get_assunto() {
        return this.assunto;
    }

    /**
     * Devolve a descrição do pedido
     *
     * @return descricao do pedido
     */
    public String get_descricao() {
        return this.descricao;
    }

    /**
     * Devolve o nome do funcionário que tratou do pedido
     *
     * @return nome do funcionário
     */
    public String get_funcionario() {
        return this.funcionario;
    }

    /**
     * Devolve o instante em que o pedido foi concluido
     * Devolve null se ainda não terminou o pedido
     *
     * @return instante em que o pedido foi concluido
     */
    public LocalDateTime get_instante_concluido() {
        return this.instante_concluido;
    }

    /**
     * Devolve a informação a ser transmitida ao cliente
     *
     * @return informação a ser transmitida ao cliente
     */
    public String get_informacao() {
        return this.informacao;
    }

    // setters
    
    /**
     * Altera o nome do cliente que efetuou o pedido
     *
     * @param cliente nome do cliente
     */
    public void set_cliente(String cliente) {
        this.cliente = cliente;
    }

    /**
     * Altera o assunto do pedido de suporte
     *
     * @param assunto assunto do pedido
     */
    public void set_assunto(String assunto) {
        this.assunto = assunto;
    }

    /**
     * Altera a descricao do pedido de suporte
     *
     * @param descricao descricao do pedido
     */
    public void set_descrição(String descricao) {
        this.descricao = descricao;
    }

    /**
     * Atera o funcionário que trata do pedido
     *
     * @param funcionario funcionario que trata do pedido
     */
    public void set_funcionario(String funcionario) {
        this.funcionario = funcionario;
    }

    /**
     * Coloca o pedido como terminado, se ainda nao terminou
     */
    public void set_instante_concluido() {
        if (this.instante_concluido == null)
            this.instante_concluido = LocalDateTime.now();
    }

    /**
     * Altera a informação a transmitir ao cliente
     *
     * @param informacao informacao a transmitir
     */
    public void set_informacao(String informacao) {
        this.informacao = informacao;
    }

    // outros métodos

    /**
     * Compara um objeto ao Pedido de Suporte chamador
     *
     * @param o objeto a compara
     * @return true se forem iguais
     */
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (o == null || this.getClass() != o.getClass())
            return false;
        PedidodeSuporte temp = (PedidodeSuporte) o;
        return this.cliente.equals(temp.cliente) && this.instante_pedido.equals(temp.instante_pedido)
            && this.assunto.equals(temp.assunto) && this.descricao.equals(temp.descricao)
            && this.funcionario.equals(temp.funcionario) && this.instante_concluido.equals(temp.instante_concluido)
            && this.informacao.equals(temp.informacao);
    }

    /**
     * Clona um Pedido de Suporte
     *
     * @return pedido de suporte clonado
     */
    public PedidodeSuporte clone() {
        return new PedidodeSuporte(this);
    }

    /**
     * Transforma um pedido de suporte numa string
     *
     * @return string com a informacao de um pedido de suporte
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("cliente: ").append(this.cliente);
        sb.append("instante pedido: ").append(this.instante_pedido.toString());
        sb.append("assunto: ").append(this.assunto);
        sb.append("descricao: ").append(this.descricao);
        sb.append("funcionario: ").append(this.funcionario);
        sb.append("instante concluido: ").append(this.instante_concluido.toString());
        sb.append("informacao: ").append(this.informacao);

        return sb.toString();
    }
}
