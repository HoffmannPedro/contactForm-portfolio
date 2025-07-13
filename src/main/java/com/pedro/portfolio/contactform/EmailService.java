package com.pedro.portfolio.contactform;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
    
    @Autowired
    private JavaMailSender mailSender;

    public void sendContactEmail(ContactForm form) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo("phoffmanndev@gmail.com"); // Destinatario
        message.setSubject("Nuevo mensaje de contacto del portfolio");
        message.setText(
            "Nombre: " + form.getName() + "\n" +
            "Email: " + form.getEmail() + "\n" +
            "Mensaje:\n" + form.getMessage()
        );
        message.setFrom("phoffmanndev@gmail.com"); // El mismo que en application.properties

        mailSender.send(message);
    }
}
