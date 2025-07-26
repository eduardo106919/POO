
import java.util.Arrays;
import java.util.Scanner;
import java.lang.Math;
import java.time.LocalDate;

/**
 * Class for the resolution of the proposed exercises in Ficha 2
 */
public class Ficha2 {

    /* instance variables */

    private LocalDate[] dates = new LocalDate[1];
    private int current;

    private int[][] students_grades = new int[5][5];

    /* methods */

    // exercise 1

    /**
     * Determines the minimum value on the array
     *
     * @param values Array of integers
     * @return minimum value of the array
     */
    public int minimum(int[] values) {
        int min_value = Integer.MAX_VALUE;
        
        // iterate over the array
        for (int iteration: values) {
            if (iteration < min_value)
                min_value = iteration;
        }

        return min_value;
    }

    /**
     * Given two indexes, return the sub-array in between those indexes
     *
     * @param values Array of integers
     * @param index1 Starting index
     * @param index2 Ending index
     * @return Array of integers
     */
    public int[] range(int[] values, int index1, int index2) {
        // invalid input
        if (index1 > index2 || index2 >= values.length)
            return null;

        int len = index2 - index1 + 1;
        int[] result = new int[len];

        for (int i = 0; i < len; i++)
            result[i] = values[i + index1];

        return result;

        /* ANOTHER WAY
         * 
         * return Arrays.copyOfRange(values, index1, index2);
         */
    }

    /**
     * Determines the common values in the two arrays
     *
     * @param values1 First array of integers
     * @param values2 Second array of integers
     * @return Array with the common values
     */
    public int[] intersect(int[] values1, int[] values2) {
        int min_len = Math.min(values1.length, values2.length);
        int[] result = new int[min_len];
        int current = 0;

        for (int val: values1) {
            if (Arrays.binarySearch(values2, val) > -1)
                result[current++] = val;
        }

        return Arrays.copyOfRange(result, 0, current);
    }


    // exercise 2

    /**
     * Adds a date to the date storage (this.dates)
     *
     * @param date new date
     */
    public void insert_date(LocalDate date) {
        // array is full
        if (this.current == this.dates.length) {
            LocalDate[] aux = new LocalDate[this.dates.length * 2];

            int i = 0;
            for (LocalDate temp: this.dates)
                aux[i++] = temp;

            this.dates = aux;
        }

        // add the new date to the end
        this.dates[current++] = date;
    }

    /**
     * Determines the difference between two dates in days
     *
     * @param date1 First date
     * @param date2 Second date
     * @return Difference between date1 and date2 in days
     */
    private int date_difference(LocalDate date1, LocalDate date2) {
        int year_diff = Math.abs(date1.getYear() - date2.getYear());

        return Math.abs(date1.getDayOfYear() - date2.getDayOfYear()) + 365 * year_diff;
    }

    /**
     * Determines the closest date in storage (this.dates) to date
     *
     * @param date search point
     * @return closest date
     */
    public LocalDate closest_date(LocalDate date) {
        int max = Integer.MAX_VALUE;
        LocalDate result = null;

        // find the closest date
        for (int i = 0; i < this.current; i++) {
            if (this.date_difference(date, this.dates[i]) < max) {
                result = this.dates[i];
            }
        }

        return result;
    }

    /**
     * Turn the dates in this.dates in a String
     *
     * @return String with all the dates
     */
    public String toString() {
        String result = "";
            
        for (int i = 0; i < this.current; i++)
            result += this.dates[i].toString() + "\n";

        return result;

        /* ANOTHER WAY
         *
         * return Arrays.toString(this.dates);
         */
    }

    
    // exercise 3
    
    /**
     * Swap two values in an array
     *
     * @param arr Array
     * @param i First index
     * @param j Second index
     */
    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /**
     * Sorts an array of integers using bubble sort
     *
     * @param values Array to sort
     */
    public void sort(int[] values) {
        for (int i = 0; i < values.length - 1; i++) {
            for (int j = 0; j < values.length - i - 1; j++) {
                if (values[j] > values[j + 1])
                    swap(values, j, j + 1);
            }
        }

        // ANOTHER WAY
        // Arrays.sort(values);
    }

    /**
     * Looks for key in the array, using binary search algorihtm
     *
     * @param values Array
     * @param key Integer to look for
     * @return position of key, -1 if it is not in the array
     */
    public int binary_search(int[] values, int key) {
        int left = 0, right = values.length - 1;
        int middle;

        while (left <= right) {
            middle = (right + left) / 2;
            if (values[middle] == key)
                return middle;

            if (values[middle] < key)
                left = middle + 1;
            else
                right = middle - 1;
        }

        return -1;

        // ANOTHER WAY
        // return Arrays.binarySearch(values, key);
    }


