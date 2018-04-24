package edu.iis.mto.multithread;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.junit.Test;

import repeat.Repeat;

public class BetterRadarTest {

	private ExecutorService executorService = Executors.newSingleThreadExecutor();

	@Test
	@Repeat(times = 1000)
	public void launchPatriotOnceWhenNoticesAScudMissle() {
		PatriotBattery batteryMock = mock(PatriotBattery.class);
		BetterRadar betterRadar = new BetterRadar(batteryMock, executorService);
		betterRadar.notice(new Scud());
		executorService.shutdown();
		while (!executorService.isTerminated()) {
		}
		verify(batteryMock, times(10)).launchPatriot();
	}

}
