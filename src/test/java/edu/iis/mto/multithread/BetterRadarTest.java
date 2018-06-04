package edu.iis.mto.multithread;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import repeat.Repeat;
import repeat.RepeatRule;

import java.util.concurrent.Executor;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class BetterRadarTest {
    private Executor executor;
    @Before
    public void setup() {
        executor = new Executor() {
            @Override
            public void execute(Runnable arg0) {
                arg0.run();
            }
        };
    }
    @Rule
    public RepeatRule repeatRule = new RepeatRule();
    @Test
    @Repeat( times = 1000 )
    public void launchPatriotOnceWhenNoticesAScudMissle() {
        PatriotBattery batteryMock = mock(PatriotBattery.class);
        BetterRadar radar = new BetterRadar(batteryMock, executor);
        radar.notice(new Scud());

        verify(batteryMock, times(10)).launchPatriot();
    }

}
