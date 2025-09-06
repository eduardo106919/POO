package dev.carrental;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

/**
 * Classe de execução do programa.
 * @author Eduardo Freitas Fernandes
 */
public class Main {

    /**
     * Método de execução do programa.
     * @param args argumentos da linha de comando
     */
    public static void main(String[] args) {

        InputStream input = System.in;

        if (args.length >= 1) {
            try {
                input = new FileInputStream(args[0]);
            } catch (FileNotFoundException e) {
                System.out.println(e.getMessage());
                return;
            }
        }

        CarRentalApp controller = new CarRentalApp(input);
        controller.run();

    }
}