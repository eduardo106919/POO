
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

    public void ligaLampadaNormal(int index) {
        Lampada temp = this.lampadas.get(index);
        if (temp != null) {
            temp.lampON();
        }
    }

    public void ligaLampadaEco(int index) {
        Lampada temp = this.lampadas.get(index);
        if (temp != null) {
            temp.lampECO();
        }
    }

    public int qtEmEco() {
        return (int) this.lampadas.stream().filter(l -> l.getModo() == Modo.ECO).count();
    }

    public void removeLampada(int index) {
        this.lampadas.remove(index);
    }

    public void ligaTodasEco() {
        this.lampadas.forEach(Lampada::lampECO);
    }

    public void ligaTodasMax() {
        this.lampadas.forEach(Lampada::lampON);
    }

    public double consumoTotal() {
        return this.lampadas.stream().mapToDouble(Lampada::totalConsumo).sum();
    }

    public Lampada maisGastadora() {
        return this.lampadas.stream()
                            .sorted((l1, l2) -> Double.compare(l2.totalConsumo(), l1.totalConsumo())) // inverter argumentos
                            .findFirst()
                            .orElse(null);
    }

    public Set<Lampada> lampadasEmModoEco() {
        return this.lampadas.stream()
                            .filter(l -> l.getModo() == Modo.ECO)
                            .map(Lampada::clone)
                            .collect(Collectors.toSet());
    }

    public void reset() {
        this.lampadas.forEach(Lampada::resetPeriodo);
    }

    public Set<Lampada> podiumEconomia() {
        return this.lampadas.stream()
                            .sorted((l1, l2) -> Double.compare(l1.totalConsumo(), l2.totalConsumo()))
                            .limit(3)
                            .collect(Collectors.toSet());
    }

}
