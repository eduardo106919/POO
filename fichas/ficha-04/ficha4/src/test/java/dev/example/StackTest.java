package dev.example;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StackTest {

    private Stack s1, s2, s3;

    @BeforeEach
    void setUp() {
        s1 = new Stack();
        s2 = new Stack(Arrays.asList("Joao", "Maria", "Pedro", "Carla", "Diogo", "Ines"));
        s3 = new Stack(s2);
    }

    @Test
    void top() {
        assertTrue(s2.top().equals("Ines"));
    }

    @Test
    void push() {
        assertTrue(s2.top().equals("Ines"));
        s2.push("Afonso");
        assertTrue(s2.top().equals("Afonso"));
    }

    @Test
    void pop() {
        assertTrue(s2.top().equals("Ines"));
        s2.pop();
        assertTrue(s2.top().equals("Diogo"));
    }

    @Test
    void empty() {
        assertTrue(s1.empty());
        assertFalse(s2.empty());
    }

    @Test
    void length() {
        assertEquals(0, s1.length());
        assertEquals(6, s2.length());
    }

    @Test
    void testEquals() {
        assertTrue(s2.equals(s3));
        assertTrue(s3.equals(s2));
        assertFalse(s1.equals(s3));
        assertFalse(s2.equals(null));
    }

}