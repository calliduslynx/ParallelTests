package de.mabe.threads;

import static de.mabe.threads.Util.log;
import static de.mabe.threads.Util.zzz;

import java.lang.Thread.State;

public class Thread_01_Properties {
  public static void main(String[] args) throws Exception {


    Thread thread = new Thread(() -> {
      zzz(3000);
    });

    log(thread.getState());
    thread.start();

    while (true) {
      zzz(100);

      // - NEW: noch nicht gestartet
      // - RUNNABLE: läuft
      // - BLOCKED: wartet auf einen Lock, zb. an einem syncronized-Block
      // - WAITING: wartet auf notify()
      // - TIMED_WAITING: wartet in einem sleep()
      // - TERMINATED: beendet
      State state = thread.getState();
      log(state);

      // - isAlive = started, but not yed dead
      boolean alive = thread.isAlive();
      if (!alive) break;
    }


  }
}