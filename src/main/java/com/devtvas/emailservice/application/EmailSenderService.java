package com.devtvas.emailservice.application;

import com.devtvas.emailservice.adapters.EmailSenderGateway;
import com.devtvas.emailservice.core.usecases.EmailSenderUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmailSenderService implements EmailSenderUseCase {
    //dependencia
    private final EmailSenderGateway emailSenderGateway;

    @Autowired
    public EmailSenderService(EmailSenderGateway emailGateway){
        this.emailSenderGateway = emailGateway;
    }
    @Override
    public void sendEmail(String to, String subject, String body) {
            this.emailSenderGateway.sendEmail(to,subject,body);
    }
}
