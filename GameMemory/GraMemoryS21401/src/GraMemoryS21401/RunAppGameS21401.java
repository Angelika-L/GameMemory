package GraMemoryS21401;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class RunAppGameS21401 extends Application {

    public static void main(String[] args){
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("startLayout.fxml"));
        primaryStage.setTitle("Memory The Game");
        primaryStage.setScene(new Scene(root, 470, 400));  //Height="260.0" prefWidth="425.0">
        primaryStage.show();

    }

}
