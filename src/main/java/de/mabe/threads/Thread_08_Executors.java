package de.mabe.threads;

import static de.mabe.threads.Util.log;
import static de.mabe.threads.Util.zzz;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Thread_08_Executors {
  public static void main(String[] args) throws InterruptedException {
    ExecutorService executorService1 = Executors.newCachedThreadPool(); // Threadpool mit wachsender Größe
    ExecutorService executorService2 = Executors.newFixedThreadPool(3); // Threadpool mit fester Größe


    Runnable r = () -> {
      log("started");
      zzz(2000);
      log("finished");
    };

    executorService2.execute(r);
    executorService2.execute(r);
    executorService2.execute(r);

    executorService2.execute(r); // <-- der muss warten bis ein Thread wieder frei ist

    // ExecutorService hat laufende Threads. Werden diese nicht beendet, wird auch das Programm nicht beendet.
    executorService2.shutdown();
  }
}
