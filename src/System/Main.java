package System;
import java.io.IOException;
import System.Model.Item;
import System.View.BidDialogueController;
import System.View.ItemOverviewController;
import System.View.ItemViewController;
import System.View.NewEntryDialogueController;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
public class Main extends Application {
    private Stage primaryStage;
    private BorderPane rootLayout;
    private ObservableList<Item> itemdata = FXCollections.observableArrayList();
    public Main(){
        itemdata.add(new Item("Tires",1000));
    }
    public ObservableList<Item> getItemdata(){
        return itemdata;
    }
    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("BiddingApp");
        initRootLayout();
        showItemOverview();
    }
    public void initRootLayout() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("view/RootLayout.fxml"));
            rootLayout = (BorderPane) loader.load();
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public void showItemOverview(){
        try {

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("view/ItemOverview.fxml"));
            AnchorPane personOverview = (AnchorPane) loader.load();
            rootLayout.setCenter(personOverview);
            ItemOverviewController controller=loader.getController();
            controller.setMain(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void showItem(Item I){
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("view/ItemView.fxml"));
            AnchorPane itemview= (AnchorPane) loader.load();
            rootLayout.setCenter(itemview);
            ItemViewController controller=loader.getController();
            controller.setitem(I);
            controller.setMain(this);
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    public void BidDialog(Item I) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("view/BidDialougue.fxml"));
            AnchorPane page = (AnchorPane) loader.load();
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Bid Higher");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(primaryStage);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);
            BidDialogueController controller = loader.getController();
            controller.setDialogStage(dialogStage);
            controller.setItem(I);
            dialogStage.showAndWait();
            showItem(I);

        } catch (IOException e) {
            e.printStackTrace();

        }
    }
    public void NewEntryDialog(Item I){
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("view/NewEntryDialogue.fxml"));
            AnchorPane page = (AnchorPane) loader.load();
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Edit Item");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(primaryStage);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);
            NewEntryDialogueController controller = loader.getController();
            controller.setDialogStage(dialogStage);
            controller.setItem(I);
            dialogStage.showAndWait();
            showItemOverview();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    public Stage getPrimaryStage() {
        return primaryStage;
    }
    public static void main(String[] args) {
        launch(args);
    }

}
