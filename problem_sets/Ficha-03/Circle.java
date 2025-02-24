

/**
 * Class that represents a circle in 2 dimensions
 */
public class Circle {

    /**
     * Instance variables
     */
    
    // center
    private double x;
    private double y;

    private double radius;


    /**
     * Constructors
     */

    /**
     * Constructor for an empty Circle
     */
    public Circle() {
        this.x = 0;
        this.y = 0;
        this.radius = 0;
    }

    /**
     * Parameterized constructor for a Circle
     *
     * @param x value for the x coordinate
     * @param y value for the y coordinate
     * @param radius value for the radius of the Circle
     */
    public Circle(double x, double y, double radius) {
        this.x = x;
        this.y = y;

        // radius must be positive
        this. radius = radius;
    }

    /**
     * Copy constructor for a Circle
     *
     * @param another_circle Other Circle
     */
    public Circle(Circle another_circle) {
        this.x = another_circle.get_x();
        this.y = another_circle.get_y();
        this.radius = another_circle.get_radius();
    }


    /**
     * Instance Methods
     */

    /**
     * Returns the value of the horizontal coordinate of the center
     *
     * @return value of the horizontal coordinate
     */
    public double get_x() {
        return this.x;
    }

    /**
     * Returns the value of the vertical coordinate of the center
     *
     * @return value of the vertical coordinate
     */
    public double get_y() {
        return this.y;
    }

    /**
     * Returns the value of the radius of the Circle
     *
     * @return value of the radius
     */
    public double get_radius() {
        return this.radius;
    }

    /**
     * Changes the value of the horizontal coordinate of the center
     *
     * @param x new value for the x coordinate
     */
    public void set_x(double x) {
        this.x = x;
    }

    /**
     * Changes the value of the vertical coordinate of the center
     *
     * @param y new value for the y coordinate
     */
    public void set_y(double y) {
        this.y = y;
    }

    /**
     * Changes the value of the radius of the circle
     *
     * @param radius new value for the radius
     */
    public void set_radius(double radius) {
        this.radius = radius;
    }

    /**
     * Changes the position of the center
     *
     * @param x new value for the x coordinate
     * @param y new value for the y coordinate
     */
    public void change_center(double x, double y) {
        this.set_x(x);
        this.set_y(y);
    }

    /**
     * Determines the area of the circle
     *
     * @return area of the circle
     */
    public double calculate_area() {
        return Math.PI * this.radius * this.radius;
    }

    /**
     * Determines the perimeter of the circle
     *
     * @return perimeter of the circle
     */
    public double calculate_perimeter() {
        return 2 * Math.PI * this.radius;
    }

    /**
     * Compares a Circle with an Object
     * 
     * @param obj given Object to compare
     * @return true if the objects are equal
     */
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        else if (obj == null || this.getClass() != obj.getClass())
            return false;
        Circle temp = (Circle) obj;
        return this.x == temp.get_x() && this.y == temp.get_y() && this.radius == temp.get_radius();
    }

    /**
     * Creates a clone of the Circle
     *
     * @return Cloned object
     */
    public Circle clone() {
        return new Circle(this);
    }

    /**
     * Turns a Circle into a String
     *
     * @return String with a Circle information
     */
    public String toString() {
        return "x = " + this.x + " | y = " + this.y + " | radius = " + this.radius;
    }
}
