package edu.iis.mto.multithread;

import java.util.concurrent.*;

public class ExecutorServiceSameThread implements Executor {
    @Override
    public void execute(Runnable command) {
        command.run();
    }
}
