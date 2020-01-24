package nu.t4.opendata.backend.beans;

import at.favre.lib.crypto.bcrypt.BCrypt;
import com.mysql.jdbc.Connection;
import java.security.SecureRandom;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Base64;
import nu.t4.opendata.backend.entities.Credentials;

import javax.ejb.Stateless;
import nu.t4.opendata.backend.ConnectionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Stateless
public class CredentialsBean {

    private static final Logger LOGGER = LoggerFactory.getLogger(CredentialsBean.class);

    /**
     * Creat credentials from basicAuth string
     *
     * @param basicAuth username and password in Base64 encoding
     * @return Returns a credentilas object if successfully decoded the string
     * else returns null
     */
    public Credentials createCredentials(String basicAuth) {
        try {
            basicAuth = basicAuth.substring(6).trim();//Removes "Basic " from string
            byte[] bytes = Base64.getDecoder().decode(basicAuth);
            basicAuth = new String(bytes);
            int colon = basicAuth.indexOf(":");
            String username = basicAuth.substring(0, colon);
            String password = basicAuth.substring(colon + 1);
            return new Credentials(username, password);
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
        }
        return null;
    }

    private static final SecureRandom secureRandom = new SecureRandom(); //threadsafe
    private static final Base64.Encoder base64Encoder = Base64.getUrlEncoder(); //threadsafe

    /**
     * Generates a token for future authentication
     *
     * @return
     */
    public static String generateNewToken() {
        byte[] randomBytes = new byte[24];
        secureRandom.nextBytes(randomBytes);
        return base64Encoder.encodeToString(randomBytes);
    }

    public boolean verifyToken(String token) {;
        try ( Connection connection = ConnectionFactory.getConnection()) {
            PreparedStatement stmt = connection.prepareStatement("SELECT * FROM user WHERE token = ?");
            stmt.setString(1, token);
            ResultSet data = stmt.executeQuery();
            if (data.next()) {
                return true;
            }
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
        }
        return false;
    }

    /**
     * Adds a token to the user
     *
     * @param credentials users credentials
     * @param token token to add
     * @return Returns 1 if success and 0 if failed to set token
     */
    private int addToken(Credentials credentials, String token) {
        try ( Connection connection = ConnectionFactory.getConnection()) {
            PreparedStatement stmt = connection.prepareStatement("UPDATE user SET token = ? WHERE username = ?");
            stmt.setString(1, token);
            stmt.setString(2, credentials.getUsername());
            return stmt.executeUpdate();
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
        }
        return 0;
    }

    /**
     * Checks if credentials are valid, if valid returns a token
     *
     * @param credentials credentials to check
     * @return Returns a token if success else an emtpy string
     */
    public String checkCredentials(Credentials credentials) {
        String token = "";
        try ( Connection connection = ConnectionFactory.getConnection()) {
            String hashedPassword = "";
            PreparedStatement stmt = connection.prepareStatement("SELECT * FROM user WHERE username = ?");
            stmt.setString(1, credentials.getUsername());
            ResultSet data = stmt.executeQuery();
            if (data.next()) {
                hashedPassword = data.getString("hash");
            }
            if (BCrypt.verifyer().verify(credentials.getPassword().toCharArray(), hashedPassword).verified) {
                token = generateNewToken();
                addToken(credentials, token);
            }
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
        }
        return token;

    }

    /**
     * Saves credentials to DB
     *
     * @param credentials credentials to save
     * @return Returns 1 if success else 0 if failed to save credentials
     */
    public int saveCredentials(Credentials credentials) {
        try ( Connection connection = ConnectionFactory.getConnection()) {
            PreparedStatement stmt = connection.prepareStatement("INSERT INTO user (username, hash) VALUES(?, ?)");
            stmt.setString(1, credentials.getUsername());
            String hashedPassword = BCrypt.withDefaults().hashToString(13, credentials.getPassword().toCharArray());
            stmt.setString(2, hashedPassword);
            return stmt.executeUpdate();
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
        }
        return 0;
    }
}
