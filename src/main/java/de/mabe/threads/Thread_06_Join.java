package de.mabe.threads;

import static de.mabe.threads.Util.log;
import static de.mabe.threads.Util.zzz;

public class Thread_06_Join {
  public static void main(String[] args) throws InterruptedException {
    Thread t1 = new Thread(() -> {
      log("living");
      zzz(500);
      log("ending");
    });
    t1.start();

    log("waiting for finish");
    t1.join();
    log("t1 finished");

    // ******************************************************************************************************************

    Thread t2 = new Thread(() -> {
      log("living");
      zzz(1000);
      log("ending");
    });
    t2.start();

    log("waiting for finish, but only 500ms");
    t2.join(500); // wartet 500ms und geht dann einfach weiter
    log("t2 finished");
  }
}
