package nu.t4.opendata.backend.beans;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import nu.t4.opendata.backend.ConnectionFactory;
import nu.t4.opendata.backend.entities.Item;

import javax.ejb.Stateless;
import java.util.List;

@Stateless
public class ItemBean {

    public List<Item> getItems(int userId){
        try (Connection connection = ConnectionFactory.getConnection()){
            PreparedStatement stmt = connection.prepareStatement("SELECT * FROM user_item_full_info WHERE user_id = ?");
            stmt.setInt(1, userId);
            ResultSet data = stmt.executeQuery();
            while (data.next()) {
                //TODO update so that it takes all item values from db and adds to item obj
                int itemId = data.getInt("Id");
                String link = data.getString("link");
                String username = data.getString("username");
            }
        } catch (Exception e) {
            //TODO: fixa logger
        }
        return null;
    }

    public Item addItem(Item item){
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

    public int removeItem(int itemId){
        try (Connection connection = ConnectionFactory.getConnection()){
            Statement stmt = connection.createStatement();
        } catch (Exception e) {
            //TODO: fixa logger
        }
        return 0;
    }
}
