
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class GestaoEncomendas {

    /**
     * Variávies de Instância
     */

    private HashMap<Integer, Encomenda> encomendas;


    /**
     * Construtores
     */

    /**
     * Construtor por omissão de um Gestor de Encomendas
     */
    public GestaoEncomendas() {
        this.encomendas = new HashMap<>();
    }

    /**
     * Construtor parametrizado de um Gestor de Encomendas
     *
     * @param encomendas colecao de encomendas
     */
    public GestaoEncomendas(Collection<Encomenda> encomendas) {
        this();
        encomendas.forEach(e -> this.encomendas.put(e.getCodigo(), e.clone()));
    }

    /**
     * Construtor de cópia de um Gestor de Encomendas
     *
     * @param outro Gestor de encomendas a copiar
     */
    public GestaoEncomendas(GestaoEncomendas outro) {
        this();
        outro.encomendas.values().forEach(e -> this.encomendas.put(e.getCodigo(), e.clone()));
    }


    /**
     * Métodos de Instância
     */

    // getters

    /**
     * Devolve as encomendas guardadas
     *
     * @return Lista de encomendas
     */
    public List<Encomenda> getEncomendas() {
        return this.encomendas.values().stream().map(Encomenda::clone).collect(Collectors.toList());
    }

    // setters

    /**
     * Altera as encomendas guardadas
     *
     * @param encomendas colecao de encomendas
     */
    public void setEncomendas(Collection<Encomenda> encomendas) {
        this.encomendas.clear();
        encomendas.forEach(e -> this.encomendas.put(e.getCodigo(), e.clone()));
    }

    // métodos de utilidade

    /**
     * Compara um objeto ao Gestor de Encomendas que recebe a mensagem
     *
     * @param outro objeto a comparar
     * @return true se forem iguais
     */
    public boolean equals(Object outro) {
        if (this == outro)
            return true;
        if ((outro == null) || (this.getClass() != outro.getClass()))
            return false;
        GestaoEncomendas temp = (GestaoEncomendas) outro;
        return this.encomendas.equals(((GestaoEncomendas) outro).encomendas);
    }

    /**
     * Devolve uma representacao textual de um Gestor de Encomendas
     *
     * @return representacao textual
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();

        this.encomendas.values().forEach(e -> sb.append(e.toString()));

        return sb.toString();
    }

    /**
     * Devolve uma cópia de um Gestor de Encomendas
     *
     * @return cópia de um Gestor
     */
    public GestaoEncomendas clone() {
        return new GestaoEncomendas(this);
    }

    // outros métodos

    /**
     * Método que determina os códigos de encomenda existentes
     *
     * @return conjunto de códigos
     */
    public Set<Integer> todosCodigosEnc() {
        return this.encomendas.keySet();
    }

    /**
     * Método que adiciona mais uma encomenda ao sistema
     *
     * @param enc Encomenda a adicionar
     */
    public void addEncomenda(Encomenda enc) {
        this.encomendas.put(enc.getCodigo(), enc.clone());
    }

    /**
     * Método que dado um código de encomenda devolve a informação respectiva
     *
     * @param codEnc código da Encomenda
     * @return Instância da Encomenda
     */
    public Encomenda getEncomenda(Integer codEnc) {
        Encomenda temp = this.encomendas.get(codEnc);
        if (temp != null) {
            return temp.clone();
        }
        return null;
    }

    /**
     * Método que remove uma encomenda dado o seu código
     *
     * @param codEnc código da Encomenda
     */
    public void removeEncomenda(Integer codEnc) {
        this.encomendas.remove(codEnc);
    }

    /**
     * Método que determina a encomenda (identificada pelo código) com mais produtos encomendados
     *
     * @return código da Encomenda com mais produtos
     */
    public Integer encomendaComMaisProdutos() {
        Comparator<Encomenda> comp = (e1, e2) -> Integer.compare(e1.numProdutos(), e2.numProdutos());
        Optional<Encomenda> temp = this.encomendas.values().stream().max(comp);
        if (temp.isPresent()) {
            return temp.get().getCodigo();
        }
        return null;
    }

    /**
     * Método que determina todas as encomendas em que um determinado produto,
     * identificado pelo código, está presente
     *
     * @param codProd código do Produto
     * @return Conjunto de código de encomendas
     */
    public Set<Integer> encomendasComProduto(String codProd) {
        return this.encomendas.values().stream()
                .filter(e -> e.existeNaEncomenda(codProd))
                .map(Encomenda::getCodigo)
                .collect(Collectors.toSet());
    }

    /**
     * Método que determina todas as encomendas com data posterior
     * a uma data fornecida como parâmetro
     *
     * @param d data de referencia
     * @return conjunto de códigos de encomendas
     */
    public Set<Integer> encomendasAposData(LocalDate d) {
        return this.encomendas.values().stream()
                .filter(e -> e.getData().isAfter(d))
                .map(Encomenda::getCodigo)
                .collect(Collectors.toSet());
    }

    /**
     * método que determina a encomenda de maior valor
     *
     * @return Encomenda de maior valor
     */
    public Encomenda encomendaMaiorValor() {
        Comparator<Encomenda> comp = (e1, e2) -> Double.compare(e1.calculaValorTotal(), e2.calculaValorTotal());
        Optional<Encomenda> temp = this.encomendas.values().stream().max(comp);
        if (temp.isPresent()) {
            return temp.get().clone();
        }
        return null;
    }

    /**
     * Método que determina uma ordenação das encomendas por
     * quantidade crescente de produtos por encomenda
     *
     * @return conjunto de encomendas
     */
    public Set<Encomenda> encomendasOrdenadasPorQtProdutos() {
        Comparator<Encomenda> comp = (e1, e2) -> Integer.compare(e1.numProdutos(), e2.numProdutos());
        return this.encomendas.values().stream()
                .map(Encomenda::clone)
                .collect(Collectors.toCollection(() -> new TreeSet<>(comp)));
    }

    /**
     * Método que devolve uma ordenação, por ordem decrescente
     * de valor de encomenda, de todas as encomendas do sistema
     *
     * @return conjunto de encomendas
     */
    public Set<Encomenda> encomendasValorDecrescente() {
        Comparator<Encomenda> comp = (e1, e2) -> Double.compare(e2.calculaValorTotal(), e1.calculaValorTotal());
        return this.encomendas.values().stream()
                .map(Encomenda::clone)
                .collect(Collectors.toCollection(() -> new TreeSet<>(comp)));
    }

    /**
     * Método que calcula um map em que associa cada código de
     * produto à lista das encomendas em que foi referida
     *
     * @return
     */
    // TODO
    public Map<String,List<Integer>> encomendasDeProduto() {
        return null;
    }
}
