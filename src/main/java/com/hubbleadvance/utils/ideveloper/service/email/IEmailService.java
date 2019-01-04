package com.hubbleadvance.utils.ideveloper.service.email;

import javax.mail.internet.MimeMessage;

import org.springframework.mail.SimpleMailMessage;

public interface IEmailService {
    void sendSimple(SimpleMailMessage... smm);
    void sendMime(MimeMessage... mm);
    
    void sendCaptcha(String email);
    boolean checkCaptcha(String email, String code);
}
