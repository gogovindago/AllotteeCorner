package hsvp.digital.allottee_corner.model;

public class Masteradminmodel {
    public int ItemId;
    public String itemname;

    public Masteradminmodel(int itemId, String ItemName) {
        ItemId = itemId;
        itemname = ItemName;
    }

    public int getItemId() {
        return ItemId;
    }

    public void setItemId(int itemId) {
        ItemId = itemId;
    }

    public String getItemname() {
        return itemname;
    }

    public void setItemname(String itemname) {
        this.itemname = itemname;
    }
}
