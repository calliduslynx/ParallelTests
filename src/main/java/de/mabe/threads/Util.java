package de.mabe.threads;

public class Util {
  public static void zzz(long millis) {
    try {
      Thread.sleep(millis);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  public static void log(Object msg) {
    System.out.println("[" + Thread.currentThread().getName() + "] " + msg);
  }
}
