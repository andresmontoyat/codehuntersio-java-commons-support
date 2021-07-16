package io.codehunters.commons.util.mail;

import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessagePreparator;

import java.util.Properties;

public class MailSenderHelper {

    private final JavaMailSenderImpl mailSender;

    public MailSenderHelper(MailProperties mailProperties) {
        mailSender = new JavaMailSenderImpl();
        mailSender.setHost(mailProperties.getHost());
        mailSender.setPort(mailProperties.getPort());
        mailSender.setUsername(mailProperties.getUsername());
        mailSender.setPassword(mailProperties.getPassword());

        Properties props = mailSender.getJavaMailProperties();
        props.put("mail.transport.protocol", JavaMailSenderImpl.DEFAULT_PROTOCOL);
        props.put("mail.smtp.auth", mailProperties.isAuth());

        if (mailProperties.isSslEnabled()) {
            props.put("mail.smtp.ssl.enable", mailProperties.isSslEnabled());
            props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
            props.put("mail.smtp.ssl.checkserveridentity", mailProperties.isCheckServerIdentity());
        }

        if (mailProperties.isStarttlsEnabled()) {
            props.put("mail.smtp.starttls.enable", "true");
            props.put("mail.smtp.starttls.required", "true");
        }

        props.put("mail.debug", mailProperties.isDebug());
    }

    public void send(MimeMessagePreparator mimeMessagePreparator) {
        mailSender.send(mimeMessagePreparator);
    }
}
