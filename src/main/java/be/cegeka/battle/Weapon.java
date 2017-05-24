package be.cegeka.battle;


public abstract class Weapon {

    public int getDamage() {
        return 0;
    }

    public int getDamage(Weapon weapon) {
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
        int attackDamage = weaponAttack.getDamage();
        int defenseDamage = weaponDefense.getDamage();

        if (weaponAttack.getClass() == Potion.class) {
            attackDamage = weaponAttack.getDamage(weaponDefense);
        }

        if (weaponDefense.getClass() == Potion.class) {
            defenseDamage = weaponDefense.getDamage(weaponAttack);
        }

        return attackDamage > defenseDamage || attackDamage == defenseDamage;
    }

}
