import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Random;

class PowerPillTest {
    private static Random rand;
    private static String[] color = {"Blue", "Red", "Pink", "Purple", "Green"};

    @BeforeAll
    static void beforeAll() {
        rand = new Random();
    }

    @Test
    void getName() {
        for(int index = 0; index < color.length; index++) {
            String expected = color[index];
            PowerPill aPill = new PowerPill(expected);
            String actual = aPill.getName();
            assertEquals(expected,actual,"Expected " + expected + " got "+ actual);
        }

        // test non-default constructor
        for(int index = 0; index < color.length; index++) {
            String expected = color[index];
            PowerPill aPill = new PowerPill(expected,20);
            String actual = aPill.getName();
            assertEquals(expected,actual,"Expected " + expected + " got "+ actual);
        }
    }

    @Test
    void getPower() {
        for(int index = 0; index < 3; index++) {
            int expected = rand.nextInt();
            PowerPill aPill = new PowerPill(color[index],expected);
            int actual = aPill.getPower();
            assertEquals(expected,actual,"Expected " + expected + " got "+ actual);
        }
    }

    @Test
    void setPower() {
        for(int index = 0; index < 3; index++) {
            int expected = rand.nextInt();
            PowerPill aPill = new PowerPill(color[index]);
            aPill.setPower(expected);
            int actual = aPill.getPower();
            assertEquals(expected,actual,"Expected " + expected + " got "+ actual);
        }
    }

    @Test
    void setName() {
        for(int index = 0; index < color.length; index++) {
            String expected = color[index];
            PowerPill aPill = new PowerPill("");
            aPill.setName(expected);
            String actual = aPill.getName();
            assertEquals(expected,actual,"Expected " + expected + " got "+ actual);
        }
    }

    @Test
    void testToString(){
        String expected = "PowerPill{powerSupply=30, name='Green'}";
        PowerPill p = new PowerPill("Green", 30);
        assertEquals(expected, p.toString());
    }

    @Test
    void testEquals() {
        PowerPill p1 = new PowerPill("Green", 30);
        PowerPill p2 = new PowerPill("Green", 30);
        assertTrue(p1.equals(p2));
        assertTrue(p2.equals(p2));
        PowerPill p3 = new PowerPill("Green", 40);
        assertFalse(p1.equals(p3));
        assertFalse(p3.equals(p1));
        PowerPill p4 = new PowerPill("Red", 30);
        assertFalse(p1.equals(p4));
        assertFalse(p4.equals(p1));
    }
}