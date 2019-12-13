package nu.t4.opendata.backend.beans;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import nu.t4.opendata.backend.ConnectionFactory;
import nu.t4.opendata.backend.entities.Item;

import javax.ejb.Stateless;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class ItemBean {

    /**
     *
     * @return
     */
    public List<Item> getItems(){
        List<Item> items = new ArrayList();
        try (Connection connection = ConnectionFactory.getConnection()){
            Statement stmt = connection.createStatement();
            String sql = "SELECT * FROM item";
            ResultSet data = stmt.executeQuery(sql);
            while (data.next()) {
                Item item = new Item();
                item.setId(data.getInt("id"));
                item.setAddress(data.getString("address"));
                item.setBrand(data.getString("brand"));
                item.setDrivewheel(data.getString("drivewheel"));
                item.setFuel(data.getString("fuel"));
                item.setMilage(data.getInt("milage"));
                item.setPrice(data.getInt("price"));
                item.setLink(data.getString("link"));
                item.setRegnum(data.getString("regnum"));
                item.setModel(data.getString("model"));
                item.setGearbox(data.getString("gearbox"));
                item.setYear(data.getInt("year"));
                items.add(item);
            }
        } catch (Exception e) {
            //TODO: fixa logger
            System.out.println("Error in ItemBean.getItems: " + e.getMessage());
        }
        return items;
    }

    /**
     *
     * @param item
     * @return
     */
    int addItem(Item item){
        try (Connection connection = ConnectionFactory.getConnection()){
            PreparedStatement stmt = connection.prepareStatement("INSERT INTO item VALUES(null, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            stmt.setString(1, item.getLink());
            stmt.setString(2, item.getBrand());
            stmt.setString(3, item.getRegnum());
            stmt.setString(4, item.getAddress());
            stmt.setString(5, item.getModel());
            stmt.setString(6, item.getDrivewheel());
            stmt.setInt(7, item.getMilage());
            stmt.setInt(8, item.getPrice());
            stmt.setString(9, item.getGearbox());
            stmt.setInt(10, item.getYear());
            return stmt.executeUpdate();
        } catch (Exception e) {
            //TODO: fixa logger
            System.out.println("Error in ItemBean.addItem: " + e.getMessage());
        }
        return 0;
    }

    /**
     *
     * @param itemId
     * @return
     */
    int removeItem(int itemId){
        try (Connection connection = ConnectionFactory.getConnection()){
            PreparedStatement stmt = connection.prepareStatement("DELETE FROM item WHERE id = ?");
            stmt.setInt(1, itemId);
            return stmt.executeUpdate();
        } catch (Exception e) {
            //TODO: fixa logger
            System.out.println("Error in ItemBean.removeItem: " + e.getMessage());
        }
        return 0;
    }


}
