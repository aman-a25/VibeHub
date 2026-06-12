package com.myorg.vibehub.startup;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class Greetings {

    @Bean
    public CommandLineRunner greetings(){

        return args -> {
            System.out.println("Hello user");
        };

        // now this will run every time the server is started
        // So if we want some entities to be present On the time of user startup or server startup
        // We can just check for that entity to be present or not here and if it is not present then we can just create it
        // and if it is present then we don't need to create it
    }
}
