package dev.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class EncEficienteTest {

    private LinhaEncomenda le1 = new LinhaEncomenda("AAA", "martelos", 10.0, 5, 0.2, 0.95);
    private LinhaEncomenda le2 = new LinhaEncomenda("BBB", "vidro", 40.0, 25, 0.1, 0.90);
    private LinhaEncomenda le3 = new LinhaEncomenda("CCC", "papel", 5.0, 100, 0.1, 0.95);
    private LinhaEncomenda le4 = new LinhaEncomenda("DDD", "plástico", 10.0, 30, 0.05, 0.80);
    private LinhaEncomenda le5 = new LinhaEncomenda("EEE", "rodas", 25.0, 15, 0.3, 1);
    List<LinhaEncomenda> l = Arrays.asList(le1, le2, le3, le4, le5);

    private EncEficiente e1, e2, e3;

    @BeforeEach
    void setUp() {
        e1 = new EncEficiente();
        e2 = new EncEficiente("Diogo", 123456, "Lisboa, Rossio", LocalDateTime.now(), l);
        e3 = new EncEficiente(e2);
    }

    @Test
    void calculaValorTotal() {
        double valor = l.stream().mapToDouble(LinhaEncomenda::calculaValorLinhaEnc).sum();
        assertEquals(valor, e2.calculaValorTotal(), 0.5);
    }

    @Test
    void calculaValorDesconto() {
        double valor = l.stream().mapToDouble(LinhaEncomenda::calculaValorDesconto).sum();
        assertEquals(valor, e2.calculaValorDesconto(), 0.5);
    }

    @Test
    void numeroTotalProdutos() {
        int quant = l.stream().mapToInt(LinhaEncomenda::getQuantidade).sum();
        assertEquals(quant, e2.numeroTotalProdutos());
    }

    @Test
    void existeProdutoEncomenda() {
        assertTrue(e2.existeProdutoEncomenda("AAA"));
        assertTrue(e2.existeProdutoEncomenda("BBB"));
        assertFalse(e2.existeProdutoEncomenda("FFF"));
        assertFalse(e1.existeProdutoEncomenda("AAA"));
    }

    @Test
    void adicionaLinha() {
        assertFalse(e2.existeProdutoEncomenda("FFF"));
        LinhaEncomenda l = new LinhaEncomenda("FFF", "pregos", 13.0, 8, 0.1, 0.97);
        e2.adicionaLinha(l);
        assertTrue(e2.existeProdutoEncomenda("FFF"));
    }

    @Test
    void removeProduto() {
        assertTrue(e2.existeProdutoEncomenda("CCC"));
        e2.removeProduto("CCC");
        assertFalse(e2.existeProdutoEncomenda("CCC"));
    }

    @Test
    void testEquals() {
        assertTrue(e2.equals(e3));
        assertTrue(e3.equals(e2));
        assertFalse(e1.equals(e3));
        assertFalse(e2.equals(null));
    }

}