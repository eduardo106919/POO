package dev.carrental;

import java.util.List;
import java.util.Scanner;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.InputMismatchException;

/**
 * Esta classe implementa um Menu em modo de texto.
 * @author Eduardo Freitas Fernandes
 */
public class Menu {

    // variáveis de instância

    /** Scanner para leitura de dados */
    private Scanner input;
    /** Nome do Menu */
    private String nome;
    /** lista de opções a apresentar */
    private List<String> opcoes;
    /** lista de pré-condições para as opções */
    private List<PreCondition> disponivel;
    /** lista de handlers para as opções */
    private List<Handler> handlers;


    // construtores

    /**
     * Construtor para um Menu de texto
     * @param opcoes opcoes a apresentar no Menu
     */
    public Menu(String nome, Scanner input, String[] opcoes) {
        this.nome = nome;
        this.input = input;
        this.opcoes = Arrays.asList(opcoes);
        this.disponivel = new ArrayList<>();
        this.handlers = new ArrayList<>();
        this.opcoes.forEach(s -> {
            this.disponivel.add(() -> true);
            this.handlers.add(() -> System.out.println("\nATENÇÃO: Opção não implementada!"));
        });
    }


    // métodos de instância

    /**
     * Executa o Menu.
     * Termina com a opção 0.
     */
    public void run() {
        int op;
        do {
            show();
            op = readOption();
            // testar pré-condição
            if (op > 0 && !this.disponivel.get(op - 1).validate()) {
                System.out.println("Opção indisponível! Tente novamente.");
            } else if (op > 0) {
                // executar handler
                this.handlers.get(op - 1).execute();
            }
        } while (op != 0);
    }

    /**
     * Regista uma pré condição numa opção do Menu
     * @param i indíce da opção (começa em 1)
     * @param b pré condição a registar
     */
    public void setPreCondition(int i, PreCondition b) {
        this.disponivel.set(i - 1, b);
    }

    /**
     * Regista um handler numa opção do Menu
     * @param i indíce da opção (começa em 1)
     * @param h handler a registar
     */
    public void setHandler(int i, Handler h) {
        this.handlers.set(i - 1, h);
    }

    /**
     * Apresenta o Menu e as opções
     */
    private void show() {
        System.out.println("\n" + nome);
        for (int i = 0; i < this.opcoes.size(); i++) {
            System.out.print(i + 1);
            System.out.print(" - ");
            System.out.println(this.disponivel.get(i).validate() ? this.opcoes.get(i) : "---");
        }
        System.out.println("0 - Sair");
    }

    /**
     * Lê uma opção válida
     * @return opção selecionada
     */
    private int readOption() {
        int op;

        System.out.print("Opção: ");
        try {
            op = input.nextInt();
        } catch (InputMismatchException e) { // não foi escrito um int
            op = -1;
        }

        if (op < 0 || op > this.opcoes.size()) {
            System.out.println("Opção Inválida!!!");
            op = -1;
        }
        return op;
    }

}
