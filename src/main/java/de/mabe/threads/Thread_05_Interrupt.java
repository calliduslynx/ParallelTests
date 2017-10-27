package de.mabe.threads;

import static de.mabe.threads.Util.log;
import static de.mabe.threads.Util.zzz;

public class Thread_05_Interrupt {
  public static void main(String[] args) {
    // thread.interrupt:
    // - setzt flag: isInterrupted() wenn nicht gerade im sleep
    // - erzeugt InterruptedException, wenn sleep, dann aber kein Flag

    // Unterschied t1.isInterrupted() und t1.interrupted()

    Thread t1 = new Thread(() -> {
      while (true) {
        log("living");
        if (Thread.currentThread().isInterrupted()) {
          log("was interrupted");
          break;
        }
      }
    });
    t1.start();

    zzz(300);
    t1.interrupt();
    zzz(100);
    log(t1.getState()); // = TERMINATED

    zzz(100);
    Thread t2 = new Thread(() -> {
      log("living but sleeping");
      try {
        Thread.sleep(10000);
      } catch (InterruptedException e) {
        log("was interrupted");
      }
    });
    t2.start();


    zzz(1000);
    t2.interrupt();
    zzz(100);
    log(t2.getState()); // = TERMINATED


    zzz(100);
    Thread t3 = new Thread(() -> {
      log("living");
      while (true) {
        if (Thread.currentThread().isInterrupted()) {
          log("> " + Thread.currentThread().isInterrupted()); // liesst nur aus
          log("> " + Thread.interrupted());// liesst aus und setzt zurück
          log("> " + Thread.currentThread().isInterrupted()); // liesst nur aus
          return;
        }
      }
    });
    t3.start();


    zzz(300);
    t3.interrupt();
    zzz(100);
    log(t3.getState()); // = TERMINATED
  }
}
