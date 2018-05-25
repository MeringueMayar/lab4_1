package edu.iis.mto.multithread;

import org.junit.Test;

import java.util.concurrent.Executor;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class BetterRadarTest {

    @Test
    public void launchPatriotLaunchesTenTimesPatriotBattery(){
        PatriotBattery batteryMock = mock(PatriotBattery.class);
        Executor executor = new ExecutorServiceSameThread();

        BetterRadar betterRadar = new BetterRadar(batteryMock).withExecutor(executor);

        betterRadar.notice(new Scud());
        verify(batteryMock, times(10)).launchPatriot();
    }

}