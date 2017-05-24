package be.cegeka.battle;

import java.util.ArrayList;

public class Army {

    private ArrayList<Soldier> soldaten;


    public Army() {
        soldaten = new ArrayList<Soldier>();
    }

    public void addsoldier(Soldier soldaat) {
        soldaten.add(soldaat);
    }

    public ArrayList<Soldier> getSoldiers() {
        return soldaten;
    }

    public Soldier getFrontMan() {
        if (soldaten.size() > 0) {
            return (Soldier) soldaten.toArray()[0];
        }
        return null;
    }

}
