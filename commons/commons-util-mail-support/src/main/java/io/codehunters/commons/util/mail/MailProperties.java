package io.codehunters.commons.util.mail;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
public class MailProperties {

    private String host;

    private int port;

    private String username;

    private String password;
    private boolean auth;

    private boolean sslEnabled;

    private boolean starttlsEnabled;

    private boolean debug;
}
