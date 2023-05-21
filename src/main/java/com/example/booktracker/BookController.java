package com.example.booktracker;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.amqp.core.Queue;

@RestController
@RequestMapping("/books")
public class BookController {
    @Autowired
    private BookRespository repo;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private Queue queue;
    
    @Scheduled(fixedDelay = 1000, initialDelay = 500)
    public void sendMessage() {
        String message = "This is a message from the Sender";
        this.rabbitTemplate.convertAndSend(queue.getName(), message);
        System.out.println("Sent: '" + message + "'");
    }

    @PostMapping("/post")
    public void saveBook(@RequestBody Book book) {
        sendMessage();
        repo.saveBook(book);
    }
}
