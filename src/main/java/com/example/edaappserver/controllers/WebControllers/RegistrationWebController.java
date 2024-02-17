package com.example.edaappserver.controllers.WebControllers;

import com.example.edaappserver.repositories.UserRepository;
import com.example.edaappserver.requests.RegisterRequest;
import com.example.edaappserver.services.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping(path = "registration")
public class RegistrationWebController {
    private final AuthenticationService authenticationService;
    private final UserRepository userRepository;

    @GetMapping()
    public String registration(){
        return "registration";
    }

    @PostMapping()
    public String submitRegistration(Model model , RegisterRequest registerRequest){
        System.out.println(userRepository.findByEmail(registerRequest.getEmail()));
        if (userRepository.findByEmail(registerRequest.getEmail()).isEmpty()){
            authenticationService.register(registerRequest);
        }
        else {
            model.addAttribute("errorMessage", "Email " + registerRequest.getEmail() + " уже зарегистрирован");
            return "registration";
        }

        return "redirect:food/page";
    }

}
