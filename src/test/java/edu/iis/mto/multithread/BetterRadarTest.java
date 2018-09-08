package edu.iis.mto.multithread;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import org.junit.Test;

public class BetterRadarTest {

    @Test
    public void launchPatriotOnceWhenNoticesAScudMissle() {
        PatriotBattery batteryMock = mock(PatriotBattery.class);
        Executor executor = command -> command.run();
        BetterRadar betterRadar = new BetterRadar(batteryMock, executor);
        betterRadar.notice(new Scud());
        verify(batteryMock).launchPatriot();
    }

}
