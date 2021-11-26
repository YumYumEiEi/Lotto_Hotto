package Middlewear;

import ActionObjects.ActionObject;
import ActionObjects.TippActionObject;
import Backend.Backend;
import BackendObjects.Tipp;
import Frontend.GiveTippsFrontend;

public abstract class GiveTippsMiddlewear implements Middlewear {

    protected GiveTippsFrontend frontend;
    protected Backend backend;

    protected abstract boolean isTippLegal(Tipp givenTipp, String userID);

    protected abstract boolean areSevenNumbersPicked(Tipp givenTipp);

    protected abstract boolean isOneSuperzahlPicked(Tipp givenTipp);

    protected abstract boolean isTippADuplicat(Tipp givenTipp, String userID);

    protected abstract void giveTipp(TippActionObject performedAction);
}
