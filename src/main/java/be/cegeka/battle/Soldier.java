package be.cegeka.battle;

import static org.apache.commons.lang3.StringUtils.isNotBlank;

import org.apache.commons.lang3.Validate;

public class Soldier {

    private String name;

    private Weapon weapon;

    private int id;

    private Army army;

    public Soldier(String name) {
        Validate.isTrue(isNotBlank(name));

        this.name = name;
        this.weapon = new BareFist();
    }

    public Soldier(String name, Weapon weapon) {
        Validate.isTrue(isNotBlank(name));

        this.name = name;
        this.weapon = weapon;
    }

    String getName() {
        return this.name;
    }

    public Weapon getWeapon() {
        return this.weapon;
    }


    public Soldier attacks(Soldier defender) {
        boolean attackerWins = this.weapon.doesAttackingWeaponWin(defender.getWeapon());
        loserDies(defender, attackerWins);
        return getWinner(defender, attackerWins);
    }

    private void loserDies(Soldier defender, boolean attackerWins) {
        if (attackerWins) {
            defender.dies();
        } else {
            this.dies();
        }
    }

    private Soldier getWinner(Soldier defender, boolean attackerWins) {
        if (attackerWins) {
            return this;
        }
        return defender;
    }

    public int getId() {
        return this.id;
    }


    public void setId(int id) {
        this.id = id;
    }

    public Army getArmy() {
        return army;
    }

    public void setArmy(Army army) {
        this.army = army;
    }

    public void dies() {
        if (this.army != null) {
            this.army.ReportCasualty(this);
        }
    }
}
