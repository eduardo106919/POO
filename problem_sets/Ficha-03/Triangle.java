
/**
 * Class to represent a Triangle
 */
public class Triangle {
    
    /**
     * Instance Variables
     */

    private Ponto dot1;
    private Ponto dot2;
    private Ponto dot3;


    /**
     * Constructors
     */

    /**
     * Creates an "empty" Triangle
     */
    public Triangle() {
        this.dot1 = new Ponto();
        this.dot2 = new Ponto();
        this.dot2 = new Ponto();
    }
    
    /**
     * Creates a Triangle with parameters
     *
     * @param dot1 Ponto 1
     * @param dot2 Ponto 2
     * @param dot3 Ponto 3
     */
    public Triangle(Ponto dot1, Ponto dot2, Ponto dot3) {
        this.dot1 = dot1.clone();
        this.dot2 = dot2.clone();
        this.dot3 = dot3.clone();
    }

    /**
     * Creates a Triangle, with another Triangle
     *
     * @param other another Triangle
     */
    public Triangle(Triangle other) {
        // check if other is not null

        this.dot1 = other.dot1.clone();
        this.dot2 = other.dot2.clone();
        this.dot3 = other.dot3.clone();
    }


    /**
     * Instance Methods
     */

    // getters
    
    /**
     * Returns dot 1
     *
     * @return dot 1
     */
    public Ponto get_dot1() {
        return this.dot1.clone();
    }

    /**
     * Returns dot 2
     *
     * @return dot 2
     */
    public Ponto get_dot2() {
        return this.dot2.clone();
    }

    /**
     * Returns dot 3
     *
     * @return dot 3
     */
    public Ponto get_dot3() {
        return this.dot3.clone();
    }

    // setters

    /**
     * Changes dot 1
     *
     * @param new_dot new dot
     */
    public void set_dot1(Ponto new_dot) {
        // check if it null
        this.dot1 = new_dot.clone();
    }

    /**
     * Changes dot 2
     *
     * @param new_dot new dot
     */
    public void set_dot2(Ponto new_dot) {
        // check if it null
        this.dot2 = new_dot.clone();
    }

    /**
     * Changes dot 3
     *
     * @param new_dot new dot
     */
    public void set_dot3(Ponto new_dot) {
        // check if it null
        this.dot3 = new_dot.clone();
    }

    // other methods

    /**
     * Checks if other is equal to the calling Triangle
     *
     * @param other object to compare
     * @return true if the objects are equal
     */
    public boolean equals(Object other) {
        if (other == this)
            return true;
        if (other == null || other.getClass() != this.getClass())
            return false;
        Triangle temp = (Triangle) other;
        return this.dot1.equals(temp.dot1) && this.dot2.equals(temp.dot2) && this.dot3.equals(temp.dot3);
    }

    /**
     * Turns a Triangle into a String
     *
     * @return String with the Triangle information
     */
    public String toString() {
        return "Ponto 1: " + this.dot1.toString() + "\nPonto 2: " + this.dot2.toString() + "\nPonto 3: " + this.dot3.toString();
    }

    /**
     * Creates a clone of the calling Triangle
     *
     * @return cloned triangle
     */
    public Triangle clone() {
        return new Triangle(this);
    }
}
