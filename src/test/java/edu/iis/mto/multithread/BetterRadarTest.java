package edu.iis.mto.multithread;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import repeat.Repeat;
import repeat.RepeatRule;

import java.util.concurrent.Executor;

import static org.mockito.Mockito.*;

public class BetterRadarTest {
    private PatriotBattery batteryMock;
    private BetterRadar radar;
    private Executor executor;

    @Before
    public void setUp() throws Exception {
        batteryMock = mock( PatriotBattery.class );
        executor = command -> command.run();
        radar = new BetterRadar( batteryMock, executor );
    }

    @Rule
    public RepeatRule repeatRule = new RepeatRule();

    @Test
    @Repeat(times = 1000)
    public void launchPatriotTensWhenNoticesAScudMissle() {
        radar.setFiredRockets( 10 );
        radar.notice( new Scud() );
        verify( batteryMock, times( 10 ) ).launchPatriot();
    }

}