package edu.iis.mto.multithread;

import java.util.concurrent.*;

public class BetterRadar {
    private ExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
    private PatriotBattery battery;
    private int rockets = 1;

    public BetterRadar(PatriotBattery missle) {
        this.battery = missle;
    }

    public BetterRadar(PatriotBattery missle, ExecutorService executorService) {
        this.executorService = executorService;
        this.battery = missle;
    }

    public int getFiredRockets() {
        return rockets;
    }
    public void setFiredRockets(int rockets){
        this.rockets = rockets;
    }

    public void notice(Scud enemyMissle) {
        launchPatriot();
    }

    private void launchPatriot() {

        executorService.execute( () -> {
            for (int i = 0; i < rockets; i++)
                battery.launchPatriot();
        } );
        executorService.shutdown();
        while(!executorService.isTerminated());

    }
}