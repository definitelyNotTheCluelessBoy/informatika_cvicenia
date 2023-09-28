package sk.uniza.fri.zemeplocha;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * 1. 4. 2022 - 17:06
 *
 * @author Matúš
 */
class ZobrazenieTest {

    Zobrazenie test = new Zobrazenie(5);

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void skry() {
        test.skry();
    }
}