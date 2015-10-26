package System.View;
import System.Model.Item;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import System.Main;
public class ItemViewController {
    Item I;
    @FXML
        Label itemname;
    @FXML
        Label description;
    @FXML
        Label biddername;
    @FXML
        Label baseprice;
    @FXML
        Label currentprice;
    @FXML
        Button back;
    @FXML
        Button bid;

    Main main;
    public ItemViewController(){
    }
    public void initialize(){

    }
    public void setitem(Item i) {
        I = i;
        setLabels(i);
    }
    public void setLabels(Item I){
        this.itemname.setText(I.getItemname());
        this.description.setText(I.getDescription());
        this.biddername.setText(I.getBiddername());
        this.currentprice.setText(I.getCurrentbid().toString());
        this.baseprice.setText(I.getInitialprice().toString());
    }
    public void setMain(Main main) {
        this.main = main;
    }
    public void handleback(){
        main.showItemOverview();
    }
    public void handlebid(){
        main.BidDialog(I);
    }

}
