package edu.iis.mto.multithread;

import org.junit.Test;
import repeat.Repeat;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class BetterRadarTest {
    @Test
    @Repeat(times = 2000)
    public void launchPatriotCorrectNumberOfTimesWhenNoticesAScudMissle() {
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        PatriotBattery batteryMock = mock(PatriotBattery.class);
        BetterRadar radar = new BetterRadar(batteryMock, executorService);

        radar.notice(new Scud());

        executorService.shutdown();
        while (!executorService.isTerminated()) {
        }

        verify(batteryMock, times(10)).launchPatriot();
    }
}
