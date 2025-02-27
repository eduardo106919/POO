
/**
 * Class that represents the pressure in a certain room
 */
public class Sensor {

    /**
     * Instance variables
     */

    private double pressure;


    /**
     * Constructors
     */

    /**
     * Constructor for an empty Sensor
     */
    public Sensor() {
        this.pressure = 0;
    }

    /**
     * Constructor for a Sensor, with parameters
     *
     * @param value Initial pressure
     */
    public Sensor(double value) {
        if (value < 0)
            this.pressure = 0;
        else
            this.pressure = value;
    }

    /**
     * Clone constructor
     *
     * @param other Another Sensor
     */
    public Sensor(Sensor other) {
        this.pressure = other.get_pressure();
    }


    /**
     * Instance Methods
     */

    /**
     * Returns the room pressure
     *
     * @return value of the pressure
     */
    public double get_pressure() {
        return this.pressure;
    }

    /**
     * Changes the value of the room pressure
     *
     * @param value new room pressure value
     * @return true if the value is positive
     */
    public boolean set_pressure(double value) {
        if (value < 0)
            return false;

        this.pressure = value;
        return true;
    }

    /**
     * Compares a Sensor with an object
     *
     * @param obj Object to compare
     * @return true if the objects are equal
     */
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || obj.getClass() != this.getClass())
            return false;
        Sensor temp = (Sensor) obj;
        return this.pressure == temp.get_pressure();
    }

    /**
     * Creates a clone of the Sensor
     *
     * @return cloned Sensor
     */
    public Sensor clone() {
        return new Sensor(this);
    }

    /**
     * Turns a Sensor into a String
     *
     * @return String with a Sensor information
     */
    public String toString() {
        return "pressure: " + this.pressure;
    }
}
