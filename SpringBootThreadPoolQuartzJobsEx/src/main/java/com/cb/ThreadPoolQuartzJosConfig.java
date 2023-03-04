package com.cb;

import com.cb.jobs.JobOne;
import com.cb.jobs.JobThree;
import com.cb.jobs.JobTwo;
import org.quartz.spi.JobFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.scheduling.quartz.CronTriggerFactoryBean;
import org.springframework.scheduling.quartz.JobDetailFactoryBean;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.scheduling.quartz.SpringBeanJobFactory;

@Configuration
@EnableAsync
public class ThreadPoolQuartzJosConfig {

//    @Autowired
//    private JobFactory jobFactory;

    @Autowired
    private ApplicationContext applicationContext;


    @Bean
    public SchedulerFactoryBean schedulerFactoryBean() {
        SchedulerFactoryBean factory = new SchedulerFactoryBean();
        factory.setOverwriteExistingJobs(true);
        factory.setAutoStartup(true);
        factory.setJobFactory(jobFactory());
        factory.setTriggers(jobOneTrigger().getObject(), jobTwoTrigger().getObject(), jobThreeTrigger().getObject());

        factory.setTaskExecutor(threadPoolTaskExecutor());
        return factory;
    }

    @Bean
    public JobDetailFactoryBean jobOneDetail() {
        JobDetailFactoryBean factoryBean = new JobDetailFactoryBean();
        factoryBean.setJobClass(JobOne.class);
        factoryBean.setDurability(true);
        return factoryBean;
    }

    @Bean
    public CronTriggerFactoryBean jobOneTrigger() {
        CronTriggerFactoryBean factoryBean = new CronTriggerFactoryBean();
        factoryBean.setJobDetail(jobOneDetail().getObject());
        factoryBean.setCronExpression("0/5 * * * * ?");
        return factoryBean;
    }

    @Bean
    public JobDetailFactoryBean jobTwoDetail() {
        JobDetailFactoryBean factoryBean = new JobDetailFactoryBean();
        factoryBean.setJobClass(JobTwo.class);
        factoryBean.setDurability(true);
        return factoryBean;
    }

    @Bean
    public CronTriggerFactoryBean jobTwoTrigger() {
        CronTriggerFactoryBean factoryBean = new CronTriggerFactoryBean();
        factoryBean.setJobDetail(jobTwoDetail().getObject());
        factoryBean.setCronExpression("0/5 * * * * ?");
        return factoryBean;
    }

    @Bean
    public JobDetailFactoryBean jobThreeDetail() {
        JobDetailFactoryBean factoryBean = new JobDetailFactoryBean();
        factoryBean.setJobClass(JobThree.class);
        factoryBean.setDurability(true);
        return factoryBean;
    }

    @Bean
    public CronTriggerFactoryBean jobThreeTrigger() {
        CronTriggerFactoryBean factoryBean = new CronTriggerFactoryBean();
        factoryBean.setJobDetail(jobThreeDetail().getObject());
        factoryBean.setCronExpression("0/5 * * * * ?");
        return factoryBean;
    }

    @Bean
    public ThreadPoolTaskExecutor threadPoolTaskExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(5);
        executor.setMaxPoolSize(5);
        executor.setQueueCapacity(20);
        executor.setThreadNamePrefix("dhruv-pool");
        return executor;
    }

    @Bean
    public JobFactory jobFactory(){
        SpringBeanJobFactory jobFactory = new SpringBeanJobFactory();
        jobFactory.setApplicationContext(applicationContext);
        return jobFactory;
    }
}
