package com.devtvas.emailservice.core.requests;

public record EmailRequest(String to, String subject, String body) {
}
