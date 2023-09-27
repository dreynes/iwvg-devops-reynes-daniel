package es.upm.miw.iwvg_devops.code;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FractionTest {
    private Fraction fraction0, fraction1;

    @BeforeEach
    void before() {
        fraction0 = new Fraction();
        fraction1 = new Fraction(1, 2);
    }

    @Test
    void testFractionGetNumeratorDefault() {
        assertEquals(1, fraction0.getNumerator());
    }

    @Test
    void testFractionGetDenominatorDefault() {
        assertEquals(1, fraction0.getDenominator());
    }

    @Test
    void testFractionGetDecimalDefault() {
        assertEquals(1, fraction0.decimal());
    }

    @Test
    void testFractionGetNumerator() {
        assertEquals(1, fraction0.getNumerator());
    }

    @Test
    void testFractionGetDenominator() {
        assertEquals(2, fraction1.getDenominator());
    }

    @Test
    void testFractionGetDecimal() {
        assertEquals(0.5, fraction1.decimal());
    }

    @Test
    void testFractionToString() {
        assertEquals("Fraction{numerator=1, denominator=2}", fraction1.toString());
    }

    @Test
    void testFractionSetDenominator() {
        fraction1.setDenominator(10);
        assertEquals(10, fraction1.getDenominator());
    }

    @Test
    void testFractionSetNumerator() {
        fraction1.setNumerator(8);
        assertEquals(8, fraction1.getNumerator());
    }


    @Test
    void testFractionIsProper() {
        assertTrue(fraction1.isProper());
    }

    @Test
    void testFractionIsImproper() {
        assertTrue(fraction0.isImproper());
    }

    @Test
    void testFractionIsEquivalent() {
        assertTrue(fraction1.isEquivalent(new Fraction(2, 4)));
    }

    @Test
    void testFractionAdd() {
        Fraction fractionAdd = new Fraction(1, 2);
        Fraction result = new Fraction(1, 1);
        assertTrue(result.isEquivalent(fraction1.add(fractionAdd)));
    }

    @Test
    void testFractionMultiply() {
        Fraction multyFraction = new Fraction(2, 3);
        Fraction fractionAux = new Fraction(1, 2);
        Fraction result = new Fraction(2, 6);
        assertTrue(result.isEquivalent(fractionAux.multiply(multyFraction)));
    }

    @Test
    void testFractionDivide() {
        Fraction result1 = new Fraction(1, 1);

        assertTrue(result1.isEquivalent(fraction1.divide(fraction1)));

    }

}