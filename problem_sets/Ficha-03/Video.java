
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 * Class to represent a Youtube Video
 */
public class Video {

    /**
     * Instance Variables
     */

    private String name;
    private byte[] content;
    private LocalDate upload_date;
    private int resolution;
    private String time; // "mm:ss"

    private String[] comments;
    private int comment_count = 0;

    private int likes;
    private int dislikes;


    /**
     * Constructors
     */

    /**
     * Creates an empty Video
     */
    public Video() {
        this.name = "";
        this.content = null;
        this.upload_date = null;
        this.resolution = 0;
        this.time = "00:00";
        this.comments = null;
        this.likes = 0;
        this.dislikes = 0;
    }

    /**
     * Creates a Video with parameters
     *
     * @param name name of the video
     * @param content array of bytes with the content of the video
     * @param upload_date date when the video was uploaded
     * @param resolution resolution in which the video was made
     * @param minutes duration of the video in minutes
     * @param seconds remaining duration in seconds (seconds + minutes == total time)
     * @param comments users comments
     * @param likes likes counter
     * @param dislikes dislikes counter
     */
    public Video(String name, byte[] content, LocalDate upload_date, int resolution, int minutes, int seconds, String[] comments, int likes, int dislikes) {
        this.name = name;

        // basic data type, encapsulation is not broken
        this.content = content.clone();
        this.upload_date = upload_date;
        this.resolution = resolution;
        this.time = minutes + ":" + seconds;

        this.comments = comments.clone();
        for (int i = 0; i < comments.length; i++)
            if (comments[i] != null)
                this.comment_count++;

        this.likes = likes;
        this.dislikes = dislikes;
    }

    /**
     * Creates a Video from another
     *
     * @param other Another Video
     */
    public Video(Video other) {
        this.name = other.name;
        this.content = other.content.clone();
        this.upload_date = other.upload_date;
        this.resolution = other.resolution;
        this.time = other.time;

        this.comments = other.comments.clone();
        this.comment_count = other.comment_count;

        this.likes = other.likes;
        this.dislikes = other.dislikes;
    }


    /**
     * Instance Methods
     */

    // getters

    /**
     * Returns the name of the video
     *
     * @return name of the video
     */
    public String get_name() {
        return this.name;
    }

    /**
     * Returns the content of the video
     *
     * @return content of the video
     */
    public byte[] get_content() {
        return this.content.clone();
    }

    /**
     * Returns the upload date of the video
     *
     * @return upload date of the video
     */
    public LocalDate get_upload_date() {
        return this.upload_date;
    }

    /**
     * Returns the resolution of the video
     *
     * @return resolution of the video
     */
    public int get_resolution() {
        return this.resolution;
    }

    /**
     * Returns the duration of the video, in minutes and seconds
     *
     * @return duration of the video
    public int get_time() {
        return this.time;
    }

    /**
     * Returns the users comments on the video
     *
     * @return users comments
     */
    public String[] get_comments() {
        return this.comments.clone();
    }
    
    /**
     * Returns the likes count
     *
     * @return likes count
     */
    public int get_likes() {
        return this.likes;
    }

    /**
     * Returns the dislikes count
     *
     * @return dislikes count
     */
    public int get_dislikes() {
        return this.dislikes;
    }

    // setters

    /**
     * Changes the video name
     *
     * @param name New video name
     */
    public void set_name(String name) {
        this.name = name;
    }

    /**
     * Changes the videos's content
     *
     * @param content new video's content
     */
    public void set_content(byte[] content) {
        this.content = content.clone();
    }

    /**
     * Changes the upload date
     *
     * @param date new upload date
     */
    public void set_upload_date(LocalDate date) {
        this.upload_date = date;
    }
    
    /**
     * Change the video resolution
     *
     * @param resolution new video's resolution
     */
    public void set_resolution(int resolution) {
        this.resolution = resolution;
    }

    /**
     * Changes the duration of the video
     *
     * @param minutes minutes
     * @param seconds remaining seconds
     */
    public void set_time(int minutes, int seconds) {
        this.time = minutes + ":" + seconds;
    }

    /**
     * Changes the video's comments
     *
     * @param comments new video's comments
     */
    public void set_comments(String[] comments) {
        this.comments = comments.clone();
    }

    /**
     * Changes the video's likes counter
     *
     * @param likes likes count
     */
    public void set_likes(int likes) {
        this.likes = likes;
    }


    /**
     * Changes the video's dislikes counter
     *
     * @param dislikes dislikes count
     */
    public void set_dislikes(int dislikes) {
        this.dislikes = dislikes;
    }

    // other methods

    /**
     * Checks if two objects are equal
     *
     * @param obj object to compare
     * @return true if the objects are equal
     */
    public boolean equals(Object obj) {
        if (obj == this)
            return true;
        if (obj == null || this.getClass() != obj.getClass())
            return false;
        Video temp = (Video) obj;
        return this.name.equals(temp.name) && this.content.equals(temp.content)
            && this.upload_date.equals(temp.upload_date) && this.resolution == temp.resolution
            && this.time.equals(temp.time) && this.comments.equals(temp.comments)
            && this.likes == temp.likes && this.dislikes == temp.dislikes;
    }

    /**
     * Clones the caller Video
     *
     * @return cloned Video
     */
    public Video clone() {
        return new Video(this);
    }

    /**
     * Turns a Video to a string
     *
     * @return String with a Video information
     */
    public String toString() {
        return "name: " + this.name + " content: " + this.content.toString() +
               " upload date: " + this.upload_date.toString() + " resolution: " + this.resolution + 
               " duration: " + this.time + " comments: " + this.comments.toString() + 
               " likes: " + this.likes + " dislikes: " + this.dislikes;
    }
    
    /**
     * Adds a comment to the video
     *
     * @param comment new comment
     */
    public void insert_comment(String comment) {
        if (comment != null) {
            
            // if comments are null, create them
            if (this.comments == null)
                this.comments = new String[1];

            // commments are full
            if (this.comment_count == this.comments.length) {
                String[] temp = new String[this.comments.length * 2];
                for (int i = 0; i < this.comment_count; i++)
                    temp[i] = this.comments[i];
                
                this.comments = temp;
            }

            this.comments[this.comment_count++] = comment;
        }
    }

    /**
     * Determines how many days the video has been up
     *
     * @return days since upload
     */
    public long how_many_days() {
        LocalDate today = LocalDate.now();
        return this.upload_date.until(today, ChronoUnit.DAYS);
    }

    /**
     * Adds a like to the Video
     */
    public void thumbs_up() {
        this.likes++;
    }

    /**
     * Returns the content of the video, processed
     *
     * @return String with the content
     */
    public String process() {
        return this.content.toString();
    }
}
