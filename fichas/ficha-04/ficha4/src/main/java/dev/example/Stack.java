package dev.example;

import java.util.ArrayList;
import java.util.List;

/**
 * Estrutura linear do tipo LIFO de Strings.
 * @author Eduardo Freitas Fernandes
 */
public class Stack {

    // variáveis de instância

    /** pilha de Strings */
    private List<String> pilha;


    // construtores

    /**
     * Construtor por omissão de uma Stack
     */
    public Stack() {
        pilha = new ArrayList<>();
    }

    /**
     * Construtor parametrizado de uma Stack
     * @param pilha pilha de Strings
     */
    public Stack(List<String> pilha) {
        this.pilha = new ArrayList<>(pilha);
    }

    /**
     * Construtor de cópia de uma Stack
     * @param other Stack a copiar
     */
    public Stack(Stack other) {
        pilha = new ArrayList<>(other.pilha);
    }


    // métodos de instância

    /**
     * Determina o elemento no topo da Stack
     * @return topo do Stack
     */
    public String top() {
        if (pilha.isEmpty())
            return null;
        return pilha.getLast();
    }

    /**
     * Insere uma String no topo da Stack
     * @param s String a adicionar
     */
    public void push(String s) {
        pilha.add(s);
    }

    /**
     * Remove o elemento no topo da Stack
     */
    public void pop() {
        if (!pilha.isEmpty())
            pilha.removeLast();
    }

    /**
     * Determina se a Stack está vazia
     * @return {@code true} se estiver vazia, {@code false} caso contrário
     */
    public boolean empty() {
        return pilha.isEmpty();
    }

    /**
     * Determina o comprimento da Stack
     * @return comprimento da Stack
     */
    public int length() {
        return pilha.size();
    }

    /**
     * Efetua uma cópia de uma Stack
     * @return cópia de uma Stack
     */
    @Override
    public Stack clone() {
        return new Stack(this);
    }

    /**
     * Devolve uma representação textual de uma Stack
     * @return representação textual
     */
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        builder.append("Stack: { ");
        pilha.forEach(s -> builder.append(s).append(" "));
        builder.append("}");

        return builder.toString();
    }

    /**
     * Compara um objeto a uma Stack
     * @param obj Objeto a comparar
     * @return {@code true} se forem iguais, {@code false} caso contrário
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (this.getClass() != obj.getClass()) return false;

        Stack other = (Stack) obj;
        return pilha.equals(other.pilha);
    }

}
