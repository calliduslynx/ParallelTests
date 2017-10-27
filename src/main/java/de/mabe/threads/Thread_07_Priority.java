package de.mabe.threads;

import static de.mabe.threads.Util.log;
import static de.mabe.threads.Util.zzz;
import static java.lang.Math.abs;

public class Thread_07_Priority {
  public static void main(String[] args) throws InterruptedException {
    log("MIN_PRIORITY:" + Thread.MIN_PRIORITY);
    log("MIN_PRIORITY:" + Thread.NORM_PRIORITY);
    log("MAX_PRIORITY:" + Thread.MAX_PRIORITY);

    class Counter implements Runnable {
      long counter = 0;

      @Override
      public void run() {
        while (!Thread.currentThread().isInterrupted()) {
          counter++;
        }
      }
    }


    Counter c1 = new Counter();
    Counter c2 = new Counter();
    Thread t1 = new Thread(c1);
    Thread t2 = new Thread(c2);
    t1.start();
    t2.start();

    zzz(1000);
    t1.interrupt();
    t2.interrupt();

    log("------------------------ with same priority");
    log("T1: " + c1.counter + " T2: " + c2.counter + " :: " + abs(c1.counter - c2.counter));

    // ******************************************************************************************************************
    // ******************************************************************************************************************
    // ******************************************************************************************************************
    
    Counter c3 = new Counter();
    Counter c4 = new Counter();
    Thread t3 = new Thread(c3);
    Thread t4 = new Thread(c4);
    t3.setPriority(Thread.MIN_PRIORITY);
    t4.setPriority(Thread.MAX_PRIORITY);
    t3.start();
    t4.start();
    zzz(1000);

    t3.interrupt();
    t4.interrupt();
    log("------------------------ with different priority");
    log("T1: " + c3.counter + " T2: " + c4.counter + " :: " + abs(c3.counter - c4.counter));
  }
}
