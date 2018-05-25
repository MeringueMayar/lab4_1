package edu.iis.mto.multithread;

import java.util.concurrent.Executor;

public class BetterRadar implements IRadar {
    private PatriotBattery battery;
    private Executor executor;
    private boolean launchInSameThread = true;

    public BetterRadar(PatriotBattery missle) {
        this.battery = missle;
    }

    public BetterRadar withExecutor(Executor executor) {
        this.executor = executor;
        this.launchInSameThread = false;
        return this;
    }

    @Override
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

        for(int i = 0; i < 10; i++) {
            executor.execute(launchPatriotTask);
        }
    }
}
