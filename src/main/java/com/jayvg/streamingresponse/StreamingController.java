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
    
    @GetMapping("/sse")
    public SseEmitter handleSse() {
         SseEmitter emitter = new SseEmitter();
         nonBlockingService.execute(() -> {
             try {
                 emitter.send("/sse" + " @ " + new Date());
                 // sending more events after a sleep to simulate operations 
                 Thread.currentThread().sleep(10000); // 10 seconds wait ..
                 emitter.send("/sse" + " @ " + new Date());
                 emitter.complete();
             } catch (Exception ex) {
                 emitter.completeWithError(ex);
             }
         });
         return emitter;
    }   
}


