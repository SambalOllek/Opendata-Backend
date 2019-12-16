package nu.t4.opendata.backend.beans;

import nu.t4.opendata.backend.entities.Credentials;

import javax.ejb.Stateless;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Stateless
public class CredentialsBean {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(CarBean.class);
    
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
