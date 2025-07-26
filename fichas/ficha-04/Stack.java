
import java.util.ArrayList;
import java.util.List;


public class Stack {

    /**
     * Variáveis de Instância
     */

    ArrayList<String> stack;

    /**
     * Construtores
     */

    /**
     * Construtor por omissão de uma Stack
     */
    public Stack() {
        this.stack = new ArrayList<String>();
    }

    /**
     * Construtor de cópia de uma Stack
     *
     * @param outro stack a copiar
     */
    public Stack(Stack outro) {
        if (outro != null) {
            this.stack = new ArrayList<String>(outro.stack);
        } else {
            this.stack = new ArrayList<String>();
        }
    }

    /**
     * Métodos de Instância
     */

    // getters

    /**
     * Devolve as strings guardadas na stack
     *
     * @return strings guardadas
     */
    public List<String> get_data() {
        // shallow clone em strings não é problema
        return new ArrayList<String>(this.stack);
    }

    // outros métodos

    /**
     * Devolve a string que está no topo da stack
     *
     * @return topo do stack
     */
    public String top() {
        return this.stack.getLast();
    }

    /**
     * Adiciona a string ao topo da stack
     *
     * @param s string a adicionar
     */
    public void push(String s) {
        this.stack.addLast(s);
    }

    /**
     * Remove o elemento no topo da stack, se esta não estiver vazia
     */
    public void pop() {
        if (this.stack.isEmpty() == false) {
            this.stack.removeLast();
        }
    }

    /**
     * Determina se a stack está vazia ou não
     *
     * @return true se estiver vazia
     */
    public boolean isEmpty() {
        return this.stack.isEmpty();
    }

    /**
     * Determina o número de elementos na stack
     *
     * @return número de elementos na stack
     */
    public int length() {
        return this.stack.size();
    }

    /**
     * Compara um objeto à stack chamadora
     *
     * @param o objeto a comparar
     * @return true se forem iguais
     */
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || this.getClass() != o.getClass())
            return false;
        Stack outro = (Stack) o;
        return this.stack.equals(outro.stack);
    }

    /**
     * Clona uma stack
     *
     * @return stack clonada
     */
    public Stack clone() {
        return new Stack(this);
    }

    /**
     * Transforma uma Stack numa string
     *
     * @return string com os elementos da stack
     */
    public String toString() {
        return this.stack.toString();
    }
}
