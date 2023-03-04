package com.cb.sched;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Component;


@Component
public class SchedOne {

    @Autowired
    private ThreadPoolTaskExecutor executor;

    @Scheduled(cron = "0/5 * * * * ?")
    @Async("threadPoolTaskExecutor")
    public void jobExecute1() {
        for (int i = 0; i < executor.getMaxPoolSize(); i++) {
            executor.execute(() -> {
                System.out.println("Executing SchedOne !! with Thread : " + Thread.currentThread()
                                .getName() + " Id : " + Thread.currentThread().getId());
            });
        }
    }

    @Scheduled(cron = "0/5 * * * * ?")
    public void jobExecute2() {
        System.out.println("Executing SchedTwo !! with Thread : " + Thread.currentThread()
                        .getName() + " with Id: " + Thread.currentThread().getId());
    }

    @Scheduled(cron = "0/5 * * * * ?")
    public void jobExecute3() {
        System.out.println("Executing SchedThree !! with Thread : " + Thread.currentThread()
                        .getName() + " with Id: " + Thread.currentThread().getId());
    }

    @Scheduled(cron = "0/5 * * * * ?")
    public void jobExecute4() {
        System.out.println("Executing SchedFour !! with Thread : " + Thread.currentThread()
                        .getName() + " with Id: " + Thread.currentThread().getId());
    }

    @Scheduled(cron = "0/5 * * * * ?")
    @Async("threadPoolTaskExecutor")
    public void jobExecute5() {
        System.out.println("Executing SchedFive !! with Thread : " + Thread.currentThread()
                        .getName() + " with Id: " + Thread.currentThread().getId());
    }

    @Scheduled(cron = "0/5 * * * * ?")
    public void jobExecute6() {
        System.out.println("Executing SchedSix !! with Thread : " + Thread.currentThread()
                        .getName() + " with Id: " + Thread.currentThread().getId());
    }

    @Scheduled(cron = "0/5 * * * * ?")
    @Async("threadPoolTaskExecutor")
    public void jobExecute7() {
        System.out.println("Executing SchedSeven !! with Thread : " + Thread.currentThread()
                        .getName() + " with Id: " + Thread.currentThread().getId());
    }
}
