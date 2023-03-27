package com.cb.controller;

import com.cb.entity.Student;
import com.cb.repo.IStudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.locks.ReentrantLock;

@RestController
public class StudentController {

    @Autowired
    private IStudentRepo srepo;
    Object obj = new Object();

    private final ReentrantLock lock = new ReentrantLock();

    private final Semaphore semaphore = new Semaphore(1);
    private boolean stopThreads = false;

    private volatile Future<?> future;

    @PostMapping("/save")
    public synchronized ResponseEntity<String> saveStudent(@RequestBody Student student) {
        Integer id;
        try {
            if (future == null || future.isDone() || future.isCancelled()) {
                Callable<Void> task = () -> { srepo.save(student); return null; };
                FutureTask<Void> futureTask = new FutureTask<>(task);
                new Thread(futureTask).start();
                future = futureTask;
                id = student.getId();
            } else {
                stopThreads();
                return ResponseEntity.ok("Request stopped.");
            }
        } catch (Exception e) {
            return ResponseEntity.ok("Error occurred.");
        }
        return ResponseEntity.ok("Student " + id + " saved !!!");
    }

    public synchronized void stopThreads() {
        if (future != null && !future.isDone() && !future.isCancelled()) {
            future.cancel(true);
        }
    }

    @GetMapping("/student")
    public ResponseEntity<List<Student>> getStudents(){
        return ResponseEntity.ok(srepo.findAll());
    }

}
