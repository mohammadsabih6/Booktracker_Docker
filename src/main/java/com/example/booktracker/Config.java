package com.example.booktracker;
import org.springframework.context.annotation.Bean;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.context.annotation.Configuration;

@EnableRabbit
@Configuration
public class Config {
    @Bean
    public Queue helloQueue() {
        return new Queue("hello");
    }
	@RabbitListener(queues = "hello")
	public void receiver(String recevier) {
		System.out.println(" Received '" + recevier + "'");
	}
    
}
