package com.test;

import org.springframework.util.StopWatch;

import java.time.Duration;

public class Test {

    public static void main(String[] args) {

        long start = System.nanoTime();
        System.out.println("Start");
        for (int i = 0; i <= Integer.MAX_VALUE / 2; i++) {
            Math.pow(Math.pow(i + 2, 2), i + 3);
        }
        Duration duration = Duration.ofNanos(System.nanoTime() - start);
        System.out.println("Done");
        System.out.println(duration.getNano());
        System.out.println(duration.getNano()/1000);
        System.out.println(duration.getSeconds());
    }

    public static void main1(String[] args) {
        StopWatch sw = new StopWatch();
        sw.start();
        System.out.println("Start");
        for (int i = 0; i <= Integer.MAX_VALUE / 2; i++) {
            Math.pow(Math.pow(i + 2, 2), i + 2);
        }
        sw.stop();
        System.out.println("Done");
        System.out.println(sw.getTotalTimeNanos());
        System.out.println(sw.getTotalTimeMillis());
        System.out.println(sw.getTotalTimeSeconds());

    }
}
