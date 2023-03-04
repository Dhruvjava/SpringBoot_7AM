package com.cb.jobs;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class JobOne implements Job {

    @Autowired
    private ThreadPoolTaskExecutor executor;


    @Override
    @Async
    public void execute(JobExecutionContext context) throws JobExecutionException {
        List<String> names = Arrays.asList("Dhruv", "Chaitanya", "Sekhar", "Rajesh", "Anil", "Raju", "Swamy", "Pawan", "mani", "Shiva");
        int thread = executor.getMaxPoolSize();
        int partitions = (int)Math.ceil(names.size() / (double)thread);
        AtomicInteger countetr = new AtomicInteger(0);
        IntStream.range(0,thread)
                .forEach(i ->{
                    List<String> partition = names.subList(i*partitions,Math.min((i+1)*partitions,names.size()));
                    executor.execute(()->{
                        partition.forEach(val -> xyz(val));
                        countetr.incrementAndGet();
                    });
                });
    }


//    @Override
//    @Async
//    public void execute(JobExecutionContext context) throws JobExecutionException {
//        List<String> names = Arrays.asList("Dhruv", "Chaitanya", "Sekhar", "Rajesh", "Anil", "Raju", "Swamy", "Pawan", "mani", "Shiva");
//        int threads = executor.getMaxPoolSize();
//        int partitions = (int)Math.ceil(names.size()/(double) threads);
//        List<CompletableFuture<Void>> futures = new ArrayList<>();
//
//        IntStream.range(0, threads)
//                .forEach(i -> {
//                    List<String> partition = names.subList(i* partitions,Math.min((i+1)*partitions,names.size()));
//                    CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
////                        for (int j = 0; j< partition.size(); j+=2){
////                            String str1 = partition.get(j);
////                            String str2 = (j+1 < partition.size()) ? partition.get(j+1) :null;
////                            xyz(str1, str2);
////                        }
//                        partition.forEach(val ->{
//                            xyz(val);
//                        });
//
//                    }, executor);
//                    futures.add(future);
//                });
//
//        CompletableFuture.allOf(futures.toArray(new CompletableFuture[futures.size()]))
//                .join();
//    }


//    @Override
//    @Async
//    public void execute(JobExecutionContext context) throws JobExecutionException {
//        List<String> names = Arrays.asList("Dhruv", "Chaitanya", "Sekhar", "Rajesh", "Anil", "Raju", "Swamy", "Pawan", "mani", "Shiva");
//        int threads = executor.getMaxPoolSize();
//        int partitions = (int) Math.ceil(names.size() / (double) threads);
//
//        CompletableFuture<?>[] futures = new CompletableFuture[threads];
//        AtomicInteger counter = new AtomicInteger(0);
//
//        for (int i = 0; i < threads; i++) {
//            List<String> partition = names.subList(i * partitions, Math.min((i + 1) * partitions, names.size()));
//            futures[i] = CompletableFuture.runAsync(() -> {
////                for (int j = 0; j < partition.size(); j += 2) {
////                    String str1 = partition.get(j);
////                    String str2 = (j + 1 < partition.size()) ? partition.get(j + 1) : null;
////                    xyz(str1, str2);
////                }
//                partition.forEach(val->{
//                    xyz(val);
//                });
//                counter.incrementAndGet();
//            }, executor);
//        }
//
//        CompletableFuture.allOf(futures)
//                .exceptionally(throwable -> {
//                    // handle exception
//                    return null;
//                })
//                .join();
//    }


//    @Override
//    @Async
//    public void execute(JobExecutionContext context) throws JobExecutionException {
//        List<String> names = Arrays.asList("Dhruv", "Chaitanya", "Sekhar", "Rajesh", "Anil", "Raju", "Swamy", "Pawan", "mani", "Shiva");
//        int threads = executor.getMaxPoolSize();
//        int partitions = (int)Math.ceil(names.size()/(double) threads);
//        AtomicInteger counter = new AtomicInteger(0);
//
//        try {
//            for (int i = 0; i < threads; i++) {
//                List<String> partition = names.subList(i * partitions, Math.min((i + 1) * partitions, names.size()));
//                executor.execute(() -> {
//                    try {
//                        for (int j = 0; j < partition.size(); j += 2) {
//                            String str1 = partition.get(j);
//                            String str2 = (j + 1 < partition.size()) ? partition.get(j + 1) : null;
//                            xyz(str1, str2);
//                        }
//                    } catch (Exception e) {
//                        System.out.println("Error executing partition: " + e.getMessage());
//                    } finally {
//                        counter.incrementAndGet();
////                        if (counter.get() == threads) {
////                            executor.shutdown();
////                        }
//                    }
//                });
//            }
//        } catch (Exception e) {
//            System.out.println("Error submitting task to executor: " + e.getMessage());
//        }
//    }


    public void xyz(String i) {
        System.out.println("Job One is running with thread : " + Thread.currentThread().getName() + " Name -> " + i);
    }


}