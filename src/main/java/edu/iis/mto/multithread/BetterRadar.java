package edu.iis.mto.multithread;

import java.util.concurrent.Executor;

public class BetterRadar implements Executor {

    private PatriotBattery battery;

    Runnable launchPatriotTask = new Runnable() {

        @Override public void run() {
            battery.launchPatriot();

        }
    };

    @Override public void execute(Runnable command) {
        launchPatriotTask.run();
    }

    public BetterRadar(PatriotBattery missle) {
        this.battery = missle;
    }

    public void notice(Scud enemyMissle) {
        launchPatriot();
    }

    private void launchPatriot() {
        execute(launchPatriotTask);
    }

}
