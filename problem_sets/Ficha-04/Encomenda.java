
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;


/**
 * Class to represent an Order
 */
public class Encomenda {

    /**
     * Instance Variables
     */

    private String nome_cliente;
    private int NIF_cliente;
    private String morada_cliente;

    private static int total_encomendas = 0;
    private int numero_encomenda;

    private LocalDate data_encomenda;

    private ArrayList<LinhaEncomenda> linhas_encomendas;


    /**
     * Constructors
     */

    /**
     * Inicializa uma Encomenda vazia
     */
    public Encomenda() {
        this.nome_cliente = "n/a";
        this.NIF_cliente = -1;
        this.morada_cliente = "n/a";

        this.numero_encomenda = Encomenda.total_encomendas++;
        this.data_encomenda = LocalDate.now();

        this.linhas_encomendas = new ArrayList<LinhaEncomenda>();
    }

    /**
     * Inicializa uma Encomenda com parâmetros
     *
     * @param cliente nome do cliente
     * @param NIF número fiscal do cliente
     * @param morada morada do cliente
     */
    public Encomenda(String cliente, int NIF, String morada) {
        this.nome_cliente = cliente;
        this.NIF_cliente = NIF;
        this.morada_cliente = morada;

        this.numero_encomenda = Encomenda.total_encomendas++;
        this.data_encomenda = LocalDate.now();
        this.linhas_encomendas = new ArrayList<LinhaEncomenda>();
    }

    /**
     * Constructor de cópia de uma Encomenda
     *
     * @param outro outra encomenda
     */
    public Encomenda(Encomenda outro) {
        this.nome_cliente = outro.nome_cliente;
        this.NIF_cliente = outro.NIF_cliente;
        this.morada_cliente = outro.morada_cliente;
    
        this.numero_encomenda = outro.numero_encomenda;
        this.data_encomenda = outro.data_encomenda;

        this.linhas_encomendas = new ArrayList<LinhaEncomenda>(outro.linhas_encomendas.size());

        // fazer clone de todas as Linhas de encomenda
        Iterator<LinhaEncomenda> iterator = outro.linhas_encomendas.iterator();
        while (iterator.hasNext()) {
            this.linhas_encomendas.add(iterator.next().clone());
        }
    }

    /**
     * Instance Methods
     */

    // getters

    /**
     * Devolve o nome do cliente que efetuou a encomenda
     *
     * @return string com o nome do cliente
     */
    public String get_nome_cliente() {
        return this.nome_cliente;
    }

    /**
     * Devolve o número fiscal do cliente
     *
     * @return interger com o NIF do cliente
     */
    public int get_NIF_cliente() {
        return this.NIF_cliente;
    }

    /**
     * Devolve a morada do cliente que efetuou a encomenda
     *
     * @return String com a morada do cliente
     */
    public String get_morada_cliente() {
        return this.morada_cliente;
    }

    /**
     * Devolve o número da encomenda (valor único)
     *
     * @return número da encomenda
     */
    public int get_numero_encomenda() {
        return this.numero_encomenda;
    }

    /**
     * Devolve a data na qual a encomenda foi efetuada
     *
     * @return data da encomenda
     */
    public LocalDate get_data_encomenda() {
        return this.data_encomenda;
    }

    /**
     * Devolve a lista de linha de encomendas
     *
     * @return lista de linha de encomendas
     */
    public ArrayList<LinhaEncomenda> get_linha_encomendas() {
        ArrayList<LinhaEncomenda> result = new ArrayList<LinhaEncomenda>(this.linhas_encomendas.size());

        Iterator<LinhaEncomenda> iterator = this.linhas_encomendas.iterator();
        while (iterator.hasNext()) {
            result.add(iterator.next().clone());
        }

        return result;
    }

    // setters

    /**
     * Altera o nome do cliente que efetuou a encomenda
     *
     * @param nome nome do novo cliente
     */
    public void set_nome_cliente(String nome) {
        this.nome_cliente = nome;
    }

    /**
     * Altera o NIF do cliente que efetuou a encomenda
     *
     * @param NIF número fiscal do cliente
     */
    public void set_NIF_cliente(int NIF) {
        this.NIF_cliente = NIF;
    }

    /**
     * Altera a morada do cliente que efetuou a encomenda
     *
     * @param morada morada do cliente
     */
    public void set_morada_cliente(String morada) {
        this.morada_cliente = morada;
    }

    // other methods

    /**
     * Determina o valor total da encomenda
     *
     * @return valor total da encomenda
     */
    public double valor_total() {
        double valor = 0;
        for (LinhaEncomenda item : this.linhas_encomendas) {
            valor += item.calculaValorLinhaEnc();
        }

        return valor;
    }

    /**
     * Determina o valor descontado por todos os produtos
     *
     * @return valor descontado
     */
    public double valor_descontors() {
        double valor = 0;
        for (LinhaEncomenda item : this.linhas_encomendas) {
            valor += item.calculaValorDesconto();
        }

        return valor;
    }

    /**
     * Determina o número total de produtos a encomendar
     *
     * @return número total de produtos
     */
    public int total_produtos() {
        int valor = 0;
        for (LinhaEncomenda item : this.linhas_encomendas) {
            valor += item.getQuantidade();
        }

        return valor;
    }

    /**
     * Verifica se um certo produto vai ser encomendado
     *
     * @param referencia referencia do produto
     * @return true se o produto for encomendado
     */
    public boolean existe_produto(String referencia) {
        boolean existe = false;

        Iterator<LinhaEncomenda> iterator = this.linhas_encomendas.iterator();
        while (existe == false && iterator.hasNext()) {
            existe = iterator.next().getReferencia().equals(referencia);
        }

        return existe;
    }

    /**
     * Adiciona uma linha de encomenda à encomenda
     *
     * @param linha linha de encomenda a adicionar
     */
    public void adiciona_linha(LinhaEncomenda linha) {
        if (linha != null) {
            this.linhas_encomendas.add(linha.clone());
        }
    }

    /**
     * Remove a linha de encomenda com a referencia do produto
     *
     * @param referencia código do produto
     */
    public void remove_produto(String referencia) {
        this.linhas_encomendas.removeIf(linha -> linha.getReferencia() == referencia);
    }

    /**
     * Efetua o clone da Encomenda
     *
     * @return Encomenda clonada
     */
    public Encomenda clone() {
        return new Encomenda(this);
    }

    /**
     * Verifica se outro é igual ao objeto que chama
     *
     * @param outro objeto a comparar
     * @return true se os objetos forem iguais
     */
    public boolean equals(Object outro) {
        if (this == outro)
            return true;
        if (outro == null || this.getClass() != outro.getClass())
            return false;
        Encomenda temp = (Encomenda) outro;
        return this.nome_cliente.equals(temp.nome_cliente) && this.morada_cliente.equals(temp.morada_cliente)
            && this.NIF_cliente == temp.NIF_cliente && this.numero_encomenda == temp.numero_encomenda
            && this.data_encomenda.equals(temp.data_encomenda) && this.linhas_encomendas.equals(temp.linhas_encomendas);
    }

    /**
     * Transforma uma Encomenda numa String
     *
     * @return string com a informacao de uma Encomenda
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Encomenda:");
        sb.append("Cliente: ").append(this.nome_cliente);
        sb.append("NIF: ").append(this.NIF_cliente);
        sb.append("Morada: ").append(this.morada_cliente);
        sb.append("Número Encomenda: ").append(this.numero_encomenda);
        sb.append("Data: ").append(this.data_encomenda);
        sb.append("Linhas: ").append(this.linhas_encomendas.toString());

        return sb.toString();
    }
}
