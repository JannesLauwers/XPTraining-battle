package be.cegeka.battle;

import static org.apache.commons.lang3.StringUtils.isNotBlank;

import org.apache.commons.lang3.Validate;

public class Soldier {

    private String name;

    private Weapon weapon;

    private int id;

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

        Soldier victor;

        if (attackerWins) {
            victor = this;
        } else {
            victor = defender;
        }

        return victor;
    }

    public Object getId() {
        return this.id;
    }


    public void setId(int id) {
        this.id = id;
    }
}
