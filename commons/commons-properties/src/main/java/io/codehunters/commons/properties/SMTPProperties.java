package io.codehunters.commons.properties;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
public class SMTPProperties {

    private String fromDisplayName;

    private String from;

    private String replyTo;

    private String host;

    private int port;

    private String username;

    private String password;

    private boolean auth;

    private boolean sslEnabled;

    private boolean starttlsEnabled;

    private boolean debug;

    private boolean checkServerIdentity;
}
