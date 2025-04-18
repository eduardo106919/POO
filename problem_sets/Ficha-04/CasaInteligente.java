
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.Collection;
import java.util.stream.Collectors;



public class CasaInteligente {

    /**
     * Variáveis de Instância
     */

    private ArrayList<Lampada> lampadas;


    /**
     * Construtores
     */

    /**
     * Construtor por omissão de uma CasaInteligente
     */
    public CasaInteligente() {
        this.lampadas = new ArrayList<Lampada>();
    }

    /**
     * Construtor parametrizado de uma CasaInteligente
     *
     * @param lampadas colecao de Lampadas
     */
    public CasaInteligente(Collection<Lampada> lampadas) {
        this.lampadas = lampadas.stream().map(Lampada::clone).collect(Collectors.toCollection(ArrayList::new));
    }

    /**
     * Construtor de cópia de uma CasaInteligente
     *
     * @param outro CasaInteligente a copiar
     */
    public CasaInteligente(CasaInteligente outro) {
        this.lampadas = outro.lampadas.stream().map(Lampada::clone).collect(Collectors.toCollection(ArrayList::new));
    }


    /**
     * Métodos de Instância
     */

    // getters
    
    /**
     * Devolve as Lampadas da CasaInteligente
     *
     * @return lista de lampadas
     */
    public List<Lampada> get_lampadas() {
        return this.lampadas.stream().map(Lampada::clone).collect(Collectors.toList());
    }

    // setters
    
    /**
     * Altera as lampadas da CasaInteligente
     *
     * @param lampadas colecao de lampadas
     */
    public void set_lampadas(Collection<Lampada> lampadas) {
        this.lampadas = lampadas.stream().map(Lampada::clone).collect(Collectors.toCollection(ArrayList::new));
    }

    // métodos de utilidade

    /**
     * Compara um objecto a um CasaInteligente
     *
     * @param outro objeto a comparar
     * @return true se forem iguais
     */
    @Override
    public boolean equals(Object outro) {
        if (this == outro)
            return true;
        if ((outro == null) || (this.getClass() != outro.getClass()))
            return false;
        CasaInteligente temp = (CasaInteligente) outro;
        return this.lampadas.equals(temp.lampadas);
    }

    /**
     * Devolve uma representacao textual de uma CasaInteligente
     *
     * @return representacao textual
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        this.lampadas.forEach(l -> sb.append(l.toString()));

        return sb.toString();
    }

    /**
     * Cria uma cópia de uma CasaInteligente
     *
     * @return cópia de uma CasaInteligente
     */
    @Override
    public CasaInteligente clone() {
        return new CasaInteligente(this);
    }

    // outros métodos
    
    /**
     * Adiciona uma lampada à CasaInteligente
     *
     * @param l lampada a adicionar
     */
    public void addLampada(Lampada l) {
        this.lampadas.add(l.clone());
    }

    /**
     * Liga no modo de consumo máximo a lâmpada que está na posição indicada
     *
     * @param index posicao da Lampada
     */
    public void ligaLampadaNormal(int index) {
        Lampada temp = this.lampadas.get(index);
        if (temp != null) {
            temp.lampON();
        }
    }

    /**
     * Liga no modo de consumo económico a lâmpada que está na posição indicada
     *
     * @param index posicao da Lampada
     */
    public void ligaLampadaEco(int index) {
        Lampada temp = this.lampadas.get(index);
        if (temp != null) {
            temp.lampECO();
        }
    }

    /**
     * Determina quantas lâmpadas é que estão ligadas em modo económico
     *
     * @return numero de lampadas no modo economico
     */
    public int qtEmEco() {
        return (int) this.lampadas.stream().filter(l -> l.getModo() == Modo.ECO).count();
    }

    /**
     * Remove a lâmpada da posição passada como parâmetro
     *
     * @param index posicao da Lampada
     */
    public void removeLampada(int index) {
        this.lampadas.remove(index);
    }

    /**
     * Liga todas as lâmpadas da casa em modo Eco
     */
    public void ligaTodasEco() {
        this.lampadas.forEach(Lampada::lampECO);
    }

    /**
     * Liga todas as lâmpadas da casa em modo de consumo máximo
     */
    public void ligaTodasMax() {
        this.lampadas.forEach(Lampada::lampON);
    }

    /**
     * Determina o consumo total da casa
     *
     * @return consumo total
     */
    public double consumoTotal() {
        return this.lampadas.stream().mapToDouble(Lampada::totalConsumo).sum();
    }

    /**
     * Determina a lâmpada que mais consumiu até à data
     *
     * @return Lampada mais gastadora
     */
    public Lampada maisGastadora() {
        return this.lampadas.stream()
                            .sorted((l1, l2) -> Double.compare(l2.totalConsumo(), l1.totalConsumo())) // inverter argumentos
                            .findFirst()
                            .orElse(null);
    }

    /**
     * Devolve um conjunto com todas as lâmpadas que se encontram em modo económico
     *
     * @return conjunto de Lampadas
     */
    public Set<Lampada> lampadasEmModoEco() {
        return this.lampadas.stream()
                            .filter(l -> l.getModo() == Modo.ECO)
                            .map(Lampada::clone)
                            .collect(Collectors.toSet());
    }

    /**
     * Efectua o reset do contador parcial de consumo em todas as lâmpadas
     */
    public void reset() {
        this.lampadas.forEach(Lampada::resetPeriodo);
    }

    /**
     * Devolve as três lâmpadas mais económicas da casa
     *
     * @return três lampadas mais económicas
     */
    public Set<Lampada> podiumEconomia() {
        return this.lampadas.stream()
                            .sorted((l1, l2) -> Double.compare(l1.totalConsumo(), l2.totalConsumo()))
                            .limit(3)
                            .collect(Collectors.toSet());
    }
}
