package edu.iis.mto.multithread;

import org.junit.Before;
import org.junit.Test;
import repeat.Repeat;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class BetterRadarTest {

    private BetterRadar betterRadar;
    private PatriotBattery patriotBattery;
    private Scud enemyMissle;
    private ExecutorService executor;

    @Before
    public void setup(){
        patriotBattery = mock(PatriotBattery.class);
        betterRadar = new BetterRadar(patriotBattery, Executors.newSingleThreadExecutor());
        enemyMissle = new Scud();
    }
    @Test
    @Repeat( times = 10000 )
    public void launchRocketShouldLaunchPatriotTenTimes(){
        betterRadar.notice(enemyMissle);
        verify(patriotBattery, times(10)).launchPatriot();
    }
}
