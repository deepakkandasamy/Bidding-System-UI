package System.View;
import System.Model.Item;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class BidDialogueController {
    @FXML
    private TextField newbid;
    @FXML
    private TextField biddername;
    @FXML
    private Button ret;
    @FXML
    private Button bid;
    private Stage dialogstage;
    private boolean bidClicked = false;
    private Item I;
    @FXML
    private void initialize() {
    }
    public void setDialogStage(Stage dialogstage) {
        this.dialogstage = dialogstage;
    }
    public void setItem(Item I){
        this.I=I;
    }
    public boolean isBidClicked(){
        return bidClicked;
    }
    @FXML
    private void handleBid(){
        if(I.getCurrentbid()<Integer.parseInt(newbid.getText())){
            I.setCurrentbid(Integer.parseInt(newbid.getText()));
            I.setBiddername(biddername.getText());
            bidClicked=true;
            dialogstage.close();
        }
        else {

                Alert alert = new Alert(AlertType.ERROR);
                alert.initOwner(dialogstage);
                alert.setTitle("Bid Is lesser than current bid");
                alert.setHeaderText("Please enter a higher bid!");
                alert.showAndWait();
        }
    }
    @FXML
    private void handleCancel() {
        dialogstage.close();
    }
}
