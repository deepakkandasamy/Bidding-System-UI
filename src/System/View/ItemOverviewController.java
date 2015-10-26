package System.View;
import System.Main;
import System.Model.Item;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class ItemOverviewController {
    @FXML
    private TableView<Item> itemTableView;
    @FXML
    private TableColumn<Item,String> itemnamecolumn;
    @FXML
    private TableColumn<Item,Integer> basepricecolumn;
    @FXML
    private Button newentry;
    private Main main;
    public ItemOverviewController(){

    }
    @FXML
    private void initialize(){
        itemnamecolumn.setCellValueFactory(celldata->celldata.getValue().itemnameProperty());
        basepricecolumn.setCellValueFactory(celldata->celldata.getValue().initialpriceProperty().asObject());
        itemTableView.getSelectionModel().selectedItemProperty().addListener((observable,oldvalue,newvalue)->main.showItem(newvalue));
    }
    public void setMain(Main main){
        this.main=main;
        itemTableView.setItems(main.getItemdata());
    }
    @FXML
    private void handleNewItem(){
        Item item= new Item();
        main.NewEntryDialog(item);
        main.getItemdata().add(item);
    }

}
