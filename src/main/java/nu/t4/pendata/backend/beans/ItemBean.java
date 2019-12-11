package nu.t4.pendata.backend.beans;

import nu.t4.pendata.backend.entities.Item;

import javax.ejb.Stateless;
import java.util.List;

@Stateless
public class ItemBean {
    public List<Item> getItems(int userId){
        return null;
    }

    public int addItem(Item item){
        return 0;
    }

    public int removeItem(int itemId){
        return 0;
    }
}
