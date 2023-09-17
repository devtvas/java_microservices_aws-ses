package com.devtvas.emailservice.core.usecases;

import org.springframework.stereotype.Component;

@Component
public interface EmailSenderUseCase {
    //definindo o caso de uso...
    //atraves desse contrato(interface)
    //alguem vai extender os metodos implementando nosso contrato

    void sendEmail(String to, String subject, String body);

}
