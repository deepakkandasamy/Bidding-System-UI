package System.Model;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.image.Image;

public class Item {
    private final StringProperty itemname;
    private final IntegerProperty initialprice;
    private final StringProperty biddername;
    private final IntegerProperty currentbid;
    private final StringProperty description;
    public Item() {
        this(null,0);
    }
    public Item(String itemname,Integer initialprice){
        this.itemname=new SimpleStringProperty(itemname);
        this.initialprice=new SimpleIntegerProperty(initialprice);
        this.currentbid=new SimpleIntegerProperty(initialprice);
        this.biddername=new SimpleStringProperty("No Bidder Yet");
        this.description=new SimpleStringProperty(itemname + " is a great product.") ;

    }

    public String getBiddername() {
        return biddername.get();
    }

    public StringProperty biddernameProperty() {
        return biddername;
    }

    public void setBiddername(String biddername) {
        this.biddername.set(biddername);
    }

    public Integer getCurrentbid() {
        return currentbid.get();
    }

    public IntegerProperty currentbidProperty() {
        return currentbid;
    }

    public void setCurrentbid(Integer currentbid) {
        this.currentbid.set(currentbid);
    }

    public String getDescription() {
        return description.get();
    }

    public StringProperty descriptionProperty() {
        return description;
    }

    public void setDescription(String description) {
        this.description.set(description);
    }

    public Integer getInitialprice() {
        return initialprice.get();
    }

    public IntegerProperty initialpriceProperty() {
        return initialprice;
    }

    public void setInitialprice(Integer initialprice) {
        this.initialprice.set(initialprice);
    }

    public String getItemname() {
        return itemname.get();
    }

    public StringProperty itemnameProperty() {
        return itemname;
    }

    public void setItemname(String itemname) {
        this.itemname.set(itemname);
    }
}
