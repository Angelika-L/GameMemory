package GraMemoryS21401.serviceGame;

import GraMemoryS21401.exception.DifferenValuesGride;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;

public class ControllerGride {

    @FXML
    TextField sizeGridID;
    Integer sizeGrideValueACT;
    @FXML
    Label worning1;
    @FXML
    Button playGame1;

    public void playGame() throws IOException {
        sizeGrideValueACT = Integer.valueOf(sizeGridID.getText());
        System.out.println("Wybór ustawień grid -- start. Twoj size= "+ sizeGrideValueACT);
        try {
            if ((sizeGrideValueACT%2 == 0) && sizeGrideValueACT>=2) {
                worning1.setText("");
                System.out.println("[SUCCESS]---> Wartość size_gride jest poprawna --> przechodzisz do panelu rozgrywki gry");
                Stage playGameStage;
                Scene containGameStage;
                containGameStage = playGame1.getScene();
                playGameStage = (Stage) containGameStage.getWindow();
                FXMLLoader loaderGame = new FXMLLoader();
                loaderGame.setLocation(getClass().getResource("gameLayout.fxml"));
                Parent root = loaderGame.load(); //(getClass().getResource("gameLayout.fxml"));
                playGameStage.setTitle("Game");
                ControllerGame controllerGame = loaderGame.getController();
                controllerGame.startGameRing(sizeGrideValueACT);
                containGameStage = new Scene(root, 100*sizeGrideValueACT, 50+(100*sizeGrideValueACT));  //eleatyczny grid- wielkość zależy od size Gridu Usera
                playGameStage.setScene(containGameStage);
                playGameStage.show();
                System.out.println("process...");
            } else if(sizeGrideValueACT==null || sizeGrideValueACT<=2) {
                System.out.println("[ERROR null]---> Wartość size_gride jest pusta.");
                worning1.setText("Musisz podać rozmiar powyżej 2.");
                throw new DifferenValuesGride("Wartość size_gride jest pusta");
            }else if(sizeGrideValueACT%2 != 0 && sizeGrideValueACT>=2){
                System.out.println("[ERROR size]---> Wartość size_gride jest nieparzysta:" + sizeGrideValueACT);
                worning1.setText("NIEPOPRAWNY ROZMIAR! Podaj wartość parzystą.");
                throw new DifferenValuesGride("Wartość size_gride jest nieparzysta");
            }
        }catch (DifferenValuesGride e){
            e.printStackTrace();
        }
    }

}
