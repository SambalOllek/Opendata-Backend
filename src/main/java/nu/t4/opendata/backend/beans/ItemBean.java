package nu.t4.opendata.backend.beans;

import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import nu.t4.opendata.backend.ConnectionFactory;
import nu.t4.opendata.backend.entities.Item;

import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Stateless
public class ItemBean {

    public List<Item> getItems(){
        try (Connection connection = ConnectionFactory.getConnection()){
            Statement stmt = connection.createStatement();
            String sql = "SELECT * FROM item";
            ResultSet data = stmt.executeQuery(sql);
            while (data.next()) {
                //TODO update so that it takes all item values from db and adds to item obj
                int itemId = data.getInt("Id");
                String link = data.getString("link");
            }
        } catch (Exception e) {
            //TODO: fixa logger
        }
        return null;
    }

    Item addItem(Item item){
        try (Connection connection = ConnectionFactory.getConnection()){
            PreparedStatement stmt = connection.prepareStatement("INSERT INTO item VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)");
            stmt.setString(1, item.getLink());
            //TODO add stmt.set on all values
            if(stmt.executeUpdate() != 0){
                String sql = "LAST_INSERT_ID()";
                ResultSet data = stmt.executeQuery(sql);
                item.setId(data.getInt(1));
            }
        } catch (Exception e) {
            //TODO: fixa logger
        }
        return null;
    }

    int removeItem(int itemId){
        try (Connection connection = ConnectionFactory.getConnection()){
            Statement stmt = connection.createStatement();
        } catch (Exception e) {
            //TODO: fixa logger
        }
        return 0;
    }


}
