package dev.carrental.exceptions;

/**
 * Registar uma viagem num carro inexistente.
 * @author Eduardo Freitas Fernandes
 */
public class ViagemInvalidaException extends Exception {
    public ViagemInvalidaException(String message) {
        super(message);
    }
}
