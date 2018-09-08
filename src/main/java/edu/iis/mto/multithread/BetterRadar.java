package edu.iis.mto.multithread;

import java.util.concurrent.Executor;

public class BetterRadar implements RadarInterface{

    private PatriotBattery battery;
    private Executor executor;

    public BetterRadar(PatriotBattery missile) {
        this.battery = missile;
    }

    BetterRadar(PatriotBattery missile, Executor executor) {
        this.battery = missile;
        this.executor = executor;
    }

    public void notice(Scud enemyMissile) {
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
