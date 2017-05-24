package be.cegeka.battle;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class WeaponTest {

    @Test
    public void TestIfAxeExists() {
        Weapon weaponAxe = new Axe();

        assertEquals(Axe.class, weaponAxe.getClass());
    }

    @Test
    public void TestIfSwordExists() {
        Weapon weaponSword = new Sword();

        assertEquals(Sword.class, weaponSword.getClass());
    }

    @Test
    public void TestIfSpeardExists() {
        Weapon weaponSpear = new Spear();

        assertEquals(Spear.class, weaponSpear.getClass());
    }

    @Test
    public void TestIfBareFistExists() {
        Weapon weaponBareFist = new BareFist();

        assertEquals(BareFist.class, weaponBareFist.getClass());
    }

}
