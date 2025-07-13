package com.pedro.portfolio.contactform;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*") // Permite conexiones desde cualquier frontend
@RequestMapping("/contact")
public class ContactController {
    
    @Autowired
    private EmailService emailService;

    @PostMapping
    public ResponseEntity<String> submitContactForm(@RequestBody ContactForm form) {
        try {
            emailService.sendContactEmail(form);
            return ResponseEntity.ok("Mensaje enviado correctamente.");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error al enviar el mensaje.");
        }
    }
}
