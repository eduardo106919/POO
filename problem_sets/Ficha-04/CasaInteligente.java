
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Set;
import java.util.Iterator;


public class CasaInteligente {

    /**
     * Variáveis de Instância
     */

    private ArrayList<Lampada> lampadas;


    /**
     * Construtores
     */

    /**
     * Construtor por omissão de uma Casa Inteligente
     */
    public CasaInteligente() {
        this.lampadas = new ArrayList<Lampada>();
    }

    /**
     * Construtor de cópia de uma Casa Inteligente
     *
     * @param outro Casa Inteligente a copiar
     */
    public CasaInteligente(CasaInteligente outro) {
        this.lampadas = new ArrayList<Lampada>(outro.lampadas.size());
        Iterator<Lampada> iterator = outro.lampadas.iterator();

        while (iterator.hasNext()) {
            this.lampadas.add(iterator.next().clone());
        }
    }

    /**
     * Métodos de Instância
     */

    // getters
    
    /**
     * Devolve as lampadas da casa
     *
     * @return lista de lampadas
     */
    public List<Lampada> get_lampadas() {
        Iterator<Lampada> iterator = this.lampadas.iterator();
        ArrayList<Lampada> result = new ArrayList<Lampada>(this.lampadas.size());

        while (iterator.hasNext()) {
            result.add(iterator.next().clone());
        }

        return result;
    }

    // outros métodos

    /**
     * Adiciona uma lampada à casa
     *
     * @param l lampada a adicionar
     */
    public void adiciona_lampada(Lampada l) {
        this.lampadas.add(l);
    }

    /**
     * Liga a lampada na posicao index, no modo normal
     *
     * @param index posicao da lampada a ligar
     */
    public void liga_lampada_normal(int index) {
        Lampada temp = this.lampadas.get(index);
        if (temp != null) {
            temp.lampON();
        }
    }

    /**
     * Liga a lampada na posicao index, no modo ECO
     *
     * @param index posicao da lampada a ligar
     */
    public void liga_lampada_eco(int index) {
        Lampada temp = this.lampadas.get(index);
        if (temp != null) {
            temp.lampECO();
        }
    }

    /**
     * Compara dois objetos
     *
     * @param outro objeto a comparar
     * @return true se forem iguais
     */
    public boolean equals(Object outro) {
        if (outro == this)
            return true;
        if (outro == null || this.getClass() != outro.getClass())
            return false;
        CasaInteligente temp = (CasaInteligente) outro;
        return this.lampadas.equals(temp.lampadas);
    }
    
    /**
     * Determina quantas lampadas estão no modo ECO
     *
     * @return número de lampadas
     */
    public int quantas_modo_ECO() {
        return (int) this.lampadas.stream().filter(l -> l.getModo() == Lampada.Modo.ECO).count();
    }


    public void remove_lampada(int index) {
        if (index < this.lampadas.size()) {
            this.lampadas.remove(index);
        }
    }

    /**
     * Liga todas as lampadas no modo ECO
     */
    public void liga_todas_ECO() {
        Iterator<Lampada> iterator = this.lampadas.iterator();

        while (iterator.hasNext()) {
            iterator.next().lampECO();
        }
    }

    /**
     * Liga todas as lampadas no consumo
     */
    public void liga_todas_MAX() {
        Iterator<Lampada> iterator = this.lampadas.iterator();

        while (iterator.hasNext()) {
            iterator.next().lampON();
        }
    }

    /**
     * Determina o consumo total da casa
     *
     * @return consumo total
     */
    public double consumo_total() {
        return this.lampadas.stream().mapToDouble(Lampada::getConsumoTotal).sum();
    }

    /**
     * Determina a lampada com o maior consumo
     *
     * @return lampada com maior consumo, desde sempre
     */
    public Lampada mais_gastadora() {
        Lampada max = null;
        Iterator<Lampada> iterator = this.lampadas.iterator();
        if (iterator.hasNext()) {
            max = iterator.next();
            Lampada temp = null;

            while (iterator.hasNext()) {
                temp = iterator.next();
                if (temp.getConsumoTotal() > max.getConsumoTotal()) {
                    max = temp;
                }
            }
        }
        
        return max;
    }

    /**
     * Determina todas as lampadas que estão em modo ECO
     *
     * @return lampadas em modo ECO
     */
    public Set<Lampada> lampadas_ECO() {
        return this.lampadas.stream().filter(l -> l.getModo() == Lampada.Modo.ECO).map(Lampada::clone).collect(Collectors.toSet());
    }

    /**
     * Efetua um reset do contador parcial a todas as lampadas
     */
    public void reset() {
        this.lampadas.forEach(l -> l.resetPeriodo());
    }

    /**
     * Determina as 3 lampadas mais economicas
     *
     * @return 3 lampadas mais economicas
     */
    public Set<Lampada> podium_economia() {
        return this.lampadas.stream().sorted((l1,l2) -> Double.compare(l1.getConsumoTotal(), l2.getConsumoTotal())).limit(3).collect(Collectors.toSet());
    }

    /**
     * Clona uma casa inteligente
     *
     * @return cada clonada
     */
    public CasaInteligente clone() {
        return new CasaInteligente(this);
    }

    /**
     * Transforma uma casa inteligente numa string
     *
     * @return string com a informação das lampadas
     */
    public String toString() {
        return this.lampadas.toString();
    }
}
