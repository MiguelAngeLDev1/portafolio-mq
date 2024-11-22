package com.miguelangelquesada.portafolio.controller;


import com.miguelangelquesada.portafolio.services.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@CrossOrigin(origins = "*")// Permitir solicitudes desde cualquier origen
public class HomeController {

    @Autowired
    private EmailService emailService;

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping("about")
    public String about() {
        return "about";
    }

    @GetMapping("/resume")
    public String resume() {
        return "resume";
    }

    @GetMapping("/services")
    public String services() {
        return "services";
    }

    @GetMapping("/portfolio")
    public String portafolio() {
        return "portfolio";
    }

    @GetMapping("/contact")
    public String contact() {
        return "contact";
    }

    @PostMapping("forms/contact")
    public String handleContactForm(@RequestParam("name")String name,
                                          @RequestParam("email")String email,
                                          @RequestParam("message")String message) {

        String subject = "Nuevo mensaje de conctacto " + name;
        String body = "Nombre: " + name + "\nEmail: " + email + "\nMensaje: " + message;

        emailService.sendEmail("mig.dev1023@gmail.com", subject, body);

        return ("redirect:/portfolio");
    }


}
