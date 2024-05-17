package pl.pjatk.kamlit;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix="my.custom")
public class ConfigProperties {
    private String loginUrl;

    private Credentials credentials;

    public String getLoginUrl() {
        return loginUrl;
    }

    public Credentials getCredentials() {
        return credentials;
    }

    public void setLoginUrl(String loginUrl) {
        this.loginUrl = loginUrl;
    }

    public void setCredentials(Credentials credentials) {
        this.credentials = credentials;
    }

    public void printProperties() {
        System.out.println(this.loginUrl+" "+this.credentials.getUser()+" "+this.credentials.getPassword());
    }


}
