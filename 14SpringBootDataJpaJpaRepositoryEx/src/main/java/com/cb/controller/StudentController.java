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
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.concurrent.locks.ReentrantLock;

@RestController
public class StudentController {

    private final ReentrantLock lock = new ReentrantLock();
//    private final Semaphore semaphore = new Semaphore(1);
    @Autowired
    private IStudentRepo srepo;

    private FutureTask<Student> futureTask;

    //    @PostMapping("/save")
    //    public synchronized ResponseEntity<String> saveStudent(@RequestBody Student student) {
    //        Integer id;
    //        try {
    //            if (future == null || future.isDone() || future.isCancelled()) {
    //                Callable<Student> task = () ->  srepo.save(student);
    //                FutureTask<Student> futureTask = new FutureTask<>(task);
    //                new Thread(futureTask).start();
    //                future = futureTask;
    //                id = futureTask.get().getId();
    //            } else {
    //                stopThreads();
    //                return ResponseEntity.ok("Request stopped.");
    //            }
    //        } catch (Exception e) {
    //            return ResponseEntity.ok("Error occurred.");
    //        }
    //        return ResponseEntity.ok("Student " + id + " saved !!!");
    //    }
    //    private ReentrantLock lock = new ReentrantLock();

    //    @PostMapping("/save")
    //    public ResponseEntity<String> saveStudent(@RequestBody Student student) {
    //        try {
    //            semaphore.acquire();
    //            Student savedStudent = srepo.save(student);
    //            Integer id = savedStudent.getId();
    //            return ResponseEntity.ok("Student " + id + " saved !!!");
    //        } catch (Exception e) {
    //            return ResponseEntity.ok("Error occurred.");
    //        } finally {
    //            semaphore.release();
    //        }
    //    }

    //    @PostMapping("/save")
    //    public ResponseEntity<String> saveStudent(@RequestBody Student student) {
    //        boolean locked = false;
    //        try {
    //            locked = lock.tryLock();
    //            if (locked) {
    //                // execute critical section
    //                Integer id = srepo.save(student).getId();
    //                return ResponseEntity.ok("Student " + id + " saved !!!");
    //            } else {
    //                // skip request
    //                return ResponseEntity.ok().build();
    //            }
    //        } catch (Exception e) {
    //            return ResponseEntity.ok("Error occurred.");
    //        } finally {
    //            if (locked) {
    //                lock.unlock();
    //            }
    //        }
    //    }


//    public synchronized void stopThreads() {
//        if (future != null && !future.isDone() && !future.isCancelled()) {
//            future.cancel(true);
//        }
//    }

    @PostMapping("/save")
    public ResponseEntity<String> saveStudent(@RequestBody Student student) {
        try {
            if (lock.tryLock()) {
                if (futureTask == null || futureTask.isDone() || futureTask.isCancelled()) {
                    Callable<Student> task = () -> srepo.save(student);
                    futureTask = new FutureTask<>(task);
                    new Thread(futureTask).start();
                    Student savedStudent = futureTask.get();
                    Integer id = savedStudent.getId();
                    return ResponseEntity.ok("Student " + id + " saved.");
                } else {
                    stopThreads();
                    return ResponseEntity.ok("Request is unable to process.");
                }
            } else {
                return ResponseEntity.ok("Request skipped.");
            }
        } catch (Exception e) {
            return ResponseEntity.ok(e.getMessage());
        } finally {
            lock.unlock();
        }
    }

    public void stopThreads() {
        if (futureTask != null && !futureTask.isDone() && !futureTask.isCancelled()) {
            futureTask.cancel(true);
        }
    }



    @GetMapping("/student")
    public ResponseEntity<List<Student>> getStudents() {
        return ResponseEntity.ok(srepo.findAll());
    }

}
