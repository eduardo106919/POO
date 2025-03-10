
/**
 * Class that represents a Song
 */
public class Song {

    /**
     * Instance Variables
     */

    private String name;
    private String interpreter;
    private String author;
    private String editor_name;

    private String[] lyrics;
    private int lyrics_count;
    private String[] notes;
    private int notes_count;

    private int duration;
    private int streams;


    /**
     * Constructors
     */

    /**
     * Constructor for an empty Song
     */
    public Song() {
       this.name = null;
       this.interpreter = null;
       this.author = null;
       this.editor_name = null;

       this.lyrics = null;
       this.lyrics_count = 0;
       this.notes = null;
       this.notes_count = 0;

       this.duration = 0;
       this.streams = 0;
    }

    /**
     * Constructor of a Song, with parameters
     *
     * @param name Song's name
     * @param interpreter Song's interpreter
     * @param author Song's author
     * @param editor_name Song's editor company name
     * @param lyrics Song's lyrics
     * @param notes Song's notes
     * @param duration Song's duration in seconds
     * @param streams number of times the song was listened
     */
    public Song(String name, String interpreter, String author, String editor_name, String[] lyrics, String[] notes, int duration, int streams) {
        this.name = name;
        this.interpreter = interpreter;
        this.author = author;
        this.editor_name = editor_name;

        // does not break encapsulation, Strings are imutable
        this.lyrics = lyrics.clone();
        this.lyrics_count = lyrics.length;

        this.notes = notes.clone();
        this.notes_count = notes.length;

        this.duration = duration;
        this.streams = streams;
    }

    /**
     * Constructor of a Song, from another Song
     *
     * @param other Another Song
     */
    public Song(Song other) {
        this.name = other.get_name();
        this.interpreter = other.get_interpreter();
        this.author = other.get_author();
        this.editor_name = other.get_editor_name();

        // does not break encapsulation, Strings are imutable
        this.lyrics = other.get_lyrics();
        this.lyrics_count = other.lyrics_count;

        this.notes = other.get_notes();
        this.notes_count = other.notes_count;
        
        this.duration = other.get_duration();
        this.streams = other.get_streams();
    }

    
    /**
     * Instance Methods
     */

    // getters

    /**
     * Get the Song name
     *
     * @return Song name
     */
    public String get_name() {
        return this.name;
    }

    /**
     * Get the Song interpreter
     *
     * @return Song interpreter
     */
    public String get_interpreter() {
        return this.interpreter;
    }

    /**
     * Get the Song's author
     *
     * @return Song's author
     */
    public String get_author() {
        return this.author;
    }

    /**
     * Get the Song's editor company name
     *
     * @return Song's editor name
     */
    public String get_editor_name() {
        return this.editor_name;
    }

    /**
     * Get the Song's lyrics
     *
     * @return Song's lyrics
     */
    public String[] get_lyrics() {
        return this.lyrics.clone();
    }

    /**
     * Get the Song's notes
     *
     * @return Song's notes
     */
    public String[] get_notes() {
        return this.notes.clone();
    }

    /**
     * Get the Song's duration in seconds
     *
     * @return Song's duration
     */
    public int get_duration() {
        return this.duration;
    }

    /**
     * Get the Song's streams
     *
     * @return Song's streams
     */
    public int get_streams() {
        return this.streams;
    }

    // setters

    /**
     * Changes the Song's name
     *
     * @param name new Song name
     */
    public void set_name(String name) {
        this.name = name;
    }

    /**
     * Changes the Song's interpreter
     *
     * @param interpreter new Song interpreter
     */
    public void set_interpreter(String interpreter) {
        this.interpreter = interpreter;
    }

    /**
     * Changes the Song's author
     *
     * @param author new Song author
     */
    public void set_author(String author) {
        this.author = author;
    }

    /**
     * Changes the Song's editor company name
     *
     * @param editor_name new Song editor company name
     */
    public void set_editor_name(String editor_name) {
        this.editor_name = editor_name;
    }

    /**
     * Changes the Song's lyrics
     *
     * @param lyrics new Song lyrics
     */
    public void set_lyrics(String[] lyrics) {
        this.lyrics = lyrics.clone();
    }

    /**
     * Changes the Song's notes
     *
     * @param notes new Song notes
     */
    public void set_notes(String[] notes) {
        this.notes = notes.clone();
    }

    /**
     * Changes the Song's duration
     *
     * @param duration new Song duration
     */
    public void set_duration(int duration) {
        this.duration = duration;
    }

