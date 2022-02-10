# Spring MVC Streaming response using SseEmitter.

  

Code samples for streaming response in spring mvc.

  

**Use case**: Send streaming response back to browser/UI.

This enables UI to keep displaying continuous updates from backend.

  

**This is a one-way connection, so you can't send events from a client to a server.**

  

If 2 way communication is required, consider using **websockets** which is a computer communications protocol, providing full-duplex communication channels over a single TCP connection.

  

# References:

 1. https://www.baeldung.com/spring-mvc-sse-streams
    
 2. https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/web/servlet/mvc/method/annotation/SseEmitter.html
 
 3. https://developer.mozilla.org/en-US/docs/Web/API/Server-sent_events/Using_server-sent_events
 4. https://grapeup.com/blog/how-to-build-real-time-notification-service-using-server-sent-events-sse/
