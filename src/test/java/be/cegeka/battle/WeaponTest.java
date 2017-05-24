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

    @Test
    public void AxeHasThreeDamage() {
        Weapon axe = new Axe();

        assertEquals(3, axe.getDamage());
    }

    @Test
    public void SwordHasTwoDamage() {
        Weapon sword = new Sword();

        assertEquals(2, sword.getDamage());
    }

    @Test
    public void SpearHasTwoDamage() {
        Weapon spear = new Spear();

        assertEquals(2, spear.getDamage());
    }

    @Test
    public void BareFisteHasOneDamage() {
        Weapon bareFist = new BareFist();

        assertEquals(1, bareFist.getDamage());
    }

    @Test
    public void CompareSpearWithAxe() {
        Weapon spear = new Spear();
        Weapon axe = new Axe();


        Weapon winner;

        winner = spear.compareDamageTwoWeapons(axe, spear);

        assertEquals(axe, winner);

    }

    @Test
    public void CompareSwordWithAxe() {
        Weapon axe = new Axe();
        Weapon sword = new Sword();

        Weapon winner;

        winner = sword.compareDamageTwoWeapons(sword, axe);

        assertEquals(axe, winner);
    }

    @Test
    public void CompareAxeWithBareFists() {
        Weapon axe = new Axe();
        Weapon bareFist = new BareFist();

        Weapon winner;

        winner = axe.compareDamageTwoWeapons(axe, bareFist);

        assertEquals(axe, winner);
    }

    @Test
    public void CompareSpearAttackWithSwordDefense() {
        Weapon spear = new Spear();
        Weapon sword = new Sword();

        Weapon winner;

        winner = spear.compareDamageTwoWeapons(spear, sword);

        assertEquals(spear, winner);
    }

    @Test
    public void CompareSwordAttackWithSwordDefense() {
        Weapon swordAttack = new Sword();
        Weapon swordDefense = new Sword();

        Weapon winner;

        winner = swordAttack.compareDamageTwoWeapons(swordAttack, swordDefense);

        assertEquals(swordAttack, winner);
    }

}
