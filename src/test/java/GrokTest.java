import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import java.lang.reflect.*;

class GrokTest {
    private static final String[] name =
            {"Green", "Pink", "Blue", "Red", "Brown", "Turquoise"};
    private Grok grok1;
    private PowerPill[] pill;

    @BeforeEach
    void setUp() {
        grok1 = new Grok(80);
        pill = new PowerPill[6];
        for(int index=0; index < pill.length; index++){
            pill[index] = new PowerPill(name[index], (index+1)*10);
        }
    }

    @Test
    void getPowerLevel() {
        assertEquals(80, grok1.getPowerLevel());
    }

    @Test
    void canPickUpPowerPill() {
        assertTrue(grok1.canPickUpPowerPill());
        for(int index = 0; index < pill.length-2; index++){
            grok1.pickUpPowerPill(pill[index]);
            assertTrue(grok1.canPickUpPowerPill());
        }
        grok1.pickUpPowerPill(pill[0]);
        assertFalse(grok1.canPickUpPowerPill());
    }

    @Test
    void setPowerLevel() {
        grok1.setPowerLevel(100);
        assertEquals(100, grok1.getPowerLevel());
        grok1.setPowerLevel(50);
        assertEquals(50, grok1.getPowerLevel());
        grok1.setPowerLevel(-1);
        assertEquals(0, grok1.getPowerLevel());
        grok1.setPowerLevel(101);
        assertEquals(100, grok1.getPowerLevel());
    }

    @Test
    void pickUpPowerPill() {
        for(PowerPill p: pill){
            grok1.pickUpPowerPill(p);
        }
        try {
            Field f = grok1.getClass().getDeclaredField("powerPill");
            f.setAccessible(true);
            PowerPill[] p = (PowerPill[])f.get(grok1);
            for(int index = 0; index < p.length; index++){
                assertEquals(pill[index], p[index]);
            }
        } catch (NoSuchFieldException | IllegalAccessException e){
            throw new RuntimeException(e);
        }
    }

    @Test
    void takePowerPill() {
        for(PowerPill p: pill){
            grok1.pickUpPowerPill(p);
        }
        int[] power = {60, 50, 40, 30, 20};
        for(int index = 0; index < power.length; index++){
            grok1.setPowerLevel(10);
            grok1.takePowerPill();
            assertEquals(power[index], grok1.getPowerLevel());
        }
    }

    @Test
    void takePowerPillUsingName() {
        for(PowerPill p: pill){
            grok1.pickUpPowerPill(p);
        }
        String[] pillsToRemove = {"White", "Blue", "Brown", "Green", "Red"};
        String[][]  nameSet = {
                {"Green", "Pink", "Blue", "Red", "Brown"},
                {"Green", "Pink", "Red", "Brown"},
                {"Green", "Pink", "Red"},
                {"Pink", "Red"},
                {"Pink"}
        };
        try {
            Field f = grok1.getClass().getDeclaredField("powerPill");
            f.setAccessible(true);

            for(int index = 0; index < nameSet.length; index++) {
                grok1.takePowerPill(pillsToRemove[index]);
                PowerPill[] p = (PowerPill[]) f.get(grok1);
                for(int nameIndex = 0; nameIndex < nameSet[index].length; nameIndex++) {
                    assertEquals(nameSet[index][nameIndex], p[nameIndex].getName());
                }
            }
        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void tookHit() {
        grok1.setPowerLevel(20);
        for(int i = 0; i < 5; i++){
            grok1.tookHit();
            int power = 20 - (i+1)*5 > 0 ? 20 - (i+1)*5 : 0;
            assertEquals(power, grok1.getPowerLevel());
        }
    }
}