package edu.iis.mto.multithread;

import java.util.concurrent.Executor;

public class BetterRadar {

    private PatriotBattery battery;
    private Executor executor;

    public BetterRadar(PatriotBattery battery, Executor executor) {
        this.battery = battery;
        this.executor = executor;
    }

    public void notice(Scud enemyMissle) {
        launchPatriot();
    }

    private void launchPatriot() {
        Runnable launchPatriotTask = new Runnable() {

            @Override
            public void run() {
                battery.launchPatriot();
            }
        };

        executor.execute(launchPatriotTask);
    }
}
