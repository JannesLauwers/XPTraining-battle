package be.cegeka.battle;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class SoldierTest {

    @Test
    public void construction_ASoldierMustHaveAName() {
        Soldier soldier = new Soldier("name");

        assertThat(soldier.getName()).isEqualTo("name");
    }

    @Test(expected = IllegalArgumentException.class)
    public void construction_ASoldierMustHaveAName_CannotBeNull() {
        new Soldier(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void construction_ASoldierMustHaveAName_CannotBeEmpty() {
        new Soldier("");
    }

    @Test(expected = IllegalArgumentException.class)
    public void construction_ASoldierMustHaveAName_CannotBeBlank() {
        new Soldier("   ");
    }

    @Test
    public void defaultWeaponOfSoldierIsBareFist() {
        Soldier soldier = new Soldier("Fumblewumble");

        assertEquals(BareFist.class, soldier.getWeapon().getClass());
    }


    @Test
    public void soldier_fights_soldier() {
        Soldier soldier1 = new Soldier("lala");
        Soldier soldier2 = new Soldier("Fumblewumble2");
        soldier1.attacks(soldier2);


    }


}