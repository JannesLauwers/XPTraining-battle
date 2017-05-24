package be.cegeka.battle;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class SoldierTest {

    @Mock
    HQ hq;

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


    @Test
    public void soldierBareFistsAttacksSoldierBareFist() {
        Soldier soldier1 = new Soldier("lala");
        Soldier soldier2 = new Soldier("Fumblewumble2");

        assertEquals(soldier1, soldier1.attacks(soldier2));
    }

    @Test
    public void SoldierAxeAttacksSoldierBareFist() {
        Soldier soldierAxe = new Soldier("Fumble's square", new Axe());
        Soldier soldierBareFist = new Soldier("Mr.T");

        assertEquals(soldierAxe, soldierAxe.attacks(soldierBareFist));
    }

    @Test
    public void SoldierBareFistAttacksSoldierAxe() {
        Soldier soldierBareFist = new Soldier("Fumble's square");
        Soldier soldierAxe = new Soldier("Mr.T", new Axe());

        assertEquals(soldierAxe, soldierBareFist.attacks(soldierAxe));
    }

    @Test
    public void soldier_dies_sends_message_to_hq() {
        Soldier soldier = new Soldier("Fumblewumble");
        Army army = new Army(hq);
        when(hq.ReportEnlistment(soldier.getName())).thenReturn(5);
        army.addsoldier(soldier);
        soldier.dies();
        verify(hq).ReportCasualty(5);
    }
}