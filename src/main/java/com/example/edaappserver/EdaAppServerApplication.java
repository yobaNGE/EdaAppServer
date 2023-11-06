package com.example.edaappserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EdaAppServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(EdaAppServerApplication.class, args);
    }
//    @Bean
//    public CommandLineRunner commandLineRunner(
//            AuthenticationService service
//    ){
//        return args -> {
//            var admin = RegisterRequest.builder()
//                    .name("COCK")
//                    .surname("AND BALLS")
//                    .email("admin@mail.sru")
//                    .password("admin")
//                    .build();
//            System.out.println("Token: " + service.createAdmin(admin).getToken());
//        };
//    }

}
