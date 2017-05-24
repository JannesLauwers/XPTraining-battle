package be.cegeka.battle;


public class Trident extends Spear {

    @Override
    public int getDamage() {
        return new Spear().getDamage() * 3;
    }
}
