package nu.t4.opendata.backend.beans;

import nu.t4.opendata.backend.entities.Item;

import javax.ejb.Stateless;
import java.util.List;

@Stateless
public class UserItemBean {

    public List<Item> getUserItems(int userId) {
        return null;
    }

    public Item addUserItem(Item item) {
        return null;
    }

    public int deleteUserItem() {
        return 0;
    }
}
