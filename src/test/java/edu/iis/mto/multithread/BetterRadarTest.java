package edu.iis.mto.multithread;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static org.mockito.Mockito.times;
import org.junit.Rule;
import org.junit.Test;


import edu.iis.mto.multithread.RepeatRule.Repeat;

public class BetterRadarTest {
    @Rule
    public RepeatRule repeatRule=new RepeatRule();
    
    @Test
    @Repeat(times=20000)
    public void launchPatriotOnceInNewThreadWhenNoticesAScudMissle() {
        PatriotBattery batteryMock=mock(PatriotBattery.class);
        BetterRadar betterRadar = new BetterRadar(batteryMock, Executors.newSingleThreadExecutor());
        betterRadar.notice(new Scud());
        verify(batteryMock, times(10)).launchPatriot();
    }
}
