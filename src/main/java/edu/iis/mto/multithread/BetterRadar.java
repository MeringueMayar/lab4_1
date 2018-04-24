package edu.iis.mto.multithread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class BetterRadar {
    
    private ExecutorService executor;
    private PatriotBattery battery;

    public BetterRadar(PatriotBattery missle, ExecutorService executor) {
        this.battery = missle;
        this.executor = executor;
    }

    public void notice(Scud enemyMissle) {
        launchPatriot();
    }

    private void launchPatriot() {
        executor.submit(() -> {
            for (int i = 0; i < 10; i++) {
                battery.launchPatriot();
            }
        });
        try {
            executor.shutdown();
            executor.awaitTermination(5, TimeUnit.SECONDS);
        }
        catch (InterruptedException e) {
        }
        finally {
            executor.shutdownNow();
        }
    }
    
}
