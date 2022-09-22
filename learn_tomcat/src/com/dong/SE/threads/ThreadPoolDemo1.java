package com.dong.SE.threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author dfx
 */
public class ThreadPoolDemo1 {
    public static void main(String[] args) {
        ExecutorService es = Executors.newFixedThreadPool(2);
        es.submit(new RunnableImpl3());
        es.submit(new RunnableImpl3());
        es.submit(new RunnableImpl3());

        es.shutdown();
    }
}
