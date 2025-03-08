
/**
 * Class to represent a Car
 */
public class Car {

    /**
     * Instance Variables
     */

    private boolean status = false;

    private String brand;
    private String model;
    private int year;

    // at a speed of 100 km/h
    private double fuel_consumption;

    // kms done since the car was built
    private int total_kms;

    // average consumption since the car was built
    private double average_consumption;

    // kms done in the last trip
    private int parcial_kms;

    // average consumption in the last trip
    private double parcial_avg_consumption;

    // energy regeneration capacity
    private double energy_regeneration;


    /**
     * Constructors
     */

    /**
     * Constructor for an empty Car
     */
    public Car() {
        this.brand = null;
        this.model = null;
        this.year = 0;
        this.fuel_consumption = 0;
        this.total_kms = 0;

        this.average_consumption = 0;
        this.parcial_kms = 0;
        this.parcial_avg_consumption = 0;
        this.energy_regeneration = 0;
    }

    /**
     * Constructor for a Car, with parameters
     *
     * @param brand car brand
     * @param model car model
     * @param year year in which the car was made
     * @param f_cons fuel consumption at 100 km/h
     * @param total_kms number of km done
     * @param avrg_cons average consumption
     * @param parcial_kms kms done in the last trip
     * @param par_avg_cons average consumption in the last trip
     * @param eng_reg energy regeneration
     */
    public Car(String brand, String model, int year, double f_cons, int total_kms, double avrg_cons, int parcial_kms, double par_avg_cons, double eng_reg) {
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.fuel_consumption = f_cons;
        this.total_kms = total_kms;
        this.average_consumption = avrg_cons;
        this.parcial_kms = parcial_kms;
        this.parcial_avg_consumption = par_avg_cons;
        this.energy_regeneration = eng_reg;
    }

    /**
     * Copy constructor
     *
     * @param other car
     */
    public Car(Car other) {
        this.status = other.status;

        this.brand = other.brand;
        this.model = other.model;
        this.year = other.year;
        this.fuel_consumption = other.fuel_consumption;
        this.total_kms = other.total_kms;
        this.average_consumption = other.average_consumption;
        this.parcial_kms = other.parcial_kms;
        this.parcial_avg_consumption = other.parcial_avg_consumption;
        this.energy_regeneration = other.energy_regeneration;
    }


    /**
     * Instance Methods
     */

    // getters

    /**
     * Returns the brand of the Car
     *
     * @return brand of the Car
     */
    public String get_brand() {
        return this.brand;
    }

    /**
     * Returns the model of the Car
     *
     * @return model of the Car
     */
    public String get_model() {
        return this.model;
    }

    /**
     * Returns the year in which the car was made
     *
     * @return year of the Car
     */
    public int get_year() {
        return this.year;
    }

    /**
     * Returns the fuel consumption per km at a speed of 100 km/h
     *
     * @return fuel consumption
     */
    public double get_fuel_consumption() {
        return this.fuel_consumption;
    }

    /**
     * Returns the total kilometers made by the Car
     *
     * @return total kilometers
     */
    public int get_total_kms() {
        return this.total_kms;
    }

    /**
     * Returns the average consumption since the car was made
     *
     * @return average consumption
     */
    public double get_average_consumption() {
        return this.average_consumption;
    }

    /**
     * Returns the amount of kilometers made in the last trip
     *
     * @return parcial kms
     */
    public int get_parcial_kms() {
        return this.parcial_kms;
    }

    /**
     * Returns the average consumption of the last trip made by the Car
     *
     * @return last average consumption
     */
    public double get_last_avg_consumption() {
        return this.parcial_avg_consumption;
    }

    /**
     * Returns the energy regeneration of the Car
     *
     * @return energy regeneration
     */
    public double get_energ_regen() {
        return this.energy_regeneration;
    }

    // setters

    /**
     * Changes the Car's brand
     *
     * @param brand car brand
     */
    public void set_brand(String brand) {
        this.brand = brand;
    }

    /**
     * Changes the Car's model
     *
     * @param model car model
     */
    public void set_model(String model) {
        this.model = model;
    }

