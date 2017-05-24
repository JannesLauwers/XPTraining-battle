package be.cegeka.battle;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.verify;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class HQTest {

    @Mock
    HQ hq;

    @Test
    public void enlist_soldier_report() {
        Army army = new Army(hq);
        Soldier soldaat = new Soldier("jantje");

        army.addsoldier(soldaat);
        verify(hq).ReportEnlistment(soldaat.getName());
    }

    @Test
    public void soldier_get_id() {
        Army army = new Army(hq);
        Soldier soldaat = new Soldier("jantje");

        army.addsoldier(soldaat);
        assertNotNull(soldaat.getId());

    }
}
