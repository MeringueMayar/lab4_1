package edu.iis.mto.multithread;

import org.junit.Rule;
import org.junit.Test;

import java.util.concurrent.Executor;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class BetterRadarTest {

    @Rule
    public RepeatRule repeatRule = new RepeatRule();

    @Test
    @RepeatRule.Repeat(times = 10000 )
    public void launchPatriotOnceWhenNoticesAScudMissile() {
        Executor executor = Runnable::run;
        PatriotBattery batteryMock = mock(PatriotBattery.class);
        BetterRadar betterRadar = new BetterRadar(batteryMock, executor);
        betterRadar.notice(new Scud());
        verify(batteryMock).launchPatriot();
    }
}
