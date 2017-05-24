package be.cegeka.battle;


public abstract class Weapon {

    public int getDamage() {
        return 0;
    }

    public Weapon compareDamageTwoWeapons(Weapon weaponAttack, Weapon weaponDefense) {

        Weapon winner;

        if (checkIfWeaponAttackWins(weaponAttack, weaponDefense)) {
            winner = weaponAttack;
        } else {
            winner = weaponDefense;
        }


        return winner;

    }

    private boolean checkIfWeaponAttackWins(Weapon weaponAttack, Weapon weaponDefense) {
        return weaponAttack.getDamage() > weaponDefense.getDamage()
                || weaponAttack.getDamage() == weaponDefense.getDamage();
    }

}
