
/**
 * Class to represent a Phone
 */
public class Phone {

    /**
     * Instance variables
     */

    private String brand;
    private String model;
    private int display_x;
    private int display_y;

    // total space for texts
    private int storage_texts;
    private String[] texts;
    private int texts_count;

    private int total_storage; // storage for pictures and apps
    private int picture_storage;
    private int apps_storage;
    private int used_space; // bytes
    private int stored_pictures;

    private int apps_count;
    private String[] apps;


    /**
     * Constructors
     */

    /**
     * Constructor for an empty Phone
     */
    public Phone() {
        this.brand = "";
        this.model = "";
        this.display_x = this.display_y = 0;

        this.storage_texts = 0;
        this.texts = null;
        this.texts_count = 0;

        this.total_storage = 0;
        this.picture_storage = 0;
        this.apps_storage = 0;
        this.used_space = 0;
        this.stored_pictures = 0;

        this.apps_count = 0;
        this.apps = null;
    }

    /**
     * Constructor of a Phone with parameters
     *
     * @param brand phone brand
     * @param model phone model
     * @param display_x phone horizontal display
     * @param display_y phone vertical display
     * @param storage_texts phone size to store texts
     * @param total_storage phone size to store pictures and apps
     * @param picture_storage phone size to store pictures
     * @param apps_storage phone size to store apps
     * @param used_space phone used space in bytes
     * @param stored_pictures number of pictures stored
     * @param apps_count number of apps installed
     * @param apps names of installed apps
     */
    public Phone(String brand, String model, int display_x, int display_y,
                 int storage_texts, int total_storage, int picture_storage, 
                 int apps_storage, int used_space, int stored_pictures, 
                 int apps_count, String[] apps) {
        this.brand = brand;
        this.model = model;

        // display must be positive
        this.display_x = Math.abs(display_x);
        this.display_y = Math.abs(display_y);

        this.storage_texts = Math.abs(storage_texts);
        this.total_storage = Math.abs(total_storage);
        this.picture_storage = Math.abs(picture_storage);
        this.apps_storage = Math.abs(apps_storage);
        this.used_space = Math.abs(used_space);
        this.stored_pictures = Math.abs(stored_pictures);

        this.apps_count = Math.abs(apps_count);
        this.apps = apps.clone();
    }
    
    /**
     * Constructor of a Phone through another Phone
     *
     * @param other another Phone
     */
    public Phone(Phone other) {
        this.brand = other.brand;
        this.model = other.model;

        this.display_x = other.display_x;
        this.display_y = other.display_y;

        this.storage_texts = other.storage_texts;
        this.total_storage = other.total_storage;
        this.picture_storage = other.picture_storage;
        this.apps_storage = other.apps_storage;
        this.used_space = other.used_space;
        this.stored_pictures = other.stored_pictures;

        this.apps_count = other.apps_count;
        this.apps = other.apps.clone();
    }

    /**
     * Instance methods
     */

    // getters
    
    /**
     * Returns the phone brand
     *
     * @return phone brand
     */
    public String get_brand() {
        return this.brand;
    }

    /**
     * Returns the phone model
     *
     * @return phone model
     */
    public String get_model() {
        return this.model;
    }

    /**
     * Returns the size of the horizontal display
     *
     * @return horizontal display
     */
    public int get_display_x() {
        return this.display_x;
    }
    
    /**
     * Returns the size of the vertical display
     *
     * @return vertical display
     */
    public int get_display_y() {
        return this.display_y;
    }

    /**
     * Returns the max storage for texts
     *
     * @return max storage for texts
     */
    public int get_storage_texts() {
        return this.storage_texts;
    }
    
    /**
     * Returns the maximum storage for photos and apps
     *
     * @return maximum storage
     */
    public int get_total_storage() {
        return this.total_storage;
    }

    /**
     * Returns the maximum storage for photos
     *
     * @return maximum storage for photos
     */
    public int get_picture_storage() {
        return this.picture_storage;
    }
    
