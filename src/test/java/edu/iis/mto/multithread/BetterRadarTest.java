package edu.iis.mto.multithread;

import org.junit.Test;
import repeat.Repeat;

import java.util.concurrent.Executor;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class BetterRadarTest {
    @Test
    @Repeat(times = 2000)
    public void launchPatriotTenTimesWhenNoticesAScudMissile() {
        Executor executor = command -> command.run();

        PatriotBattery batteryMock = mock(PatriotBattery.class);
        BetterRadar radar = new BetterRadar(batteryMock, 10, executor);

        radar.notice(new Scud());

        verify(batteryMock, times(10)).launchPatriot();
    }

    @Test
    @Repeat(times = 2000)
    public void launchPatriotOnceWhenNoticesAScudMissile() {
        Executor executor = command -> command.run();

        PatriotBattery batteryMock = mock(PatriotBattery.class);
        BetterRadar radar = new BetterRadar(batteryMock, 1, executor);

        radar.notice(new Scud());

        verify(batteryMock, times(1)).launchPatriot();
    }
}
