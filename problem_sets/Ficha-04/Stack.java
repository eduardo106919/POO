
import java.util.ArrayList;

/**
 * Class to represent a Stack
 */
public class Stack {

    /**
     * Instance Variables
     */

    private static int initial_capacity = 10;
    private int size;
    private ArrayList<String> storage;

    /**
     * Constructors
     */
    
    /**
     * Initializes an empty Stack, of size 10
     */
    public Stack() {
        this.size = Stack.initial_capacity;
        this.storage = new ArrayList<String>(Stack.initial_capacity);
    }

    /**
     * Initializes a Stack, with the given size
     *
     * @param size initial size
     */
    public Stack(int size) {
        this.size = size;
        this.storage = new ArrayList<String>(size);
    }

    /**
     * Initializes a Stack, with another Stack
     *
     * @param other another stack
     */
    public Stack(Stack other) {
        this.size = other.size;
        // strings are imutable, so shallow clone is safe
        this.storage = (ArrayList<String>) other.storage.clone();
    }


    /**
     * Instance Methods
     */

    /**
     * Determines the element on the top of the Stack
     *
     * @return top of the Stack
     */
    public String top() {
        if (this.storage.isEmpty())
            return null;
        else
            return (String) this.storage.getLast();
    }

    /**
     * Adds str to the top of the Stack
     *
     * @param str String to add
     */
    public void push(String str) {
        // stack is full
        if (this.storage.size() == this.size) {
            this.size *= 2;
            this.storage.ensureCapacity(this.size);
        }

        this.storage.addLast(str);
    }

    /**
     * Removes the top element on the stack, if it's not empty
     */
    public void pop() {
        if (this.storage.isEmpty() == false) {
            this.storage.removeLast();
        }
    }

    /**
     * Checks whether if the stack is empty
     *
     * @return true if the stack is empty
     */
    public boolean empty() {
        return this.storage.isEmpty();
    }

    /**
     * Determines the length of the stack
     *
     * @return length of the stack
     */
    public int length() {
        return this.storage.size();
    }
}
