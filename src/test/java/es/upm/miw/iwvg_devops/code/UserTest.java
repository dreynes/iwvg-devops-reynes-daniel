package es.upm.miw.iwvg_devops.code;

import java.util.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class UserTest {
    private User user1, user2;
    private ArrayList<Fraction> fractions;

    @BeforeEach
    void before() {
        fractions = new ArrayList<Fraction>();
        fractions.add(new Fraction(1, 2));
        fractions.add(new Fraction(2, 3));
        user1 = new User();
        user2 = new User("id2", "Juan", "Perez", fractions);
    }

    @Test
    void testUserGetIdNull() {
        assertNull(user1.getId());
    }

    @Test
    void testUserGetNameNull() {
        assertNull(user1.getName());
    }

    @Test
    void testUserGetFamilyNameNull() {
        assertNull(user1.getFamilyName());
    }

    @Test
    void testUser1GetFractions() {
        assertEquals(new ArrayList<Fraction>(), user1.getFractions());
    }

    @Test
    void testUserGetName() {
        assertEquals("Juan", user2.getName());
    }

    @Test
    void testUserGetFamilyName() {
        assertEquals("Perez", user2.getFamilyName());
    }

    @Test
    void testUserGetFullName() {
        assertEquals("Juan Perez", user2.fullName());
    }

    @Test
    void testUser2GetFractions() {
        assertEquals(fractions, user2.getFractions());
    }

    @Test
    void testUserGetInitials() {
        assertEquals("J.", user2.initials());
    }

    @Test
    void testUserGetId() {
        assertEquals("id2", user2.getId());
    }

    @Test
    void testUserToString() {
        assertEquals("User{id='id2', name='Juan', familyName='Perez', fractions=[Fraction{numerator=1, denominator=2}, Fraction{numerator=2, denominator=3}]}", user2.toString());
    }

    @Test
    void testUserSetName() {
        user2.setName("Pepe");
        assertEquals("Pepe", user2.getName());
    }

    @Test
    void testUserSetFamilyName() {
        user2.setFamilyName("Gomez");
        assertEquals("Gomez", user2.getFamilyName());
    }

    @Test
    void testUserSetFractions() {
        ArrayList<Fraction> f2 = new ArrayList<Fraction>();
        f2.add(new Fraction(2, 8));
        user2.setFractions(f2);
        assertEquals(f2, user2.getFractions());
    }
}


