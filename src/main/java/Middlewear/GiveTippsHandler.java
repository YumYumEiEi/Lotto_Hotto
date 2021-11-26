package Middlewear;

import ActionObjects.ActionObject;
import ActionObjects.TippActionObject;
import Backend.Backend;
import BackendObjects.Tipp;
import BackendObjects.User;
import Frontend.GiveTippsFrontend;

public class GiveTippsHandler extends GiveTippsMiddlewear {

    public GiveTippsHandler(GiveTippsFrontend frontend, Backend backend){
        this.frontend = frontend;
        this.backend = backend;
    }

    @Override
    protected boolean isTippLegal(Tipp givenTipp, String userID) {
        return areSevenNumbersPicked(givenTipp) && isOneSuperzahlPicked(givenTipp) && isTippADuplicat(givenTipp, userID);
    }

    @Override
    protected boolean areSevenNumbersPicked(Tipp givenTipp) {
        if(givenTipp.getTippedNumbers().length == 7){
            return true;
        }else{
            frontend.showNotSevenNumbersPickedErrorMessage();
            return false;
        }
    }

    @Override
    protected boolean isOneSuperzahlPicked(Tipp givenTipp) {
        if(givenTipp.getSuperzahl().equals("")){
            frontend.showNoSuperzahlPickedErrorMessage();
            return false;
        }else{
            return true;
        }
    }

    @Override
    protected boolean isTippADuplicat(Tipp givenTipp, String userID) {
        if(backend.isTippAlreaddyGiven(givenTipp, userID )){
            frontend.showTippAlreaddyThereErrorMessage();
            return false;
        }else{
            return true;
        }
    }

    @Override
    protected void giveTipp(TippActionObject performedAction) {
        String userID = performedAction.getUserID();
        String[] tippedNumbers = performedAction.getTippedNumbers();
        String superzahl  = performedAction.getSuperzahl();
        String nextZiehungID = backend.getNextDrawing().getID();

        Tipp givenTipp = new Tipp(tippedNumbers, superzahl, userID, nextZiehungID);

        if(isTippLegal(givenTipp, userID)){
            backend.saveTipp(givenTipp);
        }

    }

    @Override
    public void heandleAction(ActionObject performedAction) {
        String calledFunction = performedAction.getFunctionCall();

        switch(calledFunction){
            case "giveTipp":
                giveTipp((TippActionObject) performedAction);
        }
    }


}