    /**
     * Returns the maximum storage for apps
     *
     * @return maximum storage for apps
     */
    public int get_apps_storage() {
        return this.apps_storage;
    }

    /**
     * Returns the amount of used space in the phone
     *
     * @return used space
     */
    public int get_used_space() {
        return this.used_space;
    }

    /**
     * Returns the amount of stored photos
     *
     * @return number of stored photos
     */
    public int get_stored_pictures() {
        return this.stored_pictures;
    }

    /**
     * Returns the number of installed apps in the phone
     *
     * @return number of installed apps
     */
    public int get_apps_count() {
        return this.apps_count;
    }

    /**
     * Returns the names of the installed apps
     *
     * @return names of installed apps
     */
    public String[] get_apps() {
        return this.apps.clone();
    }

    // setters
    
    /**
     * Changes the phone's brand
     *
     * @param brand phone brand
     */
    public void set_brand(String brand) {
        this.brand = brand;
    }

    /**
     * Changes the phone's model
     *
     * @param model phone model
     */
    public void set_model(String model) {
        this.model = model;
    }

    /**
     * Changes the phone display
     *
     * @param x horizontal display
     * @param y vertical display
     */
    public void set_display(int x, int y) {
        this.display_x = x;
        this.display_y = y;
    }

    /**
     * Changes the maximum number of texts allowed to store
     *
     * @param storage_texts maximum space for texts
     */
    public void set_storage_texts(int storage_texts) {
        this.storage_texts = storage_texts;
    }

    /**
     * Changes the maximum storage for photos and apps
     *
     * @param total_storage maximum storage for photos and apps
     */
    public void set_total_storage(int total_storage) {
        this.total_storage = total_storage;
    }

    /**
     * Changes the maximum number of picture stored
     *
     * @param picture_storage maximum number of picture allowed to store
     */
    public void set_picture_storage(int picture_storage) {
        this.picture_storage = picture_storage;
    }

    /**
     * Changes the maximum number of allowed apps installed
     *
     * @param apps_storage number of apps installed (maximum)
     */
    public void set_apps_storage(int apps_storage) {
        this.apps_storage = apps_storage;
    }

    /**
     * Changes the used space on the phone
     *
     * @param used_space used space
     */
    public void set_used_space(int used_space) {
        this.used_space = used_space;
    }

    /**
     * Changes the number of pictures on the phone
     *
     * @param stored_pictures number of stored pictures
     */
    public void set_stored_pictures(int stored_pictures) {
        this.stored_pictures = stored_pictures;
    }

    /** Changes the number of installed apps
     *
     * @param apps_count number of installed apps
     */
    public void set_apps_count(int apps_count) {
        this.apps_count = apps_count;
    }

    /**
     * Changes the names of the installed apps
     *
     * @param apps names of apps
     */
    public void set_apps(String[] apps) {
        this.apps = apps.clone();
    }

    // other methods
    
    /**
     * Compares two Phones
     *
     * @param obj object to compare with caller
     * @return true if objects are equal
     */
    public boolean equals(Object obj) {
        if (obj == this)
            return true;
        if (obj == null || this.getClass() != obj.getClass())
            return false;
        Phone temp = (Phone) obj;
        return this.model.equals(temp.model) && this.brand.equals(temp.brand)
            && this.display_x == temp.display_x && this.display_y == temp.display_y
            && this.storage_texts == temp.storage_texts && this.total_storage == temp.total_storage
            && this.picture_storage == temp.picture_storage && this.apps_storage == temp.apps_storage
            && this.used_space == temp.used_space && this.stored_pictures == temp.stored_pictures
            && this.apps_count == temp.apps_count && this.apps.equals(temp.apps);
    }

    /**
     * Clones a Phone
     *
     * @return Cloned Phone
     */
    public Phone clone() {
        return new Phone(this);
    }
    
    /**
     * Turns a Phone to a String
     *
     * @return String with the information about a Phone
     */
    public String toString() {
        return "brand: " + this.brand + " model: " + this.model +
               " display: " + this.display_x + " X " + this.display_y +
               " ";
    }

}
