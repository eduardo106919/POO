package dev.example;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Gestor eficiente de linhas de encomendas.
 * @author Eduardo Freitas Fernandes
 */
public class EncEficiente {

    // variáveis de classe

    /** número de encomendas únicas */
    private static int totalEncomendas = 0;

    // variáveis de instância

    /** nome do cliente */
    private String cliente;
    /** número de identificação fiscal do cliente */
    private int nif;
    /** morada do cliente */
    private String morada;
    /** número do cliente */
    private final int numeroEncomenda;
    /** data em que a encomenda foi realizada */
    private LocalDateTime dataEncomenda;
    /** produtos encomendados */
    private List<LinhaEncomenda> linhasEncomenda;


    // construtores

    /**
     * Construtor por omissão de uma EncEficiente
     */
    public EncEficiente() {
        cliente = morada = "";
        nif = 0;
        dataEncomenda = LocalDateTime.now();
        linhasEncomenda = new ArrayList<>();
        numeroEncomenda = EncEficiente.totalEncomendas++;
    }

    /**
     * Construtor parametrizado de uma EncEficiente
     * @param cliente nome do Cliente
     * @param nif número de identificação fiscal
     * @param morada morada do cliente
     * @param dataEncomenda data da encomenda
     * @param linhasEncomenda produtos encomendados
     */
    public EncEficiente(String cliente,
                        int nif,
                        String morada,
                        LocalDateTime dataEncomenda,
                        List<LinhaEncomenda> linhasEncomenda) {
        this.cliente = cliente;
        this.nif = nif;
        this.morada = morada;
        this.dataEncomenda = dataEncomenda;
        this.linhasEncomenda = linhasEncomenda.stream()
                .map(LinhaEncomenda::clone)
                .collect(Collectors.toList());
        this.numeroEncomenda = EncEficiente.totalEncomendas++;
    }

    /**
     * Construtor de cópia de uma EncEficiente
     * @param other EncEficiente a copiar
     */
    public EncEficiente(EncEficiente other) {
        cliente = other.cliente;
        nif = other.nif;
        morada = other.morada;
        dataEncomenda = other.dataEncomenda;
        linhasEncomenda = other.linhasEncomenda.stream()
                .map(LinhaEncomenda::clone)
                .collect(Collectors.toList());
        numeroEncomenda = other.numeroEncomenda;
    }


    // métodos de instância

    /**
     * Devolve o número de encomendas únicas
     * @return número de encomendas únicas
     */
    public static int getTotalEncomendas() {
        return EncEficiente.totalEncomendas;
    }

    /**
     * Devolve o nome do cliente
     * @return nome do cliente
     */
    public String getCliente() {
        return cliente;
    }

    /**
     * Altera o nome do cliente
     * @param cliente nome do cliente
     */
    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    /**
     * Devolve o número de identificação fiscal
     * @return número de identificação fiscal
     */
    public int getNif() {
        return nif;
    }

    /**
     * Altera o número de identificação fiscal
     * @param nif número de identificação fiscal
     */
    public void setNif(int nif) {
        this.nif = nif;
    }

    /**
     * Devolve a morada do cliente
     * @return morada do cliente
     */
    public String getMorada() {
        return morada;
    }

    /**
     * Altera a morada do cliente
     * @param morada morada do cliente
     */
    public void setMorada(String morada) {
        this.morada = morada;
    }

    /**
     * Devolve o número da encomenda
     * @return número da encomenda
     */
    public int getNumeroEncomenda() {
        return numeroEncomenda;
    }

    /**
     * Devolve a data em que a encomenda foi feita
     * @return data da encomenda
     */
    public LocalDateTime getDataEncomenda() {
        return dataEncomenda;
    }

    /**
     * Altera a data em que a encomenda foi feita
     * @param dataEncomenda data da encomenda
     */
    public void setDataEncomenda(LocalDateTime dataEncomenda) {
        this.dataEncomenda = dataEncomenda;
    }

