package edu.iis.mto.multithread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BetterRadar {

    private PatriotBattery battery;
    private ExecutorService executor;

    public BetterRadar(PatriotBattery missle, ExecutorService executor) {
        this.executor = executor;
        this.battery = missle;
    }

    public void notice(Scud enemyMissle) {
        launchPatriot();
    }

    private void launchPatriot() {

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
