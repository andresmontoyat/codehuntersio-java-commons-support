package io.codehunters.commons.util.mail;

import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessagePreparator;

import java.util.Properties;

public class MailHelper {

    public void send(MimeMessagePreparator mimeMessagePreparator, String protocol, String host, int port, String username, String password, boolean auth) {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost(host);
        mailSender.setPort(port);
        mailSender.setUsername(username);
        mailSender.setPassword(password);

        Properties props = mailSender.getJavaMailProperties();
        props.put("mail.transport.protocol", protocol);
        props.put("mail.smtp.auth", auth);
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.debug", "true");

       mailSender.send(mimeMessagePreparator);
    }
}
