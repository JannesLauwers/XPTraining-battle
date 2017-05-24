package be.cegeka.battle;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class ArmyTest {

    @Test
    public void enroll_soldiers_in_army() {
        Soldier soldaat = new Soldier("jantje");
        Army army = new Army();
        army.addsoldier(soldaat);
        assertTrue(army.getSoldiers().contains(soldaat));

    }

    @Test
    public void front_man_first_man_army() {
        Soldier soldaat1 = new Soldier("jantje");
        Soldier soldaat2 = new Soldier("dirk");
        Army army = new Army();
        army.addsoldier(soldaat1);
        army.addsoldier(soldaat2);
        assertEquals(army.getFrontMan(), soldaat1);

    }

    @Test
    public void front_man_first_man_army_geen_man() {
        Army army = new Army();
        assertEquals(army.getFrontMan(), null);

    }


}
