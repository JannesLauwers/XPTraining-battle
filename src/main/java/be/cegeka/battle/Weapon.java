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
        int bonus = 0;

        bonus = checkAxeHasBonus(weaponAttack, weaponDefense, bonus);

        bonus = checkSpearHasBonus(weaponAttack, weaponDefense, bonus);

        bonus = checkSwordHasBonus(weaponAttack, weaponDefense, bonus);

        if (weaponAttack.getClass() == Potion.class) {
            attackDamage = weaponAttack.getDamage(weaponDefense);
        }

        if (weaponDefense.getClass() == Potion.class) {
            defenseDamage = weaponDefense.getDamage(weaponAttack);
        }

        return attackDamage + bonus > defenseDamage || attackDamage + bonus == defenseDamage;
    }

    private int checkSwordHasBonus(Weapon weaponAttack, Weapon weaponDefense, int bonus) {
        if (weaponAttack.getClass() == Sword.class
                || weaponAttack.getClass() == TwoHandedSword.class && weaponDefense.getClass() == Axe.class
                || weaponDefense.getClass() == BroadAxe.class) {
            bonus = 3;
        }
        return bonus;
    }

    private int checkSpearHasBonus(Weapon weaponAttack, Weapon weaponDefense, int bonus) {
        if (weaponAttack.getClass() == Spear.class
                || weaponAttack.getClass() == Trident.class && weaponDefense.getClass() == Sword.class
                || weaponDefense.getClass() == TwoHandedSword.class) {
            bonus = 3;
        }
        return bonus;
    }

    private int checkAxeHasBonus(Weapon weaponAttack, Weapon weaponDefense, int bonus) {
        if (weaponAttack.getClass() == Axe.class
                || weaponAttack.getClass() == BroadAxe.class && weaponDefense.getClass() == Spear.class
                || weaponDefense.getClass() == Trident.class) {
            bonus = 3;
        }
        return bonus;
    }

}
