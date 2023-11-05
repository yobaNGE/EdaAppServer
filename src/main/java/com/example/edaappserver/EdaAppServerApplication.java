package com.example.edaappserver;

import com.example.edaappserver.requests.RegisterRequest;
import com.example.edaappserver.services.AuthenticationService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.neo4j.Neo4jProperties;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class EdaAppServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(EdaAppServerApplication.class, args);
    }
    @Bean
    public CommandLineRunner commandLineRunner(
            AuthenticationService service
    ){
        return args -> {
            var admin = RegisterRequest.builder()
                    .name("COCK")
                    .surname("AND BALLS")
                    .email("admin@mail.sru")
                    .password("admin")
                    .build();
            System.out.println("Token: " + service.createAdmin(admin).getToken());
        };
    }

}
