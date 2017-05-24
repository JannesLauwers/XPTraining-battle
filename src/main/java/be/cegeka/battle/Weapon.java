package be.cegeka.battle;


public abstract class Weapon {

    public int getDamage() {
        return 0;
    }

    public Weapon compareDamageTwoWeapons(Weapon weapon1, Weapon weapon2) {

        Weapon winner;

        if (weapon1.getDamage() > weapon2.getDamage()) {
            winner = weapon1;
        } else {
            winner = weapon2;
        }


        return winner;

    }

}
