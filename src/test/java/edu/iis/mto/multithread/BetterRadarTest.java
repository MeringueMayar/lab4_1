package edu.iis.mto.multithread;

import org.junit.Rule;
import org.junit.Test;
import repeat.Repeat;
import repeat.RepeatRule;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class BetterRadarTest {

    @Rule
    public RepeatRule repeatRule = new RepeatRule();
    @Test
    @Repeat( times = 1000 )
    public void launchPatriotOnceWhenNoticesAScudMissle() {
        PatriotBattery batteryMock = mock(PatriotBattery.class);
        BetterRadar radar = new BetterRadar(batteryMock);
        radar.notice(new Scud());

        verify(batteryMock, times(10)).launchPatriot();
    }

}
