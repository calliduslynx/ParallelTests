package de.mabe.threads;

import static de.mabe.threads.Util.log;
import static de.mabe.threads.Util.zzz;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Thread_10_Scheduled {
  public static void main(String[] args) throws InterruptedException, ExecutionException {
    ScheduledExecutorService es = Executors.newScheduledThreadPool(1);


    Runnable r = () -> {
      log("CALLED");
    };

    es.schedule(r, 2, TimeUnit.SECONDS); // starte mit 2 sec Verzögerung
    zzz(3000);

    long startDelay = 2; // seconds
    long repeatDelay = 1; // second
    
    log("starte sheduler");
    es.scheduleAtFixedRate(r, startDelay, repeatDelay, TimeUnit.SECONDS);
    
    zzz(10000);

    es.shutdown();
  }
}
