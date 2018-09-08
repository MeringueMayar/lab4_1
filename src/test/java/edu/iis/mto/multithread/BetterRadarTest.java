package edu.iis.mto.multithread;

import edu.iis.mto.multithread.RepeatRule.Repeat;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import org.junit.Rule;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import org.junit.Test;

public class BetterRadarTest {

    @Rule
    public RepeatRule repeatRule = new RepeatRule();

    @Test
    @Repeat(times = 10)

    public void launchPatriotOnceWhenNoticesAScudMissle() {
        PatriotBattery batteryMock = mock(PatriotBattery.class);
        Executor executor = command -> command.run();
        BetterRadar betterRadar = new BetterRadar(batteryMock, executor);
        betterRadar.notice(new Scud());
        verify(batteryMock).launchPatriot();
    }

}