    /**
     * Changes the year in which the car was made
     *
     * @param year year in which the car was made
     */
    public void set_year(int year) {
        this.year = Math.abs(year);
    }

    /**
     * Changes the fuel consumption of the Car
     *
     * @param fuel_consumption fuel consumption
     */
    public void set_fuel_consumption(double fuel_consumption) {
        this.fuel_consumption = Math.abs(fuel_consumption);
    }

    /**
     * Changes the total kms made by the Car
     *
     * @param total_kms total kilometers
     */
    public void set_total_kms(int total_kms) {
        this.total_kms = Math.abs(total_kms);
    }

    /**
     * Changes the average consumption of the Car
     *
     * @param avrg_cons average consumption
     */
    public void set_avrg_consup(double avrg_cons) {
        this.average_consumption = avrg_cons;
    }
    
    /**
     * Changes the kilometers made in the last trip
     *
     * @param parcial_kms kilometers made in the last trip
     */
    public void set_parcial_kms(int parcial_kms) {
        this.parcial_kms = parcial_kms;
    }
    
    /**
     * Changes the average fuel consumption of the last trip
     *
     * @param parcial_avg_cons average consumption of the last trip
     */
    public void set_parcial_avg_cons(double parcial_avg_cons) {
        this.parcial_avg_consumption = parcial_avg_cons;
    }
    
    /**
     * Changes the energy regeneration of the Car
     *
     * @param energy_regen energy regeneration
     */
    public void set_energ_regeneration(double energy_regen) {
        this.energy_regeneration = energy_regen;
    }

    /**
     * Starts the calling Car
     */
    public void start_car() {
        this.status = true;
    }
    
    /**
     * Turns off the calling Car
     */
    public void poweroff_car() {
        this.status = false;
    }

    // other methods

    /**
     * Turns the car engine on
     */
    public void turn_engine_on() {
        this.status = true;
        this.parcial_kms = 0;
        this.parcial_avg_consumption = 0;
    }

    /**
     * Turns the car engine off
     */
    public void turn_engine_off() {
        this.status = false;
    }
    
    /**
     * Resets the car counters for the last trip
     */
    public void reset_last_trip() {
        this.parcial_kms = 0;
        this.parcial_avg_consumption = 0;
    }

    /**
     * Rides the car foward
     *
     * @param distance distance in meters
     * @param speed speed
     */
    public void ride(double distance, double speed) {
        // if the car engine is on
        if (this.status == true) {
            this.total_kms += distance;
            this.parcial_kms += distance;

            // make the calculations for the fuel consumptio
        }
    }

    /**
     * Brakes the car for a certain distance
     *
     * @param distance distance
     */
    public void brake(double distance) {
        // if the car engine is on
        if (this.status == true) {
            this.parcial_kms += distance;
            this.total_kms += distance;
        }
    }

    /**
     * Compares two obj to the calling Car
     *
     * @param obj object to compare
     * @return true if the objects are equal
     */
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || this.getClass() != obj.getClass())
            return false;
        Car temp = (Car) obj;
        return this.brand.equals(temp.brand) && this.model.equals(temp.model) && this.year == temp.year &&
               this.fuel_consumption == temp.fuel_consumption && this.total_kms == temp.total_kms &&
               this.average_consumption == temp.average_consumption && this.parcial_kms == temp.parcial_kms &&
               this.parcial_avg_consumption == temp.parcial_avg_consumption && this.energy_regeneration == temp.energy_regeneration;
    }

    /**
     * Clones the calling Car
     *
     * @return Clone of a Car
     */
    public Car clone() {
        return new Car(this);
    }

    /**
     * Turns a Car into a String
     *
     * @return string with the information of a car
     */
    public String toString() {
        return "brand: " + this.brand + "\nmodel: " + this.model + "\nyear: " + this.year
             + "\nfuel consumption: " + this.fuel_consumption + "\ntotal kms: " + this.total_kms
             + "\naverage consumption: " + this.average_consumption + "parcial kms: " + this.parcial_kms
             + "\nparcial average consumption: " + this.parcial_avg_consumption + "energy regeneration: " + this.energy_regeneration;
    }
}
