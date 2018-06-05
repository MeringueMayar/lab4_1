package edu.iis.mto.multithread;

import java.util.concurrent.Executor;

public class BetterRadar {
    private Executor executor;
    private PatriotBattery battery;
    private int rockets;

    public BetterRadar(PatriotBattery missle) {
        this.battery = missle;
    }

    public BetterRadar(PatriotBattery missle, Executor executor) {
        this.executor = executor;
        this.battery = missle;
    }

    public int getFiredRockets() {
        return rockets;
    }

    public void setFiredRockets(int rockets) {
        this.rockets = rockets;
    }

    public void notice(Scud enemyMissle) {
        launchPatriot();
    }

    private void launchPatriot() {
        executor.execute( () -> {
            for (int i = 0; i < rockets; i++)
                battery.launchPatriot();
        } );
    }
}