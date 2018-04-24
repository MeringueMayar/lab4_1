package edu.iis.mto.multithread;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import repeat.Repeat;
import repeat.RepeatRule;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static org.mockito.Mockito.*;

public class BetterRadarTest {
    private PatriotBattery batteryMock;
    private BetterRadar radar;
    private ExecutorService executorService;

    @Before
    public void setUp() throws Exception {
        batteryMock = mock( PatriotBattery.class );
        executorService = Executors.newSingleThreadExecutor();
        radar = new BetterRadar( batteryMock , executorService);
    }
    @Rule
    public RepeatRule repeatRule = new RepeatRule();

    @Test
    @Repeat(times = 1000)
    public void launchPatriotOnceWhenNoticesAScudMissle() {
        radar.setFiredRockets( 1 );
        radar.notice( new Scud() );
        verify( batteryMock , times( 1 )).launchPatriot();
    }
    @Test
    @Repeat(times = 1000)
    public void launchPatriotTensWhenNoticesAScudMissle() {
        radar.setFiredRockets( 10 );
        radar.notice( new Scud() );
        verify( batteryMock , times( 10 )).launchPatriot();
    }

}