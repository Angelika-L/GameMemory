package GraMemoryS21401.thead;

import javafx.concurrent.Task;

public class Timekeeper  extends Thread{

    Integer timeGame;
    boolean exit;
    String strTimeGame;
    Integer value;

    public Timekeeper(){
        this.strTimeGame="Czas: ";
        this.timeGame=0;
        this.exit=false;
        this.value=0;
    }

    @Override
    public void run() {

        while (!exit){
            value++;
            strTimeGame="Czas: " + (int) value/10;
            try {
                Thread.sleep(100);
            } catch (InterruptedException e){
                e.printStackTrace();
            }
            toStringTime();
        }
    }

    public void stopTimer(){
        exit = true;
    }

    public String toStringTime(){
        return  this.strTimeGame;
    }


    //inspiracja : https://docs.oracle.com/javafx/2/api/javafx/concurrent/Task.html
//    private void startTime(){
//        Task progressTask = new Task() { //progrmownaie zadańasynhronicznychw javaFX
//            @Override
//            protected Integer call() throws Exception {
//                int value = 0;
//                while (isFinished == false) {
//                    value++;
//                    this.strTimeGame ("Czas: " + (int) value/10);
//                    Thread.sleep(100);
//                }
//                return value;
//            }
//        };
//        timeField.textProperty().bind(progressTask.messageProperty());
//    }
}
