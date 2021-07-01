package com.htw.whoisdown.email;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
@Component
public class EmailUtils {

    @Value("${spring.mail.port}")
    private int emailPort;

    @Value("${spring.mail.username}")
    private String emailUsername;

    @Value("${spring.mail.password}")
    private String emailPassword;

    @Value("${spring.mail.host}")
    private String emailHost;

    public int getEmailPort() {
        return emailPort;
    }

    public String getEmailUsername() {
        return emailUsername;
    }

    public String getEmailPassword() {
        return emailPassword;
    }

    public String getEmailHost() {
        return emailHost;
    }
}


