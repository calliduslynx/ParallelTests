package de.mabe.threads;

import static de.mabe.threads.Util.log;
import static de.mabe.threads.Util.zzz;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class Thread_09_Callables {
  public static void main(String[] args) throws InterruptedException, ExecutionException {
    ExecutorService es = Executors.newCachedThreadPool();


    Callable<String> c = () -> {
      log("started");
      zzz(2000);
      log("finished");
      return "ALL RIGHT";
    };

    // ***** future.get()
    Future<String> stringFuture1 = es.submit(c);
    log(stringFuture1.get()); // get() blockiert bis das Ergebnis da ist und returned es dann

    // ***** future.get() mit timeout
    Future<String> stringFuture2 = es.submit(c);
    try {
      String res = stringFuture2.get(100, TimeUnit.MILLISECONDS); // wie get(), aber nach definierter Zeit kommt TimeoutException
    } catch (TimeoutException toe) {
      toe.printStackTrace();
    }

    // future.isDone()
    Future<String> stringFuture3 = es.submit(c);
    zzz(1000);
    log("isDone: " + stringFuture3.isDone());
    zzz(1100);
    log("isDone: " + stringFuture3.isDone());

    // future auf runnable
    Runnable r = () -> {
      log("started");
      zzz(2000);
      log("finished");
    };
    Future<?> runnableFuture = es.submit(r);
    log(runnableFuture.get());  // get() liefert null


    es.shutdown();
  }
}
