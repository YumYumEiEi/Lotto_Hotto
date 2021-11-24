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
    protected boolean isTippLegal() {
        return false;
    }

    @Override
    protected boolean areSevenNumbersPicked() {
        return false;
    }

    @Override
    protected boolean isOneSuperzahlPicked() {
        return false;
    }

    @Override
    protected boolean isTippADuplicat() {
        return false;
    }

    @Override
    protected void giveTipp(TippActionObject performedAction) {
        String username = performedAction.getCurrendUsername();
        String[] tippedNumbers = performedAction.getTippedNumbers();
        String superzahl  = performedAction.getSuperzahl();
        String nextZiehungID = backend.getNextDrawing().getID();

        if(tippedNumbers.length != 7){
            frontend.showNotSevenNumbersPickedErrorMessage();
        }else {
            Tipp givenTipp = new Tipp(tippedNumbers, superzahl, username, nextZiehungID);

            if(backend.isTippAlreaddyGiven(givenTipp)){
                frontend.showTippAlreaddyThereErrorMessage();
            }else{
                backend.saveTipp(givenTipp);
            }
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
