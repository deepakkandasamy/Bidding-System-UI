package System.View;

import System.Model.Item;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class NewEntryDialogueController {
    @FXML
    private TextField baseprice;
    @FXML
    private TextField itemname;
    @FXML
    private TextField description;
    @FXML
    private Button ok;
    @FXML
    private Button cancel;
    private Stage dialogStage;
    private Item item;
    @FXML
    public void initialize(){

    }
    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }
    public void setItem (Item item){
        this.item=item;
    }
    @FXML
    private void handleOk(){
        item.setItemname(itemname.getText());
        item.setInitialprice(Integer.parseInt(baseprice.getText()));
        item.setCurrentbid(Integer.parseInt(baseprice.getText()));
        item.setDescription(description.getText());
        dialogStage.close();
    }
    @FXML
    private void handleCancel() {
        dialogStage.close();
    }
}
