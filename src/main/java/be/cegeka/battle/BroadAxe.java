package be.cegeka.battle;


public class BroadAxe extends Axe {

    @Override
    public int getDamage() {
        return new Axe().getDamage() + 2;
    }
}
