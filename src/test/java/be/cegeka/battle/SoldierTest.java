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
    public void soldierGetsSword() {
        Soldier soldier = new Soldier("Fumblewumble", new Sword());

        assertEquals(Sword.class, soldier.getWeapon().getClass());
    }

    @Test
    public void soldierGetsSpear() {
        Soldier soldier = new Soldier("Fumblewumble", new Spear());

        assertEquals(Spear.class, soldier.getWeapon().getClass());
    }

    @Test
    public void soldierGetsAxe() {
        Soldier soldier = new Soldier("Fumblewumble", new Axe());

        assertEquals(Axe.class, soldier.getWeapon().getClass());
    }

    @Test
    public void soldierGetsBareFist() {
        Soldier soldier = new Soldier("Fumblewumble", new BareFist());

        assertEquals(BareFist.class, soldier.getWeapon().getClass());
    }


}