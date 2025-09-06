package dev.carrental.exceptions;

/**
 * Comparador de Carros não existe.
 * @author Eduardo Freitas Fernandes
 */
public class ComparadorInexistenteException extends Exception {
    public ComparadorInexistenteException(String message) {
        super(message);
    }

}
