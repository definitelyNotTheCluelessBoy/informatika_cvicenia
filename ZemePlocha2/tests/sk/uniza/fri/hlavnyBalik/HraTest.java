package sk.uniza.fri.hlavnyBalik;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * 1. 4. 2022 - 17:06
 *
 * @author Matúš
 */
class HraTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void hraj() {
        Hra hra = new Hra(5);
    }
}