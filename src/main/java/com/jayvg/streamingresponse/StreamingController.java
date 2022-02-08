package com.jayvg.streamingresponse;

import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

@Controller
public class StreamingController {
    private ExecutorService nonBlockingService = Executors
      .newCachedThreadPool();
    
    @GetMapping("/emit-job-updates")
    public SseEmitter handleSse() {
         SseEmitter emitter = new SseEmitter();
         nonBlockingService.execute(() -> {
             try {
                 emitter.send("Starting Job execution at " + " @ " + new Date());
                 // sending more events after a sleep to simulate operations 
                 Thread.currentThread().sleep(5000); // 5 seconds wait ..
                 emitter.send("Job execution in-progress " + " @ " + new Date());
                 Thread.currentThread().sleep(10000); // 10 seconds wait ..
                 emitter.send("Job execution completed successfully " + " @ " + new Date());
                 emitter.complete();
             } catch (Exception ex) {
                 emitter.completeWithError(ex);
             }
         });
         return emitter;
    }   
}


