package de.mabe.threads;

import static de.mabe.threads.Util.log;
import static de.mabe.threads.Util.zzz;

public class Thread_03_End {
  public static void main(String[] args) {
    // Thread live ends when:
    // - run() exits without error
    // - run() throws a RuntimeException
    // - (call on stop() which is deprecated)
    // - VM is stopped

    new Thread(() -> {
      zzz(2000);
      log("ending");
    }).start();

    new Thread(() -> {
      zzz(3000);
      log("throwing exception");
      throw new RuntimeException("Thread will be dead");
    }).start();

    log("main done");
  }
}
