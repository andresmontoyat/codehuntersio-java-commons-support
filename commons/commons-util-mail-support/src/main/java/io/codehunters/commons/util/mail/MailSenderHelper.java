package io.codehunters.commons.util.mail;

import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessagePreparator;

import java.util.Properties;

public class MailSenderHelper {

    private final JavaMailSenderImpl mailSender;

    public MailSenderHelper(String host, int port, String username, String password) {
        this(host, port, username, password, Boolean.TRUE, Boolean.FALSE, Boolean.FALSE, Boolean.TRUE);
    }

    public MailSenderHelper(String host, int port, String username, String password, boolean auth, boolean sslEnabled, boolean starttlsEnabled, boolean debug) {
        mailSender = new JavaMailSenderImpl();
        mailSender.setHost(host);
        mailSender.setPort(port);
        mailSender.setUsername(username);
        mailSender.setPassword(password);

        Properties props = mailSender.getJavaMailProperties();
        props.put("mail.transport.protocol", JavaMailSenderImpl.DEFAULT_PROTOCOL);
        props.put("mail.smtp.auth", auth);

        if (sslEnabled) {
            props.put("mail.smtp.ssl.enable", sslEnabled);
            props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        }

        if (starttlsEnabled) {
            props.put("mail.smtp.starttls.enable", "true");
            props.put("mail.smtp.starttls.required", "true");
        }

        props.put("mail.debug", debug);
    }

    public void send(MimeMessagePreparator mimeMessagePreparator) {
        mailSender.send(mimeMessagePreparator);
    }
}
