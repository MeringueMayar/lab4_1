package edu.iis.mto.multithread;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

public class BetterRadar {

    private Executor executor;
    private PatriotBattery battery;

    public BetterRadar(PatriotBattery battery, Executor executor) {
        this.battery = battery;
        this.executor = executor;
    }

    public void notice(Scud missle) {
        launchMissle();
    }

    private void launchMissle() {
        executor.execute(new Runnable() {

            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    battery.launchPatriot();
                }

            }
        });

    }
}
