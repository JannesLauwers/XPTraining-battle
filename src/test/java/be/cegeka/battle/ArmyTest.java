package be.cegeka.battle;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ArmyTest {

    @Mock
    HQ hq;

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

    @Test
    public void dead_soldiers_removed_from_army() {
        Soldier soldaat = new Soldier("jantje");
        Army army = new Army(hq);

        army.addsoldier(soldaat);
        int aantalSoldiers = army.getAantalSoldiers();
        soldaat.dies();
        assertNotEquals(aantalSoldiers, army.getAantalSoldiers());
    }

    @Test
    public void army_tegen_army_frontman_dies() {
        Soldier soldaat1 = new Soldier("jantje");
        Soldier soldaat2 = new Soldier("dirk");
        Army attackingArmy = new Army(hq);
        Army defendingArmy = new Army(hq);

        attackingArmy.addsoldier(soldaat1);
        defendingArmy.addsoldier(soldaat2);
        int aantalSoldiers = defendingArmy.getAantalSoldiers();

        attackingArmy.attacks(defendingArmy);

        assertNotEquals(aantalSoldiers, defendingArmy.getAantalSoldiers());
    }
}
