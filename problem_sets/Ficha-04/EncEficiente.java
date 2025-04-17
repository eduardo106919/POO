import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;
import java.util.List;



public class EncEficiente {

    /**
     * Variáveis de Instância
     */

    private static int nr_encomendas;

    private String cliente;
    private int NIF;
    private String morada;
    private int numero;
    private LocalDateTime data;
    private ArrayList<LinhaEncomenda> linhas;


    /**
     * Construtores
     */

    /**
     * Construtor por omissão de uma EncEficiente
     */
    public EncEficiente() {
        this.cliente = "";
        this.NIF = 0;
        this.morada = "";
        this.numero = EncEficiente.nr_encomendas++;
        this.data = LocalDateTime.now();
        this.linhas = new ArrayList<LinhaEncomenda>();
    }

    /**
     * Construtor parametrizado de uma EncEficiente
     *
     * @param cliente nome do cliente
     * @param NIF numero fiscal do cliente
     * @param morada morada do cliente
     * @param linhas colecao de linhas de encomenda
     */
    public EncEficiente(String cliente, int NIF, String morada, Collection<LinhaEncomenda> linhas) {
        this();
        this.cliente = cliente;
        this.NIF = NIF;
        this.morada = morada;
        this.linhas = linhas.stream().map(LinhaEncomenda::clone).collect(Collectors.toCollection(ArrayList::new));
    }

    /**
     * Construtor de cópia para uma EncEficiente
     *
     * @param outro EncEficiente a copiar
     */
    public EncEficiente(EncEficiente outro) {
        this.cliente = outro.cliente;
        this.NIF = outro.NIF;
        this.morada = outro.morada;
        this.numero = outro.numero;
        this.data = outro.data;
        this.linhas = outro.linhas.stream().map(LinhaEncomenda::clone).collect(Collectors.toCollection(ArrayList::new));
    }

    /**
     * Métodos de Instância
     */

    // getters
    
    /**
     * Devolve o numero de encomendas únicas
     *
     * @return numero de encomendas
     */
    public static int get_nr_encomendas() {
        return EncEficiente.nr_encomendas;
    }

    /**
     * Devolve o nome do cliente
     *
     * @return nome do cliente
     */
    public String get_cliente() {
        return this.cliente;
    }

    /**
     * Devolve o numero fiscal do cliente
     *
     * @return numero fiscal
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
     * Devolve o numero da encomenda
     *
     * @return numero da encomenda
     */
    public int get_numero() {
        return this.numero;
    }

    /**
     * Devolve a data da Encomenda
     *
     * @return data da Encomenda
     */
    public LocalDateTime get_data() {
        return this.data;
    }

    /**
     * Devolve as linhas de Encomenda
     *
     * @return linhas de encomenda
     */
    public List<LinhaEncomenda> get_linhas() {
        return this.linhas.stream().map(LinhaEncomenda::clone).collect(Collectors.toList());
    }

    // setters
 
    /**
     * Altera o nome do cliente
     *
     * @param cliente nome do cliente
     */
    public void set_cliente(String cliente) {
        this.cliente = cliente;
    }

    /**
     * Altera o numero fiscal do cliente
     *
     * @param NIF numero fiscal
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

    /**
     * Altera as linhas de encomenda
     *
     * @param linhas linhas de encomenda
     */
    public void set_linhas(Collection<LinhaEncomenda> linhas) {
        this.linhas = linhas.stream().map(LinhaEncomenda::clone).collect(Collectors.toCollection(ArrayList::new));
    }

    // métodos de utilidade

    /**
     * Compara um objeto a uma EncEficiente
     *
     * @param outro objeto a comparar
     * @return true se forem iguais
     */
    public boolean equals(Object outro) {
        if (this == outro)
            return true;
        if ((outro == null) || (this.getClass() != outro.getClass()))
            return false;
        EncEficiente temp = (EncEficiente) outro;
        return this.cliente.equals(temp.cliente) && this.NIF == temp.NIF
            && this.morada.equals(temp.morada) && this.numero == temp.numero
            && this.data.equals(temp.data) && this.linhas.equals(temp.linhas);
    }

    /**
     * Devolve uma representacao textual de uma EncEficiente
     *
     * @return representacao textual
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("Cliente: ").append(this.cliente);
        sb.append("NIF: ").append(this.NIF);
        sb.append("Morada: ").append(this.morada);
        sb.append("Numero: ").append(this.numero);
        sb.append("Data: ").append(this.data.toString());
        sb.append("Linhas de Encomenda:\n");
        this.linhas.forEach(l -> sb.append(l.toString()));

        return sb.toString();
    }

    /**
     * Cria uma cópia de uma EncEficiente
     *
     * @return cópia de uma EncEficiente
     */
    public EncEficiente clone() {
        return new EncEficiente(this);
    }

    // outros métodos

    /**
     * Método que determina o valor total da encomenda
     *
     * @return valor total
     */
    public double calculaValorTotal() {
        return this.linhas.stream().mapToDouble(LinhaEncomenda::calculaValorLinhaEnc).sum();
    }

    /**
     * Método que determina o valor total dos descontos obtidos nos diversos produtos encomendados
     *
     * @return valor total dos descontos
     */
    public double calculaValorDesconto() {
        return this.linhas.stream().mapToDouble(LinhaEncomenda::calculaValorDesconto).sum();
    }

    /**
     * Método que determina o número total de produtos a receber
     *
     * @return numero total de produtos a receber
     */
    public int numeroTotalProdutos() {
        return this.linhas.stream().mapToInt(LinhaEncomenda::getQuantidade).sum();
    }

    /**
     * Método que determina se um produto vai ser encomendado
     *
     * @param refProduto referencia do produto
     * @return true se o produto existir
     */
    public boolean existeProdutoEncomenda(String refProduto) {
        return this.linhas.stream().anyMatch(l -> l.getReferencia().equals(refProduto));
    }

    /**
     * Método que adiciona uma nova linha de encomenda
     *
     * @param linha linha de encomenda a adicionar
     */
    public void adicionaLinha(LinhaEncomenda linha) {
        this.linhas.add(linha.clone());
    }

    /**
     * Método que remove uma linha de encomenda dado a referência do produto
     *
     * @param codProd referencia do produto
     */
    public void removeProduto(String codProd) {
        this.linhas.removeIf(l -> l.getReferencia().equals(codProd));
    }
}
