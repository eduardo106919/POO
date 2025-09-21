package dev.example;

import java.time.Duration;
import java.time.LocalDateTime;

/**
 * Classe que representa um pedido de suporte informático.
 * @author Eduardo Freitas Fernandes
 */
public class PedidodeSuporte {

    // variáveis de instância

    /** nome do cliente */
    private String cliente;
    /** instante do registo do pedido */
    private LocalDateTime instanteRegisto;
    /** assunto a ser tratado */
    private String assunto;
    /** descrição do pedido */
    private String descricao;
    /** funcionário que tratou o pedido */
    private String funcionario;
    /** instante de conclusão do pedido */
    private LocalDateTime instanteConclusao;
    /** informação a transmitir ao cliente */
    private String informacao;
    /** indica se o pedido está resolvido ou não */
    private boolean resolvido;


    // construtores

    /**
     * Construtor por omissão de um Pedido de Suporte
     */
    public PedidodeSuporte() {
        cliente = assunto = descricao = funcionario = informacao = "";
        instanteRegisto = instanteConclusao = LocalDateTime.now();
        resolvido = false;
    }

    /**
     * Construtor parametrizado de um Pedido de Suporte
     * @param cliente nome do cliente
     * @param instanteRegisto instante do registo
     * @param assunto assunto a ser tratado
     * @param descricao descrição do pedido
     */
    public PedidodeSuporte(String cliente,
                           LocalDateTime instanteRegisto,
                           String assunto,
                           String descricao) {
        this();
        this.cliente = cliente;
        this.instanteRegisto = instanteRegisto;
        this.assunto = assunto;
        this.descricao = descricao;
    }

    /**
     * Construtor de cópia de um Pedido de Suporte
     * @param other Pedido de Suporte a copiar
     */
    public PedidodeSuporte(PedidodeSuporte other) {
        cliente = other.cliente;
        instanteRegisto = other.instanteRegisto;
        assunto = other.assunto;
        descricao = other.descricao;
        funcionario = other.funcionario;
        instanteConclusao = other.instanteConclusao;
        informacao = other.informacao;
        resolvido = other.resolvido;
    }


    // métodos de instância

    /**
     * Devolve o nome do cliente que efetuou o pedido
     * @return nome do cliente
     */
    public String getCliente() {
        return cliente;
    }

    /**
     * Altera o nome do cliente que efetuou o pedido
     * @param cliente nome do cliente
     */
    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    /**
     * Devolve o instante que o pedido foi registado
     * @return instante de registo
     */
    public LocalDateTime getInstanteRegisto() {
        return instanteRegisto;
    }

    /**
     * Altera o instante que o pedido foi registado
     * @param instanteRegisto instante de registo
     */
    public void setInstanteRegisto(LocalDateTime instanteRegisto) {
        this.instanteRegisto = instanteRegisto;
    }

    /**
     * Devolve o assunto a ser tratado no pedido
     * @return assunto a ser tratado
     */
    public String getAssunto() {
        return assunto;
    }

    /**
     * Altera o assunto a ser tratado no pedido
     * @param assunto assunto a ser tratado
     */
    public void setAssunto(String assunto) {
        this.assunto = assunto;
    }

    /**
     * Devolve a descrição do pedido
     * @return descrição do pedido
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * Altera a descrição do pedido
     * @param descricao descrição do pedido
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /**
     * Devolve o nome do técnico que tratou do pedido
     * @return nome do técnico
     */
    public String getFuncionario() {
        return funcionario;
    }

    /**
     * Devolve o instante que o pedido foi concluido
     * @return instante de conclusão
     */
    public LocalDateTime getInstanteConclusao() {
        return instanteConclusao;
    }

    /**
     * Devolve a informação a ser transmitida ao cliente
     * @return informação a ser transmitida
     */
    public String getInformacao() {
        return informacao;
    }

    /**
     * Indica se o pedido está resolvido ou não
     * @return {@code true} se o pedido está resolvido, {@code false} caso contrário
     */
    public boolean isResolvido() {
        return resolvido;
    }

    /**
     * Resolve um pedido por concluir
     * @param tecnico nome do técnico
     * @param info informação a transmitir
     */
    public void resolverPedido(String tecnico, String info) {
        if (!resolvido) {
            funcionario = tecnico;
            informacao = info;
            instanteConclusao = LocalDateTime.now();
            resolvido = true;
        }
    }

    /**
     * Devolve o tempo de resolução em minutos
     * @return tempo de resolução (-1 caso não esteja resolvido)
     */
    public int getTempoResolucao() {
        if (resolvido)
            return (int) Duration.between(instanteRegisto, instanteConclusao).toMinutes();
        return -1;
    }

    /**
     * Efetua uma cópia de um Pedido de Suporte
     * @return cópia de um Pedido de Suporte
     */
    @Override
    public PedidodeSuporte clone() {
        return new PedidodeSuporte(this);
    }

    /**
     * Devolve uma representação textual de um Pedido de Suporte
     * @return representação textual
     */
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        builder.append("Pedido de Suporte: { ");
        builder.append("cliente: ").append(cliente);
        builder.append("registo: ").append(instanteRegisto.toString());
        builder.append("assunto: ").append(assunto);
        builder.append("descrição: ").append(descricao);
        if (resolvido) {
            builder.append("funcionário: ").append(funcionario);
            builder.append("conclusão: ").append(instanteConclusao);
            builder.append("informação: ").append(informacao);
        }
        builder.append(" }");

        return builder.toString();
    }

    /**
     * Compara um objeto a um Pedido de Suporte
     * @param obj objeto a comparar
     * @return {@code true} se forem iguais, {@code false} caso contrário
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (this.getClass() != obj.getClass()) return false;

        PedidodeSuporte other = (PedidodeSuporte) obj;
        return cliente.equals(other.cliente) && instanteRegisto.equals(other.instanteRegisto)
                && assunto.equals(other.assunto) && descricao.equals(other.descricao)
                && resolvido == other.resolvido && funcionario.equals(other.funcionario)
                && instanteConclusao.equals(other.instanteConclusao) && informacao.equals(other.informacao);
    }

}
