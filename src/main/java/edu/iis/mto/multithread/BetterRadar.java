package edu.iis.mto.multithread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BetterRadar {

    private PatriotBattery battery;
    private int timesLaunched;

    public BetterRadar(PatriotBattery missle) {
        this.timesLaunched = 0;
        this.battery = missle;
    }

    public void notice(Scud enemyMissle) {
        launchPatriot();
    }

    private void launchPatriot() {

        ExecutorService executor = Executors.newFixedThreadPool(1);
        executor.execute( new Runnable() {

            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {

                    battery.launchPatriot();
                }
            }
        });

        executor.shutdown();
        while (!executor.isTerminated()) {
        }
    }
}
