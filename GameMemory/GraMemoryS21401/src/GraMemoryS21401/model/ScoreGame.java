package GraMemoryS21401.model;

public class ScoreGame {

    String nameGamer;
    String timeScore;
    Integer grideSize;
    Double scoreResults;
    Integer lookCards;
    Integer firstGuessing;

    public ScoreGame(){
        this.nameGamer=null;
        this.timeScore=null;
        this.grideSize=null;
        this.scoreResults=null;
        this.lookCards=null;
        this.firstGuessing=null;
    }

    public void updateScore(String nameGamer, String timeScore, Integer grideSize, Integer lookCards, Integer firstGuessing){
        this.nameGamer=nameGamer;
        this.timeScore=timeScore;
        this.grideSize=grideSize;
        this.lookCards=lookCards;
        this.firstGuessing=firstGuessing;
        this.calculateScoreResults(timeScore, grideSize, lookCards, firstGuessing);
    }

    public void calculateScoreResults(String timeScore, Integer grideSize, Integer lookCards, Integer firstGuessing){
        Integer timeSecunde = 0;
        if(timeScore.substring(0,1).equals("0")||timeScore.substring(0,1).equals("00")){
            timeSecunde = Integer.valueOf(timeScore.substring(2,3));
        } else{
            timeSecunde = Integer.valueOf(timeScore.substring(2,3));
            timeSecunde += Integer.valueOf(timeScore.substring(0,1));
        }
        Double results = (grideSize/timeSecunde) + (double) firstGuessing; // - (lookCards/0.5);
        this.scoreResults=results;
    }

    public void updateScoreResults(String timeScore, Double scoreResults, Integer grideSize, Integer lookCards){
    }

/**
*Ranking liczony jest na podstawie czasu i wielkości planszy
 * (np. punkty = wielkość planszy/czas w sekundach).
 * W rankingu należy także dodać punkty zależnie od ilości poprawnie odgadniętych pierwszych par.
 * Ranking powinien być posortowany malejąco względem liczby uzyskanych punktów.
 **/



}
