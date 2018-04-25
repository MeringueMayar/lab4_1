package edu.iis.mto.multithread;

import java.util.concurrent.ExecutorService;

public class BetterRadar implements IRadar {
    private PatriotBattery battery;
    private ExecutorService executorService;
    private boolean launchInSameThread = true;
    private int launchNumber = 10;

    public BetterRadar(PatriotBattery missle) {
        this.battery = missle;
    }

    public BetterRadar withExecutor(ExecutorService executorService) {
        this.executorService = executorService;
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

        for(int i = 0; i < launchNumber; i++) {
            executorService.execute(launchPatriotTask);
        }
    }
}
