package classes;

import java.util.ArrayList;

/**
 * Created by ABoK4Do on 21.02.17.
 */
public class ResultPOJO {
    private ArrayList info = null;

    public ResultPOJO(){};
    public void setResultPOJO(ArrayList info){
        this.info = info;
    }
    public ArrayList getResultPOJO(){
        return this.info;
    }
}
