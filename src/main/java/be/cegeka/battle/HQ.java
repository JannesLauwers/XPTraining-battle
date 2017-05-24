package be.cegeka.battle;


public class HQ implements IHeadquarters {

    private int uitTeDelenId = 1;

    @Override
    public int ReportEnlistment(String soldierName) {
        uitTeDelenId++;
        return uitTeDelenId;
    }

    @Override
    public void ReportCasualty(int soldierId) {
        throw new UnsupportedOperationException("implement me (after test)");
    }

    @Override
    public void ReportVictory(int remainingNumberOfSoldiers) {
        throw new UnsupportedOperationException("implement me (after test)");
    }

}
