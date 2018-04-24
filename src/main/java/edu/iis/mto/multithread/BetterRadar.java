package edu.iis.mto.multithread;

import java.util.concurrent.*;

public class BetterRadar {
    private ExecutorService executorService;
    private PatriotBattery battery;

    public BetterRadar(PatriotBattery missle) {
        this.battery = missle;
        executorService = Executors.newSingleThreadScheduledExecutor();

    }

    public void notice(Scud enemyMissle) {
        launchPatriot();
    }


    private void launchPatriot() {

        executorService.submit( () -> {
            battery.launchPatriot();
        } );
        executorService.shutdown();

        try {
            executorService.awaitTermination( 1, TimeUnit.SECONDS );
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}