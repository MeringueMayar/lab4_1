package edu.iis.mto.multithread;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import static org.mockito.Mockito.times;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import edu.iis.mto.multithread.RepeatRule.Repeat;

public class BetterRadarTest {
    
    @Rule
    public RepeatRule repeatRule = new RepeatRule();
    
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
    
    @Repeat(times = 1000)
    @Test
    public void launchPatriotOnceWhenNoticesAScudMissle() {
        PatriotBattery batteryMock = mock(PatriotBattery.class);
        BetterRadar radar = new BetterRadar(batteryMock, executor);
        radar.notice(new Scud());
        verify(batteryMock, times(10)).launchPatriot();
    }
    
}
