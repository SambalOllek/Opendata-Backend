package nu.t4.opendata.backend.beans;

import java.sql.Connection;
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
            Statement stmt = connection.createStatement();
            String sql = "SELECT * FROM user";
            ResultSet data = stmt.executeQuery(sql);
            while (data.next()) {
                int id = data.getInt("Id");
                userId = data.getInt("userId");
                String link = data.getString("link");
                
            }
        } catch (Exception e) {
            //TODO: fixa logger
        }
        return null;
    }

    public Item addItem(Item item){
        try (Connection connection = ConnectionFactory.getConnection()){
            Statement stmt = connection.createStatement();
            String sql = String.format( "INSERT INTO ... VALUES (%d, %d, '%s'); ");
        } catch (Exception e) {
            //TODO: fixa logger
        }
        return item;
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
