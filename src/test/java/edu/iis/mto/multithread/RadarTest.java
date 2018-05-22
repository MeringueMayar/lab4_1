package edu.iis.mto.multithread;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import org.junit.Test;

import edu.iis.mto.multithread.RepeatRule.Repeat;

public class RadarTest {

    @Test
    @Repeat (times=1000)
    public void launchPatriotOnceWhenNoticesAScudMissle() {
        PatriotBattery batteryMock = mock(PatriotBattery.class);
        Radar radar = new Radar(batteryMock);
        radar.notice(new Scud());
        verify(batteryMock, times(10)).launchPatriot();
    } 
}

