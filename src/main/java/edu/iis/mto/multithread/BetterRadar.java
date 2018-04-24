package edu.iis.mto.multithread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class BetterRadar {

    private PatriotBattery battery;
    
    public BetterRadar (PatriotBattery battery) {
        this.battery=battery;
    }
    public void notice(Scud missle) {
        launchMissle();
    }
    private void launchMissle() {
        ExecutorService executor=Executors.newSingleThreadExecutor();
        executor.submit(() ->
        {
            for (int i = 0; i < 10; i++) {
                battery.launchPatriot();
            }
        });
        
        try {
            executor.shutdown();
            executor.awaitTermination(5, TimeUnit.SECONDS);
        }
        catch(InterruptedException e){
            System.err.println("Executor shutdown interupted");
        }
        finally {
            executor.shutdownNow();
        }
    }
}
