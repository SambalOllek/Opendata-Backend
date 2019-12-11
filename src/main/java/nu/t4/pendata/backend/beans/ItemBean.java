package nu.t4.pendata.backend.beans;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import nu.t4.pendata.backend.entities.Item;

import javax.ejb.Stateless;
import java.util.List;
import nu.t4.pendata.backend.ConnectionFactory;

@Stateless
public class ItemBean {
    public List<Item> getItems(int userId){
        try (Connection connection = ConnectionFactory.getConnection()){
            Statement stmt = connection.createStatement();
            String sql = "SELECT * FROM user";
            ResultSet data = stmt.executeQuery(sql);
            while (data.next()) {
                int id = data.getInt("Id");
                int userId = data.getInt("userId");
                String link = data.getString("link");
                
            }
        } catch (Exception e) {
        }
        return null;
    }

    public int addItem(Item item){
        try (Connection connection = ConnectionFactory.getConnection()){
            Statement stmt = connection.createStatement();
            String sql = String.format( "INSERT INTO ... VALUES (%d, %d, '%s'); "
                    ,);
        } catch (Exception e) {
        }
        return 0;
    }

    public int removeItem(int itemId){
        try (Connection connection = ConnectionFactory.getConnection()){
            Statement stmt = connection.createStatement();
        } catch (Exception e) {
        }
        return 0;
    }
}
