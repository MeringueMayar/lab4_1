package edu.iis.mto.multithread;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.junit.Rule;
import org.junit.Test;

import repeat.Repeat;
import repeat.RepeatRule;

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
