package dev.carrental;

/**
 * Interface que permite valida uma operação.
 * @author Eduardo Freitas Fernandes
 */
public interface PreCondition {

    /**
     * Valida uma operação
     * @return {@code true} ou {@code false}
     */
    boolean validate();

}
