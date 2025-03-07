

/**
 * Class to represent a Footbal Game
 */
public class Game {

    /**
     * Instance Variables
     */

    private int home_team;
    private int adversary_team;

    // "starting" "in progress" "finished"
    private String status;


    /**
     * Constructors
     */

    /**
     * Constructor for a starting Game
     */
    public Game() {
        this.home_team = 0;
        this.adversary_team = 0;
        this.status = "starting";
    }

    /**
     * Constructor for a Game, with parameters
     *
     * @param home_goals ammount of goals scored by the home team
     * @param adversary_goals ammount of goals scored by the adversary team
     * @param status current game status
     */
    public Game(int home_goals, int adversary_goals, String status) {
        if (home_goals < 0)
            home_goals = 0;
        this.home_team = home_goals;

        if (adversary_goals < 0)
            adversary_goals = 0;
        this.adversary_team = adversary_goals;

        // missing validation for the game status
        this.status = status;
    }

    /**
     * Copy Constructor 
     *
     * @param other another Game
     */
    public Game(Game other) {
        this.home_team = other.home_team;
        this.adversary_team = other.adversary_team;
        this.status = other.status;
    }


    /**
     * Instance Methods
     */

    // getters

    /**
     * Returns the home team points
     *
     * @return home team points
     */
    public int get_home_team_goals() {
        return this.home_team;
    }

    /**
     * Returns the adversary team points
     *
     * @return adversary points
     */
    public int get_adversary_goals() {
        return this.adversary_team;
    }

    /**
     * Returns the current game status
     *
     * @return game status
     */
    public String get_status() {
        return this.status;
    }

    // setters

    /**
     * Changes the home team points
     *
     * @param home_team home team goals
     */
    public void set_home_team_goals(int home_team) {
        this.home_team = home_team;
    }

    /**
     * Changes the adversary team points
     *
     * @param adversary adversary points
     */
    public void set_adversary_goals(int adversary) {
        this.adversary_team = adversary;
    }

    /**
     * Changes the game status
     *
     * @param status game status
     */
    public void set_status(String status) {
        this.status = status;
    }

    // other methods

    /**
     * Starts the game, if it hasn't began yet
     */
    public void start_game() {
        if (this.status.equals("starting") == true) {
            this.status = "in progress";
            this.home_team = this.adversary_team = 0;
        }
    }

    /**
     * Ends the game, if it is in progress
     */
    public void end_game() {
        if (this.status.equals("in progress") == true) {
            this.status = "finished";
        }
    }

    /**
     * Adds a goal to the home team
     */
    public void score_home_team() {
        if (this.status.equals("in progress") == true) {
            this.home_team += 1;
        }
    }

    /**
     * Adds a goal to the adversary team
     */
    public void score_adversary() {
        if (this.status.equals("in progress") == true) {
            this.adversary_team += 1;
        }
    }

    /**
     * Returns the game score, only if it has started already
     *
     * @return game score
     */
    public String get_result() {
        String result = "";
        if (this.status.equals("starting") == false) {
            result = "home team: " + this.home_team + " | adversary: " + this.adversary_team;
        }

        return result;
    }

    /**
     * Clones a Game
     *
     * @return Cloned Game
     */
    public Game clone() {
        return new Game(this);
    }

    /**
     * Turns a Game into a String
     *
     * @return String with the Game information
     */
    public String toString() {
        return "home team goals: " + this.home_team + " adversary goals: " + this.adversary_team + " status: " + this.status;
    }

    /**
     * Compares two Games
     *
     * @param obj object to compare
     * @return true if the objects are equal
     */
    public boolean equals(Object obj) {
        if (obj == this)
            return true;
        if (obj == null || obj.getClass() != this.getClass())
            return false;
        Game temp = (Game) obj;
        return this.home_team == temp.home_team && this.adversary_team == temp.adversary_team && this.status.equals(temp.status);
    }
}