    /**
     * Changes the Song's streams
     *
     * @param streams new Song streams
     */
    public void set_streams(int streams) {
        this.streams = streams;
    }

    // other methods

    /**
     * Checks if obj is equal to the caller
     *
     * @param obj Object to compare
     * @return true if the objects are equal
     */
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || this.getClass() != obj.getClass())
            return false;
        Song temp = (Song) obj;
        return this.name.equals(temp.name) && this.interpreter.equals(temp.interpreter)
            && this.author.equals(temp.author) && this.editor_name.equals(temp.editor_name)
            && this.lyrics.equals(temp.lyrics) && this.notes.equals(temp.notes)
            && this.duration == temp.duration && this.streams == temp.streams;
    }

    /**
     * Clones a Song
     *
     * @return cloned Song
     */
    public Song clone() {
        return new Song(this);
    }

    /**
     * Turns a Song into a String
     *
     * @return String with the Song information
     */
    public String toString() {
        String lyrics = "";
        if (this.lyrics != null) {
            for (int i = 0; i < this.lyrics_count; i++)
                lyrics += this.lyrics[i];
        }
        String notes = "";
        if (this.notes != null) {
            for (int i = 0; i < this.notes_count; i++)
                notes += this.notes[i];
        }

        return "name: "       + this.name      + "\ninterpreter: " + this.interpreter + 
               "\nauthor: "   + this.author    + "\neditor: "      + this.editor_name + 
               "\nlyrics: "   + lyrics         + "\nnotes: "       + notes + 
               "\nduration: " + this.duration  + "\nstreams: "     + this.streams;
    }

    /**
     * Determines the number of lines of the lyrics
     *
     * @return length of the lyrics (lines)
     */
    public int lyrics_lines_count() {
        return this.lyrics.length;
    }

    /**
     * Determines the number of characters on the lyrics
     *
     * @return number of characters on the lyrics
     */
    public int total_lyrics_chars() {
        int total = 0;
        for (String item: this.lyrics)
            total += item.length();

        return total;
    }

    /**
     * Adds a new line to the lyrics at the selected position
     *
     * @param position position to add the line
     * @param new_line line to add to the lyrics
     */
    public void add_line(int position, String new_line) {
        // lyrics are full
        if (this.lyrics_count == this.lyrics.length) {
            // double the size
            String[] temp = new String[this.lyrics_count * 2];
            for (int i = 0; i < lyrics_count; i++)
                temp[i] = this.lyrics[i];

            this.lyrics = temp;
        }
        
        for (int i = this.lyrics_count; i > position; i--) {
            this.lyrics[i] = this.lyrics[i - 1];
        }

        this.lyrics[position] = new_line;
        this.lyrics_count++;
    }

    /**
     * Determines the longest line on the lyrics
     *
     * @return longest line
     */
    public String longest_line() {
        int max_len = Integer.MIN_VALUE;
        String max = null;

        for (String item: this.lyrics)
            if (item.length() > max_len) {
                max = item;
                max_len = item.length();
            }

        return max;
    }

    /**
     * Determines the 3 most used letters
     *
     * @return 3 most used letters
     */
    public String[] most_used_letters() {
        String[] result = new String[3];
        int count = 0;
        int[] max_counts = {0, 0, 0};
        int i, j;

        for (i = 0; i < this.lyrics_count; i++) {
            count = 0;

            // count how many times item occurs (atleast 1)
            for (j = 0; j < this.lyrics_count; j++) {
                if (this.lyrics[i].equals(this.lyrics[j]))
                    count++;
            }

            if (this.lyrics[i].equals(result[0]) == false && this.lyrics[i].equals(result[1]) == false && this.lyrics[i].equals(result[2]) == false) {
                if (count > max_counts[0] && (this.lyrics[i].equals(result[0]) == false)) {
                    max_counts[2] = max_counts[1];
                    max_counts[1] = max_counts[0];
                    max_counts[0] = count;

                    // switch the strings
                    result[2] = result[1];
                    result[1] = result[0];
                    result[0] = this.lyrics[i];
                } else if (count > max_counts[1] && (this.lyrics[i].equals(result[1]) == false)) {
                    max_counts[2] = max_counts[1];
                    max_counts[1] = count;

                    // switch the strings
                    result[2] = result[1];
                    result[1] = this.lyrics[i];
                } else if (count > max_counts[2] && (this.lyrics[i].equals(result[2]) == false)) {
                    max_counts[2] = count;

                    result[2] = this.lyrics[i];
                }
            }
        }

        return result;
    }
}
