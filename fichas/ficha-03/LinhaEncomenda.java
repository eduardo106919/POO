





public class LinhaEncomenda {

    /**
     * Variáveis de Instância
     */

    private String referencia;
    private String descricao;
    private double preco;
    private int quantidade;
    private double imposto;
    private double desconto;

    /**
     * Construtores
     */

    /**
     * Construtor por omissão de uma LinhaEncomenda
     */
    public LinhaEncomenda() {
        this.referencia = "";
        this.descricao = "";
        this.preco = 10;
        this.quantidade = 1;
        this.imposto = 0.1;
        this.desconto = 0.1;
    }

    /**
     * Construtor parametrizado de uma LinhaEncomenda
     *
     * @param referencia referencia do produto
     * @param descricao descricao do produto
     * @param preco preco do produto antes dos impostos
     * @param quantidade quantidade encomendada
     * @param imposto regime de impostos que se aplica ao produto
     * @param desconto valor do desconto comercial
     */
    public LinhaEncomenda(String referencia, String descricao, double preco, int quantidade, double imposto, double desconto) {
        this.referencia = referencia;
        this.descricao = descricao;
        this.preco = preco;
        this.quantidade = quantidade;
        this.imposto = imposto;
        this.desconto = desconto;
    }
    
    /**
     * Construtor de cópia de uma LinhaEncomenda
     *
     * @param outro LinhaEncomenda a copiar
     */
    public LinhaEncomenda(LinhaEncomenda outro) {
        this.referencia = outro.referencia;
        this.descricao = outro.descricao;
        this.preco = outro.preco;
        this.quantidade = outro.quantidade;
        this.imposto = outro.imposto;
        this.desconto = outro.desconto;
    }


    /**
     * Métodos de Instância
     */

    // getters
    
    /**
     * Devolve a referencia do produto
     *
     * @return referencia do produto
     */
    public String get_referencia() {
        return this.referencia;
    }

    /**
     * Devolve a descricao do produto
     *
     * @return descricao do produto
     */
    public String get_descricao() {
        return this.descricao;
    }

    /**
     * Devolve o preco do produto, antes dos impostos
     *
     * @return preco do produto
     */
    public double get_preco() {
        return this.preco;
    }

    /**
     * Devolve a quantidade a ser encomendada
     *
     * @return quantidade de produto
     */
    public int get_quantidade() {
        return this.quantidade;
    }

    /**
     * Devolve o regime de impostos
     *
     * @return regime de impostos
     */
    public double get_imposto() {
        return this.imposto;
    }

    /**
     * Devolve o desconto comercial do produto
     *
     * @return desconto comercial
     */
    public double get_desconto() {
        return this.desconto;
    }

    // setters
    
    /**
     * Altera a referencia do produto
     *
     * @param referencia referencia do produto
     */
    public void set_referencia(String referencia) {
        this.referencia = referencia;
    }

    /**
     * Altera a descricao do produto
     *
     * @param descricao descricao do produto
     */
    public void set_descricao(String descricao) {
        this.descricao = descricao;
    }

    /**
     * Altera o preco do produto
     *
     * @param preco preco do produto
     */
    public void set_preco(double preco) {
        this.preco = preco;
    }

    /**
     * Altera a quantidade de produto a encomendar
     *
     * @param quantidade quantidade a encomendar
     */
    public void set_quantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    /**
     * Altera o imposto aplicado ao produto
     *
     * @param imposto regime de imposto
     */
    public void set_imposto(double imposto) {
        this.imposto = imposto;
    }

    /**
     * Altera o desconto aplicado ao produto
     *
     * @param desconto desconto comercial
     */
    public void set_desconto(double desconto) {
        this.desconto = desconto;
    }

    // métodos de utilidade
 
    /**
     * Compara um objeto a uma LinhaEncomenda
     *
     * @param outro objeto a comparar
     * @return true se forem iguais
     */
    public boolean equals(Object outro) {
        if (this == outro)
            return true;
        if ((outro == null) || (this.getClass() != outro.getClass()))
            return false;
        LinhaEncomenda temp = (LinhaEncomenda) outro;
        return this.referencia.equals(temp.referencia) && this.descricao.equals(temp.descricao)
            && this.preco == temp.preco && this.quantidade == temp.quantidade
            && this.imposto == temp.imposto && this.desconto == temp.desconto;
    }

    /**
     * Devolve uma representacao textual de uma LinhaEncomenda
     *
     * @return representacao textual
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("Referencia: ").append(this.referencia);
        sb.append("\nDescricao: ").append(this.descricao);
        sb.append("\nPreco: ").append(this.preco);
        sb.append("\nQuantidade: ").append(this.quantidade);
        sb.append("\nImposto: ").append(this.imposto);
        sb.append("\nDesconto: ").append(this.desconto);

        return sb.toString();
    }

    /**
     * Cria uma cópia de uma LinhaEncomenda
     *
     * @return copia de LinhaEncomenda
     */
    public LinhaEncomenda clone() {
        return new LinhaEncomenda(this);
    }

    // outros métodos

    /**
     * Método que determina o valor da venda já considerados os impostos e os descontos
     *
     * @return valor da LinhaEncomenda
     */
    public double calculaValorLinhaEnc() {
        return this.preco - this.calculaValorDesconto() + (this.preco * this.imposto);
    }

    /**
     * Método que determina o valor numérico (em euros) do desconto
     *
     * @return valor do desconto
     */
    public double calculaValorDesconto() {
        return this.preco * this.desconto;
    }
}
