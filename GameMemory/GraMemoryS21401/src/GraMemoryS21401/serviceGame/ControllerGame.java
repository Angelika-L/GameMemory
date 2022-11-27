package GraMemoryS21401.serviceGame;

import GraMemoryS21401.model.ScoreGame;
import javafx.animation.FadeTransition;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.util.Duration;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

public class ControllerGame  {

    private Boolean exite = false;
    private static final String PATH_IMAGE = "src/GraMemoryS21401/FotyDoGame/";
    private ArrayList<Image> imagesToGride;
    private int nrKlika = 2;

    @FXML
    TextField timerID;
    @FXML
    GridPane gridPane;
    ImageView imageView;

    public Text timerGame = new Text(1,1, "Test");

    //inicjajcja zegara -----------------------------------------??? o.O
    //Timekeeper timekeeper = new Timekeeper();
    //timekeeper.start();

//    @Override
//    public void initialize(URL location, ResourceBundle resources) {
//
//    }



    public void startGameRing(Integer numberGride) throws IOException {
        //inicjacja planszy do gry i logiki

        ScoreGame newGameResult = new ScoreGame(); //nowa rozgrywka
        setImageGridPane(PATH_IMAGE,numberGride);
        registerTimerGame();


        //ruchy i zmiany na kliki

        //dodanie aktualizacji zegara
    }

    private void setImageGridPane(String path, Integer numberGride) throws IOException {
        int no = 1;
       // FileInputStream imageSRC = null;
        BufferedImage imageSRC = null;
        for (int i = 0; i<1;) {
//            imageSRC = new FileInputStream(path + no + ".jpg");
//            //Image image = new Image(inputstream);
//            ArrayList<Image> listaImage = new ArrayList<>();
            imageSRC = new BufferedImage(250,250,BufferedImage.TYPE_INT_ARGB);
            imageSRC = ImageIO.read(new File(path + no + ".jpg"));
            imagesToGride.add(new Image(imageSRC,imageSRC.getWidth()/numberGride,imageSRC.getHeight()/numberGride,no,no));
            no++;
        }
            int sourceWidth = imageSRC.getWidth();
            int sourceHeigth = imageSRC.getHeight();

        //int cutPartWidth = sourceWidth / numberGride;
        //int cutPartHeigth = sourceHeigth / numberGride;

        //https://docs.oracle.com/javase/8/javafx/api/javafx/scene/image/Image.html
        int partNumber = 0;
        for (int x = 0; x < numberGride; x++) {
            for (int y = 0; y < numberGride; y++) {
                if (x == 0 && y == 0) {
                    //imagesToGride.add(new Image(imageSRC,imageSRC.getWidth()/numberGride,imageSRC.getHeight()/numberGride,x,y) );
                } else {
                    //imagesToGride.add(new Image(path + numberGride + ".jpg", cutPartWidth, cutPartHeigth, false, false));
                }
                partNumber++;
            }
        }

        //wylosowanie im miejsc na gridzie i wstawienie:
        Collections.swap(imagesToGride, 0, 1);
        ArrayList<Integer> listColumn = new ArrayList<>();
        ArrayList<Integer> listRow = new ArrayList<>();
        for (int i = 1; i < numberGride; i++) {
            listColumn.add(i);
            listRow.add(i);
        }
        HashMap<Image, int[]> listImageNumber = new HashMap<>();
        //zrobić hsha i iterowac indeksy razem z image -- pozniej tylko wstawic onklika na image i koniex - bedzie sie pokazywac znikac jesli nie ma tych indeksow
        //for(Map.Entry<Image,ArrayList> imagelist: listImageNumber.entrySet()){
        for (int j = 0; j < numberGride; j++) {   //////np. 2X2=4,4x4=16...
            //listImageNumber.add(i+1);
            Random r = new Random();
            int losPic = r.nextInt(imagesToGride.size());
            for (Map.Entry<Image, int[]> imagelist : listImageNumber.entrySet()) {
                if (!(imagelist.getKey() == (imagesToGride.get(losPic))))         ///////////czy obraz juz jest w greadzie
                {                                                               //////////jesli nie ma na liscie wstawianej mozana dodać
                    // //////// losuje miejsce na gridzie:
                    for (int i = 0; i < 2; i++) {
                        int losCol = r.nextInt(listColumn.size());
                        int losRow = r.nextInt(listRow.size());

                        if (!gridPane.contains(losRow, losCol) && imagesToGride.get(losPic) != null) {     //jesli nie ma w grid taakiego pic
                            listImageNumber.put(imagesToGride.get(losPic), new int[]{losRow, losCol});
                            gridPane.add(new ImageView(imagesToGride.get(losPic)), losCol, losRow);
                            System.out.println("dodano pic:" + losRow + "x" + losCol);
                            //imageView.setOnMouseClicked(this::handleMouseClick);
                           //close();
                        }
                    }
                }
            }
        }


//        for (int x = 0; x < numberGride; x++) {
//            for (int y = 0; y < numberGride && count < listaImage.size(); y++) {
//                //ImagePart currentPart = imgPartArr.get(count);
//                if (listaImage.get(count) != null) {
//                    //gridPane.add(setImageView(listaImage.get(count), count), x, y);
//                    ImageView imageView = new ImageView(listaImage.get(count));
//
//
//                }
//
//            }
//        }
    }

    private void handleMouseClick(MouseEvent mouseEvent) {
        if (imageView.getOpacity() == 1 || nrKlika == 0)
             return;
        nrKlika--;
         if (imageView == null) {
             imageView = this.imageView;
             lookAtCard(() -> {});
         }
         else {
             lookAtCard(() -> {
//                 if (!imageView.getImage().equals(other.text.getText())) {
//                     imageView.close();
//                     this.close();
//                 }
//                 imageView = null;
//                 nrKlika = 2;
             });
         }

    }
    public void lookAtCard(Runnable action) {
        FadeTransition ft = new FadeTransition(Duration.seconds(0.5), imageView);
        ft.setToValue(1);
        ft.setOnFinished(e -> action.run());
        ft.play();
    }

    public void close() {
        FadeTransition ft = new FadeTransition(Duration.seconds(0.5), imageView);
        ft.setToValue(0);
        ft.play();
    }

    /**
     *wstawienie grida:
     **/

    /**
     * metoda wstawiania zdjęc do grida:?
     **/

    /**
     * zapisanie wyniku do obiekty rozgrywki --> aktualizacja logu z wynikami i wczytwnie go do wynikow
     **/


    /**
    * task watek asynchroniczny dla javafx
    * pomoce net: https://stackoverflow.com/questions/45144059/how-to-add-change-listener-to-message-property-of-task-in-javafx
     **/

    private void registerTimerGame(){
        Task task = new Task<Double>() {
            @Override
            protected Double call() throws Exception {
                Integer timeS = 0;
                Double timeM = 0.00;
                while (exite) {
                    timeS++;
                    if (timeS == 60) {
                        timeM++;
                        timeS=0;
                    } else {
                        updateMessage(timeM + ":" + (timeS / 10));
                        Thread.sleep(100);
                    }
                }
                    return timeM;
            }
        };
        timerGame.textProperty().bind(task.messageProperty());
    }


}
