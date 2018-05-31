package edu.iis.mto.multithread;

import org.junit.Before;
import org.junit.Test;
import repeat.Repeat;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executor;

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
        enemyMissle = new Scud();
    }
    @Test
    @Repeat( times = 100000 )
    public void launchRocketShouldLaunchPatriotTenTimes(){
        Executor executor = command -> command.run();
        betterRadar = new BetterRadar(patriotBattery, executor);

        betterRadar.notice(enemyMissle);
        verify(patriotBattery, times(10)).launchPatriot();
    }
}
