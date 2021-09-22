package io.codehunters.commons.properties;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
