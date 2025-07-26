

import java.awt.List;
import java.time.LocalDateTime;
import java.util.Arrays;


public class Encomenda {

    /**
     * Variáveis de Instância
     */

    private static int nr_encomendas = 0;

    private String cliente;
    private int NIF;
    private String morada;
    private int numero;
    private LocalDateTime data;
    private LinhaEncomenda[] linhas;
    private int nr_linhas;


    /**
     * Construtores
     */

    /**
     * Construtor por omissão de uma Encomenda
     */
    public Encomenda() {
        this.cliente = "";
        this.NIF = 0;
        this.morada = "";
        this.numero = Encomenda.nr_encomendas++;
        this.data = LocalDateTime.now();
        this.linhas = new LinhaEncomenda[10];
    }

    /**
     * Construtor parametrizado de uma Encomenda
     *
     * @param cliente nome do cliente
     * @param NIF contribuinte do cliente
     * @param morada morada do cliente
     * @param linhas linhas de encomenda
     */
    public Encomenda(String cliente, int NIF, String morada, LinhaEncomenda[] linhas) {
        this();
        this.cliente = cliente;
        this.NIF = NIF;
        this.morada = morada;
        this.linhas = new LinhaEncomenda[linhas.length * 2];
        for (int i = 0; i < linhas.length; i++) {
            this.linhas[i] = linhas[i].clone();
        }
        this.nr_linhas = linhas.length;
    }

    /**
     * Construtor de cópia de uma Encomenda
     * 
     * @param outro Encomenda a copiar
     */
    public Encomenda(Encomenda outro) {
        this.cliente = outro.cliente;
        this.NIF = outro.NIF;
        this.morada = outro.morada;
        this.numero = outro.numero;
        this.data = outro.data;
        this.linhas = new LinhaEncomenda[outro.linhas.length];
        for (int i = 0; i < outro.nr_linhas; i++) {
            this.linhas[i] = outro.linhas[i].clone();
        }
        this.nr_linhas = outro.nr_linhas;
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
        return Encomenda.nr_encomendas;
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
    public LinhaEncomenda[] get_linhas() {
        LinhaEncomenda[] res = new LinhaEncomenda[this.nr_linhas];
        for (int i = 0; i < this.nr_linhas; i++) {
            res[i] = this.linhas[i].clone();
        }
        return res;
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
    public void set_linhas(LinhaEncomenda[] linhas) {
        this.linhas = new LinhaEncomenda[linhas.length * 2];
        for (int i = 0; i < linhas.length; i++) {
            this.linhas[i] = linhas[i].clone();
        }
        this.nr_linhas = linhas.length;
    }

    // métodos de utilidade

    /**
     * Compara um objeto a uma Encomenda
     *
     * @param outro objeto a comparar
     * @return true se forem iguais
     */
    public boolean equals(Object outro) {
        if (this == outro)
            return true;
        if ((outro == null) || (this.getClass() != outro.getClass()))
            return false;
        Encomenda temp = (Encomenda) outro;
        return this.cliente.equals(temp.cliente) && this.NIF == temp.NIF
            && this.morada.equals(temp.morada) && this.numero == temp.numero
            && this.data.equals(temp.data) && this.nr_linhas == temp.nr_linhas
            && Arrays.equals(this.linhas, temp.linhas);
    }

    /**
     * Devolve uma representacao textual de uma Encomenda
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
        for (int i = 0; i < this.nr_linhas; i++) {
            sb.append(this.linhas[i].toString());
        }

        return sb.toString();
    }

    /**
     * Cria uma cópia de uma Encomenda
     *
     * @return cópia de uma Encomenda
     */
    public Encomenda clone() {
        return new Encomenda(this);
    }

    // outros métodos

    /**
     * Método que determina o valor total da encomenda
     *
     * @return valor total da Encomenda
     */
    public double calculaValorTotal() {
        double total = 0;
        for (int i = 0; i < this.nr_linhas; i++) {
            total += this.linhas[i].calculaValorLinhaEnc();
        }

        return total;
    }

    /**
     * Método que determina o valor total dos descontos obtidos nos diversos produtos encomendados
     *
     * @return valor total dos descontos
     */
    public double calculaValorDesconto() {
        double total = 0;
        for (int i = 0; i < this.nr_linhas; i++) {
            total += this.linhas[i].calculaValorDesconto();
        }

        return total;
    }

    /**
     * Método que determina o número total de produtos a receber
     *
     * @return numero total de produtos a receber
     */
    public int numeroTotalProdutos() {
        int total = 0;
        for (int i = 0; i < this.nr_linhas; i++) {
            total += this.linhas[i].get_quantidade();
        }

        return total;
    }

    /**
     * Método que determina se um produto vai ser encomendado
     *
     * @param refProduto referencia do produto
     * @return true se o produto existir
     */
    public boolean existeProdutoEncomenda(String refProduto) {
        for (int i = 0; i < this.nr_linhas; i++) {
            if (this.linhas[i].get_referencia().equals(refProduto)) {
                return true;
            }
        }

        return false;
    }

    /**
     * Método que adiciona uma nova linha de encomenda
     *
     * @param linha linha a adicionar
     */
    public void adicionaLinha(LinhaEncomenda linha) {
        // array cheio
        if (this.nr_linhas == this.linhas.length) {
            LinhaEncomenda[] temp = new LinhaEncomenda[this.nr_linhas * 2];

            for (int i = 0; i < this.nr_linhas; i++) {
                temp[i] = this.linhas[i];
            }

            this.linhas = temp;
        }

        this.linhas[this.nr_linhas] = linha.clone();
        this.nr_linhas++;
    }

    /**
     * Método que remove uma linha de encomenda dado a referência do produto
     *
     * @param codProduto referencia do produto
     */
    public void removeProduto(String codProd) {
        int index = 0;
        for (index = 0; index < this.nr_linhas && this.linhas[index].get_referencia().equals(codProd) == false; index++);

        // encontrou o produto
        if (index < this.nr_linhas) {
            for (int i = index + 1; i < this.nr_linhas; i++) {
                this.linhas[i - 1] = this.linhas[i];
            }

            this.nr_linhas--;
        }
    }
}
