package com.hubbleadvance.utils.ideveloper.service.email.impl;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.hubbleadvance.utils.ideveloper.service.email.IEmailService;
@Service
public class EmailServiceImpl implements IEmailService{
    @Autowired
    private JavaMailSender mailSender;
    
    @Override
    public void sendSimple(SimpleMailMessage... smm) {
        mailSender.send(smm);
    }

    @Override
    public void sendMime(MimeMessage... mm) {
        // TODO Auto-generated method stub
        mailSender.send(mm);
    }

    @Override
    public void sendCaptcha(String email) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public boolean checkCaptcha(String email, String code) {
        // TODO Auto-generated method stub
        return false;
    }

}
