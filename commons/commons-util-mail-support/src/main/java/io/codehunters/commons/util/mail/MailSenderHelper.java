package io.codehunters.commons.util.mail;

import io.codehunters.commons.properties.SMTPProperties;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessagePreparator;

import java.util.Properties;

public class MailSenderHelper {

    protected final JavaMailSenderImpl mailSender;

    protected final SMTPProperties smtpProperties;

    public MailSenderHelper(SMTPProperties smtpProperties) {
        this.smtpProperties = smtpProperties;

        mailSender = new JavaMailSenderImpl();
        mailSender.setHost(smtpProperties.getHost());
        mailSender.setPort(smtpProperties.getPort());
        mailSender.setUsername(smtpProperties.getUsername());
        mailSender.setPassword(smtpProperties.getPassword());

        Properties props = mailSender.getJavaMailProperties();
        props.put("mail.transport.protocol", JavaMailSenderImpl.DEFAULT_PROTOCOL);
        props.put("mail.smtp.auth", smtpProperties.isAuth());

        if (smtpProperties.isSslEnabled()) {
            props.put("mail.smtp.ssl.enable", smtpProperties.isSslEnabled());
            props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
            props.put("mail.smtp.ssl.checkserveridentity", smtpProperties.isCheckServerIdentity());
        }

        if (smtpProperties.isStarttlsEnabled()) {
            props.put("mail.smtp.starttls.enable", "true");
            props.put("mail.smtp.starttls.required", "true");
        }

        props.put("mail.debug", smtpProperties.isDebug());
    }

    public void send(MimeMessagePreparator mimeMessagePreparator) {
        mailSender.send(mimeMessagePreparator);
    }
}
