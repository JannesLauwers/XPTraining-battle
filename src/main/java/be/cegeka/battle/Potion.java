package be.cegeka.battle;


public class Potion extends Weapon {

    @Override
    public int getDamage(Weapon opponentsWeapon) {
        int damage = 0;

        if (opponentsWeapon.getDamage() % 2 == 0) {
            damage = 10;
        }

        return damage;
    }
}
