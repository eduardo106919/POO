package dev.carrental.exceptions;

/**
 * Carro inexistente numa consulta.
 * @author Eduardo Freitas Fernandes
 */
public class CarroInexistenteException extends Exception {
    public CarroInexistenteException(String message) {
        super(message);
    }
}
