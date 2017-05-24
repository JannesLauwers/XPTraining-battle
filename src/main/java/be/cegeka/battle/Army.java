package be.cegeka.battle;

import java.util.ArrayList;

public class Army {

    private ArrayList<Soldier> soldaten;

    private HQ hq;

    public Army() {
        soldaten = new ArrayList<Soldier>();
    }

    public Army(HQ hq) {
        soldaten = new ArrayList<Soldier>();
        this.hq = hq;
    }

    public void addsoldier(Soldier soldaat) {
        soldaten.add(soldaat);
        soldaat.setArmy(this);
        if (hq != null) {
            soldaat.setId(hq.ReportEnlistment(soldaat.getName()));

        }
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

    public void ReportCasualty(Soldier soldier) {
        this.hq.ReportCasualty(soldier.getId());
        soldaten.remove(soldier);
    }

    public int getAantalSoldiers() {
        return soldaten.size();
    }

    public Army attacks(Army defendingArmy) {
        while (gevechtNogMogelijk(defendingArmy)) {
            this.getFrontMan().attacks(defendingArmy.getFrontMan());
        }
        Army winningArmy = getWinningArmy(defendingArmy);
        winningArmy.ReportVictory();
        return winningArmy;
    }

    private void ReportVictory() {
        this.hq.ReportVictory(getAantalSoldiers());
    }

    private Army getWinningArmy(Army defendingArmy) {
        if (this.getAantalSoldiers() > 0) {
            return this;
        }
        return defendingArmy;
    }

    private boolean gevechtNogMogelijk(Army defendingArmy) {
        return this.getAantalSoldiers() > 0 && defendingArmy.getAantalSoldiers() > 0;
    }

}
