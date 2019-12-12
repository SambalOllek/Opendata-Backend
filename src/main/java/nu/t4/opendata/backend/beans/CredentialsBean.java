package nu.t4.opendata.backend.beans;

import nu.t4.opendata.backend.entities.Credentials;

import javax.ejb.Stateless;

@Stateless
public class CredentialsBean {
    public String validateCredentials(Credentials credentials) {
        return "";
    }

    public boolean validateToken(String token) {
        return false;
    }

    public int registerCredentials(Credentials credentials) {
        return 0;
    }
}
