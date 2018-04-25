package edu.iis.mto.multithread;

import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

public class BetterRadarTest {

    @Test
    public void test(){
        PatriotBattery batteryMock = mock(PatriotBattery.class);
        ExecutorService executorService = new ExecutorServiceSameThread();

        BetterRadar betterRadar = new BetterRadar(batteryMock).withExecutor(executorService);

        betterRadar.notice(new Scud());
    }

}