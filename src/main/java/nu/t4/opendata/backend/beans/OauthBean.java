package nu.t4.opendata.backend.beans;


import com.mysql.jdbc.Connection;
import java.sql.PreparedStatement;
import javax.ejb.Stateless;
import javax.json.JsonObject;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import nu.t4.opendata.backend.ConnectionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Stateless
public class OauthBean {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(OauthBean.class);
    
    private final String CLIENT_ID = "0b4be5c42fd4aad65f85"; 
    private final String CLIENTSECRET = "d57b6fcf3b684b3023a85b9311f583dd4ab30d22";
    
    public String getToken(String code){
        String url = String.format("https://github.com/login/oauth/access_token?client_id=%s&client_secret=%s&code=%s", CLIENT_ID,CLIENTSECRET,code);
        
        Client client = ClientBuilder.newClient();
        String result = client.target(url).request().post(null, String.class);
        return result.substring(13,result.indexOf("&")); 
    }
    
    public JsonObject githubOauth(String token){
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target("https://api.github.com/user?access_token="+token);
        JsonObject data = target.request(MediaType.APPLICATION_JSON).get(JsonObject.class);
        int id = data.getInt("id");
        String name = data.getString("login");
        try (Connection connection = ConnectionFactory.getConnection()){
            PreparedStatement stmt = connection.prepareStatement("INSERT INTO user VALUES(null, ?, null, ?, ?)");
            stmt.setString(1, name);
            stmt.setInt(2, id);
            stmt.setString(3, token);
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
        }
        return data;
    }
}
