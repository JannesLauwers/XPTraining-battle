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

        spear.doesAttackingWeaponWin(axe);

        assertEquals(true, spear.doesAttackingWeaponWin(axe));

    }

    @Test
    public void CompareSwordWithAxe() {
        Weapon axe = new Axe();
        Weapon sword = new Sword();

        assertEquals(true, sword.doesAttackingWeaponWin(axe));
    }

    @Test
    public void CompareAxeWithBareFists() {
        Weapon axe = new Axe();
        Weapon bareFist = new BareFist();


        assertEquals(true, axe.doesAttackingWeaponWin(bareFist));
    }

    @Test
    public void CompareSpearAttackWithSwordDefense() {
        Weapon spear = new Spear();
        Weapon sword = new Sword();


        assertEquals(true, spear.doesAttackingWeaponWin(sword));
    }

    @Test
    public void CompareAxeWithTridentDefense() {
        Weapon axe = new Axe();
        Weapon trident = new Trident();

        assertEquals(true, axe.doesAttackingWeaponWin(trident));
    }

    @Test
    public void CompareSwordAttackWithSwordDefense() {
        Weapon swordAttack = new Sword();
        Weapon swordDefense = new Sword();

        assertEquals(true, swordAttack.doesAttackingWeaponWin(swordDefense));
    }

    @Test
    public void getDamageTwoHandedSword() {
        Weapon twohandedSword = new TwoHandedSword();

        assertEquals(5, twohandedSword.getDamage());
    }

    @Test
    public void CompareTwohandedSwordWithTridentDefense() {
        Weapon twohandedsword = new TwoHandedSword();
        Weapon trident = new Trident();

        assertEquals(true, twohandedsword.doesAttackingWeaponWin(trident));
    }

    @Test
    public void getDamageTrident() {
        Weapon trident = new Trident();

        assertEquals(3 * new Spear().getDamage(), trident.getDamage());
    }

    @Test
    public void getDamageBroadaxe() {
        Weapon broadaxe = new BroadAxe();

        assertEquals(2 + new Axe().getDamage(), broadaxe.getDamage());
    }

    @Test
    public void getDamagePotionWhenOpponentDamageIsEven() {
        Weapon potion = new Potion();

        assertEquals(10, potion.getDamage(new Sword()));
    }

    @Test
    public void GetDamagePotionWhenOpponentDamageIsOdd() {
        Weapon potion = new Potion();

        assertEquals(0, potion.getDamage(new Axe()));
    }

    @Test
    public void GetDamagePotionWhenOpponentIsPotion() {
        Weapon potion = new Potion();
        Weapon potionDefender = new Potion();

        assertEquals(10, potion.getDamage(potionDefender));
        assertEquals(10, potionDefender.getDamage(potion));
    }

    @Test
    public void GetWinnerWhenPotionDefendsAgainstEven() {
        Weapon potion = new Potion();
        Weapon trident = new Trident();

        assertEquals(false, trident.doesAttackingWeaponWin(potion));
    }

    @Test
    public void GetWinnerWhenPotionDefendsAgainstOdd() {
        Weapon potion = new Potion();
        Weapon bareFist = new BareFist();

        assertEquals(true, bareFist.doesAttackingWeaponWin(potion));
    }

    @Test
    public void GetWinnerWhenPotionAttacksAgainstOdd() {
        Weapon potion = new Potion();
        Weapon bareFist = new BareFist();

        assertEquals(false, potion.doesAttackingWeaponWin(bareFist));
    }

    @Test
    public void GetWinnerWhenPotionAttacksAgainstEven() {
        Weapon potion = new Potion();
        Weapon trident = new Trident();

        assertEquals(true, potion.doesAttackingWeaponWin(trident));
    }

}
