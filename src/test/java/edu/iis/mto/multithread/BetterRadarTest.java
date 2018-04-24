package edu.iis.mto.multithread;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class BetterRadarTest {

    private BetterRadar betterRadar;
    private PatriotBattery patriotBattery;
    private Scud enemyMissle;

    @Before
    public void setup(){
        patriotBattery = mock(PatriotBattery.class);
        betterRadar = new BetterRadar(patriotBattery);
        enemyMissle = new Scud();
    }
    @Test
    public void launchRocketShouldLaunchPatriotTenTimes(){
        betterRadar.notice(enemyMissle);
        verify(patriotBattery, times(10)).launchPatriot();
    }
}
