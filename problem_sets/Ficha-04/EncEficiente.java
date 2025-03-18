import java.time.LocalDate;
import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.List;

/**
 * Encomenda Eficiente
 */
public class EncEficiente {

    /**
     * Variáveis de Instância
     */

    private String cliente;
    private int NIF;
    private String morada;
    private int numero_encomenda;
    private LocalDate data;
    private ArrayList<LinhaEncomenda> linhas_encomenda;

    private static int identificadores_encomenda = 0;

    /**
     * Construtores
     */

    /**
     * Construtor por omissão de uma Encomenda Eficiente
     */
    public EncEficiente() {
        this.cliente = "n/a";
        this.NIF = -1;
        this.morada = "n/a";
        this.numero_encomenda = EncEficiente.identificadores_encomenda++;
        this.data = LocalDate.now();
        this.linhas_encomenda = new ArrayList<LinhaEncomenda>();
    }

    /**
     * Construtor parametrizado de uma Encomenda Eficiente
     *
     * @param cliente nome do cliente
     * @param NIF numero fiscal do cliente
     * @param morada morada do cliente
     */
    public EncEficiente(String cliente, int NIF, String morada) {
        this.cliente = cliente;
        this.NIF = NIF;
        this.morada = morada;
        this.numero_encomenda = EncEficiente.identificadores_encomenda++;
        this.data = LocalDate.now();
        this.linhas_encomenda = new ArrayList<LinhaEncomenda>();
    }

    /**
     * Construtor de cópia de uma Encomenda Eficiente
     *
     * @param outro encomenda a copiar
     */
    public EncEficiente(EncEficiente outro) {
        if (outro != null) {
            this.cliente = outro.cliente;
            this.NIF = outro.NIF;
            this.morada = outro.morada;
            this.numero_encomenda  = outro.numero_encomenda;
            this.data = outro.data;
            this.linhas_encomenda = new ArrayList<LinhaEncomenda>(outro.linhas_encomenda.stream()
                                         .map(LinhaEncomenda::clone)
                                         .collect(Collectors.toList()));
        }
    }

    /**
     * Métodos de Instância
     */

    // getters
    
    /**
     * Devolve o número total de encomendas
     *
     * @return número de encomendas
     */
    public static int get_identificadores_encomenda() {
        return EncEficiente.identificadores_encomenda;
    }

    /**
     * Devolve o nome do cliente que efetuou a encomenda
     *
     * @return nome do cliente
     */
    public String get_cliente() {
        return this.cliente;
    }

    /**
     * Devolve o número fiscal do cliente
     *
     * @return número fiscal
     */
    public int get_NIF() {
        return this.NIF;
    }

    /**
     * Devolve a morada do cliente
     *
     * @return morada do cliente
     */
    public String get_morada() {
        return this.morada;
    }

    /**
     * Devolve o identificador da encomenda
     *
     * @return numero de encomenda
     */
    public int get_numero_encomenda() {
        return this.numero_encomenda;
    }

    /**
     * Devolve a data na qual a encomenda foi feita
     *
     * @return data de realização da encomenda
     */
    public LocalDate get_data() {
        return this.data;
    }

    /**
     * Devolve a lista de Linhas de Encomendas
     *
     * @return lista de linhas  de encomendas
     */
    public List<LinhaEncomenda> get_linhas_encomenda() {
        return this.linhas_encomenda.stream().map(LinhaEncomenda::clone).collect(Collectors.toList());
    }

    // setters
 
    /**
     * Altera o nome do cliente que efetuou a encomenda
     *
     * @param cliente nome do cliente
     */
    public void set_cliente(String cliente) {
        this.cliente = cliente;
    }

    /**
     * Altera o NIF do cliente
     *
     * @param NIF número fiscal do cliente
     */
    public void set_NIF(int NIF) {
        this.NIF = NIF;
    }

    /**
     * Altera a morada do cliente
     *
     * @param morada morada do cliente
     */
    public void set_morada(String morada) {
        this.morada = morada;
    }

    // outros métodos

    /**
     * Determina o valor total da encomenda
     *
     * @return valor total
     */
    public double calcula_valor_total() {
        return this.linhas_encomenda.stream().mapToDouble(LinhaEncomenda::calculaValorLinhaEnc).sum();
    }

    /**
     * Determina o valor total dos descontos obtidos
     *
     * @return valor total dos descontos
     */
    public double calcula_valor_desconto() {
        return this.linhas_encomenda.stream().mapToDouble(LinhaEncomenda::calculaValorDesconto).sum();
    }

    /**
     * Determina o número total de produtos a receber
     *
     * @return número de produtos a receber
     */
    public int numero_total_produtos() {
        return this.linhas_encomenda.stream().mapToInt(LinhaEncomenda::getQuantidade).sum();
    }

    /**
     * Verifica se existe algum produto com a referencia a ser encomendado
     *
     * @param referencia identificador do produto
     * @return true se o produto existir
     */
    public boolean existe_produto(String referencia) {
        return this.linhas_encomenda.stream().anyMatch(l -> l.getReferencia().equals(referencia));
    }

    /**
     * Adiciona uma linha de encomenda à encomenda
     *
     * @param linha linha de encomenda a adicionar
     */
    public void adiciona_linha(LinhaEncomenda linha) {
        if (linha != null) {
            this.linhas_encomenda.add(linha.clone());
        }
    }

    /**
     * Remove o produto selecionado
     *
     * @param referencia código do produto a remover
     */
    public void remove_produto(String referencia) {
        this.linhas_encomenda.removeIf(l -> l.getReferencia().equals(referencia));
    }

    /**
     * Compara o objeto chamador a outro
     *
     * @param outro objeto a comparar
     * @return true se forem iguais
     */
    public boolean equals(Object outro) {
        if (outro == this)
            return true;
        if (outro == null || this.getClass() != outro.getClass())
            return false;
        EncEficiente temp = (EncEficiente) outro;
        return this.cliente.equals(temp.cliente) && this.NIF == temp.NIF
            && this.morada.equals(temp.morada) && this.data.equals(temp.data)
            && this.numero_encomenda == temp.numero_encomenda
            && this.linhas_encomenda.equals(temp.linhas_encomenda);
    }

    /**
     * Transforma uma Encomenda Eficiente numa string
     *
     * @return string com a informação de uma encomenda eficiente
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("cliente: ").append(this.cliente);
        sb.append("\nNIF: ").append(this.NIF);
        sb.append("\nmorada: ").append(this.morada);
        sb.append("\nnumero: ").append(this.numero_encomenda);
        sb.append("\ndata: ").append(this.data);
        sb.append("\nlinhas: ").append(this.linhas_encomenda.toString());

        return sb.toString();
    }

    /**
     * Clona uma Encomenda Eficiente
     *
     * @return encomenda clonada
     */
    public EncEficiente clone() {
        return new EncEficiente(this);
    }
}