    /**
     * Devolve uma cópia dos produtos encomendados
     * @return cópia dos produtos encomendados
     */
    public List<LinhaEncomenda> getLinhasEncomenda() {
        return linhasEncomenda.stream()
                .map(LinhaEncomenda::clone)
                .collect(Collectors.toList());
    }

    /**
     * Altera os produtos encomendados
     * @param linhasEncomenda produtos encomendados
     */
    public void setLinhasEncomenda(List<LinhaEncomenda> linhasEncomenda) {
        this.linhasEncomenda = linhasEncomenda.stream()
                .map(LinhaEncomenda::clone)
                .collect(Collectors.toList());
    }

    /**
     * Determina o valor total da encomenda
     * @return valor total da encomenda
     */
    public double calculaValorTotal() {
        return linhasEncomenda.stream().mapToDouble(LinhaEncomenda::calculaValorLinhaEnc).sum();
    }

    /**
     * Determina o valor total dos descontos obtidos nos diversos produtos encomendados
     * @return valor total dos descontos
     */
    public double calculaValorDesconto() {
        return linhasEncomenda.stream().mapToDouble(LinhaEncomenda::calculaValorDesconto).sum();
    }

    /**
     * Determina o número total de produtos a receber
     * @return número total de produtos a receber
     */
    public int numeroTotalProdutos() {
        return linhasEncomenda.stream().mapToInt(LinhaEncomenda::getQuantidade).sum();
    }

    /**
     * Determina se um produto vai ser encomendado
     * @param refProduto referência do produto
     * @return {@code true} se foi encomendado, {@code false} caso contrário
     */
    public boolean existeProdutoEncomenda(String refProduto) {
        Iterator<LinhaEncomenda> iterator = linhasEncomenda.iterator();

        while (iterator.hasNext()) {
            if (iterator.next().getReferencia().equals(refProduto))
                return true;
        }

        return false;
    }

    /**
     * Adiciona uma nova linha de encomenda
     * @param linha LinhaEncomenda a adicionar
     */
    public void adicionaLinha(LinhaEncomenda linha) {
        linhasEncomenda.add(linha.clone());
    }

    /**
     * Remove uma linha de encomenda dado a referência do produto
     * @param codProd referência do produto
     */
    public void removeProduto(String codProd) {
        Iterator<LinhaEncomenda> iterator = linhasEncomenda.iterator();
        boolean found = false;

        while (iterator.hasNext() && !found) {
            if (iterator.next().getReferencia().equals(codProd)) {
                iterator.remove();
                found = true;
            }
        }
    }

    /**
     * Efetua uma cópia de uma EncEficiente
     * @return cópia de uma EncEficiente
     */
    @Override
    public EncEficiente clone() {
        return new EncEficiente(this);
    }

    /**
     * Devolve uma representação textual de uma EncEficiente
     * @return representação textual
     */
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        builder.append("Encomenda Eficiente: {");
        builder.append("cliente: ").append(cliente);
        builder.append(", NIF: ").append(nif);
        builder.append(", morada: ").append(morada);
        builder.append(", número encomenda: ").append(numeroEncomenda);
        builder.append(", data da encomenda: ").append(dataEncomenda.toString());
        builder.append(", linhas de encomenda: ");
        linhasEncomenda.forEach(l -> builder.append(l.toString()).append(" "));
        builder.append("}");

        return builder.toString();
    }

    /**
     * Compara um objeto a uma EncEficiente
     * @param obj objeto a comparar
     * @return {@code true} se forem iguais, {@code false} caso contrário
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (this.getClass() != obj.getClass()) return false;

        EncEficiente other = (EncEficiente) obj;
        return cliente.equals(other.cliente) && nif == other.nif
                && morada.equals(other.morada) && numeroEncomenda == other.numeroEncomenda
                && dataEncomenda.equals(other.dataEncomenda) && linhasEncomenda.equals(other.linhasEncomenda);
    }

}
