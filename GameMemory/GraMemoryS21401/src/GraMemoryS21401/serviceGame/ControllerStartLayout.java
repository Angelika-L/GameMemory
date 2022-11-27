package GraMemoryS21401.serviceGame;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class ControllerStartLayout {

    @FXML
    Label etykieta;
    @FXML
    Button start1;


    public void start() throws IOException{
        System.out.println("[SUCCESS]---> [Wykryto buttona] -- przechdzisz do wyboru ustawień grid");

        Stage chooseGrideStage;
        Scene containGridStage;

        containGridStage = start1.getScene();
        chooseGrideStage = (Stage) containGridStage.getWindow();

        Parent root =  FXMLLoader.load(getClass().getResource("gameGrideLayoutl.fxml"));
        chooseGrideStage.setTitle("New game");
        containGridStage = new Scene(root, 450, 150);  //prefHeight="135.0" prefWidth="286.0"
        chooseGrideStage.setScene(containGridStage);
        System.out.println("process...");
    }

    public void changeText(){
        etykieta.setText("Zmieniono tekst wtykiety okna");


    }


}
