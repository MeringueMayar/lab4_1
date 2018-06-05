package edu.iis.mto.multithread;

import org.junit.Before;
import org.junit.Test;
import repeat.Repeat;

import java.util.concurrent.Executor;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class BetterRadarTest {
    Executor executor;
    PatriotBattery batteryMock;

    @Before
    public void setUp() {
        executor = command -> command.run();
        batteryMock = mock(PatriotBattery.class);
    }

    @Test
    @Repeat(times = 2000)
    public void launchPatriotTenTimesWhenNoticesAScudMissile() {
        BetterRadar radar = new BetterRadar(batteryMock, 10, executor);

        radar.notice(new Scud());

        verify(batteryMock, times(10)).launchPatriot();
    }

    @Test
    @Repeat(times = 2000)
    public void launchPatriotOnceWhenNoticesAScudMissile() {
        BetterRadar radar = new BetterRadar(batteryMock, 1, executor);

        radar.notice(new Scud());

        verify(batteryMock, times(1)).launchPatriot();
    }
}
