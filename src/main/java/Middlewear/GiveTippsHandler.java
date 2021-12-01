package Middlewear;

import ActionObjects.ActionObject;
import ActionObjects.GiveATippActionObject;
import Backend.Backend;
import BackendObjects.Tipp;
import Frontend.GiveTippsFrontend;

public class GiveTippsHandler extends GiveTippsMiddlewear {

    public GiveTippsHandler(GiveTippsFrontend frontend, Backend backend){
        this.frontend = frontend;
        this.backend = backend;
    }

    @Override
    protected boolean isTippLegal(Tipp givenTipp, String userID) {
        return areSixNumbersPicked(givenTipp) && isOneBonusnumberPicked(givenTipp) && isTippADuplicat(givenTipp, userID);
    }

    @Override
    protected boolean areSixNumbersPicked(Tipp givenTipp) {
        if(givenTipp.getAllTippedNumbers().length == 6){
            return true;
        }else{
            frontend.showNotSixNumbersPickedErrorMessage();
            return false;
        }
    }

    @Override
    protected boolean isOneBonusnumberPicked(Tipp givenTipp) {
        if(givenTipp.getBonusNumber().equals("")){
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
    protected void giveTipp(GiveATippActionObject performedAction) {
        String userID = performedAction.getUserID();
        String[] tippedNumbers = performedAction.getTippedNumbers();
        String bonusNumber  = performedAction.getSuperzahl();
        String drawingID = backend.getNextDrawing().getId();

        Tipp givenTipp = new Tipp(tippedNumbers, bonusNumber, userID, drawingID);

        if(isTippLegal(givenTipp, userID)){
            backend.saveTipp(givenTipp);
            frontend.startTippMainWindow();
        }

    }

    @Override
    public void heandleAction(ActionObject performedAction) {
        String calledFunction = performedAction.getFunctionCall();

        switch(calledFunction){
            case "giveTipp":
                giveTipp((GiveATippActionObject) performedAction);
        }
    }


}
