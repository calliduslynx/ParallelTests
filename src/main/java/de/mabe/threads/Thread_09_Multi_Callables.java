package de.mabe.threads;

import static de.mabe.threads.Util.zzz;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Thread_09_Multi_Callables {
  public static void main(String[] args) throws InterruptedException, ExecutionException {
    ExecutorService es = Executors.newCachedThreadPool();


    Callable<Double> c = () -> {
      zzz(500);
      return Math.random();
    };


    List<Callable<Double>> list = Collections.nCopies(20, c);

    List<Future<Double>> futures = es.invokeAll(list); // ruft alle auf und gibt Futures auf alles
    for (Future<Double> future : futures) {
      future.get();
    }
    
    
    Double firstResult = es.invokeAny(list); // startet alle, gibt das ERSTE Ergebnis zurück


    es.shutdown();
  }
}
