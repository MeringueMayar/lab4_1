package edu.iis.mto.multithread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BetterRadar {
    private ExecutorService executor = Executors.newFixedThreadPool(1);
    private PatriotBattery battery;

    public BetterRadar(PatriotBattery missle) {
        this.battery = missle;
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
            executor.execute(launchPatriotTask);

        executor.shutdown();
        while (!executor.isTerminated()) {
        }
    }
}
