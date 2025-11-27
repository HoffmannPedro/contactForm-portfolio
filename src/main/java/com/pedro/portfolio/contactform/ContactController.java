package com.pedro.portfolio.contactform;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*") 
@RequestMapping("/contact")
public class ContactController {
    
    @Autowired
    private EmailService emailService;

    @PostMapping
    public ResponseEntity<String> submitContactForm(@RequestBody ContactForm form) {
        try {
            System.out.println("Intentando enviar correo de: " + form.getEmail()); // Log de depuración
            emailService.sendContactEmail(form);
            return ResponseEntity.ok("Mensaje enviado correctamente.");
        } catch (Exception e) {
            System.err.println("ERROR CRÍTICO AL ENVIAR CORREO:"); 
            e.printStackTrace(); // Esto imprimirá todo el detalle del error en Render
            // ----------------------------------------------
            return ResponseEntity.status(500).body("Error al enviar el mensaje.");
        }
    }
}