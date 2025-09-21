package dev.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Gestor inteligente de lampadas instaladas numa casa.
 * @author Eduardo Freitas Fernandes
 */
public class CasaInteligente {

    // variáveis de instância

    /** lâmpadas instaladas na cada */
    private List<Lampada> lampadas;


    // construtores

    /**
     * Construtor por omissão de uma CasaInteligente
     */
    public CasaInteligente() {
        lampadas = new ArrayList<>();
    }

    /**
     * Construtor parametrizado de uma CasaInteligente
     * @param lampadas lampadas instaladas na casa
     */
    public CasaInteligente(List<Lampada> lampadas) {
        this.lampadas = lampadas.stream()
                .map(Lampada::clone)
                .collect(Collectors.toList());
    }

    /**
     * Construtor de cópia de uma CasaInteligente
     * @param other CasaInteligente a copiar
     */
    public CasaInteligente(CasaInteligente other) {
        lampadas = other.lampadas.stream()
                .map(Lampada::clone)
                .collect(Collectors.toList());
    }


    // métodos de instância

    /**
     * Devolve uma cópia das lampadas instaladas
     * @return cópia das lampadas instaladas
     */
    public List<Lampada> getLampadas() {
        return lampadas.stream()
                .map(Lampada::clone)
                .collect(Collectors.toList());
    }

    /**
     * Altera as lampadas instaladas na casa
     * @param lampadas lampadas a instalar na casa
     */
    public void setLampadas(List<Lampada> lampadas) {
        this.lampadas = lampadas.stream()
                .map(Lampada::clone)
                .collect(Collectors.toList());
    }

    /**
     * Adiciona uma Lampada à casa
     * @param l Lampada a adicionar
     */
    public void addLampada(Lampada l) {
        lampadas.add(l.clone());
    }

    /**
     * Liga a Lampada, na posição indicada, no modo de consudo máximo
     * @param index posição da Lampada
     */
    public void ligaLampadaNormal(int index) {
        Lampada l = lampadas.get(index);
        if (l != null)
            l.lampON();
    }

    /**
     * Liga a Lampada, na posição indicada, no modo de consudo económico
     * @param index posição da Lampada
     */
    public void ligaLampadaEco(int index) {
        Lampada l = lampadas.get(index);
        if (l != null)
            l.lampECO();
    }

    /**
     * Determina quantas lampadas é que estão ligadas em modo económico
     * @return número de lampadas no modo ECO
     */
    public int qtEmEco() {
        return (int) lampadas.stream()
                .filter(l -> l.getModo() == Modo.ECO)
                .count();
    }

    /**
     * Remove a lampada da posição passada como parâmetro
     * @param index posição da Lampada
     */
    public void removeLampada(int index) {
        lampadas.remove(index);
    }

    /**
     * Liga todas as Lampadas no modo ECO
     */
    public void ligaTodasEco() {
        lampadas.forEach(Lampada::lampECO);
    }

    /**
     * Liga todas as Lampadas no modo ON
     */
    public void ligaTodasMax() {
        lampadas.forEach(Lampada::lampON);
    }

    /**
     * Determina o consumo total da casa
     * @return consumo total
     */
    public double consumoTotal() {
        return lampadas.stream().mapToDouble(Lampada::totalConsumo).sum();
    }

    /**
     * Determina a lampada que mais consumiu até à data
     * @return lampada mais gastadora
     */
    public Lampada maisGastadora() {
        Optional<Lampada> l = lampadas.stream()
                .max((l1, l2) ->
                                Double.compare(l1.getConsumoTotal(), l2.getConsumoTotal())
                );
        return l.isPresent() ? l.get().clone() : null;
    }

    /**
     * Devolve um conjunto com todas as lampadas que se encontram em modo económico
     * @return Lampadas em modo enconómico
     */
    public Set<Lampada> lampadasEmModoEco() {
        return lampadas.stream()
                .filter(l -> l.getModo() == Modo.ECO)
                .map(Lampada::clone)
                .collect(Collectors.toSet());
    }

    /**
     * Efetua o reset do contador parcial de consumo em todas as lampadas
     */
    public void reset() {
        lampadas.forEach(Lampada::resetPeriodo);
    }

    /**
     * Devolve as três lampadas mais económicas da casa
     * @return três lampadas mais económicas
     */
    public Set<Lampada> podiumEconomia() {
        return lampadas.stream()
                .sorted((l1, l2) ->
                        Double.compare(l2.getConsumoTotal(), l1.getConsumoTotal()))
                .limit(3)
                .map(Lampada::clone)
                .collect(Collectors.toSet());
    }

    /**
     * Efetua uma cópia de uma CasaInteligente
     * @return cópia de uma CasaInteligente
     */
    @Override
    public CasaInteligente clone() {
        return new CasaInteligente(this);
    }

    /**
     * Devolve uma representação textual de uma CasaInteligente
     * @return representação textual
     */
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        builder.append("Casa Inteligente: { ");
        lampadas.forEach(l -> builder.append(l.toString()).append(" "));
        builder.append("}");

        return builder.toString();
    }

    /**
     * Compara um objeto a uma CasaInteligente
     * @param obj objeto a comparar
     * @return {@code true} se forem iguais, {@code false} caso contrário
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (this.getClass() != obj.getClass()) return false;

        CasaInteligente other = (CasaInteligente) obj;
        return lampadas.equals(other.lampadas);
    }

}
