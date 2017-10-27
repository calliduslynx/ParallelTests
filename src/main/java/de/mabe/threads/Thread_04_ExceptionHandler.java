package de.mabe.threads;

import static de.mabe.threads.Util.log;
import static de.mabe.threads.Util.zzz;

public class Thread_04_ExceptionHandler {
  public static void main(String[] args) {

    // ***** lokaler ExceptionHandler
    Thread t1 = new Thread(() -> {
      zzz(500);
      throw new IllegalStateException("Hoppala");
    });
    t1.setUncaughtExceptionHandler((t, e) -> log("Thread " + t + " hat geworfen: " + e.getMessage()));

    t1.start();

    // ***** globaler ExceptionHandler
    Thread.setDefaultUncaughtExceptionHandler((t, e) -> log("Thread " + t + " hat geworfen: " + e.getMessage()));
    new Thread(() -> {
      zzz(500);
      throw new IllegalStateException("Hoppala");
    }).start();
    new Thread(() -> {
      zzz(500);
      throw new IllegalStateException("Hoppala");
    }).start();
  }
}