    // exercise 4
    
    /**
     * Removes the duplicated strings
     *
     * @param words Array with Strings
     * @return Array with no duplicate strings
     */
    public String[] remove_repetions(String[] words) {
        int index = 0;
        int len = words.length;
        String[] result = new String[len];

        int i, j;
        for (i = 0; i < len; i++) {
            // check if it is duplicate
            for (j = 0; j < index && words[i].equals(words[j]) == false; j++)

            // is not repeated
            if (j == index)
                result[index++] = words[i];
        }

        return Arrays.copyOfRange(result, 0, index);
    }

    /**
     * Determine the largest string in the array
     *
     * @param words Array with strings
     * @return largest string
     */
    public String biggest_string(String[] words) {
        int max_len = Integer.MIN_VALUE;
        String biggest = "";

        for (String item: words) {
            if (item.length() > max_len)
                biggest = item;
        }

        return biggest;
    }

    /**
     * Determine the more frequent strings in the array
     *
     * @param words Array with strings
     * @return Array with more frequent strings
     */
    public String[] more_frequent(String[] words) {
        String[] result = new String[words.length];
        int curr = 0;

        int j, i;
        for (i = 0; i < words.length; i++) {
            for (j = 0; j < i && words[i].equals(words[j]) == false; j++)

            // is repeated
            if (j < i)
                result[curr++] = words[i];
        }

        return result;
    }

    /**
     * Determine how many times a string occurs in the array
     *
     * @param words Array with strings
     * @param reference String to count
     * @return total occurrences
     */
    public int occurrences(String[] words, String reference) {
        int result = 0;

        for (String item: words) {
            if (item.equals(reference))
                result++;
        }

        return result;
    }


    // exercise 5
 
    /**
     * Updates the student grades
     *
     * @param grades New student grades
     */
    public void update_grades(int[][] grades) {
        int i, j;
        for (i = 0; i < 5; i++) {
            for (j = 0; j < 5; j++)
                this.students_grades[i][j] = grades[i][j];
        }
    }

    /**
     * Determine the sum of the grades of a class
     *
     * @param class_index Class
     * @return sum of grades (-1 on error)
     */
    public int class_grade_sum(int class_index) {
        // invalid class
        if (class_index < 1 || class_index > 5)
            return -1;

        int sum = 0;
        for (int i = 0; i < 5; i++)
            sum += this.students_grades[i][class_index - 1];

        return sum;
    }

    /**
     * Determine a student average
     *
     * @param student Index of the student
     * @return Student average
     */
    public float student_average(int student) {
        // invalid student
        if (student < 1 || student > 5)
            return -1;

        int average = 0;
        for (int i = 0; i < 5; i++)
            average += this.students_grades[student - 1][i];

        return (float) average / 5;
    }

    /**
     * Determine the class average
     *
     * @param class_index Index of the class
     * @return class average
     */
    public float class_average(int class_index) {
        // invalid class
        if (class_index < 1 || class_index > 5)
            return -1;

        return (float) this.class_grade_sum(class_index) / 5;
    }

    /**
     * Determine the highest grade of all students and classes
     *
     * @return highest grade
     */
    public int highest_grade() {
        int max = Integer.MIN_VALUE;

        int i, j;
        for (i = 0; i < 5; i++) {
            for (j = 0; j < 5; j++)
                if (this.students_grades[i][j] > max)
                    max = this.students_grades[i][j];
        }

        return max;
    }

    /**
     * Determine the words grade of all students and classes
     *
     * @return worst grade
     */
    public int worst_grade() {
        int min = Integer.MAX_VALUE;

        int i, j;
        for (i = 0; i < 5; i++) {
            for (j = 0; j < 5; j++)
                if (this.students_grades[i][j] < min)
                    min = this.students_grades[i][j];
        }

        return min;
    }

    /**
     * Determine the grades above x
     *
     * @param x Reference grade
     * @return grades above x
     */
    public int[] grades_above_x(int x) {
        int[] result = new int[25];
        int curr = 0;

        int i, j;
        for (i = 0; i < 5; i++) {
            for (j = 0; j < 5; j++) {
                if (this.students_grades[i][j] > x)
                    result[curr++] = this.students_grades[i][j];
            }
        }

        return Arrays.copyOfRange(result, 0, curr - 1);
    }

