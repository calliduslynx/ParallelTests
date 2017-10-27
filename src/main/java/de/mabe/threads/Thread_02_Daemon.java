package de.mabe.threads;

import static de.mabe.threads.Util.log;
import static de.mabe.threads.Util.zzz;

public class Thread_02_Daemon {
  public static void main(String[] args) throws Exception {

    // if thread is configured as daemon, it shuts automatically down if main is down
    // isDaemon=true  --> shuts automatically down
    // isDaemon=false --> keeps application alive even if main thread is finished
    boolean isDaemon = true;


    Thread thread = new Thread(() -> {
      while (true) {
        zzz(500);
        log("Thread still alive");
      }
    });
    thread.setDaemon(isDaemon);
    thread.start();


    Thread.sleep(1000);
    log("Main finished");
  }
}
