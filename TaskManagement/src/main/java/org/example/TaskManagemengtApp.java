package org.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Hello world!
 *
 */
@SpringBootApplication
public class TaskManagemengtApp {
    public static void main( String[] args ) {

        System.out.println( "Hello World!" );

        SpringApplication.run(TaskManagemengtApp.class, args);
    }
}
