package edu.iis.mto.multithread;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.Rule;
import org.junit.Test;

import java.util.concurrent.Executor;

public class RadarTest {
    @Rule
    public RepeatRule repeatRule = new RepeatRule();

    @Test
    @RepeatRule.Repeat(times = 10)
    public void launchPatriotOnceWhenNoticesAScudMissle() {
        PatriotBattery batteryMock = mock(PatriotBattery.class);
        Executor executor = command -> command.run();
        BetterRadar radar = new BetterRadar(batteryMock, executor);
        radar.notice(new Scud());
        verify(batteryMock).launchPatriot();
    }

}
