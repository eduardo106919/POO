package dev.carrental.exceptions;

/**
 * Adicionar um carro repetido, isto é, com a mesma matrícula.
 * @author Eduardo Freitas Fernandes
 */
public class CarroRepetidoException extends Exception {
    public CarroRepetidoException(String message) {
        super(message);
    }
}
