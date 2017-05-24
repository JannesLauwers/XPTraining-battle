package be.cegeka.battle;


public abstract class Weapon {

    public int getDamage() {
        return 0;
    }

    public boolean doesAttackingWeaponWin(Weapon weaponDefense) {

        boolean winner;

        if (checkIfWeaponAttackWins(this, weaponDefense)) {
            winner = true;
        } else {
            winner = false;
        }


        return winner;

    }

    private boolean checkIfWeaponAttackWins(Weapon weaponAttack, Weapon weaponDefense) {
        return weaponAttack.getDamage() > weaponDefense.getDamage()
                || weaponAttack.getDamage() == weaponDefense.getDamage();
    }

}
