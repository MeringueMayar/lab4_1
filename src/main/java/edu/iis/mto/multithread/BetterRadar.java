package edu.iis.mto.multithread;

import java.util.concurrent.ExecutorService;

public class BetterRadar {

	private PatriotBattery battery;
	private ExecutorService executorService;

	public BetterRadar(PatriotBattery missle, ExecutorService executorService) {
		this.battery = missle;
		this.executorService = executorService;
	}

	public void notice(Scud enemyMissle) {
		launchPatriot();
	}

	private void launchPatriot() {
		Runnable launchPatriotTask = new Runnable() {

			@Override
			public void run() {
				for (int i = 0; i < 10; i++) {
					battery.launchPatriot();
				}
			}
		};

		executorService.execute(launchPatriotTask);
		// Thread launchingThread = new Thread(launchPatriotTask);
		// launchingThread.start();
	}
}
