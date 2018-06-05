package edu.iis.mto.multithread;

import java.util.concurrent.Executor;

public class BetterRadar {

    private PatriotBattery battery;
    private int firedMissiles;
    private Executor executor;

    public BetterRadar(PatriotBattery missle, int firedMissiles, Executor executor) {
        this.battery = missle;
        this.firedMissiles = firedMissiles;
        this.executor = executor;
    }

    public void notice(Scud enemyMissle) {
        launchPatriot();
    }

    private void launchPatriot() {
        Runnable launchPatriotTask = new Runnable() {

            @Override
            public void run() {
                for (int i = 0; i < firedMissiles; i++) {
                    battery.launchPatriot();
                }
            }
        };
        executor.execute(launchPatriotTask);
    }
}