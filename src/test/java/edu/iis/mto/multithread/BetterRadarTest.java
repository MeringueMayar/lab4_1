package edu.iis.mto.multithread;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import org.junit.Rule;
import org.junit.Test;

public class BetterRadarTest {

    @Rule
    public RepeatRule repeatRule = new RepeatRule();

    @Test
    @RepeatRule.Repeat(times = 500)
    public void launchPatriotOnceWhenNoticesAScudMissle() {
        PatriotBattery batteryMock = mock(PatriotBattery.class);
        BetterRadar betterRadar= new BetterRadar(batteryMock);
        betterRadar.notice(new Scud());
        verify(batteryMock).launchPatriot();
    }

}