    /**
     * Turns the students grades in a String
     *
     * @return string with all the grades
     */
    public String grades_to_string() {
        String result = "";

        for (int i = 0; i < 5; i++) {
            for (int item: this.students_grades[i])
                result += Integer.toString(item) + " ";
        }

        return result;
    }

    /**
     * Determines the index of the class with the highest average
     *
     * @return index of the class
     */
    public int highest_class_average() {
        float max = Float.MIN_VALUE;
        int index = 0;

        for (int i = 0; i < 5; i++) {
            if (max < this.class_average(i + 1)) {
                max = this.class_average(i + 1);
                index = i;
            }
        }

        return index;
    }


    // exercise 6

    /**
     * Read a matrix from standard input
     *
     * @param lines how many lines to read
     * @param collumns how many collumns to read
     * @return read matrix
     */
    public int[][] read_matrix(int lines, int collumns) {
        // invalid input
        if (lines <= 0 || collumns <= 0)
            return null;

        Scanner input = new Scanner(System.in);
        int[][] result = new int[lines][collumns];

        int i, j;
        for (i = 0; i < lines; i++)
            for (j = 0; j < collumns; j++)
                result[i][j] = input.nextInt();

        return result;
    }

    /**
     * Adds two matrixes
     *
     * @param matrix_a first matrix
     * @param matrix_b second matrix
     * @return result of the operation
     */
    public int[][] add_matrix(int[][] matrix_a, int[][] matrix_b) {
        int lines = matrix_a.length;
        int collumns = matrix_a[0].length;

        // matrix must have the same size
        if (lines != matrix_b.length || collumns != matrix_b[0].length)
            return null;

        int[][] result = new int[matrix_a.length][matrix_a[0].length];

        int i, j;
        for (i = 0; i < lines; i++)
            for (j = 0; j < collumns; j++)
                result[i][j] = matrix_a[i][j] + matrix_b[i][j];

        return result;
    }

    /**
     * Checks if two matrixes are equal
     *
     * @param matrix_a first matrix
     * @param matrix_b second matrix
     * @return true if they are equal, otherwise, false
     */
    public boolean matrix_equals(int[][] matrix_a, int[][] matrix_b) {
        int lines = matrix_a.length;
        int collumns = matrix_a[0].length;

        // matrix must have the same size
        if (lines != matrix_b.length || collumns != matrix_b[0].length)
            return false;

        boolean result = true;
        int i, j;
        for (i = 0; i < lines && result; i++)
            for (j = 0; j < collumns && result; j++)
                if (matrix_a[i][j] != matrix_b[i][j])
                    result = false;
        
        return result;
    }

    /**
     * Determines the opposite matrix
     *
     * @param matrix Reference matrix
     * @return opposite matrix
     */
    public int[][] opposite_matrix(int[][] matrix) {
        int lines = matrix.length;
        int collumns = matrix[0].length;

        int[][] opposite = new int[lines][collumns];

        int i, j;
        for (i = 0; i < lines; i++)
            for (j = 0; j < collumns; j++)
                opposite[i][j] = - matrix[i][j];

        return opposite;
    }


    // exercise 7

    /**
     * Simulates eurojackpot
     *
     * @param numbers 5 numbers between 1 and 50
     * @param stars 2 numbers between 1 and 9
     * @param player_nums 5 numbers chosen by the player
     * @param player_stars 2 stars chosen by the player
     */
    public void eurojackpot(int[] numbers, int[] stars, int[] player_nums, int player_stars[]) {
        int[] common_numbers = this.intersect(numbers, player_nums);
        int[] common_stars = this.intersect(stars, player_stars);

        int spaces = 0, j;

        // hit the jackpot
        if (common_numbers.equals(numbers) == true && common_stars.equals(stars) == true) {
            for (int i = 0; i < 50; i++) {
                for (j = 0; j < spaces; j++)
                    System.out.print(" ");

                spaces += 2;

                System.out.print("Numbers:");
                for (int item: numbers)
                    System.out.print(" " + Integer.toString(item));

                System.out.print("Stars:");
                for (int item: stars)
                    System.out.print(" " + Integer.toString(item));
            }
        } else {
            System.out.print("Numbers:");
            for (int item: common_numbers)
                System.out.print(" " + Integer.toString(item));

            System.out.print("Stars:");
            for (int item: common_stars)
                System.out.print(" " + Integer.toString(item));
        }
    }
}
